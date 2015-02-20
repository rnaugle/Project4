package Semant.Types;

import java.util.Iterator;

//import Semant.Visitor;

public class RECORD extends Type implements java.lang.Iterable<FIELD>{
	
	public RECORD(){
		
	}
	
	public FIELD get(String name){
		return null;
	}
	
	public Iterator<FIELD> iterator(){
		return null;
		
	}
	
	public FIELD put(Type type, String name){
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
