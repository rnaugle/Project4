package Semant.Types;

import java.util.Iterator;

//import Semant.Visitor;

public class RECORD extends Type implements java.lang.Iterable<FIELD>{
	java.util.LinkedList<FIELD> fields;

	public RECORD(java.util.LinkedList<FIELD> f){
		this.fields = f;
	}

	public FIELD get(Semant.Symbol.Symbol name){
		return null;
	}
	
	public Iterator<FIELD> iterator(){
		return null;
		
	}
	
	public FIELD put(Type type, Semant.Symbol.Symbol name){
		return null;
		
	}

	@Override
	public void accept(Semant.Visit.Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean coerceTo(Type t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
