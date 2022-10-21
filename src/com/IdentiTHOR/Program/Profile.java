package com.IdentiTHOR.Program;

/**
 * Objecto reservado para los perfiles de la Base de datos de Blockchain.
 *
**/
public class Profile {
    private String name;
    private String serialNumber;
    private String password;
    private String email;
    private String token;
    private String addressThorChain;

    public void createProfile(String name, String serialNumber, String password, String email, String token){
        this.name = name;
        this.serialNumber = serialNumber;
        this.password = password;
        this.email = email;
        this.token = token;
        this.addressThorChain = null;
    }

    }

