package Semant.Absyn;

public class BooleanType extends Type{
	public BooleanType(){
		
		
		
	}
	
	public String toString()
	  {   return "";   }
	
	 public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
}
