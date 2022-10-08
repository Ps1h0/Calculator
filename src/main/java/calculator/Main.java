package calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение для подсчета: ");
        String num = scanner.nextLine();
        System.out.println(calculator.calculate(num));
    }
}
