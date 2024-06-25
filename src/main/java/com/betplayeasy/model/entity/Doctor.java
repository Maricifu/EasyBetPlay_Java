package com.betplayeasy.model.entity;

public class Doctor extends Person {
    private String titulo;
    private int expYear;

    public Doctor() {
        super();
    }

    public Doctor(int id, String nombre, String apellido, int edad, String titulo, int expYear) {
        super(id, nombre, apellido, edad);
        this.titulo = titulo;
        this.expYear = expYear;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getExpYear() {
        return expYear;
    }

    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }

    // Opcional: Puedes implementar métodos adicionales según tus necesidades
}
