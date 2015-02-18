package Absyn;

public class ArrayExpr extends AssignableExpr{
	public Expr target, index;
	public ArrayExpr(Expr e1, Expr e2){
		this.target = e1;
		this.index = e2;
	}
	
	 public String toString()
	  {   return this.target + " [ " + this.index + " ] ";   }
	
	 public void accept(Visit.Visitor v)      {          v.visit(this);   }
}