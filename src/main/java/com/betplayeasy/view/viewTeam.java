package com.betplayeasy.view;

import java.util.Map;
import java.util.Scanner;

import com.betplayeasy.Controller;
import com.betplayeasy.model.entity.Team;

public class viewTeam {
    public static Controller controlador;
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Equipo");
            System.out.println("2. Actualizar Equipo");
            System.out.println("3. Buscar Equipo");
            System.out.println("4. Eliminar Equipo");
            System.out.println("5. Listar todos Equipos");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> { // crea un equipo
                    Team equipo = new Team();
                    System.out.println("Ingrese el código del equipo:");
                    String codigoEquipo = scanner.nextLine();
                    System.out.println("Ingrese Nombre del equipo:");
                    equipo.setNombre(scanner.nextLine());
                    System.out.println("Ingrese la ciudad:");
                    equipo.setCiudad(scanner.nextLine());
                    controlador.equipos.put(codigoEquipo, equipo);
                    System.out.println("Equipo creado exitosamente.");
                    break;
                }
                

                case 2 -> { // actualiza un equipo
                    System.out.println("Ingrese el código del equipo que desea actualizar:");
                    String codigoEquipoActualizar = scanner.nextLine();
                    Team equipoActualizar = controlador.equipos.get(codigoEquipoActualizar);
                    
                    if (equipoActualizar != null) {
                        System.out.println("Ingrese el nuevo nombre del equipo:");
                        equipoActualizar.setNombre(scanner.nextLine());
                        System.out.println("Ingrese la nueva ciudad:");
                        equipoActualizar.setCiudad(scanner.nextLine());
                        
                        controlador.equipos.put(codigoEquipoActualizar, equipoActualizar);
                        System.out.println("Equipo actualizado exitosamente.");
                    } else {
                        System.out.println("No se encontró ningún equipo con ese código. No se puede actualizar.");
                    }
                    break;
                }

                case 3 -> { // busca un equipo
                    System.out.println("Ingrese el código del equipo que desea buscar:");
                    String codigoE = scanner.nextLine();
                    Team eq = controlador.equipos.get(codigoE);
                    
                    if (eq != null) {
                        System.out.println("Nombre del equipo encontrado: " + eq.getNombre());
                    } else {
                        System.out.println("No se encontró ningún equipo con ese código.");
                    }
                    break;
                }
                

                case 4 -> { // elimina un equipo
                    System.out.println("Ingrese el código del equipo que desea eliminar:");
                    String codigoEquipoEliminar = scanner.nextLine();
                    Team equipoEliminar = controlador.equipos.remove(codigoEquipoEliminar);
                    
                    if (equipoEliminar != null) {
                        System.out.println("Equipo eliminado correctamente.");
                    } else {
                        System.out.println("No se encontró ningún equipo con ese código. No se puede eliminar.");
                    }
                    break;
                }

                case 5 -> { // lista todos los equipos
                    System.out.println("Lista de Equipos:");
                    for (Map.Entry<String, Team> entry : controlador.equipos.entrySet()) {
                        String codigoEquipo = entry.getKey();
                        Team equipo = entry.getValue();
                        System.out.println("Código: " + codigoEquipo + ", Nombre: " + equipo.getNombre() + ", Ciudad: " + equipo.getCiudad());
                    }
                    break;
                }

                case 6 -> { // salir
                    scanner.close();
                    System.exit(0);
                }

                default -> System.out.println("Opcion invalida, intentelo de nuevo.");
            }
        }
    }
}
