package GetEquations;

import java.io.IOException;

public class Equations {
	public String s;
	public StringBuilder s2;
	public Equation[] E;
	int length;

	public Equations(int i) {
		E = new Equation[i];
		length = i;
	}

	public static Equations makecopy(Equations e) throws IOException {
		Equations EQ = Equationsfromfile.EquationsBuilder(e.s2);
		return EQ;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {if(this.E[i]!=null){
			if(i==0){
				sb.append(E[i].toString1()+";\n");
			}
			else if(i<length-1)
			sb.append(E[i].toString() + ";\n");
			else 
				sb.append(E[i].toString() + "");
		}}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] a = new String[2];

		System.out.println(a.equals(null));
	}
}