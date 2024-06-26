package com.betplayeasy.view;

import java.util.Map;
import java.util.Scanner;

import com.betplayeasy.Controller;
import com.betplayeasy.model.entity.Coach;

public class viewCoach {
    public static Controller controlador;
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Coach");
            System.out.println("2. Actualizar Coach");
            System.out.println("3. Buscar Coach");
            System.out.println("4. Eliminar Coach");
            System.out.println("5. Listar todos los Coaches");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    Coach coach = new Coach();
                    String codigoCoach = null;
                    System.out.println("Ingrese el código del coach:");
                    codigoCoach = scanner.nextLine();
                    System.out.println("Ingrese Nombre del coach:");
                    coach.setNombre(scanner.nextLine());
                    System.out.println("Ingrese la edad del coach:");
                    coach.setEdad(scanner.nextInt());
                    scanner.nextLine(); 
                    System.out.println("Ingrese el ID de federación del coach:");
                    coach.setIdFederacion(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    controlador.coaches.put(codigoCoach, coach);
                }

                case 2 -> {
                    System.out.println("Ingrese el código del coach que desea actualizar:");
                    String codigoCoachActualizar = scanner.nextLine();
                    Coach coachActualizar = controlador.coaches.get(codigoCoachActualizar);
                    
                    if (coachActualizar != null) {
                        System.out.println("Ingrese el nuevo nombre del coach:");
                        coachActualizar.setNombre(scanner.nextLine());
                        System.out.println("Ingrese la nueva edad del coach:");
                        coachActualizar.setEdad(scanner.nextInt());
                        scanner.nextLine(); 
                        System.out.println("Ingrese el nuevo ID de federación del coach:");
                        coachActualizar.setIdFederacion(scanner.nextInt());
                        scanner.nextLine(); // Consume newline

                        controlador.coaches.put(codigoCoachActualizar, coachActualizar);
                        System.out.println("Coach actualizado exitosamente.");
                    } else {
                        System.out.println("No se encontró ningún coach con ese código. No se puede actualizar.");
                    }
                }

                case 3 -> {
                    System.out.println("Ingrese el código del coach que desea buscar:");
                    String codigoC = scanner.nextLine();
                    Coach c = controlador.coaches.get(codigoC);
                    
                    if (c != null) {
                        System.out.println("Nombre del coach encontrado: " + c.getNombre());
                        System.out.println("Edad del coach encontrado: " + c.getEdad());
                        System.out.println("ID de federación del coach encontrado: " + c.getIdFederacion());
                    } else {
                        System.out.println("No se encontró ningún coach con ese código.");
                    }
                }
                case 4 -> {
                    System.out.println("Ingrese el código del coach que desea eliminar:");
                    String codigoCoachEliminar = scanner.nextLine();
                    Coach coachEliminar = controlador.coaches.remove(codigoCoachEliminar);
                    
                    if (coachEliminar != null) {
                        System.out.println("Coach eliminado correctamente.");
                    } else {
                        System.out.println("No se encontró ningún coach con ese código. No se puede eliminar.");
                    }
                }

                case 5 -> {
                    System.out.println("Lista de Coaches:");
                    for (Map.Entry<String, Coach> entry : controlador.coaches.entrySet()) {
                        String codigoCoach = entry.getKey();
                        Coach coach = entry.getValue();
                        System.out.println("Código: " + codigoCoach + ", Nombre: " + coach.getNombre() + ", Edad: " + coach.getEdad() + ", ID de federación: " + coach.getIdFederacion());
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
