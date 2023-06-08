package org.example.resources;

import org.example.Models.Isbn;
import org.example.Models.User;

public class TestDataBuild {

    public User newUserPayload() {

        User newUserPayload = new User();
        newUserPayload.setUserName("Test2");
        newUserPayload.setPassword("Test@hen_13");
        return newUserPayload;
    }


}
