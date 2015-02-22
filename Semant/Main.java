package Semant;
import Semant.Types.*;
import Semant.Symbol.*;
public class Main {
	
	public static Table tb;
	
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
    
    tb = new Table();
    
    
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
    RECORD xinuMethods = new RECORD();
    CLASS xinu = new CLASS(Symbol.symbol("Xinu"));
    xinu.methods = xinuMethods;
    xinu.parent = null;
    xinu.fields = null;
    xinu.instance = null;
    
    CLASS thread = new CLASS(Symbol.symbol("Thread"));
    xinu.methods = null;
    xinu.parent = null;
    xinu.fields = null;
    xinu.instance = null;
    tb.put(xinu.name, xinu);
    tb.put(thread.name, thread);
    boolean error = false;
    java.util.LinkedList<String> classNames = new java.util.LinkedList<String>();
    //CLASSES, DUPLICATES
    for(Semant.Absyn.ClassDecl cd : pm.classes){
    	for(String s : classNames){
    		if(s.equals(cd.name)){
    			//Error print
    			System.out.println("ERROR duplicate class: " + cd.name + ": line not available");
    			error = true;
    			//return;
    		}
    	}
    	classNames.add(cd.name);
    	CLASS c1 = new CLASS(Symbol.symbol(cd.name));
    	
    	RECORD methods = new RECORD();
    	//for(Semant.Absyn.MethodDecl md : cd.methods){
    	//	methods.put(new FUNCTION(Symbol.symbol(md.name),null, new RECORD(), null), Symbol.symbol(md.name));
    	//}
  
    	RECORD fields = new RECORD();
    	//for(Semant.Absyn.VarDecl vd : cd.fields){
    	//	fields.put(null, Symbol.symbol(vd.name));
    	//}
    	c1.methods = methods;
    	
    	c1.fields = fields;
    	
   
    	//c1.methods = null;
    	
    	//c1.fields = null;
    	c1.parent = null;
    	c1.instance = null;
    	tb.put(c1.name, c1);
    }
    
    if(error == true){
    	return;
    }
    //BUILD PARENTS
    for(Semant.Absyn.ClassDecl cd : pm.classes){
    	CLASS c1 = (CLASS)tb.get(Symbol.symbol(cd.name));
    	if(cd.parent == null){
    		
    	}else{
    		CLASS p1 = (CLASS)tb.get(Symbol.symbol(cd.parent));
        	
        	if(p1 == null){
        		//print error cannot resolve parent class
        		System.out.println("ERROR cannot resolve parent class: "+cd.parent + ": line not available");
        		error = true;
        	}else{
        		c1.parent = p1;
        	    		
        	}    	
        	//OBJECT instance = new OBJECT(c1, );
    	}
    	
    	
    }
    
    if(error == true){
    	return;
    }
    
    
    
    //CHECK FOR CYCLE
    for(Semant.Absyn.ClassDecl cd : pm.classes){
    	CLASS c1 = (CLASS)tb.get(Symbol.symbol(cd.name));
    	String ogClassName = cd.name;
    	if(cd.parent == null){
    		   	
    	}else{
    		CLASS p1 = (CLASS)tb.get(Symbol.symbol(cd.parent));
        	while(p1.parent != null){
        		//System.out.println(p1.name.toString() + " ==?" + ogClassName);
        		if(p1.name.toString().equals(ogClassName)){
        			//print error cycle
        			System.out.println("ERROR cyclic inheritence involving "+ cd.name + ": line not available");
        			error = true;
        			break;
        		}
        		p1 = (CLASS)tb.get(p1.parent.name);
        	} 
    	}
    	
    }
    if(error == true){
    	return;
    }
    
    for(Semant.Absyn.ClassDecl cd : pm.classes){
    	CLASS c1 = (CLASS)tb.get(Symbol.symbol(cd.name));
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
	
	//public static parent merge
}  //Main
