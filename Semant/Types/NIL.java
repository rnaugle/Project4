package Semant.Types;

//import Semant.Visitor;

public class NIL extends Type{
	
	public NIL(){
		
	}

	@Override
	public void accept(Semant.Visit.Visitor v) {
		v.visit(this);
		
	}

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
		return null;
	}

}
