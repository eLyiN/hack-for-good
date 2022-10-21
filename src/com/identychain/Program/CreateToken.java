package com.identychain.Program;

import java.util.Scanner;

public class CreateToken {
    private String name;
    private String email;
    private String token;

    public String getName() {
        System.out.println("Introduzca su nombre a continuación");
        Scanner scanner = new Scanner(System.in);
        System.out.println("El nombre introducido es el siguiente: " + scanner.toString());
        name = scanner.nextLine();
        return name;
    }

    public String getToken() {
        String token = RandomToken.alphanum;
        System.out.println("El nombre introducido es el siguiente: " + token);
        return token;
    }

    public String getEmail() {
        return email;
    }
}
