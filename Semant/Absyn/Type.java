package Semant.Absyn;

public class Type extends Absyn{
	public Type(){
		
	}
	
	public String toString()
	  {   return "";   }
	
	 public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
}
