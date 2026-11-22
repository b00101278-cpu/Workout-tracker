	package project358;
	
	public class OutofBoundsException extends RuntimeException{
		private String exerciseName;
		
		public OutofBoundsException(String name, String message) {
			super(message);
			this.exerciseName=name;
		}
		
		public String getexerciseName() {return exerciseName;}
		
	}
