package exercise5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> numbers = parseList(sc);
        List<String> urls = parseList(sc);

        Smartphone smartphone = new Smartphone(numbers, urls);
        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }

    private static List<String> parseList(Scanner sc) {
        return Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());
    }
}
