package com.aninfo.recursos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Resource {

    @JsonProperty("Nombre")
    private String nombre;
    @JsonProperty("Apellido")
    private String apellido;
    @JsonProperty("legajo")
    private int legajo;

    public Resource(){}

    public String getNombre(){
            return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public int getLegajo(){
        return legajo;
    }
}
