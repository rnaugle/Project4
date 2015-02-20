package Semant.Absyn;

public class Expr extends Absyn{
	
	public Expr(){
		
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
}
