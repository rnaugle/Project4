<<<<<<< .merge_file_QR7uct
package Semant.Absyn;
=======
package Absyn;
//import Semant.Visit.Visitor;
import Semant.Visit.*;
>>>>>>> .merge_file_6RcRJt

public abstract class Absyn implements Semant.Visit.Visitable{

	public abstract String toString();
	
	public void accept(Semant.Visit.Visitor v){v.visit(this);}
	

	
}
