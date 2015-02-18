package Absyn;

public class Expr extends Absyn{
	
	public Expr(){
		
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
