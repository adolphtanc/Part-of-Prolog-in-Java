package LogicCalculator;

import java.io.IOException;

import GetEquations.*;

public class basic {
	
	
	
	public basic(Equations e) throws IOException {
		str = new String[2];
		a = 0;
		b = 0;
		c = 0;
		d = 0;
		t = 0;
		 f = 0;
		depth=0;
		EEE1 = e;
		EEE2 = Equations.makecopy(e);
	}

	Sbt sbt = new Sbt();
	static String[] str;
	static node1 no1;
	static int num;
	static String[][] S = new String[20][2];
	static String[][] S1= new String[20][2];
	static int a = 0;
	static int c = 0;
	static int depth = 0;
	static int d = 0;
	static int b = 0;
	static int f = 0;
	static boolean unisec = false;
	static Equations EEE1;
	static Equations EEE2;
	static int t = 0;// FindUnifier方法中str改变了就设为1
static node n;
	/*
	 * 只能处理类似于p(X,X)=q(X,Y)+r(X,Z); p(X,X)=s(X); q(b,a); q(a,a); q(X,Y)=r(a,Y);
	 * r(b,Z); s(X)=q(X,a)这一类，括号不嵌套的简单谓词逻辑 而且变量和这种函数型的不能替换
	 */
	static public node1 FindNodeUnifier(node x1, node x2) {
		String[][] T = new String[20][2];
		
		
		int s=0;
		unisec = false;
		;
		String[] str1=new String[2];
		x1.clean(x1);
		x2.clean(x2);
		str = new String[2];
		b = 0;
		node t1=node.buildtree(x1.toString());
		node t2=node.buildtree(x2.toString());
		node t3=node.buildtree(x1.toString());
		node t4=node.buildtree(x2.toString());
		
		if (t2.isvarible(t2) && t1.isconstant(t1)) {

			// S[num][0] = t2.toString();
			// S[num][1] = t1.toString();
			// num++;
			str=new String[2];
			str[0] = t2.toString();
			str[1] = t1.toString();
			b = 1;
			t1.x = 1;
			t2.x = 1;
			// a = 1;
			System.out.println('0');
			unisec = true;
			str1=str;
			T[s]=str1;
			S=T;
			node1 n1=new node1(true,S);
			f=0;
			no1=n1;
			return n1;
		} else if (t1.isvarible(t1) && t2.isconstant(t2)) {

			// S[num][0] = t1.toString();
			// S[num][1] = t2.toString();
			// num++;
			str=new String[2];
			str[0] = t1.toString();
			str[1] = t2.toString();
			b = 1;
			t1.x = 1;
			t2.x = 1;
			// a = 1;
			System.out.println('1');
			unisec = true;
			str1=str;
			T[s]=str1;
			S=T;
			f=0;
			node1 n1=new node1(true,S);
			no1=n1;
			return n1;
		} else if (t1.isvarible(t1) && t2.isvarible(t2)&&(!t1.toString().equals(t2.toString()))) {

			// S[num][0] = t1.toString();
			// S[num][1] = t2.toString();
			// num++;
			str=new String[2];
			str[0] = t1.toString();
			str[1] = t2.toString();
			b = 1;
			t1.x = 1;
			t2.x = 1;
			unisec = true;
			// System.out.println('2');
			str1=str;
			T[s]=str1;
			S=T;
			node1 n1=new node1(true,S);
			f=0;
			no1=n1;
			return n1;
		}
		else if(t1.isvarible(t1) && t2.isvarible(t2)&&(!t1.toString().equals(t2.toString()))){
			str=new String[2];
			str1=str;
			T[s]=str1;
			S=T;
			node1 n1=new node1(true,S);
			no1=n1;
			return n1;
		}
			else if (t1.isconstant(t1) && t2.isconstant(t2)) {
			if (!t1.m.equals(t2.m)) {
				// System.out.println('3');
				node1 n1=new node1(false,S);
				f=0;
				no1=n1;
				return n1;
				
			}
			else{
				
				str=new String[2];
				str1=str;
				T[s]=str1;
				S=T;
				node1 n1=new node1(true,S);
				no1=n1;
				return n1;
			}
		} else if (t1.isfunction(t1) && t2.isfunction(t2) && (t1.child == t2.child)) {
			if (!t1.m.equals(t2.m)) {
				System.out.println('4');
				node1 n1=new node1(false,S);
				return n1;
			} else if (t1.m.equals(t2.m)) {
				t1.x = 1;
				t2.x = 1;
				t1 = t1.firstchild;
				t2 = t2.firstchild;

				while ((t1.father != null) && (t1 != x1) && (t2.father != null) && (t2 != x2)) {

					if (t1.isfunction(t1) && t2.isfunction(t2) && (t1.child == t2.child) && (t1.x != 1) && (t2.x != 1)
							&& (t1.m.equals(t2.m))) {
						t1.x = 1;
						t2.x = 1;
						t1 = t1.firstchild;
						t2 = t2.firstchild;

					} else if (t1.isfunction(t1) && t2.isfunction(t2) && (t1.child == t2.child) && (t1.x == 1)
							&& (t2.x == 1)) {
						if ((t1.nextsibling != null) && (t2.nextsibling != null)) {
							t1.x = 1;
							t2.x = 1;
							t1 = t1.nextsibling;
							t2 = t2.nextsibling;
						} else {
							t1.x = 1;
							t2.x = 1;
							t1 = t1.father;
							t2 = t2.father;
						}
					} else if (t1.isvarible(t1) && t2.isvarible(t2) && (t1.x != 1) && (t2.x != 1)&&(!t1.m.equals(t2.m))) {

						// S[num][0] = t1.toString();
						// S[num][1] = t2.toString();
						// num++;&&
						if (b != 1) {
							str=new String[2];
							str[0] = t1.toString();
							str[1] = t2.toString();
							str1=str;
							
							T[s]=str1;
							s++;
							t1.x = 1;
							t2.x = 1;
							
							String [][] S3=T.clone();
							
							String SS1=t3.toString();
							SS1=SS1.replaceAll(str[0], str[1]);
							t3=node.buildtree(SS1);
							b = 1;
							node1 n2=FindNodeUnifier(t3, t4);
							if(n2.n){
								//node1 a2=new node1(false,null);
								String[][] S2=new String[10][2];
								int i4=0;
								if(S3!=null)
								for(int i=0;i<S3.length;i++){
									if(S3[i][0]!=null){
										S2[i4]=S3[i].clone();
										i4++;
									}
								}
								if(n2.a!=null)
								for(int i=0;i<n2.a.length;i++){
									if(n2.a[i][0]!=null){
										S2[i4]=n2.a[i];
										i4++;
									}
								}
								n2.a=S2;
								}
							no1=n2;
							return n2;
							
						}
						str=new String[2];
						str[0] = t1.toString();
						str[1] = t2.toString();
						str1=str;
						T[s]=str1;
						s++;
						t1.x = 1;
						t2.x = 1;
						if ((t1.nextsibling != null) && (t2.nextsibling != null)) {
							t1.x = 1;
							t2.x = 1;
							t1 = t1.nextsibling;
							t2 = t2.nextsibling;
						} else {
							t1.x = 1;
							t2.x = 1;
							t1 = t1.father;
							t2 = t2.father;
						}
						// System.out.println('2');
						// return true;
					}else if(t1.isvarible(t1) && t2.isvarible(t2) && (t1.x != 1) && (t2.x != 1)&&(t1.m.equals(t2.m))){
						t1.x = 1;
						t2.x = 1;
						b=1;
						if ((t1.nextsibling != null) && (t2.nextsibling != null)) {
							t1.x = 1;
							t2.x = 1;
							t1 = t1.nextsibling;
							t2 = t2.nextsibling;
						} else {
							t1.x = 1;
							t2.x = 1;
							t1 = t1.father;
							t2 = t2.father;
						}
					}
					else if (t1.isvarible(t1) && t2.isconstant(t2) && (t1.x != 1) && (t2.x != 1)) {

						// S[num][0] = t1.toString();
						// S[num][1] = t2.toString();
						// num++;

						if (b != 1) {
							b = 1;
							str=new String[2];
							str[0] = t1.toString();
							str[1] = t2.toString();
							str1=str;
							
							T[s]=str1;
							s++;
							t1.x = 1;
							t2.x = 1;
							
							String [][] S3=T.clone();
							String SS1=t3.toString();
							SS1=SS1.replaceAll(str[0], str[1]);
							t3=node.buildtree(SS1);
							b = 1;
							node1 n2=FindNodeUnifier(t3, t4);
							if(n2.n){
								//node1 a2=new node1(false,null);
								String[][] S2=new String[10][2];
								int i4=0;
								if(S3!=null)
								for(int i=0;i<S3.length;i++){
									if(S3[i][0]!=null){
										S2[i4]=S3[i].clone();
										i4++;
									}
								}
								if(n2.a!=null)
								for(int i=0;i<n2.a.length;i++){
									if(n2.a[i][0]!=null){
										S2[i4]=n2.a[i];
										i4++;
									}
								}
								n2.a=S2;
								}
							no1=n2;
							return n2;
							
						}
						str=new String[2];
						str[0] = t1.toString();
						str[1] = t2.toString();
						str1=str;
						
						T[s]=str1;
						s++;
						t1.x = 1;
						t2.x = 1;
						if ((t1.nextsibling != null) && (t2.nextsibling != null)) {
							t1.x = 1;
							t2.x = 1;
							t1 = t1.nextsibling;
							t2 = t2.nextsibling;
						} else {
							t1.x = 1;
							t2.x = 1;
							t1 = t1.father;
							t2 = t2.father;
						}
						// a = 1;
						// System.out.println('3');
						// return true;
					} else if (t2.isvarible(t2) && t1.isconstant(t1) && (t1.x != 1) && (t2.x != 1)) {

						// S[num][0] = t2.toString();
						// S[num][1] = t1.toString();
						// num++;

						if (b != 1) {
							str=new String[2];
							str[0] = t2.toString();
							str[1] = t1.toString();
							str1=str;
							
							T[s]=str1;
							s++;
							t1.x = 1;
							t2.x = 1;
							
						
							String [][] S3=T.clone();
							String SS1=t4.toString();
							SS1=SS1.replaceAll(str[0], str[1]);
							t4=node.buildtree(SS1);
							b = 1;
							node1 n2=FindNodeUnifier(t3, t4);
							if(n2.n){
								//node1 a2=new node1(false,null);
								String[][] S2=new String[10][2];
								int i4=0;
								if(S3!=null)
								for(int i=0;i<S3.length;i++){
									if(S3[i][0]!=null){
										S2[i4]=S3[i].clone();
										i4++;
									}
								}
								if(n2.a!=null)
								for(int i=0;i<n2.a.length;i++){
									if(n2.a[i][0]!=null){
										S2[i4]=n2.a[i];
										i4++;
									}
								}
								n2.a=S2;
								}
							no1=n2;
							return n2;
						}str=new String[2];
						str[0] = t1.toString();
						str[1] = t2.toString();
						str1=str;
						T[s]=str1;
						s++;
						if ((t1.nextsibling != null) && (t2.nextsibling != null)) {
							t1.x = 1;
							t2.x = 1;
							t1 = t1.nextsibling;
							t2 = t2.nextsibling;
						} else {
							t1.x = 1;
							t2.x = 1;
							t1 = t1.father;
							t2 = t2.father;
						}
						// a = 1;
						// System.out.println('4');
						// return true;
					} else if (t1.isconstant(t1) && t2.isconstant(t2)) {
						if (!t1.m.equals(t2.m)) {
							
							System.out.println('5');
							node1 n1=new node1(false,S);
							return n1;
						} else if ((t1.nextsibling != null) && (t2.nextsibling != null)) {
							b=1;
							t1.x = 1;
							t2.x = 1;
							t1 = t1.nextsibling;
							t2 = t2.nextsibling;
						} else {
							b=1;
							System.out.println('8');
							t1.x = 1;
							t2.x = 1;
							t1 = t1.father;
							t2 = t2.father;
						}

					} else {
						System.out.println('6');
						node1 n1=new node1(false,S);
						return n1;
					}

				}
				System.out.println('7');
				if (b == 0) {
					node1 n1=new node1(false,S);
					return n1;
				}
				
				unisec = true;
				S=T;
				node1 n1=new node1(true,T);
				no1=n1;
				return n1;
			}

		}
		// System.out.println("can't find any unifier");
		S=T;
		node1 n1=new node1(false,T);
		no1=n1;
		return n1;
	}

	public static Equation Unifier(Equation e3, Equation e1) {
		Equation e2 = null;
		S=new String[20][2];
		node n1;
		if(e3.t2!=null)if(e3.t2[0].contains!=null)if(e3.t2[0].contains[0]!=null){
			n1=e3.t2[0].contains[0];
		
		if(e1.t1!=null)if(e1.t1[0]!=null)if(e1.t1[0].contains!=null)
		for (int i3 = 0; i3 < e1.t1[0].contains.length; i3++) {
			int ii=0;
			node1 nn=FindNodeUnifier(n1, e1.t1[0].contains[i3]);
			if(nn.n){
		while(nn.a[ii][0]!=null){
			n1.usesbt(nn.a[ii]);
			//S[c] = S[ii];
			if (e1.t1 != null) {
				for (int i1 = 0; i1 < e1.t1.length; i1++) {
					if (e1.t1[i1].contains != null)
						for (int i2 = 0; i2 < e1.t1[i1].contains.length; i2++) {
							e1.t1[i1].contains[i2].usesbt(nn.a[ii]);
						}
				}
			}
			if (e1.t2 != null) {
				for (int i1 = 0; i1 < e1.t2.length; i1++) {
					if (e1.t2[i1].contains != null)
						for (int i2 = 0; i2 < e1.t2[i1].contains.length; i2++) {
							e1.t2[i1].contains[i2].usesbt(nn.a[ii]);
						}
				}
			}
			for(int i=0;i<e3.t2[0].contains.length;i++){
				e3.t2[0].contains[i].usesbt(nn.a[ii]);
			}
			ii++;
		
			
		}//
		Equation e4=new Equation();
		int i2=0;
		if(e1.t2!=null){
			term t=new term(e3.t2[0].contains.length+e1.t2.length);
			if(e3.t2[0].contains.length>1){
			for(int i=0;i<e3.t2[0].contains.length-1;i++){
				t.contains[i]=e3.t2[0].contains[i+1];
				i2++;
			}
			}
			for(int i1=0;i1<e1.t2.length;i1++){
				boolean bool=true;
				for (int i = 1; i <e3.t2[0].contains.length ; i++) {
				if(e1.t2[0].contains[0].toString().equals(e3.t2[0].contains[i].toString())){
					bool=false;
				}
				
			}
				if(bool==true){
				t.contains[i2]=e1.t2[i1].contains[0];i2++;
				}
		}
			
			term t1=new term(i2);
			for(int i5=0;i5<i2;i5++){
				t1.contains[i5]=t.contains[i5];
				
			}
			e4.t1=null;
			e4.t2=new term[1];
			e4.t2[0]=t1;
		}else if(e1.t2==null){
			term t=new term(e3.t2[0].contains.length);
			if(e3.t2[0].contains.length>1){
			for(int i=0;i<e3.t2[0].contains.length-1;i++){
				t.contains[i]=e3.t2[0].contains[i+1];
				i2++;
			}}
			term t1=new term(i2);
			for(int i5=0;i5<i2;i5++){
				t1.contains[i5]=t.contains[i5];
				
			}
			e4.t1=null;
			e4.t2=new term[1];
			e4.t2[0]=t1;
			
		}
		
			return e4;
			}
		}
		}
		return e2;

	}

	

static	node1 deepthfirst(Equations e) throws IOException {
		linknode[] ll=new linknode[2];
		String[] aaa=new String[2];
		aaa[0]="#";
		aaa[1]="#";
		ll[0]=new linknode(aaa);
		ll[1]=new linknode(aaa);
		int ab=0;
		// String[][] aa=new String[10][2];
        Equations EE = Equations.makecopy(e);
		Equation e1 = EE.E[0];
		Equation e2;
		
		term t2 = null;
		if (e1.t2 != null)if (e1.t2[0].contains != null)
					for (int i1 = 0; i1 < e1.t2[0].contains.length; i1++) {// 对于目标子句的每一个项；
						
						int num1 = EEE1.E.length - 1;
						for (int i2 = 0; i2 < num1; i2++) {// 对于每一个程序子句；
							n = e1.t2[0].contains[i1];
							unisec = false;
							Equation ee = Unifier(e1, EE.E[i2 + 1]);
							if (ee != null) {
								if (ee.t2 != null) 
									if ((ee.t2[0] != null)) {
										
							
											EE.E[0]=ee;
										t2=ee.t2[0];

										if (t2.toString().equals("")) {
											//ll=linknode.stonode(S);
											String [][] S3=no1.a.clone();
											for(int i=0;i<S3.length;i++){
												if(S3[i][0]==null){
													Integer a=i2+1;
													S3[i][0]="Equation ("+a.toString()+"):   "+S3[i][0];
													break;
												}
											}
											no1.a=S3;
											node1 n1=new node1(true,no1.a);
											
											return n1;
										} else  {
											String [][] S3=no1.a.clone();
											for(int i=0;i<S3.length;i++){
												if(S3[i][0]==null){
													Integer a=i2+1;
													S3[i][0]="Equation ("+a.toString()+"):   "+S3[i][0];
													break;
												}
											}
											EE.E[0] = ee;
											String s1=EE.E[0].toString();
											String s2=EE.s2.toString();
											s2=s2.replaceFirst("[a-zA-Z0-9_+|=(),]*", s1);
											StringBuilder sb1=new StringBuilder();
											sb1.append(s2);
											EE=Equationsfromfile.EquationsBuilder(sb1);
											n=ee.t2[0].contains[0];
											node1  a1=deepthfirst(EE);
											if(a1.n){
											//node1 a2=new node1(false,null);
											String[][] S2=new String[10][2];
											int i4=0;
											if(S3!=null)
											for(int i=0;i<S3.length;i++){
												if(S3[i][0]!=null){
													S2[i4]=S3[i].clone();
													i4++;
												}
											}
											if(a1.a!=null)
											for(int i=0;i<a1.a.length;i++){
												if(a1.a[i][0]!=null){
													S2[i4]=a1.a[i];
													i4++;
												}
											}
											a1.a=S2;
											}else{
												continue;
											}
										    return a1;
											}
											
											
										}
									}
							}
						}

					
		return new node1(false,null);

	}
	
	public static void main(String[] args) throws IOException {
		// node a1 = new node("p(a,X)").buildtree("p(a,X)");
		// node b1 = new node("p(X,X)").buildtree("p(X,X)");
		// boolean a = FindNodeUnifier(a1, b1);

		// System.out.println(a);
		// while (a) {

		// System.out.println(b1);
		// System.out.println(str[0]+"/"+str[1]);
		// a1.usesbt(str);
		// b1.usesbt(str);

		// System.out.println(a1.firstchild.isvarible(a1.firstchild));

		// System.out.println(str[0]+"/"+str[1]);
		// System.out.println(a1);
		// System.out.println(b1);
		// a = FindNodeUnifier(a1, b1);
		// }
		Equations a = Equationsfromfile.EquationsBuilder("C:\\equations.txt");
		//
		basic bc = new basic(a);
		bc.EEE1=Equations.makecopy(a);
		bc.EEE2=Equations.makecopy(a);
		//String aa=bc.EEE1.toString();
		//System.out.println(aa);
		//String bb="ssfdsfsdfsd";
		//aa=aa.replaceFirst("[a-zA-Z0-9_+|=(),]*", bb);
		///System.out.println(aa);
		 //Equation b=a.E[1];
		//node n = new node("q(X,X)").buildtree("q(X,X)");
		//Equation b = a.E[5];
		//FindNodeUnifier(n, b.t1[0].contains[0]);
		//int ii=0;
		//while(S[ii][0]!=null){
			//System.out.println(S[ii][0]+"/"+S[ii][1]);
			//ii++;
	//	}
		//Equation ee = basic.Unifier(n, b);
		//node1 aa=new node1(false,null);
		//String aaa=aa.toString();
		System.out.println(bc.deepthfirst(a));
		//System.out.println(aaa);
		// node n=a.E[0].t2[0].contains[0];
		// System.out.println(n);
		// System.out.println(b.t1[0].contains[0]);
		// Equation ee=basic.Unifier(n, b);
		// System.out.println(FindNodeUnifier(n, b.t1[0].contains[0]));
		// System.out.println(n.isfunction(n));
		// System.out.println(n.child);
		 //System.out.println(a);
		// System.out.println(a.E[0].t2[0].contains[0].isfunction(a.E[0].t2[0].contains[0]));
		//System.out.println(ee);System.out.println(n);System.out.println(b);
		// System.out.println(a.E[0].t2[0].contains[0].child);

	}
}
