package triangle;

public class Triangle {
	private double a,b,c;
	public Triangle(){
		a=b=c=0;
	}
	public Triangle(double x,double y,double z){
		a=x;
		b=y;
		c=z;
	}
	private boolean isValid(){
		if(a+b>c && b+c>a && c+a>b) return true;
		else return false;
	}
	
	public static void main(String[] a){
		Triangle tamgiac = new Triangle();
	}
	public void check(){
		if(a==b && b==c && c==a) System.out.println("tam giac deu");
//		else if(a)
	}
}
