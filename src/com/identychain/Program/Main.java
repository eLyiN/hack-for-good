package com.identychain.Program;

import com.identychain.SecureHWID.SerialNumberLinux;
import com.identychain.SecureHWID.SerialNumberMac;
import com.identychain.SecureHWID.SerialNumberWindows;
import com.identychain.SecureHWID.OSValidator;

import java.util.Scanner;


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
        int option = scanner.nextInt();
        if (option == 1) {
            CreateToken token = new CreateToken();
            String name = token.inputName();
            System.out.println("El nombre introducido es: " + name);
            if(OSValidator.isWindows() == true) {
                String serialnb = SerialNumberWindows.getSerialNumber();
                System.out.println("Su número de serie es: " + serialnb);
            }
            else if(OSValidator.isMac() == true) {
                String serialnb = SerialNumberMac.getSerialNumber();
                System.out.println("Su número de serie es: " + serialnb);
            }
            else if (OSValidator.isUnix() == true) {
                String serialnb = SerialNumberLinux.getSerialNumber();
                System.out.println("Su número de serie es: " + serialnb);
            }
               String password = token.getPassword();
            String token1 = token.getToken();
            System.out.println("Su token generado es: " + token1);
        }
        if (option == 2) {
            Identification identificacion = new Identification();
        }
    }
}
