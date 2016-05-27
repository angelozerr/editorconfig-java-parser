package fr.opensagres.editorconfig.parser;

public class SectionNotClosedException extends ParseException {

	public SectionNotClosedException(Location location) {
		super("Section not closed. Expected ']'", location, ErrorType.SectionNotClosed);
	}
}
