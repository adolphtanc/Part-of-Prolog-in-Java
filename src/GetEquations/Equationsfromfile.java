package GetEquations;

import LogicCalculator.basic;
import java.io.*;
import java.util.regex.*;

public class Equationsfromfile {
	public static String read(String filename) throws IOException {
		// Reading input by lines:
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		while ((s = in.readLine()) != null)
			sb.append(s + "\n");
		in.close();
		return sb.toString();
	}

	public static Equations EquationsBuilder(String s) throws IOException {
		String read = read(s);
		String a = "[;]";
		String b = "[=]";
		String c = "[+]";
		String d = "[|]";
		// String e="[&][&]";
		read = read.replaceAll("\\n", "");
		String[] h = Pattern.compile(a).split(read);
		int NUM = h.length;
		Equations record = new Equations(NUM);
		Equation aim = new Equation(0);
		String[] ss = h[0].split(d);
		term t = new term(ss.length);
		term[] tt = new term[1];
		for (int i = 0; i < ss.length; i++) {
			t.contains[i] = new node(ss[i]).buildtree(ss[i]);
		}
		tt[0] = t;
		aim.t2 = tt;
		record.E[0] = aim;
		for (int i = 1; i < NUM; i++) {
			record.E[i] = new Equation(i);
			String[] x = h[i].split(b);
			if (x.length == 1) {
				String x1 = x[0];
				String[] y1 = Pattern.compile(c).split(x1);
				record.E[i].yuansu1 = y1;
				int num1 = y1.length;
				record.E[i].t1 = new term[num1];
				for (int i1 = 0; i1 < num1; i1++) {
					String[] y3 = Pattern.compile(d).split(record.E[i].yuansu1[i1]);
					int num3 = y3.length;
					term t3 = new term(num3);
					for (int i2 = 0; i2 < num3; i2++) {
						t3.contains[i2] = new node(y3[i2]).buildtree(y3[i2]);
					}
					record.E[i].t1[i1] = t3;
				}

			}
			if (x.length == 2) {
				String x1 = x[0];
				String x2 = x[1];

				// System.out.println(x1+" "+x2);
				String[] y1 = Pattern.compile(c).split(x1);
				String[] y2 = Pattern.compile(c).split(x2);
				record.E[i].yuansu1 = y1;
				record.E[i].yuansu2 = y2;
				int num1 = y1.length;
				int num2 = y2.length;
				record.E[i].t1 = new term[num1];
				for (int i1 = 0; i1 < num1; i1++) {
					String[] y3 = Pattern.compile(d).split(record.E[i].yuansu1[i1]);
					int num3 = y3.length;
					term t3 = new term(num3);
					for (int i2 = 0; i2 < num3; i2++) {
						t3.contains[i2] = new node(y3[i2]).buildtree(y3[i2]);
					}
					record.E[i].t1[i1] = t3;
				}
				record.E[i].t2 = new term[num2];
				for (int i1 = 0; i1 < num2; i1++) {
					String[] y3 = Pattern.compile(d).split(record.E[i].yuansu2[i1]);
					int num3 = y3.length;
					term t3 = new term(num3);
					for (int i2 = 0; i2 < num3; i2++) {
						t3.contains[i2] = new node(y3[i2]).buildtree(y3[i2]);
					}
					record.E[i].t2[i1] = t3;
				}
			}
			// System.out.println(record.E[i].toString());
		}
		record.s = record.toString();
		StringBuilder sb1=new StringBuilder();
		sb1.append(record.s);
		record.s2=sb1;
		return record;
	}
	public static Equations EquationsBuilder(StringBuilder s) throws IOException {
		String read = s.toString();
		String a = "[;]";
		String b = "[=]";
		String c = "[+]";
		String d = "[|]";
		// String e="[&][&]";
		read = read.replaceAll("\\n", "");
		String[] h = Pattern.compile(a).split(read);
		int NUM = h.length;
		Equations record = new Equations(NUM);
		Equation aim = new Equation(0);
		String[] ss = h[0].split(d);
		term t = new term(ss.length);
		term[] tt = new term[1];
		for (int i = 0; i < ss.length; i++) {
			t.contains[i] = new node(ss[i]).buildtree(ss[i]);
		}
		tt[0] = t;
		aim.t2 = tt;
		record.E[0] = aim;
		for (int i = 1; i < NUM; i++) {
			record.E[i] = new Equation(i);
			String[] x = h[i].split(b);
			if (x.length == 1) {
				String x1 = x[0];
				String[] y1 = Pattern.compile(c).split(x1);
				record.E[i].yuansu1 = y1;
				int num1 = y1.length;
				record.E[i].t1 = new term[num1];
				for (int i1 = 0; i1 < num1; i1++) {
					String[] y3 = Pattern.compile(d).split(record.E[i].yuansu1[i1]);
					int num3 = y3.length;
					term t3 = new term(num3);
					for (int i2 = 0; i2 < num3; i2++) {
						t3.contains[i2] = new node(y3[i2]).buildtree(y3[i2]);
					}
					record.E[i].t1[i1] = t3;
				}

			}
			if (x.length == 2) {
				String x1 = x[0];
				String x2 = x[1];

				// System.out.println(x1+" "+x2);
				String[] y1 = Pattern.compile(c).split(x1);
				String[] y2 = Pattern.compile(c).split(x2);
				record.E[i].yuansu1 = y1;
				record.E[i].yuansu2 = y2;
				int num1 = y1.length;
				int num2 = y2.length;
				record.E[i].t1 = new term[num1];
				for (int i1 = 0; i1 < num1; i1++) {
					String[] y3 = Pattern.compile(d).split(record.E[i].yuansu1[i1]);
					int num3 = y3.length;
					term t3 = new term(num3);
					for (int i2 = 0; i2 < num3; i2++) {
						t3.contains[i2] = new node(y3[i2]).buildtree(y3[i2]);
					}
					record.E[i].t1[i1] = t3;
				}
				record.E[i].t2 = new term[num2];
				for (int i1 = 0; i1 < num2; i1++) {
					String[] y3 = Pattern.compile(d).split(record.E[i].yuansu2[i1]);
					int num3 = y3.length;
					term t3 = new term(num3);
					for (int i2 = 0; i2 < num3; i2++) {
						t3.contains[i2] = new node(y3[i2]).buildtree(y3[i2]);
					}
					record.E[i].t2[i1] = t3;
				}
			}
			// System.out.println(record.E[i].toString());
		}
		record.s = s.toString();
		record.s2=s;
		return record;
	}

	public static void main(String[] args) throws IOException {
		Equations a = EquationsBuilder("C:\\equations.txt");
		//
		//basic bc = new basic();
		//Equation b = a.E[1];
		//node n = a.E[0].t2[0].contains[0];
		// System.out.println(n);
		// System.out.println(b);
		//Equation ee = basic.Unifier(n, b);
		// System.out.println(basic.FindNodeUnifier(n, b.t1[0].contains[0]));
		// System.out.println(n.isfunction(n));
		// System.out.println(n.child);
		// System.out.println(b);
		// System.out.println(a.E[0].t2[0].contains[0].isfunction(a.E[0].t2[0].contains[0]));
		System.out.println(a);  
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");  
		Equations EE = Equations.makecopy(a);
		EE.E[0]=null;
		System.out.println(EE);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n"); 
		System.out.println(a);  
		//System.out.println(Equations.makecopy(a));
		// System.out.println(a.E[0].t2[0].contains[0].child);
	}

}
