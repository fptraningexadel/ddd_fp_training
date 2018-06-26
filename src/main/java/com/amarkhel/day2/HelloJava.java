package com.amarkhel.day2;

public class HelloJava {

    static boolean val  = false;
    public static void main(String[] args) {

        String a = "123";
        a.chars().anyMatch(Character::isUpperCase);
        System.out.println("Hello Java");
        val = true;
    }
}
