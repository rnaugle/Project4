package Absyn;

public class StringLiteral extends Expr{

	String value;
	public StringLiteral(String value){
		this.value= value;
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
