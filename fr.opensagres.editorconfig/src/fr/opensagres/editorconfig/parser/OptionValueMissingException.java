package fr.opensagres.editorconfig.parser;

public class OptionValueMissingException extends ParseException {

	public OptionValueMissingException(String name, Location location) {
		super("None value defined for the option '" + name + "'. Expected a value", location,
				ErrorType.OptionValueMissing);
	}
}
