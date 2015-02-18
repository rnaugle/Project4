package Absyn;

public class FalseExpr extends Expr{

	public FalseExpr(){
		
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
