package clock;


 enum State {
		S1DisplayTime,
		S2DisplayDate,
		S3ChangeTime,
		S4ChangeDate
	} 
 
 
public class Clock {
	
	
	private Time theTime = new Time();
	private Date theDate = new Date();
	private State currentState = State.S1DisplayTime; 

	public String changeMode() {
		String currentMode = null;
		switch(currentState) {
		case S1DisplayTime:
			currentState = State.S2DisplayDate;
			currentMode = theDate.showDate();
			break; 
		case S2DisplayDate:
			currentState = State.S1DisplayTime;
			currentMode = theTime.showTime();
			break;
		case S3ChangeTime:
			currentMode = "Change Time";
			break;
		case S4ChangeDate:
			currentMode = "Change Date";
			break; 
		}
		
		return currentMode; 
	}

	public String ready() {
		String currentMode = null;
		switch(currentState) {
		case S1DisplayTime:
			currentState = State.S3ChangeTime;
			currentMode = "Change Time";
			break;
		case S2DisplayDate:
			currentState = State.S4ChangeDate;
			currentMode = "Change Date";
			break;
		case S3ChangeTime:
			currentMode = "Change Time";
			break;
		case S4ChangeDate:
			currentMode = "Change Date";
			break;
		}
		return currentMode;
	}
	
	public String set(int p1, int p2, int p3) {
		String currentMode = null;
		switch(currentState) {
		case S1DisplayTime:
			currentMode = "Display Time";
			break;
		case S2DisplayDate:
			currentMode = "Display Date";
			break;
		case S3ChangeTime:
			theTime.timeSet(p1, p2, p3);
			currentState = State.S1DisplayTime;
			currentMode = theTime.showTime();
			break;
		case S4ChangeDate:
			theDate.dateSet(p1, p2, p3);
			currentState = State.S2DisplayDate;
			currentMode = theDate.showDate();
			
		}
		return currentMode;
		
	}
	
}
