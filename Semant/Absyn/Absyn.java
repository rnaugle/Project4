package Absyn;

public abstract class Absyn implements Semant.Visit.Visitable{

	public abstract String toString();
	
	public void accept(Semant.Visit.Visitor v){v.visit(this);}
	

	
}
