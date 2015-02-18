package Absyn;

public class IdentifierExpr extends AssignableExpr{
	
	public String id;
	public IdentifierExpr(String id){
		this.id = id;
				
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
