# EditorConfig Java Parser

Provide a Java `EditorConfig Parser` which is able to parse `.editorconfig` content and throws syntax error (with location) for section, option.

This parser is useful for instance to validate the content of a IDE `.editorconfig` editor to mark errors inside the editor. 

# Usage

```java
EditorConfigParser parser = new EditorConfigParser();
parser.parse("[*");
```

throws the exception (with location line, column and offset) where errors occur:

```
Exception in thread "main" fr.opensagres.editorconfig.SectionNotClosedException: Section not closed. Expected ']' at 1:3 (2)
```