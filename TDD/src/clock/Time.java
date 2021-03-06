	package clock;
	
	public class Time {
		
		private int theHour = 0;
		private int theMinute = 0;
		private int theSecond = 0;
		
		public String timeSet(int hour, int minute, int second ) {
			
			//hour
			if (hour >= 0 && hour <= 23 ) {
				theHour = hour;
			}
			else {
				theHour = 0;
			}
			
			//minute
			if (minute >= 0 && minute <= 59) {
				theMinute = minute;
			}
			else {
				theMinute = 0;
			}
			
			//second
			if (second >= 0 && second <= 59) {
				theSecond = second;
			}
			else {
				theSecond = 0;
			}
			
			return theHour + ":" + theMinute + ":" + theSecond; 
	}
		
		public String showTime() {
			return theHour + ":" + theMinute + ":" + theSecond; 
		}
	}
