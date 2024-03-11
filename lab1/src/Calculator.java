import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define complex numbers
        ComplexNumber num1 = new ComplexNumber(2, 5);
        ComplexNumber num2 = new ComplexNumber(4, -1);


        //The number
        System.out.println("Our numbers are:2+5i and 4-i");
        System.out.println("Select the operation you want to make from the menu.");
        // Display menu
        System.out.println("Complex Number Calculator Menu:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");

        // Get user choice
        System.out.print("Enter the operation you want to make (1, 2, or 3): ");
        int choice = scanner.nextInt();

        // Perform operation based on user's choice
        ComplexNumber result;
        switch (choice) {
            case 1:
                result = num1.add(num2);
                System.out.println("Result of Addition: " + result);
                break;
            case 2:
                result = num1.subtract(num2);
                System.out.println("Result of Subtraction: " + result);
                break;
            case 3:
                result = num1.multiply(num2);
                System.out.println("Result of Multiplication: " + result);
                break;
            default:
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
        }

        scanner.close();
    }
}

class ComplexNumber {
    private double real;
    private double imag;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imag = imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imag + other.imag);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imag - other.imag);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        // (a + bi) * (c + di) = (ac - bd) + (ad + bc)i
        double resultReal = this.real * other.real - this.imag * other.imag;
        double resultImaginary = this.real * other.imag + this.imag * other.real;
        return new ComplexNumber(resultReal, resultImaginary);
    }

    @Override
    public String toString() {
        return real + " + " + imag + "i";
    }
}