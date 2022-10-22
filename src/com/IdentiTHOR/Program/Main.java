package com.IdentiTHOR.Program;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import static com.IdentiTHOR.SecureHWID.SerialNumberWindows.getSerialNumber;
import static java.lang.System.exit;


public class Main {
    static String snXML;
    static String nameXML;
    static String passwordXML;
    static String tokenXML;
    static String emailXML;

    public static void main(String[] args) throws IOException {
        System.out.println("Bienveni@ a la versión 1.0 de IdentiTHOR");
        System.out.println("Elija una de las siguientes opciones:");
        while (true) {
            System.out.println("    1. Crear token de identidad de IdentiTHOR");
            System.out.println("    2. Identificar en la Blockchain de IdentiTHOR");
            System.out.println("    3. Importar token de identidad");
            System.out.println("    4. Exportar token de identidad");
            System.out.println("    5. Salir");

            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> {
                    if (Objects.equals(snXML, getSerialNumber())) {
                        System.out.println("Este numero de serie ya esta en uso");
                        break;
                    }
                    nameXML = new CreateToken().createName();
                    System.out.println("El nombre introducido es: " + nameXML);
                    snXML = new CreateToken().getSN();
                    passwordXML = new CreateToken().getPassword();
                    emailXML = new CreateToken().getEmail();
                    tokenXML = new CreateToken().getToken();
                    System.out.println("Su perfil ha sido creado correctamente");
                    System.out.println("Este es su token, guardelo en un lugar seguro: " + tokenXML);
                }
                case 2 -> {
                    System.out.println("Su número de serie es " + getSerialNumber());
                    if (Objects.equals(snXML, getSerialNumber())) {
                        System.out.println("Actualmente usted posee un token de identidad en la Blockchain de IdentiTHOR");
                        System.out.println("Para ingresar, por favor introduzca su contraseña:");
                        Scanner scannerIdentification = new Scanner(System.in);
                        String identification = scannerIdentification.nextLine();
                        if (Objects.equals(identification, passwordXML)) {
                            System.out.println("Se ha logeado correctamente");
                            new Identification().identiThorInterface(nameXML, snXML, tokenXML);
                        } else {
                            int count = 0;
                            while (!Objects.equals(identification, passwordXML) || count != 3) {
                                System.out.println("ESTA ES LA PASSWORD" + passwordXML);
                                count++;
                                System.out.println("La contraseña es incorrecta, por favor intentelo de nuevo");
                                System.out.println("Le quedan " + (3 - count) + " intentos");
                                identification = scannerIdentification.nextLine();
                            }
                            System.out.println("No le quedan mas intentos, su numero de serie se bloqueara por 15 minutos, vuelva a intentarlo mas tarde");
                            // TO DO: Lock time;
                        }
                    } else {
                        System.out.println("Actualmente usted no posee un token de identidad en la Blockchain de IdentyTHOR");
                    }
                }
                case 3 -> {
                    ImportAddress importAddress = new ImportAddress(tokenXML);

                }
                case 4 -> {
                    ExportAddress exportAddress = new ExportAddress(tokenXML);
                }
                case 5 -> {
                    System.out.println("¡Hasta pronto!");
                    exit(0);
                }
                default ->
                System.out.println("La opción seleccionada no esta disponible, intentelo de nuevo");
            }

        }

    }
}
