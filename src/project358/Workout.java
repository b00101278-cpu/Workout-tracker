package project358;

import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

//Map containing the users exercises (unordered) acting as a composition instead of inheritance and number of sets
public class Workout implements Loggable {
	private String name;
	private Map<Exercise, Integer> exercises = new HashMap<>();
	
	public Workout (String name) {setName(name);}
	public void setName(String name) {this.name = name;}
	
	private ExerciseChecker checker = new ExerciseChecker();
	
	public void addExercise(Exercise exercise, int sets) {
		if(!checker.check(exercise)) {throw new IllegalArgumentException("Exercise failed validation: " + exercise.getName());}
		exercises.put(exercise, sets);
	}
	
	public boolean removeExercise(String exerciseName) {
		Exercise found = null;
		for (Exercise e : exercises.keySet()) {
			if(e.getName().equalsIgnoreCase(exerciseName.trim())) {
				found = e;
				break;
			}
		}
		if (found == null) { return false;}
		else {exercises.remove(found); return true;}
	}
	
	int getExerciseCount() {return exercises.size();}
	
	@Override
	public void workoutLog(User user) throws IOException, InvalidWorkoutException {
		if(exercises.isEmpty()) {
			throw new InvalidWorkoutException(name, "Cannot log an empty workout.");
		}
		try(PrintWriter out = new PrintWriter(new FileWriter("WorkoutLog.txt"))) {
			out.println("User: " + user.getName() + " (#" + user.getID() + ")");
			out.println(name + "\n____________________________________________________________________________________________");
			
			//Polymorphic loop (Special case for Calisthenics subclasses since toString() cannot access user's bodyweight)
			for (Exercise e: exercises.keySet()) {
				String line = "";
				if(e.getCategory().equals("Calisthenics")) {line = user.getWeight() + " kg bw";}
				out.printf("%-15s | %s %s %n", e.getCategory(), e, line);
			}
		}
		
		
	}
}