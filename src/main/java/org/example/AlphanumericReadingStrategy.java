package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AlphanumericReadingStrategy extends FileReadingStrategy {
    @Override
    public void readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                result.append(line.replaceAll("[^a-zA-Z0-9]", ""));
            }
            reader.close();
            System.out.println("Result: " + result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printName() {
        System.out.println("Algorithm: AlphanumericReadingStrategy");
    }

    @Override
    public void printDescription() {
        System.out.println("Description: Reads letters and numbers from the file.");
    }

    @Override
    public void calculateAndPrintExecutionTime(){
        long startTime = System.nanoTime();
        Reader reader = new Reader(new AlphanumericReadingStrategy());

        reader.setStrategy(new AlphanumericReadingStrategy());
        reader.read("test.txt");
        long endTime = System.nanoTime();
        System.out.println("Execution Time: " + (endTime - startTime) + " nanoseconds");
    }
}
