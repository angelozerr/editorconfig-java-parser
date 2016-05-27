package fr.opensagres.editorconfig.parser;

public class MultiPatternNotClosedException extends ParseException {

	public MultiPatternNotClosedException(Location location) {
		super("Multi pattern not closed. Expected ',' or '}'", location, ErrorType.MultiPatternNotClosed);
	}
}
