package Semant.Absyn;

public class BooleanType extends Type{
	public BooleanType(){
		
		
		
	}
	
	public String toString()
	  {   return "";   }
	
	 public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	 public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { v.visit(this); }
}
