package GetEquations;

public class term {
	int tag = 0;
	public node[] contains;

	public term(int n) {
		contains = new node[n];
	}

	term(int n, int m) {
		contains = new node[n];
		tag = m;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < contains.length; i++) {
			if(i< contains.length-1)
			sb.append(contains[i].toString()+"|");
			else sb.append(contains[i].toString());
		}
		return sb.toString();
	}

}