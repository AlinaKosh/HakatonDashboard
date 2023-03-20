package com.cbr.testTask.controllers;

import com.cbr.testTask.db.UsersEntity;
import com.cbr.testTask.dtos.PersonDTO;
import com.cbr.testTask.services.RegistrationService;
import com.cbr.testTask.util.PersonNotRegisteredException;
import com.cbr.testTask.util.PersonValidator;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
@RequestMapping("/auth")
public class AuthController {
    private final PersonValidator personValidator;
    private final RegistrationService registrationService;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthController(PersonValidator personValidator, RegistrationService registrationService, ModelMapper modelMapper) {
        this.personValidator = personValidator;
        this.registrationService = registrationService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") UsersEntity person){
        return "auth/registration";
    }

    /*
    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") @Valid Person person,
                                                          BindingResult bindingResult){

        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors()){
            return "/auth/registration";
        }

        registrationService.register(person);

        return "redirect:/auth/login";
    }

     */

    //Этот код рабоате, когда мы хотим работать с REST, всё работает я проверила в postman
    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> performRegistration(@RequestBody @Valid PersonDTO personDTO,
                                   BindingResult bindingResult){

        UsersEntity person = convertToPerson(personDTO);

        System.out.println(personDTO.getUsername());

        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors()){
            StringBuilder errorsMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error:errors){
                errorsMsg.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }
            throw new PersonNotRegisteredException(errorsMsg.toString());
        }

        registrationService.register(person);



        return ResponseEntity.ok(HttpStatus.OK);
    }

    private UsersEntity convertToPerson(PersonDTO personDTO) {
        return modelMapper.map(personDTO, UsersEntity.class);
    }


}
