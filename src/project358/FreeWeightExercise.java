package project358;


public class FreeWeightExercise extends Exercise {
	private String weightType;
	private double weight;
	
	public FreeWeightExercise(String name, String targetMuscle, int reps, String weightType, double weight) {
		super(name, targetMuscle, reps);
		this.weightType = weightType;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return String.format("%-20s (%s) | %-15s | %2d reps - %.2f kg", name, weightType, targetMuscle, reps, weight);
	}
	
	@Override
	public String getCategory() {return "Free Weights";}
	
}
