package org.example;

import java.util.Scanner;

public class TemperatureAnalyzer {
    public static void main(String[] args) {
        // Part 1: Input and String Parsing
        Scanner sc = new Scanner(System.in);

        double day1TempPrimitive = 0.0d;
        double day2TempPrimitive = 0.0d;

        System.out.print("Enter Day 1 High Temperature (e.g., 28.5): ");
        String day1TempStr = sc.nextLine();
        System.out.print("Enter Day 2 High Temperature (e.g., 28.5): ");
        String day2TempStr = sc.nextLine();
        System.out.print("Enter Day 3 High Temperature (e.g., 28.5): ");
        String day3TempStr = sc.nextLine();

        System.out.println("\n--- Temperature Analysis ---");

        try {
            day1TempPrimitive = Double.parseDouble(day1TempStr);
            System.out.println("\nParsed Day 1 Temp (primitive double): " + day1TempPrimitive);
        } catch (NumberFormatException e){
            System.out.println("Invalid input. Please try again and enter a valid number.");
            System.exit(0);
        }

        try {
            day2TempPrimitive = Double.parseDouble(day2TempStr);
            System.out.println("Parsed Day 2 Temp (primitive double): " + day2TempPrimitive);
        } catch (NumberFormatException e){
            System.out.println("Invalid input. Please try again and enter a valid number.");
            System.exit(0);
        }

        // Part 2: Wrapper Object Creation (valueOf)
        Double day1TempWrapper = Double.valueOf(day1TempPrimitive);
        Double day2TempWrapper = Double.valueOf(day2TempPrimitive);

        // Part 3: Comparison (compareTo)
        int result = day1TempWrapper.compareTo(day2TempWrapper);

        if (result == -1){
            System.out.println("\nDay 1 ("+ day1TempWrapper +"°C) was cooler than Day 2 ("+ day2TempWrapper + "°C)");
        } else if (result == 1){
            System.out.println("\nDay 1 ("+ day1TempWrapper +"°C) was warmer than Day 2 ("+ day2TempWrapper + "°C)");
        } else if (result == 0){
            System.out.println("\nDay 1 ("+ day1TempWrapper +"°C) was the same temperature as Day 2 ("+ day2TempWrapper + "°C)");
        }

        // Part 4: Primitive Extraction (xxxValue)
        float day1TempFloat = day1TempWrapper.floatValue();
        int day2TempInt = day2TempWrapper.intValue();
        System.out.println("\nExtracted Day 1 Temp (primitive float from Double wrapper): " + day1TempFloat);
        System.out.println("Extracted Day 2 Temp (primitive int from Double wrapper, truncated): " + day2TempInt);

        // Part 5: Extension (For the Third Temperature & Finding Max)
        double day3TempPrimitive = Double.parseDouble(day3TempStr);
        Double day3TempWrapper = Double.valueOf(day3TempPrimitive);

        double max = Math.max(day1TempPrimitive, Math.max(day2TempPrimitive,day3TempPrimitive));
        System.out.println("\nThe highest temperature recorded was: " + max + "°C");

    }
}