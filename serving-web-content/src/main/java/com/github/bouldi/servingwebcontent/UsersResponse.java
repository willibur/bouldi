package com.github.bouldi.servingwebcontent;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsersResponse {


    @JsonProperty("_embedded")
    private EmbeddedUsers embedded;

    public UsersResponse(EmbeddedUsers embedded) {
        this.embedded = embedded;
    }

    public EmbeddedUsers getEmbedded() {
        return embedded;
    }

    public UsersResponse() {
    }
}
