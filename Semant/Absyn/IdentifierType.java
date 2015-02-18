package Absyn;

public class IdentifierType extends Type{

	public String id;
	public IdentifierType(String id){
		this.id = id;
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
