package fr.opensagres.editorconfig.tests;

import org.junit.Assert;
import org.junit.Test;

import fr.opensagres.editorconfig.EditorConfigParser;
import fr.opensagres.editorconfig.ParseException;
import fr.opensagres.editorconfig.SectionNotClosedException;
import fr.opensagres.editorconfig.handlers.LoggerEditorConfigHandler;

public class Test2 {

	@Test
	public void sectionNotClosed() {
		ParseException e = parse("[");
		Assert.assertNotNull(e);
		Assert.assertTrue(e instanceof SectionNotClosedException);
		Assert.assertEquals(1, e.getLocation().line);
		Assert.assertEquals(2, e.getLocation().column);
	}

	@Test
	public void sectionWithPatternNotClosed() {
		ParseException e = parse("[*");
		Assert.assertNotNull(e);
		Assert.assertTrue(e instanceof SectionNotClosedException);
		Assert.assertEquals(1, e.getLocation().line);
		Assert.assertEquals(3, e.getLocation().column);
	}

	@Test
	public void sectionWithMultiPatternNotClosed() {
		ParseException e = parse("[{a,b}");
		Assert.assertNotNull(e);
		Assert.assertTrue(e instanceof SectionNotClosedException);
		Assert.assertEquals(1, e.getLocation().line);
		Assert.assertEquals(7, e.getLocation().column);
	}

	// @Test
	// public void sectionNotOpened() {
	// ParseException e = parse("]");
	// Assert.assertNotNull(e);
	// Assert.assertEquals(1, e.getLocation().line);
	// Assert.assertEquals(1, e.getLocation().column);
	// }

	@Test
	public void sectionEmpty() {
		ParseException e = parse("[]");
		Assert.assertNull(e);
	}

	@Test
	public void sectionWithStar() {
		ParseException e = parse("[*]");
		Assert.assertNull(e);
	}

	@Test
	public void sectionWithStarAndDot() {
		ParseException e = parse("[*.md]");
		Assert.assertNull(e);
	}

	@Test
	public void sectionWithComma() {
		ParseException e = parse("[*.md,*.txt]");
		Assert.assertNull(e);
	}

	@Test
	public void sectionMultiPatternNotClosed() {
		ParseException e = parse("[{*.md,*.txt]");
		Assert.assertNotNull(e);
	}

	@Test
	public void sectionMultiPattern() {
		ParseException e = parse("[{*.md,*.txt}]");
		Assert.assertNull(e);
	}

	private ParseException parse(String content) {
		System.err.println("--------->.editorconfig=" + content);
		EditorConfigParser parser = new EditorConfigParser(new LoggerEditorConfigHandler());
		try {
			parser.parse(content);
			return null;
		} catch (ParseException e) {
			return e;
		}
	}
}
