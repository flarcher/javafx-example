package flarcher.javafx.gui.scene;

import flarcher.javafx.gui.AppState;
import flarcher.javafx.gui.NodeFactory;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * Common frame for a scene.
 */
abstract class AbstractMainScene implements SceneDefinition {

	private static final int SCENE_WIDTH = 600;
	private static final int SCENE_HEIGHT = 300;

	public AbstractMainScene(int columnCount) {
		this.columnCount = columnCount;
		this.grid = NodeFactory.createGrid(columnCount);
	}

	private final GridPane grid;
	private int rowIndex = 0;
	private final int columnCount;

	protected final void addRow(HPos pos, Node... nodes) {
		assert nodes.length <= columnCount;
		int colIndex = 0;
		for (Node node : nodes) {
			addNode(node, rowIndex, colIndex++, 1, 1, pos);
		}
		rowIndex++;
	}

	protected final void addNode(Node node, int rowNumber, int colNumber, int rowSpan, int colSpan, HPos pos) {
		GridPane.setFillWidth(node, true);
		GridPane.setHalignment(node, pos);
		grid.add(node, colNumber, rowNumber, colSpan, rowSpan);
	}

	protected final int getRowIndex() { return rowIndex; }
	protected final int newRow() { return  ++rowIndex; }

	protected abstract void buildScene(AppState state);

	@Override
	public final Scene getScene(AppState state) {
		Text headerLabel = NodeFactory.createHeaderLabel();
		addNode(headerLabel, getRowIndex(), 0, 1, columnCount, HPos.LEFT);
		newRow();

		buildScene(state);
		newRow();

		Text footerLabel = NodeFactory.createFooterLabel();
		addNode(footerLabel, getRowIndex(), 0, 1, columnCount, HPos.RIGHT);
		newRow();

		return new Scene(grid, SCENE_WIDTH, SCENE_HEIGHT);
	}
}
