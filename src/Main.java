import java.util.ArrayList;

interface Ingredient{
    public String getName();
    public double getQuantity();

}

class SolidIngredient implements Ingredient{
    private String _name;
    private double _quantity;
    public SolidIngredient( String n, double q){
        _name = n;
        _quantity = q;
    }
    public String getName(){
        return _name;
    }
    public double getQuantity(){
        return  _quantity;
    }

}
class LiquidIngredient implements Ingredient{
    private String _name;
    private double _quantity;
    public void LiquidIngredient( String n, double q){
        _name = n;
        _quantity = q;
    }
    public String getName(){
        return _name;
    }
    public double getQuantity(){
        return  _quantity;
    }

}
class Recipe <T extends Ingredient> {
    private String _name;
    private String _instructions;
    private ArrayList<T> _ingredients;
    //    public Recipe(){
//        _ingredients = new ArrayList<T>();
//    }
    public Recipe(String n, String i){
        _name = n;
        _instructions = i;
        _ingredients = new ArrayList<>();
    }
    public void addIngredient(T t){
        _ingredients.add(t);
    }
    public void print(){
        if(_ingredients != null)
            System.out.println("Name: " + _ingredients.getClass().getName()
                    + ", instructions" + _instructions.getClass().getName()
                    + "ingredients " + _ingredients.getClass().getName());
        else
            System.out.println("This is null");
    }
}

public class Main {
    public static void main(String[] args) {
        Recipe<Ingredient> r = new Recipe<Ingredient>("Mac n Cheese", "Add cheese");

        r.addIngredient(new SolidIngredient("flour", 4));
    }
    public void menu(){

    }
}