package project358;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;



public class Food implements Comparable<Food>{
	public final String name;
	public final double protein;
	public final double carbs;
	public final double fat;
	public final double calories;
	
	public Food (String name, double protein, double carbs, double fat) {
		this.name = name;
		this.protein = protein;
		this.carbs = carbs;
		this.fat = fat;
		this.calories = protein*4 + carbs*4 + fat*9;
	}
	
	
	public static List<Food> readFoodLog() {
		List<Food> foods = new ArrayList<>();
		
		//try with resources to obtain foods and macros
		try (BufferedReader in = new BufferedReader(new FileReader("FoodLog.txt"))) {
				String line;
				while ((line = in.readLine()) != null) {
					try {
						String[] parts = line.split(",");
						if(parts.length != 4) {throw new IllegalArgumentException ("Invalid food entry" + line);}
						String name = parts[0].trim();
				
						double protein = Double.parseDouble(parts[1].trim());
						double carbs = Double.parseDouble(parts[2].trim());
						double fat = Double.parseDouble(parts[3].trim());
				
						foods.add(new Food(name, protein, carbs, fat));
					} catch (IllegalArgumentException e) {System.out.println("Cannot read line: " + e.getMessage());}
				}
		} catch (IOException e) {
			System.out.println("Could not process the file: " + e.getMessage());
		}
		return foods;
	}
	//List used to store foods to then be used for sorted printing
	public void printMacros(List<Food> foods) {
		double totalCalories = 0;
		double totalProtein = 0;
		double totalCarbs = 0;
		double totalFat = 0;
		
		for (Food food: foods) {
			totalCalories += food.calories;
			totalProtein += food.protein;
			totalCarbs += food.carbs;
			totalFat += food.fat;
		}
		if (totalCalories == 0) {
			System.out.println("No food was found");
			return;
		}
		
		System.out.println("Total Nutrition");
		System.out.println("__________________________________");
		System.out.println("Calories: " + totalCalories);
		System.out.println("Protein: " + totalProtein);
		System.out.println("Carbs: " + totalCarbs);
		System.out.println("Fat: " + totalFat);
		System.out.println("__________________________________");
		System.out.println("Foods (Ascending Calories)");
		System.out.println("__________________________________");
		
		foods.sort(Comparator.comparingDouble(food -> food.calories));
		for (Food food: foods) {
			System.out.println(food.name);
		}
	}
	
	@Override
	public int compareTo(Food other) {
		return Double.compare(this.calories, other.calories);
	}
	
	
	
}
	