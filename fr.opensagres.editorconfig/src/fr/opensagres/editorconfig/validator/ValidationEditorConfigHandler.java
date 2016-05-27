package fr.opensagres.editorconfig.validator;

import java.text.MessageFormat;

import fr.opensagres.editorconfig.EditorConfig;
import fr.opensagres.editorconfig.handlers.EditorConfigHandlerAdapter;
import fr.opensagres.editorconfig.model.ConfigPropertyException;
import fr.opensagres.editorconfig.parser.ErrorType;
import fr.opensagres.editorconfig.parser.Location;
import fr.opensagres.editorconfig.parser.ParseException;

public class ValidationEditorConfigHandler extends EditorConfigHandlerAdapter<Object, Object> {

	private static final String OPTION_NAME_NOT_EXISTS_MESSAGE = "The option ''{0}'' is not supported by .editorconfig";
	private static final String OPTION_VALUE_TYPE_MESSAGE = "The option ''{0}'' doesn't support the value ''{1}''";

	private final IReporter reporter;
	private final ISeverityProvider provider;

	public ValidationEditorConfigHandler(IReporter reporter, ISeverityProvider provider) {
		this.reporter = reporter;
		this.provider = provider != null ? provider : ISeverityProvider.DEFAULT;
	}

	@Override
	public void endPattern(Object section, String pattern, int i) {
		// TODO: validate pattern
	}

	@Override
	public void endOptionName(Object option, String name) {
		// Validate option name
		if (!EditorConfig.isOptionExists(name)) {
			Location location = getLocation();
			ErrorType errorType = ErrorType.OptionNameNotExists;
			reporter.addError(MessageFormat.format(OPTION_NAME_NOT_EXISTS_MESSAGE, name), location, null, errorType,
					provider.getSeverity(errorType));
		}
	}

	@Override
	public void endOptionValue(Object option, String value, String name) {
		// Validate value of the option name
		try {
			EditorConfig.validateOptionValue(name, value);
		} catch (ConfigPropertyException e) {
			Location location = getLocation();
			ErrorType errorType = ErrorType.OptionValueType;
			reporter.addError(e.getMessage(), location, null, errorType, provider.getSeverity(errorType));
		}
	}

	@Override
	public void error(ParseException e) {
		reporter.addError(e.getMessage(), e.getLocation(), null, e.getErrorType(), getSeverity(e));
	}

	protected Severity getSeverity(ParseException e) {
		return provider.getSeverity(e.getErrorType());
	}

}
