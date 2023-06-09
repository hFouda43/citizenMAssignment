package org.example.resources;

import org.example.models.UserBody;

import java.util.UUID;

public class TestDataBuild {

    // Preparing some test data
    public UserBody newUserPayload() {

        UserBody newUserPayload = new UserBody();
        newUserPayload.setUserName(UUID.randomUUID().toString());
        newUserPayload.setPassword("Test@hen_13");
        return newUserPayload;
    }


}
