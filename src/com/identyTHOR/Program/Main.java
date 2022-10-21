package com.identyTHOR.Program;

import java.util.Scanner;

import static com.identyTHOR.SecureHWID.SerialNumberWindows.getSerialNumber;
import static java.lang.System.exit;


public class Main {
    String serialNumber = getSerialNumber();
    static String snXML;

    public static void main(String[] args) {
            System.out.println("Bienveni@ a la versión 1.0 de IdentyTHOR");
            System.out.println("Para proceder con el programa necesitamos saber si usted ya posee un token de identidad o no.");
            System.out.println("Para ello inserte una de las siguientes opciones:");
        while (true) {
            System.out.println("    1. Crear token de identidad Blockchain con IdentyTHOR");
            System.out.println("    2. Identificarse con un token de identidad de IdentyTHOR");
            System.out.println("    3. Importar token de identidad en IdentyChain");
            System.out.println("    4. Exportar token de identidad Blockchain con IdentyTHOR");
            System.out.println("    5. Salir");

            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 1: {
                    if(snXML == getSerialNumber()) {
                        System.out.println("Este numero de serie ya esta en uso, por favor intentifiquese");
                        break;
                    }
                    CreateToken token = new CreateToken();
                    String nameXML = token.createName();
                    System.out.println("El nombre introducido es: " + nameXML);
                    snXML = token.getSN();
                    String passwordXML = token.getPassword();
                    String emailXML = token.getEmail();
                    String tokenXML = token.getToken();
                    System.out.println("Su token ha sido generado correctamente: " + tokenXML);
                    break;
                }
                case 2: {
                    Identification identificacion = new Identification();
                }
                case 3: {

                }
                case 4: {

                }
                case 5: {
                    System.out.println("Hasta pronto!");
                    exit(0);
                }
            }
            System.out.println("La opción seleccionada no esta disponible, intentelo de nuevo");
        }

    }
}