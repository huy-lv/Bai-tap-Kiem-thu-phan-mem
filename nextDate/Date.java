package nextDate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Date {
	int day, month, year;

	Date() {
		this.day = 0;
		this.month = 0;
		this.year = 0;
	}

	Date(int _day, int _month, int _year) {
		day = _day;
		month = _month;
		year = _year;
	}

	public static void main(String[] a) {
		Date today = new Date();
		System.out.println("Nhap ngay thang nam: \n");
		String input = "";
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			input = dataIn.readLine();
		} catch (IOException e) {
			System.out.println("Error!");
		}
		String[] dmy = input.split(" ");
		today.day = Integer.parseInt(dmy[0]);
		today.month = Integer.parseInt(dmy[1]);
		today.year = Integer.parseInt(dmy[2]);

		System.out.println("today: " + today.day + " " + today.month + " "
				+ today.year);
		if (today.isValid()) {
			Date nextDay = today.nextDay();
			System.out.println("next day:" + nextDay.day + " " + nextDay.month
					+ " " + nextDay.year);
		} else
			System.out.println("Date is invalid");
	}

	Date nextDay() {
		int nDay = day, nMonth = month, nYear = year;
		if (isLeapYear()) {
			switch (nMonth) {
			case 2:
				if (nDay == 28) {
					nDay++;
				} else if (nDay == 29) {
					nDay = 1;
					nMonth++;
				} else {
					nDay++;
				}
				break;
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
				if (nDay == 31) {
					nDay = 1;
					nMonth++;
				} else {
					nDay++;
				}
				break;
			case 12:
				if (nDay == 31) {
					nDay = 1;
					nMonth = 1;
					nYear++;
				}
				break;
			default:
				if (nDay == 30) {
					nDay = 1;
					nMonth++;
				} else {
					nDay++;
				}
				break;
			}
		} else {
			switch (nMonth) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
				if (nDay == 31) {
					nDay = 1;
					nMonth++;
				} else {
					nDay++;
				}
				break;
			case 2:
				if (nDay == 28) {
					nDay = 1;
					nMonth++;
				} else {
					nDay++;
				}
				break;
			case 12:
				if (nDay == 31) {
					nDay = 1;
					nMonth = 1;
					nYear++;
				}
			default:
				if (nDay == 30) {
					nDay = 1;
					nMonth++;
				} else {
					nDay++;
				}
			}

		}
		Date nextDay = new Date(nDay, nMonth, nYear);
		return nextDay;
	}

	private boolean isValid() {
		if (isLeapYear()) {
			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if (day >= 1 && day <= 31)
					return true;
				else
					return false;
			case 2:
				if (day >= 1 && day <= 29)
					return true;
				else
					return false;
			case 4:
			case 6:
			case 9:
			case 11:
				if (day >= 1 && day <= 30)
					return true;
				else
					return false;
			default:
				return false;
			}
		} else {
			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if (day >= 1 && day <= 31)
					return true;
				else
					return false;
			case 2:
				if (day >= 1 && day <= 28)
					return true;
				else
					return false;
			case 4:
			case 6:
			case 9:
			case 11:
				if (day >= 1 && day <= 30)
					return true;
				else
					return false;
			default:
				return false;
			}
		}
	}

	private boolean isLeapYear() {
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0)
					return true;
				else
					return false;
			} else {
				return true;
			}
		} else
			return false;
	}

	String ToString() {
		String a = day + " " + month + " " + year;
		return a;
	}
}
