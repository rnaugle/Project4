package Absyn;

public class Stmt extends Absyn{

	public Stmt(){
		
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
