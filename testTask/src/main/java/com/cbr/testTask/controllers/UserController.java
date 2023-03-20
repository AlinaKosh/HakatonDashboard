package com.cbr.testTask.controllers;

import com.cbr.testTask.db.CandidatesEntity;
import com.cbr.testTask.db.UsersEntity;
import com.cbr.testTask.dtos.PersonDTO;
import com.cbr.testTask.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping()
    public List<UsersEntity> getPeople(){
        return userService.findAll(); //Jackson автоматически конвертирует в JSON
    }

    @GetMapping("/{username}")
    public UsersEntity getPerson(@PathVariable("username") String username){
        //Статус 200
        return userService.getPersonByUsername(username).orElse(null);
    }

    private PersonDTO convertToPersonDTO(UsersEntity person){
        return modelMapper.map(person, PersonDTO.class);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
        userService.delete(id);
        //Отправляем HTTP ответ с пустым телом и статусом 200
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable("id") Long id,
                                             @Valid @RequestBody UsersEntity updateUser){

        userService.update(id, updateUser);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/chosen/{id}")
    public CandidatesEntity getChosen(@PathVariable("id") long id){
        return (CandidatesEntity) userService.getChosen(id);
    }

}
