package at.fhv.just.grammar.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import at.fhv.just.grammar.JustParser;
import at.fhv.just.grammar.ParseException;
import at.fhv.just.grammar.semantic.Scope;
import at.fhv.just.grammar.semantic.SymbolTable;

public class TestSuite {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File testFile = null;
		JustParser parser = null;
		InputStream stream = null;
		File testFolder = new File("test");
		
		try {
			File[] files = testFolder.listFiles();
			
			for(int i = 0; i < files.length; i++) {
				System.out.println("Test case " + (i+1) + ":");
				if(files[i].isFile()) {
					testFile = files[i].getAbsoluteFile();
					stream = new FileInputStream(testFile);
				}
				if (parser == null) {
					parser = new JustParser(stream);
				}
				JustParser.ReInit(stream);
				JustParser.Start().dump("");
				System.out.println("-> ok :)\n");
				SymbolTable.curScope = new Scope();
			}
		 } catch(SecurityException e) {
		 	System.out.println("Cant get the list of files: ");
		 	System.out.println(e.getMessage());
		 } catch(IOException e) {
		 	System.out.println(e.getMessage());
		 } catch (ParseException e) {
			System.out.println(e.getMessage());
		 }
	}
}
