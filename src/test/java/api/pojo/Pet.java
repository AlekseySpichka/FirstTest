package api.pojo;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Pet {
    public Long id;
    public void category(Category);
    public String name;
    public String[] photoUrls;

    public String status;


    public Pet() {
        Faker a = new Faker(Locale.ENGLISH);
        id = a.number().randomNumber();
        new Category() = a.name().username();
        firstName = a.name().firstName();
        lastName = a.name().lastName();
        email = username + "@ya.ru";
        password = a.bothify("??????????");
        phone = a.phoneNumber().phoneNumber();
        userStatus = a.number().numberBetween(0, 10);
    }
}
