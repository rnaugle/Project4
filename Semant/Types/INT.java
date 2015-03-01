package Semant.Types;

//import Semant.Visitor;

public class INT extends Type{
	
	public INT(){
		
	}

	@Override
	public void accept(Semant.Visit.Visitor v) {
		v.visit(this);
		
	}
	
	public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }

	@Override
	public boolean coerceTo(Type t) {
		// TODO Auto-generated method stub
		if( t.getClass().getName() == this.getClass().getName() ){
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new String("int");
	}

}
