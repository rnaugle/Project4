package Semant.Absyn;

public class ClassDecl extends Absyn{
	public java.lang.String name;
	public java.lang.String parent;
	public java.util.LinkedList<VarDecl> fields;
	public java.util.LinkedList<MethodDecl> methods;
	public ClassDecl(java.lang.String name, java.lang.String parent, java.util.LinkedList<VarDecl> fields, java.util.LinkedList<MethodDecl> methods) { 
		this.name = name;
		this.parent = parent;
		this.fields = fields;
		this.methods = methods;
		
		
	}
	
	public String toString()
	  {   return "";   }
	
	 public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
