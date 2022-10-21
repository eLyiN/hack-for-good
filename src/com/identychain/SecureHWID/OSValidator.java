package com.identychain.SecureHWID;

public class OSValidator {
    private static String OS = System.getProperty("os.name").toLowerCase();

    public static void main(String[] args) {

        System.out.println("os.name: " + OS);

        if (isWindows()) {
            System.out.println("Su sistema es Windows");
        } else if (isMac()) {
            System.out.println("Su sistema es Mac");
        } else if (isUnix()) {
            System.out.println("Su sistema es Linux");
        } else {
            System.out.println("Su sistema no es compatible!!");
        }
    }

    public static boolean isWindows() {
        return (OS.contains("win"));
    }

    public static boolean isMac() {
        return (OS.contains("mac"));
    }

    public static boolean isUnix() {
        return (OS.contains("nix")
                || OS.contains("nux")
                || OS.contains("aix"));
    }
}
