package Semant.Absyn;

public class TrueExpr extends Expr{
	public TrueExpr(){
		
	}
	
	public String toString()
	  {   return "";   }
	
	 public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
}
