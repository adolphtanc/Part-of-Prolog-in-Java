package GetEquations;

public class node {
	public int search;
	String s;// s不是node的所代表的式子也不代表node。m
	public String m = "";
	int k = 0;// buildtree中的标记
	int t = 0;// findvarible()中的标记
	int h = 0;
	public int x = 0;
	public int child = 0;
	public static String temp;
	public node firstchild;
	public node nextsibling;
	public node father;

	node() {

	}

	public void usesbt(String[] a) {
		String t1 = a[0];
		String t2 = a[1];
		node n = this;
		String s = t1;
		if ((s == n.m) && n.isvarible(n)) {
			n.m = t2;
		}
		n.h = 1;
		n = n.firstchild;
		if ((s.equals(n.m)) && n.isvarible(n)) {
			n.m = t2;
			// System.out.println("11111");
		}
		n.h = 1;
		while ((n.father != null) && (n != this)) {

			if ((n.firstchild != null) && (n.firstchild.h == 0)) {
				n = n.firstchild;
				if ((s.equals(n.m)) && n.isvarible(n)) {
					n.m = t2;
				}
				n.h = 1;

			} else if ((n.nextsibling != null) && (n.nextsibling.h == 0)) {
				n = n.nextsibling;
				if ((s.equals(n.m)) && n.isvarible(n)) {
					n.m = t2;
				}
				n.h = 1;
			} else {
				n = n.father;
			}

		}
		this.clean(this);
	}

	public node(String a) {
		s = a;

	}

	public boolean isvarible(node x) {
		Character c = (Character) (x.m.charAt(0));
		if ((x.firstchild == null) && c.isUpperCase(c)) {
			return true;
		}
		return false;
	}

	public boolean isfunction(node x) {
		if ((x.firstchild != null)) {
			return true;
		}
		return false;
	}

	public boolean isconstant(node x) {
		if (!x.isfunction(x) && !x.isvarible(x)) {
			return true;
		} else
			return false;
	}

	/*
	 * //替换变量和函数的时候要用到，有点复杂， public boolean findvarible(String ss) { node n =
	 * this; this.t = 1; String s = ss; if ((s == n.m) && n.isvarible(n)) {
	 * this.clean(this); return true; } else if (n.firstchild == null) {
	 * this.clean(this); return false; } n = n.firstchild; n.t = 1; while
	 * ((n.father != null) && (n != this)) {
	 * 
	 * if ((n.firstchild != null) && (n.firstchild.t == 0)) { n = n.firstchild;
	 * if ((s == n.m) && n.isvarible(n)) { this.clean(this); return true; } n.t
	 * = 1;
	 * 
	 * } else if ((n.nextsibling != null) && (n.nextsibling.t == 0)) { n =
	 * n.nextsibling; if ((s == n.m) && n.isvarible(n)) { this.clean(this);
	 * return true; } n.t = 1; } else { n = n.father; }
	 * 
	 * }
	 * 
	 * this.clean(this); return false; }
	 */
	public String toString() {
		node n = this;
		StringBuilder sb = new StringBuilder();
		sb.append(this.m);
		this.k = 1;
		if (n.firstchild == null) {
			return sb.toString();
		}
		n = n.firstchild;
		sb.append("(" + n.m);
		n.k = 1;
		while ((n.father != null) && (n != this)) {

			if ((n.firstchild != null) && (n.firstchild.k == 0)) {
				n = n.firstchild;
				sb.append("(" + n.m);
				n.k = 1;

			} else if ((n.nextsibling != null) && (n.nextsibling.k == 0)) {
				n = n.nextsibling;
				sb.append("," + n.m);
				n.k = 1;
			} else {
				n = n.father;
				sb.append(")");
			}

		}
		this.clean(this);
		return sb.toString();

	}

	/*
	 * public String toString(){ return this.s; } node buildnode(String a){ node
	 * n=new node(""); temp=a; for(int i=0;i<a.length();i++){
	 * 
	 * if(a.charAt(i)=='a')temp=temp+"a"; else
	 * if(a.charAt(i)=='b')temp=temp+"b"; } n.s=temp; return n; }
	 */
	public static node buildtree(String a) {
		node n = new node();
		temp = a;
		for (int i = 0; i < a.length(); i++) {

			if (a.charAt(i) == '(') {
				int z0 = temp.length();
				if (z0 > 1)
					temp = temp.substring(1);
				else
					temp = "";
				node d = new node(temp);
				n.firstchild = d;
				d.father = n;
				n = d;
				n.father.child++;
			} else if (a.charAt(i) == ')') {
				int z1 = temp.length();
				if (z1 > 1)
					temp = temp.substring(1);
				else
					temp = "";
				n = n.father;
			} else if (a.charAt(i) == ',') {
				int z2 = temp.length();
				if (z2 > 1)
					temp = temp.substring(1);
				else
					temp = "";
				node f = new node(temp);
				n.nextsibling = f;
				f.father = n.father;
				n = f;
				n.father.child++;
			} else {
				int z3 = temp.length();
				if (z3 > 1)
					temp = temp.substring(1);
				else
					temp = "";
				n.m = n.m + a.charAt(i);
			}
		}
		n.s = n.m;
		return n;
	}

	public void clean(node d) {
		node n = d;
		n.t = 0;
		n.h = 0;
		n.k = 0;
		n.x = 0;
		if(n.firstchild!=null){
		n = n.firstchild;
		n.t = 0;
		n.h = 0;
		n.k = 0;
		n.x = 0;
		while ((n.father != null) && (n != this)) {

			if ((n.firstchild != null) && ((n.firstchild.k == 1) || (n.firstchild.h == 1) || (n.firstchild.t == 1))) {
				n = n.firstchild;
				n.t = 0;
				n.h = 0;
				n.k = 0;
				n.x = 0;

			} else if ((n.nextsibling != null)
					&& ((n.nextsibling.k == 1) || (n.nextsibling.h == 1) || (n.nextsibling.t == 1))) {
				n = n.nextsibling;
				n.t = 0;
				n.h = 0;
				n.k = 0;
				n.x = 0;
			} else {
				n = n.father;

			}

		}
		}
	}

	public static void main(String[] args) {
		node a = new node();
		//a = a.buildtree(a.s);
		// a=a.buildtree(a.s);

		//System.out.println("".equals(a.toString()));

		// System.out.println(a.toString());
		// System.out.println(a.firstchild.nextsibling.child);

	}
}
