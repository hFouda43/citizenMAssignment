package org.example.resources;

import org.example.Models.Isbn;
import org.example.Models.User;
import org.example.Models.UserBody;

import java.util.UUID;

public class TestDataBuild {

    public UserBody newUserPayload() {

        UserBody newUserPayload = new UserBody();
        newUserPayload.setUserName(UUID.randomUUID().toString());
        newUserPayload.setPassword("Test@hen_13");
        return newUserPayload;
    }


}
