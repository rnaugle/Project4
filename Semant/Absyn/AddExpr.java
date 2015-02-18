package Absyn;

public class AddExpr extends BinOpExpr {

	public AddExpr(Expr e1, Expr e2){
		super(e1, e2);
		
		
	}
	
	 public String toString()
	  {   return this.e1 + " + " + this.e2;   }
	
	 public void accept(Visit.Visitor v)      {          v.visit(this);   }
}
