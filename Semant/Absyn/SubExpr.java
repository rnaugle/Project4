package Semant.Absyn;

public class SubExpr extends BinOpExpr{
	public SubExpr(Expr e1, Expr e2){
		super (e1, e2);
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
