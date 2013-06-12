package at.fhv.just.grammar.semantic;


public class Type {

	public enum Kind {
		undefKind,
		voidKind,
		booleanKind, 
		intKind,
		fieldKind
	};
	
	public Type(String name, Kind type) {
		spix = SymbolTable.curScope.namelist.add(name);
		kind = type;
	}
	
	public Kind kind;
	public int spix;
	public static Type undefType = new Type("undef", Kind.undefKind);
	public static Type voidType = new Type("void", Kind.voidKind);
	public static Type intType = new Type("int", Kind.intKind);
	public static Type booleanType = new Type("boolean", Kind.booleanKind);

}
