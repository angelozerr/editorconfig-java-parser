package fr.opensagres.editorconfig;

public class SectionNotClosedException extends ParseException{

	public SectionNotClosedException(Location location) {
		super("Section not closed. Expected ']'", location);
	}
}
