package com.aninfo.recursos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Resource {

    @JsonProperty("Nombre")
    private String name;
    @JsonProperty("Apellido")
    private String surname;
    @JsonProperty("legajo")
    private int file;

    public Resource(){}

    public String getName(){
            return name;
    }

    public String getSurname(){
        return surname;
    }

    public int getFile(){
        return file;
    }
}
