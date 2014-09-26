import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Date {
	int date, month, year;
	Date(){
		this.date=0;
		this.month=0;
		this.year=0;
	}
	Date(int _date,int _month,int _year){
		date=_date;
		month=_month;
		year=_year;
	}
	public static void main(String[] a) {
		Date today = new Date();
		System.out.println("Nhap ngay thang nam: \n");
		String input="";
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			input = dataIn.readLine();
		} catch (IOException e) {
			System.out.println("Error!");
		}
		String[] dmy = input.split(" ");
		today.date = Integer.parseInt(dmy[0]);
		today.month=Integer.parseInt(dmy[1]);
		today.year = Integer.parseInt(dmy[2]);
		
		System.out.println("today: "+today.date+" "+today.month+" "+today.year);
		if(today.isValid()){
			Date nextDay = today.nextDay();
			System.out.println("next day:"+nextDay.date+" "+nextDay.month+" "+nextDay.year);
		}else System.out.println("Date is invalid");
	}
	Date nextDay(){
		int nDate= date,nMonth = month, nYear = year;
		if(isLeapYear()){
			if(nMonth == 2){
				if(nDate==28){
					nDate++;
				}
				else if(nDate == 29){
					nDate=1;
					nMonth++;
				}else{
					nDate++;
				}
			}
			else if(nMonth == 1||nMonth == 3||nMonth == 5||nMonth == 7||nMonth == 8||nMonth == 10){
				if(nDate==31){
					nDate=1;
					nMonth++;
				}
				else{
					nDate++;
				}
			}
			else if(nMonth==12){
				if(nDate==31){
					nDate=1;
					nMonth=1;
					nYear++;
				}
			}
			else{
				if(nDate==30){
					nDate=1;
					nMonth++;
				}else{
					nDate++;
				}
			}
		}
		else{
			if(nMonth == 1||nMonth == 3||nMonth == 5||nMonth == 7||nMonth == 8||nMonth == 10){
				if(nDate==31){
					nDate = 1;
					nMonth++;
				}
				else {
					nDate++;
				}
			}else if(nMonth==2){
				if(nDate ==	28){
					nDate=1;
					nMonth++;
				}else{
					nDate++;
				}
			}
			else if(nMonth==12){
				if(nDate==31){
					nDate=1;
					nMonth=1;
					nYear++;
				}
			}
			else{
				if(nDate==30){
					nDate=1;
					nMonth++;
				}
				else{
					nDate++;
				}
			}
		}
		Date nextDay = new Date(nDate,nMonth,nYear);
		return nextDay;
	}
	
	private boolean isValid(){
		if(isLeapYear()){
			switch(month){
				case 1: case 3:	case 5:	case 7:	case 8:	case 10:case 12:
					if(date>=1 && date <=31) return true;
					else return false;
				case 2:
					if(date>=1 && date <= 29) return true;
					else return false;
				case 4: case 6: case 9: case 11:
					if(date>=1 && date <=30) return true;
					else return false;
				default: return false;
			}
		}
		else{
			switch(month){
			case 1: case 3:	case 5:	case 7:	case 8:	case 10:case 12:
				if(date>=1 && date <=31) return true;
				else return false;
			case 2:
				if(date>=1 && date <= 28) return true;
				else return false;
			case 4: case 6: case 9: case 11:
				if(date>=1 && date <=30) return true;
				else return false;
			default: return false;
			}
		}
	}
	private boolean isLeapYear(){
		if(year %4 ==0){
			if(year %100 == 0 ){
				if(year %400 ==0)	return true;
					else	return false;
			}
			else{
				return true;
			}
		}
		else return false;
	}
	String ToString(){
		String a=date +" "+ month+" "+year;
		return a;
	}
}
