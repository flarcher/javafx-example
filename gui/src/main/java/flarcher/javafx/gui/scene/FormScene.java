package flarcher.javafx.gui.scene;

import flarcher.javafx.gui.AppState;
import flarcher.javafx.gui.NodeFactory;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.*;

public class FormScene extends AbstractMainScene {

	public FormScene(Runnable next) {
		super(2);
		this.next = next;
	}

	private final Runnable next;
	private final TextField valueField = new TextField();
	private final ToggleGroup logicChoice = new ToggleGroup();

	@Override
	protected void buildScene(AppState state) {

    valueField.setText(state.getValue());
    addRow(HPos.CENTER,
			NodeFactory.createLabel("Your text:", valueField),
			valueField);

		RadioButton transformChoice = new RadioButton();
		transformChoice.setToggleGroup(logicChoice);
		transformChoice.setSelected(state.doesCallLogic());
		transformChoice.setAlignment(Pos.CENTER);
		addRow(HPos.CENTER,
			NodeFactory.createText("To uppercase:"),
			transformChoice);

		RadioButton noChangeChoice = new RadioButton();
		noChangeChoice.setToggleGroup(logicChoice);
		noChangeChoice.setSelected(! state.doesCallLogic());
		noChangeChoice.setAlignment(Pos.CENTER);
		addRow(HPos.CENTER,
			NodeFactory.createText("No change:"),
			noChangeChoice);

		Button button = NodeFactory.createButton("Go!", e -> {
				state.setValue(valueField.getText());
				state.setCallLogic(logicChoice.getSelectedToggle() == transformChoice);
				next.run();
			}  );
		addNode(button, getRowIndex(), 1, 1, 2, HPos.RIGHT);
	}


}
