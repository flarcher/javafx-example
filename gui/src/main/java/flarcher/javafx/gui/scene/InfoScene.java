package flarcher.javafx.gui.scene;

import flarcher.javafx.gui.AppState;
import flarcher.javafx.gui.NodeFactory;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class InfoScene implements SceneDefinition {

	public InfoScene(Runnable next, String label) {
		this.next = next;
		this.label = label;
	}

	private final Runnable next;
	private final String label;

	@Override
	public Scene getScene(AppState state) {
		GridPane pane = NodeFactory.createGrid(1);
		pane.addRow(0, NodeFactory.createText(label));
		pane.addRow(1, NodeFactory.createButton("OK", e -> next.run()));
		return new Scene(pane/*, 320, 200*/);
	}
}
