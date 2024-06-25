package com.betplayeasy;
import java.util.Hashtable;
import java.util.Map;

import com.betplayeasy.model.entity.Team;

public class Controller {
    public Hashtable<String, Team> equipos;

    public Controller() {
        this.equipos = new Hashtable<>();
    }

    // Agregar un equipo a la colección
    public void agregarEquipo(String codigoEquipo, Team equipo) {
        if (!equipos.containsKey(codigoEquipo)) {
            equipos.put(codigoEquipo, equipo);
            System.out.println("Equipo agregado exitosamente con código: " + codigoEquipo);
        } else {
            System.out.println("Ya existe un equipo con el código: " + codigoEquipo);
        }
    }

    // Obtener un equipo por su código
    public Team obtenerEquipo(String codigoEquipo) {
        return equipos.get(codigoEquipo);
    }

    // Actualizar un equipo existente
    public void actualizarEquipo(String codigoEquipo, Team equipoActualizado) {
        if (equipos.containsKey(codigoEquipo)) {
            equipos.put(codigoEquipo, equipoActualizado);
            System.out.println("Equipo actualizado exitosamente con código: " + codigoEquipo);
        } else {
            System.out.println("No se encontró ningún equipo con el código: " + codigoEquipo);
        }
    }

    // Eliminar un equipo por su código
    public void eliminarEquipo(String codigoEquipo) {
        if (equipos.containsKey(codigoEquipo)) {
            equipos.remove(codigoEquipo);
            System.out.println("Equipo eliminado exitosamente con código: " + codigoEquipo);
        } else {
            System.out.println("No se encontró ningún equipo con el código: " + codigoEquipo);
        }
    }

    // Obtener todos los equipos
    public Map<String, Team> obtenerTodosLosEquipos() {
        return equipos;
    }

    // Otros métodos según necesidades específicas

}
