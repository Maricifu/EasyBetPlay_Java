package com.betplayeasy.view;

import java.util.Scanner;
import com.betplayeasy.model.entity.Player;
import com.betplayeasy.model.entity.Team;

public class viewPlayer {
    private Team equipoSeleccionado; // Equipo en el que se gestionarán los jugadores
    private Scanner scanner;

    public viewPlayer(Team equipoSeleccionado) {
        this.equipoSeleccionado = equipoSeleccionado;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        if (equipoSeleccionado == null) {
            System.out.println("Primero seleccione o cree un equipo para gestionar jugadores.");
            return;
        }

        while (true) {
            System.out.println("1. Crear Jugador");
            System.out.println("2. Actualizar Jugador");
            System.out.println("3. Eliminar Jugador");
            System.out.println("4. Volver al Menú Principal");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> crearJugador();
                case 2 -> actualizarJugador();
                case 3 -> eliminarJugador();
                case 4 -> {
                    return;
                }
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private void crearJugador() {
        System.out.println("Ingrese el nombre del jugador:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido del jugador:");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese la edad del jugador:");
        int edad = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Ingrese el dorsal del jugador:");
        int dorsal = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Ingrese la posición del jugador:");
        String posicion = scanner.nextLine();

        Player nuevoJugador = new Player(equipoSeleccionado.getId(), nombre, apellido, edad, dorsal, posicion);
        equipoSeleccionado.getLstJugadores().add(nuevoJugador);
        System.out.println("Jugador creado exitosamente para el equipo " + equipoSeleccionado.getNombre() + ".");
    }

    private void actualizarJugador() {
        if (equipoSeleccionado.getLstJugadores().isEmpty()) {
            System.out.println("No hay jugadores para actualizar.");
            return;
        }

        System.out.println("Lista de Jugadores:");
        for (Player jugador : equipoSeleccionado.getLstJugadores()) {
            System.out.println(jugador.getId() + ". " + jugador.getNombre() + " " + jugador.getApellido());
        }

        System.out.println("Ingrese el ID del jugador que desea actualizar:");
        int idJugador = scanner.nextInt();
        scanner.nextLine(); 

        Player jugadorActualizar = null;
        for (Player jugador : equipoSeleccionado.getLstJugadores()) {
            if (jugador.getId() == idJugador) {
                jugadorActualizar = jugador;
                break;
            }
        }

        if (jugadorActualizar == null) {
            System.out.println("No se encontró ningún jugador con ese ID para el equipo " + equipoSeleccionado.getNombre() + ".");
            return;
        }

        System.out.println("Ingrese el nuevo nombre del jugador:");
        jugadorActualizar.setNombre(scanner.nextLine());
        System.out.println("Ingrese el nuevo apellido del jugador:");
        jugadorActualizar.setApellido(scanner.nextLine());
        System.out.println("Jugador actualizado correctamente.");
    }

    private void eliminarJugador() {
        if (equipoSeleccionado.getLstJugadores().isEmpty()) {
            System.out.println("No hay jugadores para eliminar.");
            return;
        }

        System.out.println("Lista de Jugadores:");
        for (Player jugador : equipoSeleccionado.getLstJugadores()) {
            System.out.println(jugador.getId() + ". " + jugador.getNombre() + " " + jugador.getApellido());
        }

        System.out.println("Ingrese el ID del jugador que desea eliminar:");
        int idJugador = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Player jugadorEliminar = null;
        for (Player jugador : equipoSeleccionado.getLstJugadores()) {
            if (jugador.getId() == idJugador) {
                jugadorEliminar = jugador;
                break;
            }
        }

        if (jugadorEliminar == null) {
            System.out.println("No se encontró ningún jugador con ese ID para el equipo " + equipoSeleccionado.getNombre() + ".");
            return;
        }

        equipoSeleccionado.getLstJugadores().remove(jugadorEliminar);
        System.out.println("Jugador eliminado correctamente del equipo " + equipoSeleccionado.getNombre() + ".");
    }
}
