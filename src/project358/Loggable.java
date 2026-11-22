package project358;

import java.io.IOException;

@FunctionalInterface
public interface Loggable {
	void workoutLog(User user) throws IOException, InvalidWorkoutException;
	
	//Default method for interface
	default String getLogFileName() {
		return "WorkoutLog.txt";
	}
}
