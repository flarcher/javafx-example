package flarcher.javafx.gui.scene;

import flarcher.javafx.gui.AppState;
import javafx.scene.Scene;

/**
 * Defines a GUI scene/screen.
 */
public interface SceneDefinition {

	Scene getScene(AppState state);

}
