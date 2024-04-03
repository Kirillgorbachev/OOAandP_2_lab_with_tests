package org.example;

public abstract class FileReadingStrategy {
    public abstract void readFromFile(String fileName);

    public void templateMethod(){
        printName();
        printDescription();
        calculateAndPrintExecutionTime();
    }

    public abstract void printName();
    public abstract void printDescription();

    public abstract void calculateAndPrintExecutionTime();
}

