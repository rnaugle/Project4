package Semant.Absyn;

public class Formal extends Absyn{

	public Type type;
	public String name;
	public Formal(Type type, String name){
		this.type = type;
		this.name = name;
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
