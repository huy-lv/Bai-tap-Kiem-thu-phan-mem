package GiaiPTB2;

public class Equation {
	private double a, b, c;
	private double delta;
	private double x1, x2;

	public Equation(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public String solve() {
		if (a == 0) {
			if (b == 0) {
				if (c == 0) {
					return "vo so nghiem";
				} else {
					return "vo nghiem";
				}
			} else {
				x1 = x2 = -c / b;
				return"x=" + x1;
			}
		} else {
			delta = (b * b) - 4 * a * c;
			if (delta < 0) {
				return "vo nghiem";
			} else if (delta == 0) {
				x1 = x2 = -b / (2 * a);
				return "x1=x2=" + x1;
			} else {
				x1 = (-b + Math.sqrt(delta)) / (2 * a);
				x2 = (-b - Math.sqrt(delta)) / (2 * a);
				return "x1=" + x1 + ";x2=" + x2 ;
			}
		}
	}
	public static void main(String[] b) {
		Equation a = new Equation(1, 1, 1);
		System.out.println(a.solve());
	}
}
