package api;

import api.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class Environment {

    public static final String uri = "https://petstore.swagger.io/v2/";

    public static User[] getArrayUsers(int userCount) {
        if(userCount < 1) {
            return null;
        }
        User[] users = new User[userCount];
        for (int i = 0; i < users.length; i++) {
            users[i] = new User();
        }
        return users;
    }

    public static ArrayList<User> getListUsers(int userCount) {
        if(userCount < 1) {
            return null;
        }
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < userCount; i++) {
            users.add(new User());
        }
        return users;
    }
}

