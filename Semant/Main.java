package Semant;
import Semant.Types.*;
import Semant.Symbol.*;
public class Main {
	public static void main(String[] args)
 {
    Semant.Absyn.Program pm = null;
    java.util.LinkedList c = null;
	
    try
      {
        java.io.FileReader reader = new java.io.FileReader(args[0]);
        pm = new ReadAbsyn(reader).Program();
      }
    catch (java.io.IOException e)
      {
        System.err.println(e.toString());
      }
    catch (ParseException p)
      {
        System.out.println(p.toString());
        System.exit(-1);
      }
    Table tb = new Table();
    for(Semant.Absyn.ClassDecl cd : pm.classes){
    	CLASS cl = new CLASS(Symbol.symbol(cd.name));
    	RECORD methods = new RECORDS
    	
    }
	

    // Print Visitor
    //     System.out.println("Input String:");
    //         Visit.PrintVisitor pv = new Visit.PrintVisitor();
    //             pv.visit(g);
    //                 System.out.println();
    //                    System.out.println();
    
    //                         System.out.println("Abstract Syntax Tree:");
            Semant.Visit.AbsynPrintVisitor apv = new Semant.Visit.AbsynPrintVisitor();
            apv.visit(pm);
     //       System.out.println();
     //       System.out.println();
    //        System.out.println("Interpreter:");
    //        Visit.Interpreter interp = new Visit.Interpreter();
           // System.out.println(interp.visit(g));
    }
}  //Main
