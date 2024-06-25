package com.betplayeasy.view;

import java.util.Scanner;
import com.betplayeasy.Controller;
import com.betplayeasy.model.entity.Coach;
import com.betplayeasy.model.entity.Team;

public class viewCoach {
    private final Team equipoSeleccionado; // Equipo en el que se gestionarán los entrenadores
    private final Scanner scanner;
    private final Controller controlador; // Referencia al controlador

    public viewCoach(Team equipoSeleccionado, Controller controlador) {
        this.equipoSeleccionado = equipoSeleccionado;
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        if (equipoSeleccionado == null) {
            System.out.println("Primero seleccione o cree un equipo para gestionar entrenadores.");
            return;
        }

        while (true) {
            System.out.println("1. Crear Entrenador");
            System.out.println("2. Actualizar Entrenador");
            System.out.println("3. Eliminar Entrenador");
            System.out.println("4. Volver al Menú Principal");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> crearEntrenador();
                case 2 -> actualizarEntrenador();
                case 3 -> eliminarEntrenador();
                case 4 -> {
                    return;
                }
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private void crearEntrenador() {
        System.out.println("Ingrese el nombre del entrenador:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido del entrenador:");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese la edad del entrenador:");
        int edad = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Ingrese el título del entrenador:");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese los años de experiencia del entrenador:");
        int expYear = scanner.nextInt();
        scanner.nextLine(); 

        // Crear un nuevo objeto Coach
        Coach nuevoEntrenador = new Coach(nombre, apellido, edad, titulo, expYear);

        // Llamar al controlador para agregar el entrenador al equipo seleccionado
        controlador.agregarEntrenador(equipoSeleccionado.getId(), nuevoEntrenador);

        System.out.println("Entrenador creado exitosamente para el equipo " + equipoSeleccionado.getNombre() + ".");
    }

    private void actualizarEntrenador() {
        if (equipoSeleccionado.getLstEntrenadores().isEmpty()) {
            System.out.println("No hay entrenadores para actualizar.");
            return;
        }

        System.out.println("Lista de Entrenadores:");
        for (Coach entrenador : equipoSeleccionado.getLstEntrenadores()) {
            System.out.println(entrenador.getId() + ". " + entrenador.getNombre() + " " + entrenador.getApellido());
        }

        System.out.println("Ingrese el ID del entrenador que desea actualizar:");
        int idEntrenador = scanner.nextInt();
        scanner.nextLine(); 

        // Llamar al controlador para obtener el entrenador a actualizar
        Coach entrenadorActualizar = controlador.obtenerEntrenador(equipoSeleccionado.getId(), idEntrenador);

        if (entrenadorActualizar == null) {
            System.out.println("No se encontró ningún entrenador con ese ID para el equipo " + equipoSeleccionado.getNombre() + ".");
            return;
        }

        System.out.println("Ingrese el nuevo nombre del entrenador:");
        entrenadorActualizar.setNombre(scanner.nextLine());
        System.out.println("Ingrese el nuevo apellido del entrenador:");
        entrenadorActualizar.setApellido(scanner.nextLine());

        // Llamar al controlador para actualizar el entrenador
        controlador.actualizarEntrenador(equipoSeleccionado.getId(), entrenadorActualizar);

        System.out.println("Entrenador actualizado correctamente.");
    }

    private void eliminarEntrenador() {
        if (equipoSeleccionado.getLstEntrenadores().isEmpty()) {
            System.out.println("No hay entrenadores para eliminar.");
            return;
        }

        System.out.println("Lista de Entrenadores:");
        for (Coach entrenador : equipoSeleccionado.getLstEntrenadores()) {
            System.out.println(entrenador.getId() + ". " + entrenador.getNombre() + " " + entrenador.getApellido());
        }

        System.out.println("Ingrese el ID del entrenador que desea eliminar:");
        int idEntrenador = scanner.nextInt();
        scanner.nextLine(); 

        // Llamar al controlador para eliminar el entrenador
        controlador.eliminarEntrenador(equipoSeleccionado.getId(), idEntrenador);

        System.out.println("Entrenador eliminado correctamente del equipo " + equipoSeleccionado.getNombre() + ".");
    }
}
