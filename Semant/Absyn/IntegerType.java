package Semant.Absyn;

public class IntegerType extends Type{
	public IntegerType(){
		
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
}
