package at.fhv.just.grammar.semantic;

import at.fhv.just.grammar.ParseException;

public class SymbolTable {

	public static Scope curScope = new Scope();
	
	public void enableScopeDebug(boolean flag) {
	}
	
	public void enterScope() {
		Scope newScope = new Scope();
		newScope.outerScope = curScope;
		newScope.level = curScope.level + 1;
		curScope = newScope;
		System.out.println(">> SymbolTable: enterScope() - curScope: " + curScope.level);
	}
	
	public void leaveScope() throws ParseException {
		curScope.closeScope();
		System.out.println("<< SymbolTable: leaveScope() - curScope: " + curScope.level);
		curScope = curScope.outerScope;
	}
	
	public Symbol lookup(String symbolName) {
		return curScope.find(symbolName, true);
	}
	
	public void insert(String symbolName, Type type, Symbol.Kind kind) throws ParseException {
		Symbol s = curScope.find(symbolName, false);
		if (s == null) {
			s = new Symbol();
			s.kind = kind;
			s.type = type;
			curScope.addSymbol(s);
		}
		if (s.type == Type.undefType) {
			s.kind = kind;
			s.type = type;
		} else {
			throw new ParseException("SymbolTable: insert(): FUUU!!!! leave me alone with your horseshit! (╯°□°）╯︵ ┻━┻");
		}
	}

}
