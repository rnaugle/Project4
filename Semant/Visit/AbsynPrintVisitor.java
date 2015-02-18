package Visit;

/**
 * AbsynPrintVisitor.java
 *
 * Given an AST of the program, prints and abstract syntax tree dump of
 *  the tree, suitable for completely rebuilding the tree in the next stage
 *  of the example.
 *
 * Created: Thu Sep 23 14:18:50 2004
 *
 * @author <a href="mailto:brylow@elsinore.cs.purdue.edu">Dennis Brylow</a>
 * @version 1.0
 */

public class AbsynPrintVisitor implements Visitor
{
  private java.io.PrintStream out;
  private int indent = 0;

  public AbsynPrintVisitor()
  {  this(System.out);  }

  public AbsynPrintVisitor(java.io.PrintStream out)
  {  this.out = out;  }

  private void printIndent()
  {  for (int i = 0; i < indent; i++)  out.print(" ");  }

  public void visit(Absyn.Program g)
  {
    out.println("Program(");
    indent += 2;    printIndent();
    out.println("AbstractList(");
    indent += 2;    printIndent();
    //TODO handle Lists
    //g.classes.accept(this);
    for(Absyn.ClassDecl c : g.classes){
    	c.accept(this);
    }

    indent -= 2;
    out.print(")");
    indent -= 2;    printIndent();
    out.println(")");
  }

  public void visit(Absyn.Expr e)    {  }
 

  

  public void visit(Absyn.AddExpr e)
  {
    out.println("AddExpr(");
    indent += 2;    printIndent();
    
    e.e1.accept(this);
    e.e2.accept(this);
    
    indent -= 2;    printIndent();
    out.print(")");
  }
  
  public void visit(Absyn.SubExpr e)
  {
    out.println("SubExpr(");
    indent += 2;    printIndent();
    
    e.e1.accept(this);
    e.e2.accept(this);
    
    indent -= 2;    printIndent();
    out.print(")");
  }
  
  public void visit(Absyn.MulExpr e)
  {
    out.println("MulExpr(");
    indent += 2;    printIndent();
    
    e.e1.accept(this);
    e.e2.accept(this);
    
    indent -= 2;    printIndent();
    out.print(")");
  }
  
  public void visit(Absyn.DivExpr e)
  {
    out.println("DivExpr(");
    indent += 2;    printIndent();
    
    e.e1.accept(this);
    e.e2.accept(this);
    
    indent -= 2;    printIndent();
    out.print(")");
  }

  
  public void visit(Absyn.IntegerLiteral e)
  {
    out.print("IntegerLiteral(" + e.value + ")");
  }

  public void visit(Absyn.IdentifierExpr e)
  {
    out.print("IdentifierExpr(" + e.id + ")");
  }
  
  public void visit(Absyn.Absyn e)    
  {  
	  
  }
  
  public void visit(Absyn.AndExpr e)
  {
	  out.println("AndExpr(");
	    indent += 2;    printIndent();
	    
	    e.e1.accept(this);
	    e.e2.accept(this);
	    
	    indent -= 2;    printIndent();
	    out.print(")");
  }
  
  public void visit(Absyn.ArrayExpr e)
  {
	  out.println("ArrayExpr(");
	    indent += 2;    printIndent();
	    
	    e.target.accept(this);
	    e.index.accept(this);
	    
	    indent -= 2;    printIndent();
	    out.print(")");
	    
	    
	    
  }
  public void visit(Absyn.ArrayType e)
  {
	  out.println("ArrayType(");
	  e.base.accept(this);
	  out.print(")");
  }
  public void visit(Absyn.AssignableExpr e)
  {
	  
  }
  public void visit(Absyn.AssignStmt e)
  {
	  out.println("AssignStmt(");
	  e.lhs.accept(this);
	  e.rhs.accept(this);
	  out.print(")");
  }
  public void visit(Absyn.BinOpExpr e)
  {
	  
  }
  public void visit(Absyn.BlockStmt e)
  {
	  out.println("BlockStmt(");
	  indent += 2;    
	    printIndent();
	  out.println("AbstractList(");
	    indent += 2;    
	    printIndent();
	    
	    
	  for(Absyn.Stmt c : e.stmts){
	    	c.accept(this);
	    }
	  
	  indent -= 2;

	    out.print(")");
	    indent -= 2;
		  printIndent();
	  out.print(")");
  }
  public void visit(Absyn.BooleanType e)
  {
	  out.print("BooleanType");
  }

  public void visit(Absyn.CallExpr e)
  {
	  out.print("CallExpr(");
	  indent += 2;    
	    printIndent();
	  e.target.accept(this);
	  //e.rhs.accept(this);
	  out.println(e.method);
	  out.print("AbstractList(");
	    indent += 2;    
	    printIndent();
	    
	    
	  for(Absyn.Expr c : e.args){
	    	c.accept(this);
	    }
	  
	  indent -= 2;
	    out.print(")");
	    
	    

	    indent -= 2;    
	    
	  out.print(")");
	  printIndent();
  }
  public void visit(Absyn.ClassDecl e)
  {
	  out.println("ClassDecl( "+ e.name + " " + e.parent);
	  out.println("AbstractList(");
	    indent += 2;    
	    printIndent();
	    
	    
	  for(Absyn.VarDecl c : e.fields){
	    	c.accept(this);
	    }
	  
	  indent -= 2;
	  printIndent();
	    out.println(")");
	    
	    
	    out.print("AbstractList(");
	    indent += 2;    
	    printIndent();
	    
	    
	  for(Absyn.MethodDecl c : e.methods){
	    	c.accept(this);
	    }
	  
	  indent -= 2;
	  printIndent();
	    out.print(")");
	    
	    indent -= 2;
		  printIndent();
	    
	  out.print(")");
  }
  
  public void visit(Absyn.EqualExpr e)
  {
	  out.println("EqualExpr(");
	    indent += 2;    printIndent();
	    
	    e.e1.accept(this);
	    e.e2.accept(this);
	    
	    indent -= 2;    printIndent();
	    out.print(")");
  }
 
  public void visit(Absyn.FalseExpr e)
  {
    out.println("FalseExpr");
  }
  
  //TODO: dont know
  public void visit(Absyn.FieldExpr e)
  {
    
  }
  public void visit(Absyn.Formal e)
  {
	  out.println("Formal(");
	  e.type.accept(this);
	  out.println(")");
  }
  public void visit(Absyn.GreaterExpr e)
  {
	  out.println("GreaterExpr(");
	    indent += 2;    printIndent();
	    
	    e.e1.accept(this);
	    e.e2.accept(this);
	    
	    indent -= 2;    printIndent();
	    out.print(")");
  }
  public void visit(Absyn.IdentifierType e)
  {
	  out.print("IdentifierType(" + e.id + ")");
  }
  public void visit(Absyn.IfStmt e)
  {
	  out.println("IfStmt(");
	    indent += 2;    printIndent();
	    
	    e.test.accept(this);
	    e.thenStm.accept(this);
	    e.elseStm.accept(this);
	    indent -= 2;    printIndent();
	    out.print(")");
	    
  }
  public void visit(Absyn.IntegerType e)
  {
	  out.print("IntegerType");
  }
  public void visit(Absyn.LesserExpr e)
  {
	  out.println("LesserExpr(");
	    indent += 2;    printIndent();
	    
	    e.e1.accept(this);
	    e.e2.accept(this);
	    
	    indent -= 2;    printIndent();
	    out.print(")");
  }
  public void visit(Absyn.MethodDecl e)
  {
	  out.println("MethodDecl(");
	 e.returnType.accept(this);
	 out.print(" " + e.name);
	 indent += 2;    
	    printIndent();
	 out.println("AbstractList(");
	    indent += 2;    
	    printIndent();
	    
	    
	  for(Absyn.Formal c : e.params){
	    	c.accept(this);
	    }
	  
	  indent -= 2;
	  printIndent();
	    out.print(")");
	    
	    out.println("AbstractList(");
	    indent += 2;    
	    printIndent();
	    
	    
	  for(Absyn.VarDecl c : e.locals){
	    	c.accept(this);
	    }
	  
	  indent -= 2;
	  printIndent();
	    out.print(")");
	    
	    out.println("AbstractList(");
	    indent += 2;    
	    printIndent();
	    
	    
	  for(Absyn.Stmt c : e.stmts){
	    	c.accept(this);
	    }
	  
	  indent -= 2;
	  printIndent();
	    out.print(")");
	    

	    
	    e.returnVal.accept(this);

	    
	    indent -= 2;
		  printIndent();
	    
	  out.print(")");
	  
  }
  public void visit(Absyn.NegExpr e)
  {
      out.print("NegExpr(");
      indent += 2;    printIndent();
      
      e.e1.accept(this);
      
      indent -= 2;    printIndent();
      out.println(")");
      
  }
  public void visit(Absyn.NewArrayExpr e)
  {
      out.println("NewArrayExpr(");
      indent += 2;    printIndent();
      
      e.type.accept(this);
      
      out.println("AbstractList(");
      indent += 2;    printIndent();

      for(Absyn.Expr d : e.dimensions){
          d.accept(this);
      }
      
      indent -= 2;
      out.print(")");
      
      indent -= 2;    printIndent();
      out.println(")");
  }
  public void visit(Absyn.NewObjectExpr e)
  {
      out.println("NewObjectExpr(");
      indent += 2;    printIndent();
      
      e.type.accept(this);
      
      indent -= 2;    printIndent();
      out.println(")");
  }
  public void visit(Absyn.NotEqExpr e)
  {
      out.print("NotEqExpr(");
      indent += 2;    printIndent();
      
      e.e1.accept(this);
      e.e2.accept(this);
      
      indent -= 2;    printIndent();
      out.println(")");
  }
  public void visit(Absyn.NotExpr e)
  {
      out.print("NotExpr(");
      indent += 2;    printIndent();
      
      e.e1.accept(this);
      
      indent -= 2;    printIndent();
      out.println(")");
  }
  public void visit(Absyn.NullExpr e)
  {
      out.print("NullExpr");
  }
  public void visit(Absyn.OrExpr e)
  {
      out.println("OrExpr(");
      indent += 2;    printIndent();
      
      e.e1.accept(this);
      e.e2.accept(this);
      
      indent -= 2;    printIndent();
      out.println(")");
  }
 
  public void visit(Absyn.Stmt e)
  {
      e.accept(this);
  }
  public void visit(Absyn.StringLiteral e)
  {
      out.println("StringLiteral(\""+ e.value+"\")");
  }
  public void visit(Absyn.ThisExpr e)
  {
      out.print("ThisExpr");
  }
  public void visit(Absyn.ThreadDecl e)
  {
      out.print("ThreadDecl("+ e.name+ "Thread");
      indent += 2;    printIndent();
      
      out.println("AbstractList(");
      indent += 2;    printIndent();
      
      for(Absyn.VarDecl v : e.fields){
        v.accept(this);
      }
      indent -= 2;    printIndent();
      out.println(")");
      
      out.println("AbstractList(");
      indent += 2;    printIndent();
      
      for(Absyn.MethodDecl v : e.methods){
        v.accept(this);
      }
    
      indent -= 2;    printIndent();
      out.print(")");
      
      indent -= 2;    printIndent();
      out.println(")");
  }
  public void visit(Absyn.TrueExpr e)
  {
      out.print("TrueExpr");
  }
  public void visit(Absyn.Type e)
  {
      e.accept(this);
  }
  public void visit(Absyn.VarDecl e)
  {
      out.print("VarDecl(");
      e.type.accept(this);
      out.println(" "+ e.name);
      indent += 2;    printIndent();
      
      e.init.accept(this);
      
      indent -= 2;    printIndent();
      out.println(")");
  }
  public void visit(Absyn.VoidDecl e)
  {
    out.println("VoidDecl("+ e.name);
    indent += 2;    printIndent();
    
    out.println("AbstractList(");
    indent += 2;    printIndent();
    
    for(Absyn.VarDecl v : e.locals){
        v.accept(this);
    }
    
    indent -= 2;    printIndent();
    out.println(")");
    
    out.println("AbstractList(");
    indent += 2;    printIndent();
    
    for(Absyn.Stmt v : e.stmts){
        v.accept(this);
    }
    
    indent -= 2;    printIndent();
    out.print(")");
    
    indent -= 2;    printIndent();
    out.println(")");
  }
  public void visit(Absyn.WhileStmt e)
  {
      out.println("WhileStmt(");
      indent += 2;    printIndent();

      e.test.accept(this);
      e.body.accept(this);

      indent -= 2;    printIndent();
      out.println(")");
  }
  public void visit(Absyn.XinuCallExpr e)
  {
      out.println("XinuCallExpr("+ e.method);
      indent += 2;    printIndent();

      out.println("AbstractList(");
      indent += 2;    printIndent();

      for(Absyn.Expr expr : e.args){
          expr.accept(this);
      }

      indent -= 2;
      out.print(")");

      indent -= 2;    printIndent();
      out.println(")");
  }
  public void visit(Absyn.XinuCallStmt e)
  {
      out.println("XinuCallStmt("+ e.method);
      indent += 2;    printIndent();

      out.println("AbstractList(");
      indent += 2;    printIndent();

      for(Absyn.Expr expr : e.args){
          expr.accept(this);
      }

      indent -= 2;
      out.print(")");

      indent -= 2;    printIndent();
      out.println(")");
  }
  

}// Visitor

    
