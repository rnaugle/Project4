package Absyn;

public class DivExpr extends BinOpExpr{
	
	public DivExpr(Expr e1, Expr e2){
		super(e1, e2);
	}
	
	
	public String toString()
	  {   return "";   }
	
	public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
