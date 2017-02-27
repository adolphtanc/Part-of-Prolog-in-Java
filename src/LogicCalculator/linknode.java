package LogicCalculator;



public class linknode{
	String [] a;
	linknode next=null;
	linknode(String[] s){
		a=s;
	}
	static linknode[] stonode(String[][] s){
		linknode n1 = null;
		linknode n2 = null;
		linknode n;
		linknode[] l=new linknode[2];
		if(s!=null)if(s[0]!=null)if(s[0][0]!=null){
			n1=new linknode(s[0]);
			n2=n1;
			for(int i=1;i<s.length;i++)
				if(s[i][0]!=null){
					n=new linknode(s[i]);
					n2.next=n;
					if(i==s.length-1){
						n2=n;
					}
				}
		}
		l[0]=n1;
		l[1]=n2;
		return l;
		
			}
	public String toString(){
		StringBuilder sb=new StringBuilder();
		if(a!=null){
			for(int i=0;i<a.length;i++){
				sb.append(a[i]);		
				}
			return sb.toString();
		}
		else return null;
	}
}
