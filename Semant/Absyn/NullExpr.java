package Absyn;

public class NullExpr extends Expr{
	public NullExpr(){
		
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
