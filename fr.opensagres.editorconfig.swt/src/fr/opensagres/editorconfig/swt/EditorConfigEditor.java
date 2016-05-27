package fr.opensagres.editorconfig.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import fr.opensagres.editorconfig.EditorConfig;
import fr.opensagres.editorconfig.parser.ErrorType;
import fr.opensagres.editorconfig.parser.Location;
import fr.opensagres.editorconfig.validator.IReporter;
import fr.opensagres.editorconfig.validator.Severity;

public class EditorConfigEditor {

	public static void main(String[] args) {

		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(500, 500);
		shell.setText("EditorConfig Editor");
		shell.setLayout(new GridLayout());

		final Text editor = new Text(shell, SWT.MULTI | SWT.BORDER);
		editor.setLayoutData(new GridData(GridData.FILL_BOTH));

		final Table errors = new Table(shell, SWT.BORDER | SWT.MULTI);
		errors.setLayoutData(new GridData(GridData.FILL_BOTH));

		final IReporter reporter = new IReporter() {

			@Override
			public void addError(String message, Location start, Location end, ErrorType type, Severity severity) {
				TableItem item = new TableItem(errors, SWT.NONE);
				item.setText(message);
			}
		};
		editor.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent event) {
				errors.removeAll();
				EditorConfig.validate(editor.getText(), reporter);
			}
		});

		editor.setText("[*");

		shell.open();
		editor.setFocus();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
}
