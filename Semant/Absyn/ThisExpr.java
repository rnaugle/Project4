package Absyn;

public class ThisExpr {

	
	public ThisExpr(){
		
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
