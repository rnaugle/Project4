package Absyn;

public class MethodDecl extends Absyn{
	
	public Type returnType;
	public boolean synced ;
	public java.lang.String name;
	public java.util.LinkedList<Formal> params;
	public java.util.LinkedList<VarDecl> locals ;
	public java.util.LinkedList<Stmt> stmts;
	public Expr returnVal;
	
	public MethodDecl(Type returnType, boolean synced, 
			java.lang.String name, java.util.LinkedList<Formal> params, java.util.LinkedList<VarDecl> locals, 
			java.util.LinkedList<Stmt> stmts, Expr returnVal){
		
		this.returnType = returnType;
		this.synced =  synced;
		this.name = name;
		this.params = params;
		this.locals =  locals;
		this.stmts = stmts;
		
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
