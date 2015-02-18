package Visit;

/**
 * PrintVisitor.java
 *
 * Given an AST of the program, prints the original text of the program.
 *
 * Created: Thu Sep 23 14:18:50 2004
 *
 * @author <a href="mailto:brylow@elsinore.cs.purdue.edu">Dennis Brylow</a>
 * @version 1.0
 */

public class PrintVisitor implements Visitor
{
  public PrintVisitor() {}

  public void visit(Absyn.Goal g)   {  g.e.accept(this);  }
  public void visit(Absyn.Exp e)    {  }
  public void visit(Absyn.AddExp e)
  {
    e.left.accept(this);
    System.out.print(" + ");
    e.right.accept(this);
  }

  public void visit(Absyn.SubExp e)
  {
    e.left.accept(this);
    System.out.print(" - ");
    e.right.accept(this);
  }

  public void visit(Absyn.MulExp e)
  {
    e.left.accept(this);
    System.out.print(" * ");
    e.right.accept(this);
  }

  public void visit(Absyn.DivExp e)
  {
    e.left.accept(this);
    System.out.print(" / ");
    e.right.accept(this);
  }

  public void visit(Absyn.NumExp e) {  System.out.print(e.num);  }
  public void visit(Absyn.IdExp e)  {  System.out.print(e.id);   }

}// Visitor
