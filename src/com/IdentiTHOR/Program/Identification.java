package com.IdentiTHOR.Program;


import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.exit;

public class Identification {

    public Identification(){
    }

    public void identiThorInterface(String name, String serialNumber, String token) {

        System.out.println("Bienvenid@ "+ name);
        System.out.println("Serial Number: "+ serialNumber);
        System.out.println("Token: "+ token);
        while (true) {
            System.out.println("Elija una de las siguientes opciones:");
            System.out.println("    1. Ver la trazabilidad de sus datos");
            System.out.println("    2. Modificar los datos");
            System.out.println("    3. Cambiar la contraseña");
            System.out.println("    4. Generar nuevo token");
            System.out.println("    5. Borrar todos sus datos");
            System.out.println("    6. Salir");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            if (option == 1) {
                getTraceability(token);
            } else if (option == 2) {
                modifyData(token);
            } else if (option == 3) {
                changePassword(token);
            } else if (option == 4) {
                String newToken = new CreateToken().getToken();
            } else if (option == 5) {
                eraseAllData(token);
            } else if (option == 6) {
                exit(0);
            } else {
                System.out.println("Invalid option");
                identiThorInterface(name, serialNumber, token);
            }
        }
    }

    private void eraseAllData(String token) {
        System.out.println("Su token sera destruido y con ello toda información relacionada en la cadena de bloques(IdentiTHOR)");
        System.out.println("¿Esta usted seguro?[y/N]");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        if (Objects.equals(option, "y")) {
            destroyToken(token);
        }
    }

    private void destroyToken(String token) {
        System.out.println("El borrado se ha completado");
        System.out.println("Token: "+ token + "con HASH: 6c94602b1124aee29b5fd3a573ca96b5 ha sido destruido");
        System.out.println("Genere un nuevo token para volver a utilizar su identidad");
        return;
    }

    private void changePassword(String token) {
        // TODO
    }

    private void modifyData(String token) {
        System.out.println("Modificar token: "+ token);
        System.out.println("    1. Nombre");
        System.out.println("    2. Email");
        System.out.println("    3. Salir");
        // TODO SELECCION
    }

    private void getTraceability(String token) {
        if (token == null) {
            System.out.println("Fallo en el token, genere un nuevo token");
        }
        else if (token.equals(isInBlockchain(token)))
        {
            String addressThorChain = "0xc0ffee254729296a45a3885639AC7E10F9d54979";
            String tagAddressThorChain = "PcComponentes";
            String hashThorChain = "6c94602b1124aee29b5fd3a573ca96b2";
            System.out.println("        Token "+ token + " con HASH: " + hashThorChain);
            System.out.println("            Dirección: " + addressThorChain + " con identificador " + tagAddressThorChain);
        }
    }

    private String isInBlockchain(String token) {
        String tokenThorChain = token;
        System.out.println("        ¡¡Token encontrado, retornando trazabilidad!!");
        return tokenThorChain;
    }
}
