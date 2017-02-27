package GetEquations;

public class Equation {
	static int num;
	String[] yuansu1;
	String[] yuansu2;
	public Equation() {

	}
	public Equation(int i) {
		num = i;
	}
	public String toString(){
		if(t1==null)
			return this.toString1();
		if(t1!=null)
			return this.toString2();
		return this.toString1();
	}
	public String toString2(){
		StringBuilder sb = new StringBuilder();

	if (t1 != null) {
		for (int i = 0; i < t1.length; i++) {
    if( i < t1.length-1){
			sb.append(t1[i] + "+");
		}else{
			sb.append(t1[i] + "");
		}
	}
	}
	if (t2 != null) {
		sb.append("=");
		for (int i = 0; i < t2.length; i++) {
			if( i < t2.length-1){
				sb.append(t2[i] + "+");
			}else{
				sb.append(t2[i] + "");
			}
		}
	}
	

	return sb.toString();	
	}
	public String toString1(){
		StringBuilder sb = new StringBuilder();

	
	if (t2 != null) {
		
		for (int i = 0; i < t2.length; i++) {
			if( i < t2.length-1){
				sb.append(t2[i] + "+");
			}else{
				sb.append(t2[i] + "");
			}
		}
	}
	

	return sb.toString();	
	}

	public term[] t1;
	public term[] t2;

	/*
	 * public String toString() { StringBuilder sb = new StringBuilder();
	 * 
	 * if (t1 != null) { for (int i = 0; i < t1.length; i++) {
	 * 
	 * sb.append(t1[i] + " "); } } if (t2 != null) { sb.append("="); for (int i
	 * = 0; i < t2.length; i++) { sb.append(t2[i] + " "); } } return
	 * sb.toString(); }
	 */
}

class term0 {
	String[] s1;
	String[] s2;
	int num;

	term0(int i) {
		num = i;
	}
}
