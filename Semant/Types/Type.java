package Semant.Types;

//import Semant.Visitable;
//simport Semant.Visitor;

public abstract class Type implements Semant.Visit.Visitable{
	
	public Type(){
		
	}
	
	public abstract void accept(Semant.Visit.Visitor v);
	public abstract boolean coerceTo(Type t);
	public abstract String toString();
	
}
