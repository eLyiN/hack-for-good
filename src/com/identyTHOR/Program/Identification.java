package com.identyTHOR.Program;


public class Identification {

    private String password;
    private String serialNumber;
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public Identification(String password, String serialNumber) {
        super();
    }
}
