package project358;

public class User {
	private String name;
	private static int nextID = 100; //Uniquely identify user static member
	private final int id;
	private double weight;
	public User(String name, double weight) {
		this.name = name;
		this.weight = weight;
		this.id= nextID++;
	}
	//Overloaded constructor and delegating with this()
	public User(double weight) {
		this("Anonymous", weight);
	}
	
	
	public int getID () {return id;}
	public String getName () {return name;}
	public double getWeight () {return weight;}
	
}
