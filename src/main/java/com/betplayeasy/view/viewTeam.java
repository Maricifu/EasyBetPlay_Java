package com.betplayeasy.view;

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
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> { // crea un equipo
                    Team equipo = new Team();
                    String codigoEquipo = null;
                    System.out.println("Ingrese el codigo del equipo :");
                    codigoEquipo = scanner.nextLine();
                    System.out.println("Ingrese Nombre del equipo :");
                    equipo.setNombre(scanner.nextLine());
                    System.out.println("Ingrese la ciudad :");
                    equipo.setCiudad(scanner.nextLine());
                    controlador.equipos.put(codigoEquipo, equipo);
                }

                case 2 -> { // actualiza un equipo
                }

                case 3 -> { // busca un equipo
                    Team eq = new Team();
                    String codigoE = "001";
                    eq = controlador.equipos.get(codigoE);
                    System.out.println("Mi equipo" + eq.getNombre());
                }
                case 4 -> { // elimina un equipo
                }

                case 5 -> { // lista todos los equipos
                }

                case 6 -> { // salir
                    scanner.close();
                    System.exit(0);0
                }

                default -> System.out.println("Opcion invalida, intentelo de nuevo.");
            }
        }
    }
}
