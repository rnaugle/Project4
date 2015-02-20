PARSER   = ReadAbsyn

JAVAC    = javac
JAVA     = java
JAVACC   = javacc
JJDOC    = jjdoc

JAVACC_FLAGS = -NOSTATIC
JAVAC_FLAGS = -Xdepend

JAVACCGEN = SimpleCharStream.java ParseException.java \
        $(PARSER).java $(PARSER)Constants.java \
        $(PARSER)TokenManager.java Token.java \
        TokenMgrError.java

ABSYN    = Semant/Absyn/Absyn.java Semant/Absyn/Expr.java \
	Semant/Absyn/AddExpr.java Semant/Absyn/ArrayExpr.java \
	Semant/Absyn/ArrayType.java Semant/Absyn/AssignableExpr.java \
	Semant/Absyn/AssignStmt.java Semant/Absyn/BinOpExpr.java \
	Semant/Absyn/BlockStmt.java Semant/Absyn/BooleanType.java \
	Semant/Absyn/CallExpr.java Semant/Absyn/ClassDecl.java \
	Semant/Absyn/DivExpr.java Semant/Absyn/EqualExpr.java \
	Semant/Absyn/FalseExpr.java Semant/Absyn/FieldExpr.java \
	Semant/Absyn/Formal.java Semant/Absyn/GreaterExpr.java \
	Semant/Absyn/IdentifierExpr.java Semant/Absyn/IdentifierType.java \
	Semant/Absyn/IfStmt.java Semant/Absyn/IntegerLiteral.java \
	Semant/Absyn/IntegerType.java Semant/Absyn/LesserExpr.java \
	Semant/Absyn/MainClassDecl.java Semant/Absyn/MethodDecl.java \
	Semant/Absyn/MulExpr.java Semant/Absyn/NegExpr.java \
	Semant/Absyn/NewArrayExpr.java Semant/Absyn/NewObjectExpr.java \
	Semant/Absyn/NotEqExpr.java Semant/Absyn/NotExpr.java \
	Semant/Absyn/NullExpr.java Semant/Absyn/OrExpr.java \
	Semant/Absyn/PrintVisitor.java Semant/Absyn/Program.java \
	Semant/Absyn/Stmt.java Semant/Absyn/StringLiteral.java \
	Semant/Absyn/SubExpr.java Semant/Absyn/ThisExpr.java \
	Semant/Absyn/ThreadDecl.java Semant/Absyn/TrueExpr.java \
	Semant/Absyn/Type.java Semant/Absyn/VarDecl.java \
	Semant/Absyn/VoidDecl.java Semant/Absyn/WhileStmt.java \
	Semant/Absyn/XinuCallExpr.java Semant/Absyn/XinuCallStmt.java

VISIT    = Semant/Visit/Visitor.java \
	Semant/Visit/Visitable.java \
	Semant/Visit/PrintVisitor.java \
	Semant/Visit/AbsynPrintVisitor.java 
#	Semant/Visit/Interpreter.java

SRCS     = $(VISIT) $(ABSYN) $(PARSER).java Semant/Main.java

all:  $(SRCS:.java=.class)

%.class : %.java
	$(JAVAC) $(JAVAC_FLAGS) $<



$(PARSER).java: Semant/$(PARSER).jj
	$(JAVACC) $(JAVACC_FLAGS) $<

parser: $(PARSER).class $(PARSER)Constants.class \
	$(PARSER)TokenManager.class ParseException.class

main: $(PARSER).class Main.class

clean:
	rm -f $(SRCS:.java=.class) ${JAVACCGEN} $(JAVACCGEN:.java=.class)
