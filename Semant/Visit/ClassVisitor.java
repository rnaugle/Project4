package Semant.Visit;
import Semant.Absyn.*;
//import Semant.Types.*;
import Semant.Symbol.*;

public ClassVisitor extends Visitor{
	
	Table ct;
	Table ot;
	public Semant.Types.Type setTable(Table t){
		ct = t;
		ot = new Table();
	}
	
	
	public Semant.Types.Type visit(Absyn a);
	  public Semant.Types.Type visit(AddExpr e);
	  public Semant.Types.Type visit(AndExpr e);
	  public Semant.Types.Type visit(ArrayExpr e);
	  public Semant.Types.Type visit(ArrayType e){
		  Semant.Types.Type t = e.base;
		  return new Semant.Types.ARRAY(t);
	  }
	  public Semant.Types.Type visit(AssignableExpr e);
	  public Semant.Types.Type visit(AssignStmt e);
	  public Semant.Types.Type visit(BinOpExpr e);
	  public Semant.Types.Type visit(BlockStmt e);
	  public Semant.Types.Type visit(BooleanType e){
		  return new Semant.Types.BOOLEAN();
	  }
	  public Semant.Types.Type visit(CallExpr e);
	  public Semant.Types.Type visit(ClassDecl e){
	
		  ot.beginScope();
		  CLASS c = (CLASS)get(Symbol.symbol(e.name));
		  CLASS p = (CLASS)get(Symbol.symbol(e.parent));
		  while(p != null){
			  for(FIELD f : p.)
		  }
		  for(MethodDecl m: e.methods){
			  m.accept(this;)
		  }
		  
		  
	  
	  }
	  public Semant.Types.Type visit(DivExpr e);
	  public Semant.Types.Type visit(EqualExpr e);
	  public Semant.Types.Type visit(Expr e);
	  public Semant.Types.Type visit(FalseExpr e);
	  public Semant.Types.Type visit(FieldExpr e);
	  public Semant.Types.Type visit(Formal e);
	  public Semant.Types.Type visit(GreaterExpr e);
	  public Semant.Types.Type visit(IdentifierExpr e);
	  public Semant.Types.Type visit(IdentifierType e){
		  Semant.Types.Type t = ct.get(Symbol.symbol(e.id));
		  if(t == null){
			  System.err.println("ERROR cannot resolve symbol: "+ e.id);
		  }else{
			  return t;
		  }
	  }
	  public Semant.Types.Type visit(IfStmt e);
	  public Semant.Types.Type visit(IntegerLiteral e);
	  public Semant.Types.Type visit(IntegerType e){
		  return new Semant.Types.INT();
	  }
	  public Semant.Types.Type visit(LesserExpr e);
	  public Semant.Types.Type visit(MethodDecl e){
		  for(VarDecl v : e.locals){
			  Semant.Types.Type type = v.visit(this);
		  }
		  for(Stmt s : e.stmts){
			  Semant.Types.Type type2 = s.visit(this)
		  }
		  ot.put(new FUNCTION(e.name, ))
		  //return 
	  }
	  public Semant.Types.Type visit(MulExpr e);
	  public Semant.Types.Type visit(NegExpr e);
	  public Semant.Types.Type visit(NewArrayExpr e);
	  public Semant.Types.Type visit(NewObjectExpr e);
	  public Semant.Types.Type visit(NotEqExpr e);
	  
	  public Semant.Types.Type visit(NullExpr e);
	  public Semant.Types.Type visit(OrExpr e);
	 
	  
	  public Semant.Types.Type visit(Program e){
		  for(ClassDecl c: e.classes){
			  c.accept(this;)
		  }
	  }
	  public Semant.Types.Type visit(Stmt e);
	  public Semant.Types.Type visit(StringLiteral e);
	  public Semant.Types.Type visit(SubExpr e);
	  public Semant.Types.Type visit(ThisExpr e);
	  public Semant.Types.Type visit(ThreadDecl e);
	  public Semant.Types.Type visit(TrueExpr e);
	  public Semant.Types.Type visit(Type e){
		  System.err.println("THIS SHOULDNT HAPPEN");
	  }
	  public Semant.Types.Type visit(VarDecl e){
		  Semant.Types.Type t = e.type.visit(this);
		  Semant.Types.Type t1 = e.init.visit(this);
		  
		  if(ct.get(Symbol.symbol(e.name))!= null){
			  //ERROR
			  //TODO should know what method/ class your in
			  System.err.println("ERROR "+e.name+" is already defined in:");
		  }
		  
		  if(t1.coerceTo(t)){
			  ct.put(Symbol.symbol(e.name), t);
		  }else{
			  if(t instance of Semant.Types.ARRAY){
				  System.err.println("ERROR incompatible type: array required, but " + t1.toString()+" found");
			  }else{
				  System.err.println("ERROR incompatible type: " + t.toString()+" required, but " + t1.toString()+" found");
			  }
			  AbsynPrintVisitor a = new AbsynPrintVisitor();
			  a.visit(e);
		  }
		  
		  
		  
	  }
	  public Semant.Types.Type visit(VoidDecl e);
	  public Semant.Types.Type visit(WhileStmt e);
	  public Semant.Types.Type visit(XinuCallStmt e);
	  public Semant.Types.Type visit(XinuCallExpr e);
	  
	
}