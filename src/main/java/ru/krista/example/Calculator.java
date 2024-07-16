package ru.krista.example;

import java.util.Scanner;

public class Calculator {
    private Integer num1 = 0;
    private Integer num2 = 0;
    private Integer result = 0;
    private boolean zero = true;
    private String[] parts;
    public void getEquation(){
        System.out.print("Enter math expression with +, -, * or / \n");
        Scanner in = new Scanner(System.in);
        String expr = in.nextLine();
        in.close();
        parts = expr.split(" ");
        
        try {
        num1 = Integer.parseInt(parts[0]);
        } catch (NumberFormatException e) {
        System.out.println("Не удалось получить число из: " + expr);
        zero = false;
        }
        try {
        num2 = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
        System.out.println("Не удалось получить число из: " + expr);
        zero = false;
        }
    }
    public void add(){
        result = num1 + num2;
    }
    public void difference(){
        result = num1 - num2;
    }public void multiplication(){
        result = num1 * num2;
    }public void division(){
        if(num2.equals(0)) {
            System.out.println("division by 0\n");
            zero = false;
        } else {
            result = num1 / num2;
        }
    }
    public void doMath(){
        switch (parts[1]) {
            case "+":
                add();
                break;
            case "-":
                difference();
                break;
            case "*":
                multiplication();
                break;
            case "/":
                division();
                break;
            default: System.out.println("Unsupported sign\n");
            }
            if(!zero) result = null;
    }
    public void printResult(){
        if(result != null) System.out.println(result);
    }
}