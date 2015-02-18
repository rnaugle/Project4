package Absyn;

public class IntegerLiteral extends Expr{
	public int value;
	public IntegerLiteral( int value){
		this.value = value;
	}
	public IntegerLiteral( Integer value){
		this.value = value;
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
