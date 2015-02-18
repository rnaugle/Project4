package Absyn;

public class FieldExpr extends AssignableExpr{
	public Expr target;
	public java.lang.String field;
	public FieldExpr(Expr target, java.lang.String field){
		this.target = target;
		this.field = field;
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
