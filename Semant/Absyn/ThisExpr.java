package Semant.Absyn;

public class ThisExpr extends Expr{

	
	public ThisExpr(){
		
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
}
