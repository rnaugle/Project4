package Absyn;

public class Formal extends Absyn{

	public Type type;
	public String name;
	public Formal(Type type, String name){
		this.type = type;
		this.name = name;
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
