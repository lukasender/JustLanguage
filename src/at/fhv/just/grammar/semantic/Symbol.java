package at.fhv.just.grammar.semantic;


public class Symbol {

	public enum Kind {
		undefKind,
		constKind,
		varKind,
		parKind,
		funcKind
	};
	
	public String name;
	public int spix; 			//Spelling index for name list, index of symbol in current stack
	public Kind kind;
	
	public Type type; 			//data type
	
	public boolean init; 		//is init? for vars only
	public int val; 			//for constants and initialized vars only
	public int addr; 			//for globals, params, consts and local vars
	
	//for functions only
	public boolean defined; 	//is func already defined
	public Symbol symbols; 		//params and loc vars
	
	public int level; 			//scope level
	public Symbol next; 		//linear list of symbols within a scope

	@Override
	public String toString() {
		return String.format("{%s type:%s kind:%s init:%s val:%d spix:%d}", name, type.name, kind, init, val, spix);
	}
}
