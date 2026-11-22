package project358;

public class ExerciseFactory {

	
	public static Exercise create(String type, String name, String targetMuscle, int reps, double bodyWeightRatio, String weightType, double weight, String equipment, double modificationMagnitude, boolean isUnilateral, double weightIncrement) {
		
		return switch (type.toLowerCase()) {
		case "calisthenics" -> new CalisthenicsExercise(name, targetMuscle, reps, bodyWeightRatio);
		
		case "freeweight" -> new FreeWeightExercise(name, targetMuscle, reps, weightType, weight);
		
		case "machine" -> new MachineExercise(name, targetMuscle, reps, isUnilateral, weightIncrement, weight);
		
		case "modifiedcalisthenics" -> new ModifiedCalisthenics(name, targetMuscle, reps, bodyWeightRatio, equipment, modificationMagnitude);
		
		default -> throw new IllegalArgumentException ("Unknown exercise type " + type);
		};
	}
}
