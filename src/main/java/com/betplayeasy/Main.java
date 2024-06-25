package com.betplayeasy;

import java.util.Scanner;

import com.betplayeasy.view.viewCoach;
import com.betplayeasy.view.viewDoctor;
import com.betplayeasy.view.viewPlayer;
import com.betplayeasy.view.viewTeam;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia del controlador
        Controller ctrl = new Controller();

        
        // Establecer el controlador en cada vista y pasar equipoSeleccionado
        viewDoctor vd = new viewDoctor(ctrl);
        viewCoach vc = new viewCoach(ctrl);
        viewPlayer vp = new viewPlayer(ctrl);
        viewTeam vt = new viewTeam (ctrl);

        Scanner scanner = new Scanner(System.in);

        // Menú inicial
        while (true) {
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Doctor");
            System.out.println("2. Coach");
            System.out.println("3. Player");
            System.out.println("4. Team");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    vd.start();
                    break;
                case 2:
                    vc.start();
                    break;
                case 3:
                    vp.start();
                    break;
                case 4:
                    vt.start();
                    break;
                case 5:
                    System.out.println("Saliendo de la aplicación...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
}
