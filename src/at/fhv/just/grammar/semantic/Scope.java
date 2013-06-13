package at.fhv.just.grammar.semantic;

import at.fhv.just.grammar.ParseException;


public class Scope {
	public Scope outerScope = null;
	public int level = 0;
	public int nrOfParams = 0;
	public int nrOfLocals = 0;
	public Symbol locals = null;
	public Namelist namelist = new Namelist();
	
	public void addSymbol(Symbol s) {
		if (locals == null) {
			locals = s;
		} else {
			Symbol l = locals;
			while (l.next != null) {
				l = l.next;
			}
			l.next = s;
		}
		s.spix = namelist.add(s.name);
	}
	
	public Symbol find(String symbolName, boolean createSymbol) {
		Integer spix = null;
		if ((spix = namelist.spixOf(symbolName)) != null) {
			Symbol l = locals;
			while (l != null) {
				if (l.spix == spix) {
					return l;
				} else {
					Symbol s = l.symbols;
					while (s != null) {
						if (s.spix == spix) {
							return s;
						} else {
							s = s.next;
						}
					}
					l = l.next;
				}
			}
			
			throw new IllegalArgumentException(); // key word/type name used as variable name.
		}

		Symbol s = null;
		if (outerScope == null) {
			if (createSymbol) {
			s = new Symbol();
			s.name = symbolName;
			s.type = Type.undefType;
			addSymbol(s);
			} else {
				return null;
			}
		} else {
			s = outerScope.find(symbolName, createSymbol);
		}
		
		return s;
	}

	public void closeScope() throws ParseException {
		Symbol l = locals;
		
		/* debug print */
		while (l != null) {
			System.out.println("--> Scope: closeScope() defined Symbol " + l);
			l = l.next;
		}
		
		l = locals;
		while (l != null) {
			if (l.type == Type.undefType) {
				throw new ParseException("Scope: closeScope(): undefined symbol " + l.name + "! FUUU!!!! leave me alone with your horseshit! (╯°□°）╯︵ ┻━┻");
			}
			l = l.next;
		}
	}
}
