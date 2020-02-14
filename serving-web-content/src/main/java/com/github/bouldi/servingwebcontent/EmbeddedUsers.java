package com.github.bouldi.servingwebcontent;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmbeddedUsers {


    public User[] getPeople() {
        return people;
    }

    public EmbeddedUsers(User[] people) {
        this.people = people;
    }

    private User[] people;

    public EmbeddedUsers() {
    }
}
