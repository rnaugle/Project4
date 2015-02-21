package Semant.Types;

import java.util.Iterator;

//import Semant.Visitor;

public class RECORD extends Type implements java.lang.Iterable<FIELD>{
	java.util.LinkedList<FIELD> fields;
	int counter;

	public RECORD(){
		this.fields = new java.util.LinkedList<FIELD>();
		counter = 0;
	}
	
	public FIELD get(Symbol name){
		return tb.get(name);
	}
	
	public Iterator<FIELD> iterator(){
		
		return fields.descendingIterator();
		
	}
	
	public FIELD put(Type type, Symbol name){
		tb.put(name,type);
		FIELD field = new FIELD(type,counter++,name);
		return field;
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
