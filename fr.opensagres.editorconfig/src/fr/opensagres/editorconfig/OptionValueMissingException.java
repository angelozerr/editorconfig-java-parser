package fr.opensagres.editorconfig;

public class OptionValueMissingException extends ParseException {

	public OptionValueMissingException(String name, Location location) {
		super("None value defined for the option '" + name + "'. Expected a value", location);
	}
}
