package Semant.Types;

//import Semant.Visitor;

public class FUNCTION extends Type{
	
	public RECORD formals;
	public String name;
	public Type result;
	public Type self;
	
	public FUNCTION(String n, Type s, RECORD f, Type r){
		this.name = n;
		this.formals = f;
		this.result = r;
		this.self = s;
	}
	
	public FIELD addFormal(Type type, String n){
		;
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
