import java.util.*;
public class Main {
    static class Pair{
    	double quantity;
    	double price;
    	Pair(double quantity,double price){
    		this.quantity=quantity;
    		this.price=price;
    	}
    }
    static class GroceryList{
    	HashMap<String,Pair> map;
    	double budget;
    	public GroceryList(double budget) {
    		this.map = new HashMap<>();
    		this.budget=budget;
    	}
    	public void addItem(String item,double quantity,double price) {
    		if(this.budget<price) {
    			System.out.println("Can't Buy the product ###(because budget left is "+this.budget+")");
                return;
    		}
    		if(map.containsKey(item)) {
    			Pair cc = map.get(item);
    			cc.quantity+=quantity;
    			cc.price+=price;
    			map.put(item, cc);
    		}
    		else {
    			Pair cc = new Pair(quantity,price);
    			map.put(item, cc);
    		}
    		this.budget-=price;
            System.out.println("Amount left : "+this.budget);
    	}
    	public void itemInBudget() {
    		for(String key:map.keySet()) {
    			if(map.get(key).price<=this.budget) {
    				System.out.println("Amount left can buy you "+key);
    				return;
    			}
    		}
    	}
    	public boolean budgetZero() {
    		return this.budget==0;
    	}
    	public void displayGrocery() {
    		System.out.println("GROCERY LIST is:");
    		System.out.println("Product name\t Quantity\t Price");
    		for(String key:map.keySet()) 
    			System.out.println(key+"\t"+this.map.get(key).quantity+"kg\t"+this.map.get(key).price);
    	}
    }
    public static void main(String[] args){
    	Scanner s = new Scanner(System.in);
    	System.out.println("Enter Your Budget : ");
    	double budget = s.nextDouble();
    	GroceryList list = new GroceryList(budget);
    	while(true) {
    		if(list.budgetZero()) {
    			System.out.println("Your balance is Zero can't continue");
     	        break;
    		}
    		System.out.println("1.Add an item");
    		System.out.println("2.Exit");
    		System.out.println("Enter your choice : ");
    		int choice = s.nextInt();
    		if(choice==1) {
    			System.out.println("Enter product : ");
    	        String item = s.next();
    	        System.out.println("Enter quantity (in kg) : ");
    	        double quantity = s.nextDouble();
    	        System.out.println("Enter Price : ");
    	        double price = s.nextDouble();
    	        list.addItem(item,quantity,price);
    		}
    	    else {
    	        list.itemInBudget();
    	        break;
    	    }
    	}
    	list.displayGrocery();
    }
}

