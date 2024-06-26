package com.betplayeasy.view;

import java.util.Map;
import java.util.Scanner;

import com.betplayeasy.Controller;
import com.betplayeasy.model.entity.Doctor;

public class viewDoctor {
    public static Controller controlador;
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Doctor");
            System.out.println("2. Actualizar Doctor");
            System.out.println("3. Buscar Doctor");
            System.out.println("4. Eliminar Doctor");
            System.out.println("5. Listar todos los Doctores");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    Doctor doctor = new Doctor();
                    String codigoDoctor = null;
                    System.out.println("Ingrese el código del doctor:");
                    codigoDoctor = scanner.nextLine();
                    System.out.println("Ingrese el nombre del doctor:");
                    doctor.setNombre(scanner.nextLine());
                    System.out.println("Ingrese el apellido del doctor:");
                    doctor.setApellido(scanner.nextLine());
                    System.out.println("Ingrese la edad del doctor:");
                    doctor.setEdad(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    System.out.println("Ingrese el título del doctor:");
                    doctor.setTitulo(scanner.nextLine());
                    System.out.println("Ingrese los años de experiencia del doctor:");
                    doctor.setExpYear(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    controlador.doctores.put(codigoDoctor, doctor);
                }

                case 2 -> {
                    System.out.println("Ingrese el código del doctor que desea actualizar:");
                    String codigoDoctorActualizar = scanner.nextLine();
                    Doctor doctorActualizar = controlador.doctores.get(codigoDoctorActualizar);
                    
                    if (doctorActualizar != null) {
                        System.out.println("Ingrese el nuevo nombre del doctor:");
                        doctorActualizar.setNombre(scanner.nextLine());
                        System.out.println("Ingrese el nuevo apellido del doctor:");
                        doctorActualizar.setApellido(scanner.nextLine());
                        System.out.println("Ingrese la nueva edad del doctor:");
                        doctorActualizar.setEdad(scanner.nextInt());
                        scanner.nextLine(); // Consume newline
                        System.out.println("Ingrese el nuevo título del doctor:");
                        doctorActualizar.setTitulo(scanner.nextLine());
                        System.out.println("Ingrese los nuevos años de experiencia del doctor:");
                        doctorActualizar.setExpYear(scanner.nextInt());
                        scanner.nextLine(); // Consume newline

                        controlador.doctores.put(codigoDoctorActualizar, doctorActualizar);
                        System.out.println("Doctor actualizado exitosamente.");
                    } else {
                        System.out.println("No se encontró ningún doctor con ese código. No se puede actualizar.");
                    }
                }

                case 3 -> {
                    System.out.println("Ingrese el código del doctor que desea buscar:");
                    String codigoD = scanner.nextLine();
                    Doctor d = controlador.doctores.get(codigoD);
                    
                    if (d != null) {
                        System.out.println("Nombre del doctor encontrado: " + d.getNombre());
                        System.out.println("Apellido del doctor encontrado: " + d.getApellido());
                        System.out.println("Edad del doctor encontrado: " + d.getEdad());
                        System.out.println("Título del doctor encontrado: " + d.getTitulo());
                        System.out.println("Años de experiencia del doctor encontrado: " + d.getExpYear());
                    } else {
                        System.out.println("No se encontró ningún doctor con ese código.");
                    }
                }
                case 4 -> {
                    System.out.println("Ingrese el código del doctor que desea eliminar:");
                    String codigoDoctorEliminar = scanner.nextLine();
                    Doctor doctorEliminar = controlador.doctores.remove(codigoDoctorEliminar);
                    
                    if (doctorEliminar != null) {
                        System.out.println("Doctor eliminado correctamente.");
                    } else {
                        System.out.println("No se encontró ningún doctor con ese código. No se puede eliminar.");
                    }
                }

                case 5 -> {
                    System.out.println("Lista de Doctores:");
                    for (Map.Entry<String, Doctor> entry : controlador.doctores.entrySet()) {
                        String codigoDoctor = entry.getKey();
                        Doctor doctor = entry.getValue();
                        System.out.println("Código: " + codigoDoctor + ", Nombre: " + doctor.getNombre() + ", Apellido: " + doctor.getApellido() + ", Edad: " + doctor.getEdad() + ", Título: " + doctor.getTitulo() + ", Años de experiencia: " + doctor.getExpYear());
                    }
                }

                case 6 -> {
                    return;
                }

                default -> System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }
}
