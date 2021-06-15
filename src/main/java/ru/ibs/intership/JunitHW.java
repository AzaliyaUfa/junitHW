package ru.ibs.intership;

import java.io.*;
import java.util.Scanner;

public class JunitHW {

    public static void main(String[] args) throws IOException {
        mainMethod();

    }

    public static void mainMethod() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Print the address of the file");

        try (BufferedReader br = new BufferedReader(new FileReader(sc.nextLine()))) {
            while (br.ready()) {
                actionWithContent(br);
            }
        } catch (IOException e) {
            System.out.println("File creation error");
            e.printStackTrace();
            throw new IOException("Invalid file path");
        }
    }

    public static void actionWithContent(BufferedReader br)  {
        try {
            Integer num = Integer.parseInt(br.readLine());
            System.out.println(fizzBuzz(num));
        } catch (NumberFormatException | IOException ex) {
            ex.printStackTrace();
            throw new NumberFormatException("File must contain only numbers one by one!");
        }
    }

    public static String fizzBuzz(Integer num) {
            if (num % 3 == 0 && num % 5 == 0) {
                return "FizzBuzz";
            } else if (num % 3 == 0) {
                return "Fizz";
            } else if (num % 5 == 0) {
                return "Buzz";
            } else {
                return num.toString();
            }
    }

}
