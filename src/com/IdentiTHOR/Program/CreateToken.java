package com.IdentiTHOR.Program;

import com.IdentiTHOR.SecureHWID.OSValidator;
import com.IdentiTHOR.SecureHWID.SerialNumberLinux;
import com.IdentiTHOR.SecureHWID.SerialNumberMac;
import com.IdentiTHOR.SecureHWID.SerialNumberWindows;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class CreateToken {
    private String name;
    private String email;
    private String token;
    private String password;

    public CreateToken(){

    }
    public String createName() {
        System.out.println("Introduzca su nombre a continuación");
        Scanner scanner1 = new Scanner(System.in);
        name = scanner1.nextLine();
        return name;
    }

    public String getToken() {
        String tokenCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 21) { // length of the random string.
            int index = (int) (rnd.nextFloat() * tokenCHARS.length());
            salt.append(tokenCHARS.charAt(index));
        }
        String randomTok = salt.toString();
        return randomTok;

    }

    public String getSN() {
        String serialnbXML = null;
        if (OSValidator.isWindows() == true) {
            serialnbXML = SerialNumberWindows.getSerialNumber();
            System.out.println("Su número de serie es: " + serialnbXML);
        } else if (OSValidator.isMac() == true) {
            serialnbXML = SerialNumberMac.getSerialNumber();
            System.out.println("Su número de serie es: " + serialnbXML);
        } else if (OSValidator.isUnix() == true) {
            serialnbXML = SerialNumberLinux.getSerialNumber();
            System.out.println("Su número de serie es: " + serialnbXML);
        }
        return serialnbXML;
    }
    public String getPassword() {
        System.out.println("Por favor, introduzca su contraseña a continuacion:");
        Scanner scanner = new Scanner(System.in);
        password = scanner.nextLine();
        System.out.println("Confirme su contraseña nuevamente:");
        String passwordConfirm = scanner.nextLine();
        if(Objects.equals(password, passwordConfirm) == false) {
            System.out.println("Fallo de contraseña, intentelo de nuevo.");
            return getPassword();
        }
        return password;
    }
    public String getEmail() {
        System.out.println("Introduzca su correo electronico:");
        Scanner scanner = new Scanner(System.in);
        email = scanner.nextLine();
        return email;
    }
}
