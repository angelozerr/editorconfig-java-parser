package fr.opensagres.editorconfig;

/**
 * An unchecked exception to indicate that an input does not qualify as valid
 * .editorconfig.
 */
@SuppressWarnings("serial") // use default serial UID
public class ParseException extends RuntimeException {

	private final Location location;

	ParseException(String message, Location location) {
		super(message + " at " + location);
		this.location = location;
	}

	/**
	 * Returns the location at which the error occurred.
	 *
	 * @return the error location
	 */
	public Location getLocation() {
		return location;
	}

}