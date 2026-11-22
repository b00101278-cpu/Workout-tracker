package project358;

public class MachineExercise extends Exercise {
	private boolean isUnilateral;
	private double weightIncrements;
	private double weight;
	
	
	public MachineExercise(String name, String targetMuscle, int reps, boolean isUnilateral, double weightIncrement, double weight) {
		super(name, targetMuscle, reps);
		this.weightIncrements = weightIncrement;
		this.isUnilateral = isUnilateral;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		String FullName = (isUnilateral ? "Unilateral " : "") + name;
		return String.format("%-20s | %-15s | %2d reps - %.2f kg", FullName, targetMuscle, reps, weight);
	}
	
	
	@Override
	public String getCategory() {return "Machine";}
}
