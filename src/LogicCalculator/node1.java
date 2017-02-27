package LogicCalculator;

public class node1 {

	String[][] a = null;
	boolean n = false;

	node1(boolean nn, String[][] aa) {
		n = nn;
		a = aa;
	}

	public String toString() {
		if (this.n !=false){
			if (this.a != null) {
				StringBuilder a1 = new StringBuilder();
				for (int i = 0; i < this.a.length; i++) {
					if(this.a[i][0]!=null){
					a1.append(this.a[i][0] + "/" + this.a[i][1]);
				}else{
					break;
				}
					}
				
				a1.append("\n true1");
				return a1.toString();
			} else {
				return "111111111true2";
			}
		}
		else{
		return "false";
	}
	}
}
