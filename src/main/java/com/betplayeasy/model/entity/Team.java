package com.betplayeasy.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String nombre;
    private String ciudad;
    private int id;
    private final List<Player> lstJugadores;
    private final List<Coach> lstEntrenadores;
    private final List<Doctor> lstMasajistas;

    public Team() {
        lstEntrenadores = new ArrayList<>();
        lstJugadores = new ArrayList<>();
        lstMasajistas = new ArrayList<>();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public List<Player> getLstJugadores() {
        return lstJugadores;
    }
    public void setLstJugadores(Player player) {
        this.lstJugadores.add(player);
    }
    public List<Coach> getLstEntrenadores() {
        return lstEntrenadores;
    }
    public void setLstEntrenadores(Coach coach) {
        this.lstEntrenadores.add(coach);
    }
    public List<Doctor> getLstMasajistas() {
        return lstMasajistas;
    }
    public void setLstMasajistas(Doctor masajista) {
        this.lstMasajistas.add(masajista);
    }
}