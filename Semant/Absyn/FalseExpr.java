package Semant.Absyn;

public class FalseExpr extends Expr{

	public FalseExpr(){
		
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
}
