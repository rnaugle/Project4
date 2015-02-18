package Absyn;

public class NewArrayExpr extends Expr{
	public Type type;
	public java.util.LinkedList<Expr> dimensions;
	
	NewArrayExpr(Type type, java.util.LinkedList<Expr> dimensions){
		this.type = type;
		this.dimensions = dimensions;
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Visit.Visitor v)      {          v.visit(this);   }
	
	
}
