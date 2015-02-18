package Absyn;

public class ArrayType extends Type{
	public Type base;
	public ArrayType(Type e1){
		this.base = e1;
	
	}
	
	public String toString()
	  {   return "";   }
	
	 public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
