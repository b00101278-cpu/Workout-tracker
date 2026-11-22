package project358;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.printf("Enter user name: ");
		String name = in.nextLine();
		System.out.printf("Enter bodyweight(kg): ");
		double weight = Double.parseDouble(in.nextLine());
		User user;
		if (name.isBlank()) {user = new User(weight);}
		else {user = new User(name, weight);}
		Workout workout = new Workout("My Workout");
		
		
		while (true) {
			System.out.printf("\n1. Add exercise\n2. Log workout\n3. Calculate daily macros\n4. Exit\n\nChoice: ");
			String choice = in.nextLine();
			try {
				switch(choice) {
					case "1": {
						System.out.printf("\nType:\ncalisthenics\nmodifiedcalisthenics\nmachine\nfreeweight\nexit\n\nChoice: ");
						String type = in.nextLine();
							if(type.equals("back")) {break;}
							if (!type.equals("calisthenics") && !type.equals("modifiedcalisthenics")&& !type.equals("machine") && !type.equals("freeweight")) {
								throw new IllegalArgumentException("Unknown value for exercise");
							}
						
							System.out.printf("Exercise Name: ");
							String exName = in.nextLine();
							
							System.out.printf("Target muscle: ");
							String muscle = in.nextLine().trim();
							
							double ratio = 0;
							double exWeight = 0;
							double magnitude = 0;
							double increment = 0;
							String weightType = "";
							String equipment = "";
							boolean unilateral = false;
							
							if (type.contains("calisthenics")) {
								System.out.printf("Body weight ratio (0-1): ");
								ratio = Double.parseDouble(in.nextLine());
							}
							
							if (type.equals("modifiedcalisthenics")) {
								System.out.printf("Equipment (e.g, Belt, Band): ");
								equipment = in.nextLine();
								System.out.printf("Extra weight in kg (negative = assisted): ");
								magnitude = Double.parseDouble(in.nextLine());
							}
							
							if (type.equals("machine")) {
								System.out.printf("Unilateral? (y/n): ");
								unilateral = in.nextLine().equalsIgnoreCase("y");
								System.out.printf("Weight increment (kg): ");
								increment = Double.parseDouble(in.nextLine());
								System.out.printf("Weight (kg): ");
								exWeight = Double.parseDouble(in.nextLine());
								exWeight = Math.floor(exWeight / increment) * increment;
							}
							
							if (type.equals("freeweight")) {
								System.out.printf("Weight type (Barbell/Dumbbell/...): ");
								weightType = in.nextLine();
								System.out.printf("Weight (kg): ");
								exWeight = Double.parseDouble(in.nextLine());
							}
							
							
							System.out.printf("Sets: ");
							int sets = Integer.parseInt(in.nextLine());
							
							System.out.printf("Reps: ");
							int reps = Integer.parseInt(in.nextLine());
							
							//Implementation of ExerciseFactory
							Exercise e = ExerciseFactory.create(type, exName, muscle, reps, ratio, weightType, exWeight, equipment, magnitude, unilateral, increment);
							
							workout.addExercise(e, sets);
							System.out.println("Succesfully added exercise to workout log");
						break;
					}
					case "2": {
						workout.workoutLog(user);
						System.out.println("Saved to WorkoutLog.txt");
						break;
					}
					case "3": {
						Food log = new Food("log", 0, 0, 0);
						log.printMacros(log.readFoodLog());
						break;
					}
					case "4": {
						System.out.println("Goodbye!");
						return;
					}
					default:
						throw new IllegalArgumentException("Unknown option");
					
				}	
			} catch (Exception e) {System.out.println("Error: " + e.getMessage());}
		}
		
	}
}
