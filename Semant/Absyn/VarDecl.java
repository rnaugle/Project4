package Semant.Absyn;

public class VarDecl extends Absyn{
	public Type type;
	public String name;
	public Expr init;

	public VarDecl(Type type, java.lang.String name, Expr init){
		this.type = type;
		this.name = name;
		this.init = init;
	}
	
	public String toString()
	  {   return "";   }
	
	 public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
