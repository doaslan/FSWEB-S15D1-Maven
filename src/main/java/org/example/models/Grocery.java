package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n0 - Çıkış");
            System.out.println("1 - Ürün ekle");
            System.out.println("2 - Ürün çıkar");
            System.out.print("Seçiminiz: ");

            String choice = scanner.nextLine();

            if (choice.equals("0")) {
                break;
            } else if (choice.equals("1")) {
                System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                String input = scanner.nextLine();
                addItems(input);
            } else if (choice.equals("2")) {
                System.out.println("Çıkarılmasını istediğiniz elemanları giriniz.");
                String input = scanner.nextLine();
                removeItems(input);
            } else {
                System.out.println("Geçersiz seçim!");
            }
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String product = item.trim();

            if (!product.isEmpty() && !checkItemIsInList(product)) {
                groceryList.add(product);
            }
        }

        printSorted();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String product = item.trim();

            if (!product.isEmpty() && checkItemIsInList(product)) {
                groceryList.remove(product);
            }
        }

        printSorted();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product.trim());
    }

    public static void printSorted() {
        Collections.sort(groceryList);

        System.out.println("Grocery List:");

        for (String item : groceryList) {
            System.out.println(item);
        }
    }
}