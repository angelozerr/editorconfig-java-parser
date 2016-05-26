package fr.opensagres.editorconfig.tests;

import fr.opensagres.editorconfig.EditorConfigParser;
import fr.opensagres.editorconfig.handlers.LoggerEditorConfigHandler;

public class Simple {

	public static void main(String[] args) {
		String s = "\\s*\\[(([^#;]|\\\\#|\\\\;)+)]" + ".*";
		EditorConfigParser parser = new EditorConfigParser(new LoggerEditorConfigHandler());
		parser.parse("[*]");

	}
}
