package Absyn;

public class IfStmt extends Stmt{
	public Expr testl;
	public Stmt thenStmt;
	public Stmt elseStmt;
	
	public IfStmt(Expr test1, Stmt y, Stmt u){
		this.testl = test1;
		this.thenStmt = y;
		this.elseStmt = u;
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
