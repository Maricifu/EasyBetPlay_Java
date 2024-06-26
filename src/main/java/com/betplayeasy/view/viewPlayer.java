package com.betplayeasy.view;

import java.util.Map;
import java.util.Scanner;

import com.betplayeasy.Controller;
import com.betplayeasy.model.entity.Player;

public class viewPlayer {
    public static Controller controlador;
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Jugador");
            System.out.println("2. Actualizar Jugador");
            System.out.println("3. Buscar Jugador");
            System.out.println("4. Eliminar Jugador");
            System.out.println("5. Listar todos los Jugadores");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    Player jugador = new Player();
                    String codigoJugador = null;
                    System.out.println("Ingrese el código del jugador:");
                    codigoJugador = scanner.nextLine();
                    System.out.println("Ingrese el nombre del jugador:");
                    jugador.setNombre(scanner.nextLine());
                    System.out.println("Ingrese el apellido del jugador:");
                    jugador.setApellido(scanner.nextLine());
                    System.out.println("Ingrese la edad del jugador:");
                    jugador.setEdad(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    System.out.println("Ingrese el dorsal del jugador:");
                    jugador.setDorsal(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    System.out.println("Ingrese la posición del jugador:");
                    jugador.setPosicion(scanner.nextLine());
                    controlador.jugadores.put(codigoJugador, jugador);
                }

                case 2 -> {
                    System.out.println("Ingrese el código del jugador que desea actualizar:");
                    String codigoJugadorActualizar = scanner.nextLine();
                    Player jugadorActualizar = controlador.jugadores.get(codigoJugadorActualizar);
                    
                    if (jugadorActualizar != null) {
                        System.out.println("Ingrese el nuevo nombre del jugador:");
                        jugadorActualizar.setNombre(scanner.nextLine());
                        System.out.println("Ingrese el nuevo apellido del jugador:");
                        jugadorActualizar.setApellido(scanner.nextLine());
                        System.out.println("Ingrese la nueva edad del jugador:");
                        jugadorActualizar.setEdad(scanner.nextInt());
                        scanner.nextLine(); // Consume newline
                        System.out.println("Ingrese el nuevo dorsal del jugador:");
                        jugadorActualizar.setDorsal(scanner.nextInt());
                        scanner.nextLine(); // Consume newline
                        System.out.println("Ingrese la nueva posición del jugador:");
                        jugadorActualizar.setPosicion(scanner.nextLine());

                        controlador.jugadores.put(codigoJugadorActualizar, jugadorActualizar);
                        System.out.println("Jugador actualizado exitosamente.");
                    } else {
                        System.out.println("No se encontró ningún jugador con ese código. No se puede actualizar.");
                    }
                }

                case 3 -> {
                    System.out.println("Ingrese el código del jugador que desea buscar:");
                    String codigoJ = scanner.nextLine();
                    Player j = controlador.jugadores.get(codigoJ);
                    
                    if (j != null) {
                        System.out.println("Nombre del jugador encontrado: " + j.getNombre());
                        System.out.println("Apellido del jugador encontrado: " + j.getApellido());
                        System.out.println("Edad del jugador encontrado: " + j.getEdad());
                        System.out.println("Dorsal del jugador encontrado: " + j.getDorsal());
                        System.out.println("Posición del jugador encontrado: " + j.getPosicion());
                    } else {
                        System.out.println("No se encontró ningún jugador con ese código.");
                    }
                }
                case 4 -> {
                    System.out.println("Ingrese el código del jugador que desea eliminar:");
                    String codigoJugadorEliminar = scanner.nextLine();
                    Player jugadorEliminar = controlador.jugadores.remove(codigoJugadorEliminar);
                    
                    if (jugadorEliminar != null) {
                        System.out.println("Jugador eliminado correctamente.");
                    } else {
                        System.out.println("No se encontró ningún jugador con ese código. No se puede eliminar.");
                    }
                }

                case 5 -> {
                    System.out.println("Lista de Jugadores:");
                    for (Map.Entry<String, Player> entry : controlador.jugadores.entrySet()) {
                        String codigoJugador = entry.getKey();
                        Player jugador = entry.getValue();
                        System.out.println("Código: " + codigoJugador + ", Nombre: " + jugador.getNombre() + ", Apellido: " + jugador.getApellido() + ", Edad: " + jugador.getEdad() + ", Dorsal: " + jugador.getDorsal() + ", Posición: " + jugador.getPosicion());
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
