package project358;

//Second level depth inheritance
public class CalisthenicsExercise extends Exercise { 
	protected double bodyWeightRatio;
	
	public CalisthenicsExercise(String name, String targetMuscle, int reps, double bodyWeightRatio) {
		super(name, targetMuscle, reps);
		setBodyWeightRatio(bodyWeightRatio);
	}
	
	public void setBodyWeightRatio(double bodyWeightRatio) {
		try {
			if (bodyWeightRatio < 0 || bodyWeightRatio > 1) {
				throw new IllegalArgumentException("Invalid number in range: ");
			}
			this.bodyWeightRatio = bodyWeightRatio;
		} catch (IllegalArgumentException e) {throw new OutofBoundsException(name, "Bodyweight ratio must be between 0 and 1");}
	}
	
	public double getBodyWeightRatio() {return bodyWeightRatio;}
	
	@Override
	public String toString() {
		return String.format("%-20s | %-15s | %2d reps - %.2f x", name, targetMuscle, reps, bodyWeightRatio);
	}

	@Override
	public String getCategory() {return "Calisthenics";}
}
