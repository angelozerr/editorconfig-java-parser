package fr.opensagres.editorconfig;

public class MultiPatternNotClosedException extends ParseException{

	public MultiPatternNotClosedException(Location location) {
		super("Multi pattern not closed. Expected ',' or '}'", location);
	}
}