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

        // Establecer el controlador en cada vista
        viewCoach.controlador = ctrl;
        viewDoctor.controlador = ctrl;
        viewPlayer.controlador = ctrl;
        viewTeam.controlador = ctrl;

        Scanner scanner = new Scanner(System.in);

        // Menú inicial
        while (true) {
            System.out.println("Seleccione el tipo de entidad:");
            System.out.println("1. Doctor");
            System.out.println("2. Coach");
            System.out.println("3. Player");
            System.out.println("4. Team");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt()

            switch (choice) {
                case 1:
                    viewDoctor vd = new viewDoctor();
                    vd.start();
                    break;
                case 2:
                    viewCoach vc = new viewCoach();
                    vc.start();
                    break;
                case 3:
                    viewPlayer vp = new viewPlayer();
                    vp.start();
                    break;
                case 4:
                    viewTeam vt = new viewTeam();
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
