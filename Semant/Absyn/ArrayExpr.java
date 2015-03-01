package Semant.Absyn;

public class ArrayExpr extends AssignableExpr{
	public Expr target, index;
	public ArrayExpr(Expr e1, Expr e2){
		this.target = e1;
		this.index = e2;
	}
	
	 public String toString()
	  {   return this.target + " [ " + this.index + " ] ";   }
	
	 public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	 public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { v.visit(this); }
}