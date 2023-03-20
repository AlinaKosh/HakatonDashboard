package com.cbr.testTask.security;

import com.cbr.testTask.db.UsersEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

//Данный класс является классом-обёрткой над классом Person
//Допустим в нашей сущности есть метод password123 и это не совсем коррекно, хранить в таком формате
//Поэтому в данном классе есть интерфейс, где есть обычные названия методов, где нельзя ни в чём ошибиться
public class PersonDetails implements UserDetails {
    private final UsersEntity usersEntity;

    public PersonDetails(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }


    //Будем возвращать коллекцию тех прав, которые есть у данного пользователя,
    //То есть либо есть какие-то права у пользователя, либо их нет
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //SHOW_ACCOUNT, WITHDRAW_MONEY, SEND_MONEY - на авторизации
        //ROLE_ADMIN, ROLE_USER - построенное на ролях (наш случай)
        return null;
        //return Collections.singleton(new SimpleGrantedAuthority(usersEntity.getRole()));
    }

    @Override
    public String getPassword() {
        return this.usersEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return this.usersEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Нужно, чтобы получать данные аутентифицированного пользователя
    public UsersEntity getPerson() {
        return this.usersEntity;
    }
}