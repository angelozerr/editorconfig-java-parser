/*
 * Copyright 2014 Nathan Jones
 *
 * This file is part of "EditorConfig Eclipse".
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.opensagres.editorconfig.model;

import java.util.HashMap;
import java.util.Map;

public abstract class ConfigPropertyType<T> implements Comparable<ConfigPropertyType<T>> {

	public static class Root extends ConfigPropertyType<Boolean> {
		@Override
		public String getId() {
			return "ROOT";
		}

		@Override
		public String getName() {
			return "root";
		}

		@Override
		public String getDisplayLabel() {
			return "root";
		}

		@Override
		public ValueParser<Boolean> getValueParser() {
			return ValueParser.BOOLEAN_VALUE_PARSER;
		}

		@Override
		public ValueRenderer getValueRenderer() {
			return ValueRenderer.BOOLEAN_VALUE_RENDERER;
		}

		@Override
		public ValueValidator<Boolean> getValueValidator() {
			return ValueValidator.BOOLEAN_VALUE_VALIDATOR;
		}

		@Override
		public void accept(final ConfigPropertyVisitor visitor, final ConfigProperty<Boolean> property) {
		}

	}

	public static class IndentStyle extends ConfigPropertyType<IndentStyleOption> {

		@Override
		public String getId() {
			return "INDENT_STYLE";
		}

		@Override
		public String getName() {
			return "indent_style";
		}

		@Override
		public String getDisplayLabel() {
			return "Indent Style";
		}

		@Override
		public ValueParser<IndentStyleOption> getValueParser() {
			return new EnumValueParser<IndentStyleOption>(IndentStyleOption.class);
		}

		@Override
		public ValueRenderer getValueRenderer() {
			return ValueRenderer.DISPLAYABLE_VALUE_RENDERER;
		}

		@Override
		public ValueValidator<IndentStyleOption> getValueValidator() {
			return new EnumValueValidator<IndentStyleOption>(IndentStyleOption.class);
		}

		@Override
		public void accept(final ConfigPropertyVisitor visitor, final ConfigProperty<IndentStyleOption> property) {
			visitor.visitIndentStyle(property);
		}
	}

	public static class IndentSize extends ConfigPropertyType<Integer> {
		@Override
		public String getId() {
			return "INDENT_SIZE";
		}

		@Override
		public String getName() {
			return "indent_size";
		}

		@Override
		public String getDisplayLabel() {
			return "Indent Size";
		}

		@Override
		public ValueParser<Integer> getValueParser() {
			return ValueParser.POSITIVE_INT_VALUE_PARSER;
		}

		@Override
		public ValueValidator<Integer> getValueValidator() {
			return ValueValidator.POSITIVE_INT_VALUE_VALIDATOR;
		}

		@Override
		public void accept(final ConfigPropertyVisitor visitor, final ConfigProperty<Integer> property) {
			visitor.visitIndentSize(property);
		}
	}

	public static class TabWidth extends ConfigPropertyType<Integer> {
		@Override
		public String getId() {
			return "TAB_WIDTH";
		}

		@Override
		public String getName() {
			return "tab_width";
		}

		@Override
		public String getDisplayLabel() {
			return "Tab Width";
		}

		@Override
		public ValueParser<Integer> getValueParser() {
			return ValueParser.POSITIVE_INT_VALUE_PARSER;
		}

		@Override
		public ValueValidator<Integer> getValueValidator() {
			return ValueValidator.POSITIVE_INT_VALUE_VALIDATOR;
		}

		@Override
		public void accept(final ConfigPropertyVisitor visitor, final ConfigProperty<Integer> property) {
			visitor.visitTabWidth(property);
		}

	}

	public static class EndOfLine extends ConfigPropertyType<EndOfLineOption> {
		@Override
		public String getId() {
			return "END_OF_LINE";
		}

		@Override
		public String getName() {
			return "end_of_line";
		}

		@Override
		public String getDisplayLabel() {
			return "End of Line";
		}

		@Override
		public ValueParser<EndOfLineOption> getValueParser() {
			return new EnumValueParser<EndOfLineOption>(EndOfLineOption.class);
		}

		@Override
		public ValueRenderer getValueRenderer() {
			return ValueRenderer.DISPLAYABLE_VALUE_RENDERER;
		}

		@Override
		public ValueValidator<EndOfLineOption> getValueValidator() {
			return new EnumValueValidator<EndOfLineOption>(EndOfLineOption.class);
		}

		@Override
		public void accept(final ConfigPropertyVisitor visitor, final ConfigProperty<EndOfLineOption> property) {
			visitor.visitEndOfLine(property);
		}

	}

	public static class Charset extends ConfigPropertyType<String> {
		@Override
		public String getId() {
			return "CHARSET";
		}

		@Override
		public String getName() {
			return "charset";
		}

		@Override
		public String getDisplayLabel() {
			return "Charset";
		}

		@Override
		public ValueParser<String> getValueParser() {
			return ValueParser.IDENTITY_VALUE_PARSER;
		}

		@Override
		public ValueValidator<String> getValueValidator() {
			return ValueValidator.IDENTITY_VALUE_VALIDATOR;
		}

		@Override
		public void accept(final ConfigPropertyVisitor visitor, final ConfigProperty<String> property) {
			visitor.visitCharset(property);
		}

	}

	public static class TrimTrailingWhitespace extends ConfigPropertyType<Boolean> {
		@Override
		public String getId() {
			return "TRIM_TRAILING_WHITESPACE";
		}

		@Override
		public String getName() {
			return "trim_trailing_whitespace";
		}

		@Override
		public String getDisplayLabel() {
			return "Trim Trailing Whitespace";
		}

		@Override
		public ValueParser<Boolean> getValueParser() {
			return ValueParser.BOOLEAN_VALUE_PARSER;
		}

		@Override
		public ValueRenderer getValueRenderer() {
			return ValueRenderer.BOOLEAN_VALUE_RENDERER;
		}

		@Override
		public ValueValidator<Boolean> getValueValidator() {
			return ValueValidator.BOOLEAN_VALUE_VALIDATOR;
		}

		@Override
		public void accept(final ConfigPropertyVisitor visitor, final ConfigProperty<Boolean> property) {
			visitor.visitTrimTrailingWhitespace(property);
		}
	}

	public static class InsertFinalNewline extends ConfigPropertyType<Boolean> {
		@Override
		public String getId() {
			return "INSERT_FINAL_NEWLINE";
		}

		@Override
		public String getName() {
			return "insert_final_newline";
		}

		@Override
		public String getDisplayLabel() {
			return "Insert Final Newline";
		}

		@Override
		public ValueParser<Boolean> getValueParser() {
			return ValueParser.BOOLEAN_VALUE_PARSER;
		}

		@Override
		public ValueRenderer getValueRenderer() {
			return ValueRenderer.BOOLEAN_VALUE_RENDERER;
		}

		@Override
		public ValueValidator<Boolean> getValueValidator() {
			return ValueValidator.BOOLEAN_VALUE_VALIDATOR;
		}

		@Override
		public void accept(final ConfigPropertyVisitor visitor, final ConfigProperty<Boolean> property) {
			visitor.visitInsertFinalNewLine(property);
		}

	}

	public static final Root ROOT = new Root();
	public static final IndentStyle INDENT_STYLE = new IndentStyle();
	public static final IndentSize INDENT_SIZE = new IndentSize();
	public static final TabWidth TAB_WIDTH = new TabWidth();
	public static final EndOfLine END_OF_LINE = new EndOfLine();
	public static final Charset CHARSET = new Charset();
	public static final TrimTrailingWhitespace TRIM_TRAILING_WHITESPACE = new TrimTrailingWhitespace();
	public static final InsertFinalNewline INSERT_FINAL_NEWLINE = new InsertFinalNewline();

	private static final ConfigPropertyType<?>[] ALL_TYPES = { ROOT, INDENT_STYLE, INDENT_SIZE, TAB_WIDTH, END_OF_LINE,
			CHARSET, TRIM_TRAILING_WHITESPACE, INSERT_FINAL_NEWLINE };
	private static final Map<String, ConfigPropertyType<?>> ALL_TYPES_MAP = new HashMap<String, ConfigPropertyType<?>>();
	private static final Map<String, Integer> ALL_TYPES_INDICES = new HashMap<String, Integer>();
	static {
		int index = 0;
		for (final ConfigPropertyType<?> type : ALL_TYPES) {
			ALL_TYPES_MAP.put(type.getId(), type);
			ALL_TYPES_INDICES.put(type.getId(), index);
			index += 1;
		}
	}

	public static ConfigPropertyType<?> valueOf(final String name) {
		return ALL_TYPES_MAP.get(name);
	}

	private ConfigPropertyType() {
	}

	public abstract String getId();

	public abstract String getName();

	public abstract String getDisplayLabel();

	public abstract ValueParser<T> getValueParser();

	public abstract ValueValidator<T> getValueValidator();

	public abstract void accept(ConfigPropertyVisitor visitor, ConfigProperty<T> property);

	public void validate(String value) throws ConfigPropertyException {
		getValueValidator().validate(getName(), value);
	}

	public ValueRenderer getValueRenderer() {
		return ValueRenderer.TO_STRING_VALUE_RENDERER;
	}

	public ConfigProperty<T> createConfigProperty(final String value) {
		final T parsedValue = getValueParser().parse(value);
		if (parsedValue == null) {
			return null;
		}
		return new ConfigProperty<T>(this, parsedValue);
	}

	public String getDisplayValue(final ConfigProperty<T> configProperty) {
		return getValueRenderer().renderValue(configProperty.getValue());
	}

	private Integer getIndex() {
		return ALL_TYPES_INDICES.get(getId());
	}

	@Override
	public int compareTo(final ConfigPropertyType<T> o) {
		return getIndex().compareTo(o.getIndex());
	}

	@Override
	public String toString() {
		return getName();
	}

}
