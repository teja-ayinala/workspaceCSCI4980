package handler;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import model.MyPerson;
import model.MyPersonModelProvider;

public class ExportSelectedRowHandler {
	@Inject
	private ESelectionService selectionService;
	String file = "/Users/krishnatejaayinala/Desktop/output/output-midterm-1011-KrishnaTeja-Ayinala.csv";

	@Execute
	public void execute(EPartService epartService, Shell shell) throws IOException {
		export();
		MessageDialog.openInformation(shell, "Info", "Saved: " + file);
	}

	private void export() throws IOException {
		FileWriter fileWriter = new FileWriter(file);
		PrintWriter printWriter = new PrintWriter(fileWriter);

		for (MyPerson person : MyPersonModelProvider.INSTANCE.getPersons()) {

			printWriter.print("\"" + person.getFirstName() + "\"," + person.getLastName() + "\"," + person.getPhn()
					+ "\"," + person.getAddress() + "\n");
		}
		printWriter.close();
		System.out.println("Saved a file:" + file);

	}

}