package at.fhv.just.grammar.semantic;

import java.util.ArrayList;
import java.util.HashMap;

public class Namelist {
	// name -> spix
	private HashMap<String, Integer> _nameIndices;
	// spix -> name
	private ArrayList<String> _names;
	
	public Namelist() {
		_nameIndices = new HashMap<String, Integer>();
		_names = new ArrayList<String>();
	}
	
	public int add(String name) {
		if (_nameIndices.containsKey(name)) {
			throw new IllegalArgumentException();
		}
		
		_names.add(name);
		int spix = _names.size() - 1;
		_nameIndices.put(name, spix);
		return spix;
	}
	
	public String nameOf(int spix) {
		try {
			return _names.get(spix);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public Integer spixOf(String name) {
		return _nameIndices.get(name);
	}
}
