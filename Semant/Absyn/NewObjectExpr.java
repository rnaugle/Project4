package Absyn;

public class NewObjectExpr extends Expr{
	public Type type;
	public NewObjectExpr(Type t){
		this.type = t;
		
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
