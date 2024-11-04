import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

interface Ingredient{
    public String getName();
    public double getQuantity();

}

class SolidIngredient implements Ingredient{
    private String _name;
    private double _qtyInG;
    public SolidIngredient( String n, double q){
        _name = n;
        _qtyInG = q;
    }
    public String getName(){
        return _name;
    }
    public double getQuantity(){
        return  _qtyInG;
    }

}
class LiquidIngredient implements Ingredient{
    private String _name;
    private double _qtyInMi;
    public  LiquidIngredient( String n, double q){
        _name = n;
        _qtyInMi = q;
    }
    public String getName(){
        return _name;
    }
    public double getQuantity(){
        return  _qtyInMi;
    }

}
//extends not implements
//class
class Recipe <T extends Ingredient> {
    private String _name;
    private String _instructions;
    private ArrayList<T> _ingredients;

    //    public Recipe(){
//        _ingredients = new ArrayList<T>();
//    }
    public Recipe(String n, String i) {
        _name = n;
        _instructions = i;
        _ingredients = new ArrayList<>();
    }

    public void addIngredient(T t) {
        _ingredients.add(t);
    }

    public void printRecipe() {
        System.out.println("Recipe: " + _name);
        System.out.println("Instructions: " + _instructions);
        System.out.println("Ingredients:");
        for (T ingredient : _ingredients) {
            System.out.println(" - " + ingredient);
        }
    }
}

public class Main {
    public static void addIngredient(Recipe<Ingredient> recipe, Scanner scan) {
        System.out.println("Is the ingredient solid (s) or liquid (l): ");
        char type = scan.nextLine().charAt(0);
        System.out.println("Enter the ingredient name: ");
        String name = scan.nextLine();
        System.out.println("Enter quantity: ");
        double quantity = Double.parseDouble(scan.nextLine());
        Ingredient ingredient;
        if (type == 's') {
            ingredient = new SolidIngredient(name, quantity);
        } else {
            ingredient = new LiquidIngredient(name, quantity);
        }
        recipe.addIngredient(ingredient);
    }

    public static int Menu(Scanner scan) {
        System.out.println("Recipe Menu: ");
        System.out.println("Add ingredient (Enter 1): ");
        System.out.println("List all ingredients (Enter 2): ");
        System.out.println("Exit (Enter 3): ");
        System.out.println("Enter choice here: ");
        int choice = 3; // or = scan.nextInt;
        String userInput = scan.nextLine();
        try {
            choice = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid" + e.getMessage());
        }
        return choice;
    }

    public static void main(String[] args) {
        ArrayList<Ingredient> stuff = new ArrayList<>();
        Recipe<Ingredient> recipe;
//        = new Recipe<Ingredient>("Mac n Cheese", "Add cheese");
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter an ingredient name: ");
        String name = scan.nextLine();
        System.out.println("Enter instructions: ");
        String instructions = scan.nextLine();
        recipe = new Recipe<Ingredient>(name, instructions);

//        recipe.addIngredient(new SolidIngredient("flour", 4));
//        scan.hasNextLine();

        int userinput = Menu(scan);
        while (userinput != 3) {
            switch (userinput) {
                case 1 -> addIngredient(recipe, scan);
                case 2 -> recipe.printRecipe();
                default -> System.out.println("Invalid option- Try again");
            }
            System.out.println("Enter choice here: ");
            userinput = Menu(scan);
        }
        scan.close();
    }
}