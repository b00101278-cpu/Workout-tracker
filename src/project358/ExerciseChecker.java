package project358;

import java.util.ArrayList;
import java.util.List;

public class ExerciseChecker {
	
	private final List<ExerciseRule> rules = new ArrayList<>();
	
	public ExerciseChecker() {
		addRule(e -> e.reps > 0);
		addRule(e -> !e.getName().isBlank());
		addRule(e -> !e.getTargetMuscle().isBlank());
	}
	
	public void addRule(ExerciseRule rule) {rules.add(rule);}
	
	public boolean check(Exercise exercise) {
		for (ExerciseRule r : rules)  {
			if (!r.validate(exercise)) {return false;}
		}
		return true;
	}
	
}
