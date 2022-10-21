package com.identychain.Program;

import java.util.Scanner;

import static java.lang.Character.getName;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienveni@ a la versión 1.0 de IdentyChain");
        System.out.println("Para proceder con el programa necesitamos saber si usted ya posee un token de identidad o no.");
        System.out.println("Para ello inserte una de las siguientes opciones:");
        System.out.println("    1. Crear token de identidad Blockchain con IdentyChain");
        System.out.println("    2. Identificarse con un token de identidad de IdentyChain");
        System.out.println("    3. Importar token de identidad en IdentyChain");
        System.out.println("    4. Exportar token de identidad Blockchain con IdentyChain");
        System.out.println("    5. Salir");

        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        if (opcion == 1) {

        }
    }
}
