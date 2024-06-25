package com.betplayeasy.model.entity;

public class Coach extends Person {
    private int idFederacion;

    public Coach(){
        super();
    }

    public Coach(int idFederacion) {
        this.idFederacion = idFederacion;
    }

    public Coach(String nombre2, String nombre, int edad, String titulo, int idFederacion) {
        super();
        this.idFederacion = idFederacion;
    }

    public int getIdFederacion() {
        return idFederacion;
    }

    public void setIdFederacion(int idFederacion) {
        this.idFederacion = idFederacion;
    }
}