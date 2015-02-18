package Absyn;

public class NotExpr extends Expr{
	public Expr e1;
	public NotExpr(Expr e1){
		this.e1 = e1;
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
