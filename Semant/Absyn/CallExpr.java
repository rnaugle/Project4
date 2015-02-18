package Absyn;

public class CallExpr extends Expr{
	public Expr target;
	public java.lang.String method;
	public java.util.LinkedList<Expr> args;
	
	public CallExpr(Expr target, String method, java.util.LinkedList<Expr> args){ 
		this.target = target;
		this.method = method;
		this.args = args;
		
		
	}
	
	 public String toString()
	  {   return "";   }
	
	 public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
