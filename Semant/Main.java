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
    
    
    java.util.LinkedList<FIELD> f = new java.util.LinkedList<FIELD>();
    FIELD print = new FIELD( new FUNCTION(Symbol.symbol("print"),null, null, null), 0, Symbol.symbol("print"));
    FIELD println = new FIELD( new FUNCTION(Symbol.symbol("println"),null, null, null), 0, Symbol.symbol("println"));
    FIELD printint = new FIELD( new FUNCTION(Symbol.symbol("printint"),null, null, null), 0, Symbol.symbol("printint"));
    FIELD readint = new FIELD( new FUNCTION(Symbol.symbol("readint"),null, null, null), 0, Symbol.symbol("readint"));
    FIELD threadCreate = new FIELD( new FUNCTION(Symbol.symbol("threadCreate"),null, null, null), 0, Symbol.symbol("threadCreate"));
    FIELD yield = new FIELD( new FUNCTION(Symbol.symbol("yield"),null, null, null), 0, Symbol.symbol("yield"));
    FIELD sleep = new FIELD( new FUNCTION(Symbol.symbol("sleep"),null, null, null), 0, Symbol.symbol("sleep"));
    f.add(print);
    f.add(println);
    f.add(printint);
    f.add(readint);
    f.add(threadCreate);
    f.add(yield);
    f.add(sleep);
    RECORD xinuMethods = new RECORD(f);
    CLASS xinu = new CLASS(Symbol.symbol("Xinu"));
    xinu.methods = xinuMethods;
    xinu.parent = null;
    xinu.fields = null;
    xinu.instance = null;
    
    
    
    
    for(Semant.Absyn.ClassDecl cd : pm.classes){
    	CLASS c1 = new CLASS(Symbol.symbol(cd.name));
    	RECORD methods = new RECORD();
    	for(Semant.Absyn.MethodDecl md : cd.methods){
    		methods.put(new FUNCTION(Symbol.symbol(md.name),null, new RECORD(), null), Symbol.symbol(md.name));
    	}
    	c1.methods = methods;
    	RECORD fields = new RECORD();
    	for(Semant.Absyn.VarDecl vd : cd.fields){
    		fields.put(null, Symbol.symbol(vd.name));
    	}
    	c1.fields = fields;
    	c1.parent = null;
    	c1.instance = null;
    	tb.put(c1.name, c1);
    }
    
    for(Semant.Absyn.ClassDecl cd : pm.classes){
    	CLASS c1 = (CLASS)tb.get(Symbol.symbol(cd.name));
    	Object p1 = tb.get(Symbol.symbol(cd.parent));
    	if(!(p1 instanceof CLASS)){
    		//print error
    		return;
    	}
    	CLASS parent = (CLASS) p1;
    	if(parent == null){
    		//print error
    		return;
    	}else{
    		c1.parent = parent;
    		for(FIELD parentmethods : parent.methods){
    			c1.methods.put(parentmethods.type, parentmethods.name);
    		}
    		for(FIELD parentfields : parent.fields){
    			c1.fields.put(parentfields.type, parentfields.name);
    		}
    	}
    	
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
