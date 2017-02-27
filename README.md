# Part-of-Prolog-in-Java
Reading Professor Anil Nerode's Logic for Application,I want to build a simulation of logic using fomulas in that book in Java.
If your input is"p(h(m),X);
p(h(M),X)=q(X,Y)+r(X,Z);
p(X,X)=s(X);
q(b,a);
q(a,a);
q(X,Y)=r(a,Y);
r(b,Z);
s(X)=q(X,a)
"in basic.java,p(h(m),X)is your aim;
you will get"Equation (1):   null/nullX/bY/aEquation (3):   null/nullEquation (6):   null/null
 true1",means no substitution in using equation1,x/b,y/a inequation 3,no substitution when using equation 6;
 and get a yes.
