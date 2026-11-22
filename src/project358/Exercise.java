package project358;

import java.util.Objects;

//Abstract class containing 3 concrete subclasses
public abstract class Exercise {
	protected String name;
	protected String targetMuscle;
	protected int reps;
	
	public Exercise(String name, String targetMuscle, int reps) {
		this.name = name;
		this.targetMuscle = targetMuscle;
		this.reps = reps;
		}
	
	protected void setName(String name) {this.name = name;}
	protected void setTargetMuscle(String targetMuscle) {this.targetMuscle = targetMuscle;}
	
	protected String getName() {return name;}
	protected String getTargetMuscle() {return targetMuscle;}
	
	public abstract String getCategory();
	
	
	//Equals and hashCode overridden
	@Override
	public boolean equals(Object e) {
		if(this == e) {return true;}
		if (e == null || getClass() != e.getClass()) return false;
		Exercise other = (Exercise) e;
		return name.equals(other.name) && targetMuscle.equals(other.targetMuscle) && reps==other.reps;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, targetMuscle, reps);
	}
}
