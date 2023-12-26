package api.pojo;

import com.github.javafaker.Faker;

import java.util.Locale;

public class User {

    public Long id;
    public String username;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String phone;
    public Integer userStatus;

    public User() {
        Faker a = new Faker(Locale.ENGLISH);
        id = a.number().randomNumber();
        username = a.name().username();
        firstName = a.name().firstName();
        lastName = a.name().lastName();
        email = username + "@ya.ru";
        password = a.bothify("??????????");
        phone = a.phoneNumber().phoneNumber();
        userStatus = a.number().numberBetween(0, 10);
    }

}
