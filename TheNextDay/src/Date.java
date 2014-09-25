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
		System.out.println("next day:"+today.nextDay().date+" "+today.nextDay().month+" "+today.nextDay().year);
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
			else if(nMonth == 1||nMonth == 3||nMonth == 5||nMonth == 7||nMonth == 8||nMonth == 10||nMonth == 12){
				if(nDate==31){
					nDate=1;
					nMonth++;
				}
				else{
					nDate++;
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
			if(nMonth == 1||nMonth == 3||nMonth == 5||nMonth == 7||nMonth == 8||nMonth == 10||nMonth == 12){
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
	boolean isLeapYear(){
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
