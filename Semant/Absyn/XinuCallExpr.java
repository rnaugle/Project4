package Absyn;

public class XinuCallExpr extends Expr{
	public String method;
	public java.util.LinkedList<Expr> args;
	public XinuCallExpr(java.lang.String method, java.util.LinkedList<Expr> args){
		this.method = method;
		this.args = args;
	}
	
	public String toString()
	  {   return "";   }
	
	 public void accept(Visit.Visitor v)      {          v.visit(this);   }
	
}
