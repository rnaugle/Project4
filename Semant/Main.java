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
	//xinuMethods.fields = f;
    for(FIELD field : f){
    	xinuMethods.put(field, field.name);
    }
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
    	//CLASS c1 = convertClassDecl(cd);
    	CLASS c1 = new CLASS(Symbol.symbol(cd.name));
    	for(String s : classNames){
    		if(s.equals(cd.name)){
    			//Error print
    			System.out.println("ERROR duplicate class: " + cd.name + ": line not available");
    			error = true;
    			//return;
    		}
    	}
    	classNames.add(cd.name);
    	//CLASS c1 = new CLASS(Symbol.symbol(cd.name));
    	
    	RECORD methods = new RECORD();
    	for(Semant.Absyn.MethodDecl md : cd.methods){
    		RECORD formals = new RECORD;
    		for(Semant.Absyn.Formal : md.params){
    			//formals.put();
    		}
    		methods.put(new FUNCTION(Symbol.symbol(md.name),null, new RECORD(), null), Symbol.symbol(md.name));
    		
    	}
  
    	RECORD fields = new RECORD();
    	for(Semant.Absyn.VarDecl vd : cd.fields){
    		fields.put(null, Symbol.symbol(vd.name));
    	}
    	c1.methods = methods;
    	
    	c1.fields = fields;
    	
   
    	c1.methods = null;
    	
    	//c1.fields = null;
    	//c1.parent = null;
    	//c1.instance = null;
    	//tb.put(c1.name, c1);
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
 //Main


static CLASS convertClassDecl(Semant.Absyn.ClassDecl cd)
{
	CLASS c = new CLASS(Symbol.symbol(cd.name));
	c.fields = new RECORD();
	c.fields = createFieldRECORD(cd.fields);
	c.methods = new RECORD();
	c.methods = createMethodRECORD(cd.methods, c);
	if (cd.parent != null)
		c.parent = new CLASS(Symbol.symbol(cd.parent));
	else
		c.parent = null;
	c.instance = createOBJECT(c);
	return c;
}

static OBJECT createOBJECT(CLASS c)
{
	OBJECT o = new OBJECT(c);
	return o;
}

static RECORD createFieldRECORD(java.util.LinkedList<Semant.Absyn.VarDecl> fields)
{
	RECORD f = new RECORD();
	for (int i = 0; i < fields.size(); i++)
		f.fields.add(createFieldsFIELD(fields.get(i),i));
	return f;
}

static RECORD createMethodRECORD(java.util.LinkedList<Semant.Absyn.MethodDecl> methods, CLASS c)
{
	RECORD m = new RECORD();
	for (int i = 0; i < methods.size(); i++)
		m.fields.add(createMethodsFIELD(methods.get(i),i, c));
	return m;
}

static FIELD createFieldsFIELD(Semant.Absyn.VarDecl vd, int index)
{
	if (vd.type instanceof Semant.Absyn.ArrayType)
		return new FIELD(createARRAY(vd ,index),index,Symbol.symbol(vd.name));
	else if (vd.type instanceof Semant.Absyn.BooleanType)
		return new FIELD(new BOOLEAN(),index,Symbol.symbol(vd.name));
	else if (vd.type instanceof Semant.Absyn.IdentifierType)
		return new FIELD(new OBJECT(new CLASS(Symbol.symbol(vd.name))),index,Symbol.symbol(vd.name));
	else if (vd.type instanceof Semant.Absyn.IntegerType)
		return new FIELD(new INT(),index,Symbol.symbol(vd.name));
	else
		return null;
}

static ARRAY createARRAY(Semant.Absyn.VarDecl vd, int index)
{
	if (vd.type instanceof Semant.Absyn.BooleanType)
		return new ARRAY(new BOOLEAN());
	else if (vd.type instanceof Semant.Absyn.IdentifierType)
		return new ARRAY(new OBJECT(new CLASS(Symbol.symbol(vd.name))));
	else if (vd.type instanceof Semant.Absyn.IntegerType)
		return new ARRAY(new INT());
	else
		return null;
}

static FIELD createMethodsFIELD(Semant.Absyn.MethodDecl md, int index, CLASS c)
{
	if (md.returnType != null)
		return new FIELD(new FUNCTION(Symbol.symbol(md.name), c, createFormalRECORD(md.params), createType(md.returnType)),index,Symbol.symbol(md.name));
	else
		return null;
}


static RECORD createFormalRECORD(java.util.LinkedList<Semant.Absyn.Formal> formals)
{
	RECORD f = new RECORD();
	for (int i = 0; i < formals.size(); i++)
		f.fields.add(createFormalsFIELD(formals.get(i),i));
	return f;
}

static FIELD createFormalsFIELD(Semant.Absyn.Formal formal, int index)
{
	if (formal.type instanceof Semant.Absyn.ArrayType)
		return new FIELD(createARRAYFormal(formal ,index),index,Symbol.symbol(formal.name));
	else if (formal.type instanceof Semant.Absyn.BooleanType)
		return new FIELD(new BOOLEAN(),index,Symbol.symbol(formal.name));
	else if (formal.type instanceof Semant.Absyn.IdentifierType)
		return new FIELD(new OBJECT(new CLASS(Symbol.symbol(formal.name))),index,Symbol.symbol(formal.name));
	else if (formal.type instanceof Semant.Absyn.IntegerType)
		return new FIELD(new INT(),index,Symbol.symbol(formal.name));
	else
		return null;
}

static ARRAY createARRAYFormal(Semant.Absyn.Formal formal, int index)
{
	if (formal.type instanceof Semant.Absyn.BooleanType)
		return new ARRAY(new BOOLEAN());
	else if (formal.type instanceof Semant.Absyn.IdentifierType)
		return new ARRAY(new OBJECT(new CLASS(Symbol.symbol(formal.name))));
	else if (formal.type instanceof Semant.Absyn.IntegerType)
		return new ARRAY(new INT());
	else
		return null;
}


static Type createType(Semant.Absyn.Type type)
{
	if (type instanceof Semant.Absyn.ArrayType)
		return createTypeARRAY(type);
	else if (type instanceof Semant.Absyn.BooleanType)
		return new BOOLEAN();
	else if (type instanceof Semant.Absyn.IdentifierType)
		return new OBJECT(new CLASS(Symbol.symbol(((Semant.Absyn.IdentifierType)type).id)));
	else if (type instanceof Semant.Absyn.IntegerType)
		return new INT();
	else
		return null;
}

static Type createTypeARRAY(Semant.Absyn.Type type)
{
	if (type instanceof Semant.Absyn.BooleanType)
		return new ARRAY(new BOOLEAN());
	else if (type instanceof Semant.Absyn.IdentifierType)
		return new ARRAY(new OBJECT(new CLASS(Symbol.symbol(((Semant.Absyn.IdentifierType)type).id))));
	else if (type instanceof Semant.Absyn.IntegerType)
		return new ARRAY(new INT());
	else
		return null;
}

}
