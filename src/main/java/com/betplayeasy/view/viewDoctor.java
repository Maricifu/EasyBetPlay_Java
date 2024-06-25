package com.betplayeasy.view;

import java.util.Scanner;
import com.betplayeasy.Controller;
import com.betplayeasy.model.entity.Doctor;
import com.betplayeasy.model.entity.Team;

public class viewDoctor {
    private final Team equipoSeleccionado; // Equipo en el que se gestionarán los doctores
    private final Scanner scanner;
    private final Controller controlador; // Referencia al controlador

    public viewDoctor(Team equipoSeleccionado, Controller controlador) {
        this.equipoSeleccionado = equipoSeleccionado;
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        if (equipoSeleccionado == null) {
            System.out.println("Primero seleccione o cree un equipo para gestionar doctores.");
            return;
        }

        while (true) {
            System.out.println("1. Crear Doctor");
            System.out.println("2. Actualizar Doctor");
            System.out.println("3. Eliminar Doctor");
            System.out.println("4. Volver al Menú Principal");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> crearDoctor();
                case 2 -> actualizarDoctor();
                case 3 -> eliminarDoctor();
                case 4 -> {
                    return;
                }
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private void crearDoctor() {
        System.out.println("Ingrese el nombre del doctor:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido del doctor:");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese la edad del doctor:");
        int edad = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Ingrese el título del doctor:");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese los años de experiencia del doctor:");
        int expYear = scanner.nextInt();
        scanner.nextLine(); 

        // Crear un nuevo objeto Doctor
        Doctor nuevoDoctor = new Doctor(0, nombre, apellido, edad, titulo, expYear);

        // Llamar al controlador para agregar el doctor al equipo seleccionado
        controlador.agregarDoctor(equipoSeleccionado.getId(), nuevoDoctor);

        System.out.println("Doctor creado exitosamente para el equipo " + equipoSeleccionado.getNombre() + ".");
    }

    private void actualizarDoctor() {
        if (equipoSeleccionado.getLstMasajistas().isEmpty()) {
            System.out.println("No hay doctores para actualizar.");
            return;
        }

        System.out.println("Lista de Doctores:");
        for (Doctor doctor : equipoSeleccionado.getLstMasajistas()) {
            System.out.println(doctor.getId() + ". " + doctor.getNombre() + " " + doctor.getApellido());
        }

        System.out.println("Ingrese el ID del doctor que desea actualizar:");
        int idDoctor = scanner.nextInt();
        scanner.nextLine(); 

        // Llamar al controlador para obtener el doctor a actualizar
        Doctor doctorActualizar = controlador.obtenerDoctor(equipoSeleccionado.getId(), idDoctor);

        if (doctorActualizar == null) {
            System.out.println("No se encontró ningún doctor con ese ID para el equipo " + equipoSeleccionado.getNombre() + ".");
            return;
        }

        System.out.println("Ingrese el nuevo nombre del doctor:");
        doctorActualizar.setNombre(scanner.nextLine());
        System.out.println("Ingrese el nuevo apellido del doctor:");
        doctorActualizar.setApellido(scanner.nextLine());

        // Llamar al controlador para actualizar el doctor
        controlador.actualizarDoctor(equipoSeleccionado.getId(), doctorActualizar);

        System.out.println("Doctor actualizado correctamente.");
    }

    private void eliminarDoctor() {
        if (equipoSeleccionado.getLstMasajistas().isEmpty()) {
            System.out.println("No hay doctores para eliminar.");
            return;
        }

        System.out.println("Lista de Doctores:");
        for (Doctor doctor : equipoSeleccionado.getLstMasajistas()) {
            System.out.println(doctor.getId() + ". " + doctor.getNombre() + " " + doctor.getApellido());
        }

        System.out.println("Ingrese el ID del doctor que desea eliminar:");
        int idDoctor = scanner.nextInt();
        scanner.nextLine(); 

        // Llamar al controlador para eliminar el doctor
        controlador.eliminarDoctor(equipoSeleccionado.getId(), idDoctor);

        System.out.println("Doctor eliminado correctamente del equipo " + equipoSeleccionado.getNombre() + ".");
    }
}
