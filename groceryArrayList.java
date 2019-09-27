package Grocery;

import java.util.ArrayList;

public class groceryArrayList {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addGroceryItem(String item){
        groceryList.add(item);
    }

    public ArrayList<String> getGroceryList(){
        return groceryList;
    }

    public void removeGroceryItem(String removeItem){
        groceryList.remove(removeItem);
        System.out.println(removeItem + " has been removed from the list");
    }

    public void printGroceryItem(){
        System.out.println("You have "+groceryList.size()+" items in your grocery list");
        for (int i = 0; i < groceryList.size(); i++){
            System.out.println((i+1)+". "+groceryList.get(i));
        }
    }

    public void modifyGroceryItem(String item, String newItem){
        int position = groceryList.indexOf(item);
        groceryList.set(position, newItem);
        System.out.println("Grocery item "+item+" has been modified to "+newItem);
    }

    public boolean searchGroceryItem(String searchItem){
        boolean checker = groceryList.contains(searchItem);
        if(checker){
            return true;
        }
        return false;
    }
}
