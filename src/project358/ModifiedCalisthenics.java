package project358;
//Third level depth inheritance
public class ModifiedCalisthenics extends CalisthenicsExercise {
	private String ModificationEquipment;
	private double modificationMagnitude;
	
	public ModifiedCalisthenics(String name, String targetMuscle, int reps, double bodyWeightRatio, String ModificationEquipment, double modificationMagnitude) {
		super(name, targetMuscle, reps, bodyWeightRatio);
		this.ModificationEquipment = ModificationEquipment;
		this.modificationMagnitude = modificationMagnitude;
	}
	
	
	@Override
	public String toString() {
		String fullName;
		if (modificationMagnitude > 0) {fullName = "Weighted " + name;}
		else if (modificationMagnitude < 0) {fullName = "Assisted " + name;}
		else {fullName = name;}
		return String.format("%-20s | %-15s | %2d reps - %.2f kg + %.2f x", fullName, targetMuscle, reps, Math.abs(modificationMagnitude), bodyWeightRatio);
	}
}
