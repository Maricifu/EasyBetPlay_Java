package com.betplayeasy;

import java.util.Hashtable;

import com.betplayeasy.model.entity.Coach;
import com.betplayeasy.model.entity.Doctor;
import com.betplayeasy.model.entity.Player;
import com.betplayeasy.model.entity.Team;


public class Controller {

    public Hashtable <String,Team> equipos = new Hashtable<>();
    public Hashtable<String, Coach> coaches = new Hashtable<>();
    public Hashtable<String, Doctor> doctores = new Hashtable<>();
    public Hashtable<String, Player> jugadores = new Hashtable<>();
}
