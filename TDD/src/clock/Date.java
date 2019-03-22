package clock;

public class Date {
	
	private int theYear = 3000;
	private int theMonth = 1;
	private int theDay = 1;
	
	public String dateSet(int day, int month, int year) {
		
		//year
		if (year >= 1950 && year <= 2200) {
			theYear = year;
		}
		else {
			theYear = 3000; 
		}
		
		//month
		if (month >= 1 && month <= 12) {
			theMonth = month;
		} 
		else {
			theMonth = 1;
		}
		
		//day
		if (day >= 1 && day <= 31) {
			theDay = day;
		} 
		else {
			theDay = 1; 
		}
		
		return theDay + "/" + theMonth + "/" + theYear;
	}

	
	public String showDate() {
		return theDay + "/" + theMonth + "/" + theYear; 
	}
}
