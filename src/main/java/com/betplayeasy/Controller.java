package com.betplayeasy;

import java.util.HashMap;
import java.util.Map;

import com.betplayeasy.model.entity.Coach;
import com.betplayeasy.model.entity.Doctor;
import com.betplayeasy.model.entity.Player;
import com.betplayeasy.model.entity.Team;

public class Controller {
    public Map<String, Team> equipos; // Almacena los equipos usando un código como clave
    private int nextDoctorId; // ID para los doctores
    private int nextCoachId; // ID para los entrenadores
    private int nextPlayerId; // ID para los jugadores

    public Controller() {
        equipos = new HashMap<>();
        nextDoctorId = 1;
        nextCoachId = 1;
        nextPlayerId = 1;
    }

    // Métodos CRUD para los equipos

    public void agregarEquipo(String codigo, Team equipo) {
        equipos.put(codigo, equipo);
    }

    public Team obtenerEquipo(String codigo) {
        return equipos.get(codigo);
    }

    public void actualizarEquipo(String codigo, Team equipoActualizado) {
        equipos.put(codigo, equipoActualizado);
    }

    public void eliminarEquipo(String codigo) {
        equipos.remove(codigo);
    }

    // Métodos CRUD para los doctores

    public void agregarDoctor(int i, Doctor doctor) {
        doctor.setId(nextDoctorId++);
        Team equipo = equipos.get(i);
        if (equipo != null) {
            equipo.getLstMasajistas().add(doctor);
        }
    }

    public Doctor obtenerDoctor(int i, int idDoctor) {
        Team equipo = equipos.get(i);
        if (equipo != null) {
            for (Doctor doctor : equipo.getLstMasajistas()) {
                if (doctor.getId() == idDoctor) {
                    return doctor;
                }
            }
        }
        return null;
    }

    public void actualizarDoctor(int j, Doctor doctorActualizado) {
        Team equipo = equipos.get(j);
        if (equipo != null) {
            for (int i = 0; i < equipo.getLstMasajistas().size(); i++) {
                if (equipo.getLstMasajistas().get(i).getId() == doctorActualizado.getId()) {
                    equipo.getLstMasajistas().set(i, doctorActualizado);
                    break;
                }
            }
        }
    }

    public void eliminarDoctor(int i, int idDoctor) {
        Team equipo = equipos.get(i);
        if (equipo != null) {
            Doctor doctorEliminar = null;
            for (Doctor doctor : equipo.getLstMasajistas()) {
                if (doctor.getId() == idDoctor) {
                    doctorEliminar = doctor;
                    break;
                }
            }
            if (doctorEliminar != null) {
                equipo.getLstMasajistas().remove(doctorEliminar);
            }
        }
    }

    // Métodos CRUD para los entrenadores

    public void agregarEntrenador(int i, Coach entrenador) {
        entrenador.setId(nextCoachId++);
        Team equipo = equipos.get(i);
        if (equipo != null) {
            equipo.getLstEntrenadores().add(entrenador);
        }
    }

    public Coach obtenerEntrenador(int i, int idEntrenador) {
        Team equipo = equipos.get(i);
        if (equipo != null) {
            for (Coach coach : equipo.getLstEntrenadores()) {
                if (coach.getId() == idEntrenador) {
                    return coach;
                }
            }
        }
        return null;
    }

    public void actualizarEntrenador(int j, Coach entrenadorActualizado) {
        Team equipo = equipos.get(j);
        if (equipo != null) {
            for (int i = 0; i < equipo.getLstEntrenadores().size(); i++) {
                if (equipo.getLstEntrenadores().get(i).getId() == entrenadorActualizado.getId()) {
                    equipo.getLstEntrenadores().set(i, entrenadorActualizado);
                    break;
                }
            }
        }
    }

    public void eliminarEntrenador(int i, int idEntrenador) {
        Team equipo = equipos.get(i);
        if (equipo != null) {
            Coach entrenadorEliminar = null;
            for (Coach coach : equipo.getLstEntrenadores()) {
                if (coach.getId() == idEntrenador) {
                    entrenadorEliminar = coach;
                    break;
                }
            }
            if (entrenadorEliminar != null) {
                equipo.getLstEntrenadores().remove(entrenadorEliminar);
            }
        }
    }

    // Métodos CRUD para los jugadores

    public void agregarJugador(int i, Player jugador) {
        jugador.setId(nextPlayerId++);
        Team equipo = equipos.get(i);
        if (equipo != null) {
            equipo.getLstJugadores().add(jugador);
        }
    }

    public Player obtenerJugador(String codigoEquipo, int idJugador) {
        Team equipo = equipos.get(codigoEquipo);
        if (equipo != null) {
            for (Player player : equipo.getLstJugadores()) {
                if (player.getId() == idJugador) {
                    return player;
                }
            }
        }
        return null;
    }

    public void actualizarJugador(String codigoEquipo, Player jugadorActualizado) {
        Team equipo = equipos.get(codigoEquipo);
        if (equipo != null) {
            for (int i = 0; i < equipo.getLstJugadores().size(); i++) {
                if (equipo.getLstJugadores().get(i).getId() == jugadorActualizado.getId()) {
                    equipo.getLstJugadores().set(i, jugadorActualizado);
                    break;
                }
            }
        }
    }

    public void eliminarJugador(String codigoEquipo, int idJugador) {
        Team equipo = equipos.get(codigoEquipo);
        if (equipo != null) {
            Player jugadorEliminar = null;
            for (Player player : equipo.getLstJugadores()) {
                if (player.getId() == idJugador) {
                    jugadorEliminar = player;
                    break;
                }
            }
            if (jugadorEliminar != null) {
                equipo.getLstJugadores().remove(jugadorEliminar);
            }
        }
    }
}
