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
	xinuMethods.fields = f;
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
    	CLASS c1 = convertClassDecl(cd);
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
    
    
    
	
Semant.Type.CLASS convertClassDecl(Semant.Absyn.ClassDecl cd)
{
	Semant.Types.CLASS c = new Semant.Type.CLASS(new Semant.Symbol.Symbol(cd.name));
	c.fields = new Semant.Types.RECORD();
	c.fields = createFieldRECORD(cd.fields);
	c.methods = new Semant.Types.RECORD();
	c.methods = createMethodRECORD(cd.methods);
	if (cd.parent != null)
		c.parent = new Semant.Types.CLASS(new Semant.Symbol.Symbol(cd.parent));
	else
		c.parent = null;
	c.instance = createOBJECT(c);
	return c;
}

Semant.Types.OBJECT createOBJECT(Semant.Types.CLASS c)
{
	Semant.Types.OBJECT o = new Semant.Types.OBJECT(c);
	return o;
}

Semant.Types.RECORD createFieldRECORD(java.util.LinkedList<VarDecl> fields)
{
	Semant.Types.RECORD f = new Semant.Types.RECORD();
	for (int i = 0; i < fields.size(); i++)
		f.fields.add(createFieldsFIELD(fields.get(i),i);
	return f;
}

Semant.Types.RECORD createMethodRECORD(java.util.LinkedList<MethodDecl> methods)
{
	Semant.Types.RECORD m = new Semant.Types.RECORD();
	for (int i = 0; i < methods.size(); i++)
		f.fields.add(createMethodsFIELD(fields.get(i),i);
	return f;
}

Semant.Types.FIELD createFieldsFIELD(Semant.Absyn.VarDecl vd, int index)
{
	if (vd.type instanceof Semant.Abysn.ArrayType)
		return new FIELD(Semant.Types.ARRAY,index,new Semant.Symbol.Symbol(vd.name));
	else if (vd.type instanceof Semant.Absyn.BooleanType)
		return new FIELD(Semant.Types.BOOLEAN,index,new Semant.Symbol.Symbol(vd.name));
	else if (vd.type instanceof Semant.Absyn.IdentifierType)
		return new FIELD(Semant.Types.OBJECT,index,new Semant.Symbol.Symbol(vd.name));
	else if (vd.type instanceof Semant.Absyn.IntegerType)
		return new FIELD(Semant.Types.INT,index,new Semant.Symbol.Symbol(vd.name));
	else
		return null;
}

Semant.Types.FIELD createMethodsFIELD(Semant.Absyn.MethodDecl md, int index)
{
	if (md.type != null)
		return new FIELD(Semant.Types.FUNCTION,index,new Semant.Symbol.Symbol(md.name));
	else
		return null;
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
