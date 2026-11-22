package project358;

public class InvalidWorkoutException extends Exception {
	private final String workoutName;
	
	public InvalidWorkoutException(String workoutName, String message) {
		super(message);
		this.workoutName=workoutName;
	}
	
	public String getWorkoutName() {
		return workoutName;
	}
}
