package Grocery;

import Grocery.groceryArrayList;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GroceryMenu {
    private static Scanner scanner = new Scanner(System.in);
    private static groceryArrayList groceryList = new groceryArrayList();

    public static void main(String[] args){
        boolean quit = true;
        printInstructions();
        while(quit) {
            System.out.println("Enter Choice of options");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice > 7 || choice < 0){
                    System.out.println("option mush be between 0 and 6");
                }
                switch (choice) {
                    case 0:
                        printInstructions();
                        break;
                    case 1:
                        printGrocery();
                        break;
                    case 2:
                        addGrItem();
                        break;
                    case 3:
                        modifyItem();
                        break;
                    case 4:
                        removeItem();
                        break;
                    case 5:
                        searchItem();
                        break;
                    case 6:
                        copyArrayList();
                        break;
                    case 7:
                        quit = false;
                        break;
                }
            } catch (InputMismatchException choice){
                System.out.println("Sorry that input is not valid");
                quit = false;
            }

        }
    }

    public static void printInstructions(){
        System.out.println("\nPress");
        System.out.println("0 - To print choice options.");
        System.out.println("1 - To print the list of the grocery items.");
        System.out.println("2 - To add items to the list.");
        System.out.println("3 - To modify an item in the list.");
        System.out.println("4 - To remove an item from the list.");
        System.out.println("5 - To search for an item in the list.");
        System.out.println("6 - To copy the list to another list.");
        System.out.println("7 - To quit the application.");
    }

    public static void printGrocery(){
        groceryList.printGroceryItem();
    }

    public static void addGrItem(){
        System.out.print("Enter grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem(){
        System.out.print("Enter item to modify: ");
        String item = scanner.nextLine();
        if(searchItem(item)){
            System.out.print("Enter to replace it with: ");
            String newItem = scanner.nextLine();
            groceryList.modifyGroceryItem(item, newItem);
        }
    }

    public static void removeItem(){
        System.out.print("Enter the name of item to removed: ");
        String name = scanner.nextLine();
        if(searchItem(name)) {
            groceryList.removeGroceryItem(name);
        }
    }

    public static void searchItem(){
        System.out.println("Enter item to search for: ");
        String searchItem = scanner.nextLine();
        if(groceryList.searchGroceryItem(searchItem)){
            System.out.println("Found "+searchItem+ " in grocery list");
        } else{
            System.out.println(searchItem + " is not in the shopping list");
        }
    }

    public static boolean searchItem(String searchItem){
        if(groceryList.searchGroceryItem(searchItem)){
            return true;
        } else{
            System.out.println(searchItem + " is not in the shopping list");
            return false;
        }
    }

    public static void copyArrayList(){
        ArrayList<String> newArrayL = new ArrayList<>();
        newArrayL.addAll(groceryList.getGroceryList());

      //  ArrayList<String> nextArray = new ArrayList<>(groceryList.getGroceryList());
        System.out.println("New Grocery list");
        for (int i = 0 ; i < newArrayL.size(); i ++){
            System.out.println((i+1) +" "+newArrayL.get(i));
        }

    }
}
