package Absyn;

public class VoidDecl extends MethodDecl{
	
	//TODO: Another Constructor problem
	public VoidDecl(java.lang.String name, java.util.LinkedList<VarDecl> locals, java.util.LinkedList<Stmt> stmts){
		super(null, false, name,null,  locals, stmts, null);
	}
	
	public String toString()
	  {   return "";   }
	
	 public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
