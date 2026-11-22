package project358;

//Interface for callback
@FunctionalInterface
public interface ExerciseRule {
	boolean validate(Exercise exercise);
}
