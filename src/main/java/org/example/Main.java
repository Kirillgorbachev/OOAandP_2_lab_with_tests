package org.example;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader(new LettersReadingStrategy());
        reader.templateMethod();

//        reader.setStrategy(new LettersReadingStrategy());
//        reader.read("test.txt");

        System.out.println("---------------------");

        reader.setStrategy(new NumbersReadingStrategy());
        reader.templateMethod();
//        reader.read("test.txt");

        System.out.println("---------------------");

        reader.setStrategy(new AlphanumericReadingStrategy());
        reader.templateMethod();
//        reader.read("test.txt");
    }
}