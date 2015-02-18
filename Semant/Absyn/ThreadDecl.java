package Absyn;

public class ThreadDecl extends ClassDecl{
	//TODO: no clue what to do for parent
	public ThreadDecl(java.lang.String name, java.util.LinkedList<VarDecl> fields, java.util.LinkedList<MethodDecl> methods){
		super(name,null, fields, methods);
	}
	
	public String toString()
	  {   return "";   }
	
	 public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
