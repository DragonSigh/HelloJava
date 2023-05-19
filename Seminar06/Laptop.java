package Seminar06;

public class Laptop {
    Integer ID;
    Integer RAM;
    Double inches;
    Double weight;
    Double price;
    String company;
    String product;
    String type;    
    String CPU;

    Laptop(Integer ID, Integer RAM, Double inches, Double weight, Double price, String company, String product, String type, String CPU) {
        this.ID = ID;        
        this.RAM = RAM;
        this.inches = inches;
        this.weight = weight;
        this.price = price;
        this.company = company;
        this.product = product;
        this.type = type; 
        this.CPU = CPU;
    }

    void printInfo() {
        System.out.printf("ID=%d; RAM=%d; inches=%.1f; weight=%.2f; price=%.3f; company=%s; product=%s; type=%s; CPU=%s\n", ID, RAM, inches, weight, price, company, product, type, CPU);
    }
}