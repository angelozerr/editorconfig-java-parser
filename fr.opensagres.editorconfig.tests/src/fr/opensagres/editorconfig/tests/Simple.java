package fr.opensagres.editorconfig.tests;

import fr.opensagres.editorconfig.handlers.LoggerEditorConfigHandler;
import fr.opensagres.editorconfig.parser.EditorConfigParser;

public class Simple {

	public static void main(String[] args) {
		String s = "\\s*\\[(([^#;]|\\\\#|\\\\;)+)]" + ".*";
		EditorConfigParser parser = new EditorConfigParser(new LoggerEditorConfigHandler());
		parser.parse("[*]");

	}
}
