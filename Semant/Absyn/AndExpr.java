package Absyn;

public class AndExpr extends BinOpExpr{

	public AndExpr(Expr e1, Expr e2){
		super(e1, e2);
	}
	
	 public String toString()
	  {   return this.e1 + " && " + this.e2;   }
	
	 public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
