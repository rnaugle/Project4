package Semant;

public class Main {
    public static void main(String[] args)
     {
       Absyn.Program p = null;
       try
         {
           java.io.FileReader reader = new java.io.FileReader(args[0]);
           p = new Parser(reader).Program();
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

       System.out.println(p);
     }
}
