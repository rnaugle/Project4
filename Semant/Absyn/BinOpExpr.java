package Absyn;

public class BinOpExpr extends Expr{
	public Expr e1, e2;
	public BinOpExpr(Expr e1, Expr e2){
		this.e1 = e1;
		this.e2 = e2;
		
	}
	
	public String toString()
	  {   return "";   }
	
	 public void accept(Visit.Visitor v)      {          v.visit(this);   }
	 
}
