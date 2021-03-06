package fr.opensagres.editorconfig.handlers;

import fr.opensagres.editorconfig.parser.EditorConfigParser;
import fr.opensagres.editorconfig.parser.Location;

public abstract class AbstractEditorConfigHandler<S, O> implements IEditorConfigHandler<S, O> {

	private EditorConfigParser parser;

	@Override
	public void setParser(EditorConfigParser parser) {
		this.parser = parser;
	}

	/**
	 * Returns the current parser location.
	 *
	 * @return the current parser location
	 */
	protected Location getLocation() {
		return parser.getLocation();
	}

}
