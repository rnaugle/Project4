package Absyn;

public class NotEqExpr extends BinOpExpr{
	
	public NotEqExpr(Expr e1, Expr e2){
		super(e1, e2);
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Visit.Visitor v)      {          v.visit(this);   }

}
