package Semant.Types;

import Semant.Visitable;
import Semant.Visitor;

public class ARRAY extends Type  {
	public Type element;
	
	public ARRAY(Type e){
		this.element = e;
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public
	boolean coerceTo(Type t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	//public abstract void accept(Visitor v);
}
