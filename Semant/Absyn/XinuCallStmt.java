package Absyn;

public class XinuCallStmt extends Stmt{
	
	
	public String method;
	public java.util.LinkedList<Expr> args;
	public XinuCallStmt(java.lang.String method, java.util.LinkedList<Expr> args){
		this.method = method;
		this.args = args;
	}
	
	public String toString()
	  {   return "";   }
	
	 public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
