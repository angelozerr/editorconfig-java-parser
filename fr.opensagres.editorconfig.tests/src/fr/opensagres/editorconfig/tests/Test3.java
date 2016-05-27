package fr.opensagres.editorconfig.tests;

import java.io.InputStream;
import java.util.Scanner;

import fr.opensagres.editorconfig.handlers.LoggerEditorConfigHandler;
import fr.opensagres.editorconfig.parser.EditorConfigParser;

public class Test3 {

	public static void main(String[] args) {
		InputStream in = Test3.class.getResourceAsStream("editorconfig.txt");
		Scanner s = new Scanner(in).useDelimiter("\\A");
		String result = s.hasNext() ? s.next() : "";

		EditorConfigParser parser = new EditorConfigParser(new LoggerEditorConfigHandler());
		parser.parse(result);
	}
}
