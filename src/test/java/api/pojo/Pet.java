package api.pojo;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Locale;

public class Pet {
    public Long id;
    public Category category;
    public String name;
    public List<String> photoUrls;
    public List<Tag> tags;
    public String status;
}

