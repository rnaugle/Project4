package Semant.Absyn;

public class OrExpr extends BinOpExpr{
	public OrExpr(Expr e1, Expr e2){
		super (e1, e2);
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
