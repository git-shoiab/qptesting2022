package day2;

public class AbstractDemo {
	public static void main(String[] args) {
		Dominos dominos=new TuljhaDomino();
		dominos.orderPizza();
	}
}

abstract class Dominos{
	final private void makeDough() {
		System.out.println("making dough as per dominos...");
	}
	final private void addIngredients() {
		System.out.println("adding ingredients as per dominos...");
	}
	final private void bakePizza() {
		System.out.println("baking as per dominos...");
	}
	
	final private void makePizza() {//template method
		makeDough();
		addIngredients();
		bakePizza();
	}
	final public void orderPizza() {//template method
		payment();
		makePizza();
		delivery();
	}
	public abstract void payment();
	public abstract void delivery();
}


class TuljhaDomino extends Dominos{
	@Override
	public void delivery() {
		System.out.println("delivery as per indian standards....tuljha will decide..");
	}
	@Override
	public void payment() {
		System.out.println("payment recd as per tuljha money handling...");
	}
}