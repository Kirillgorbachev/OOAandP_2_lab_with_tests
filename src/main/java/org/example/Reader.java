package org.example;

public class Reader {
    private FileReadingStrategy strategy;

    public Reader(FileReadingStrategy strategy) {this.strategy = strategy;}

    public void setStrategy(FileReadingStrategy strategy) {
        this.strategy = strategy;
    }

    public void read(String fileName) {
        strategy.readFromFile(fileName);
    }

    public void templateMethod(){
        this.strategy.templateMethod();
    }
}
