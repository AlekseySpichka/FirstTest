package UI_tests.helpers;

import UI_tests.enums.SourceName;
import com.github.javafaker.Faker;



import static java.util.Locale.*;


public class DataHelper {

    public static String getSourceName(SourceName sourceName) {
        Faker faker = new Faker(ENGLISH);
        return sourceName.getPrefix() + "_test_auto_" + faker.number().numberBetween(0, 100);
    }

    public static String getDescription() {
        Faker faker = new Faker(ENGLISH);
        return "Description" + faker.number().numberBetween(0, 100);
    }
}
