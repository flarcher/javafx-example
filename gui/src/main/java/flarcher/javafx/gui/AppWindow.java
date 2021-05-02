package flarcher.javafx.gui;

import flarcher.javafx.core.BusinessClass;
import flarcher.javafx.gui.scene.InfoScene;
import flarcher.javafx.gui.scene.SceneDefinition;
import flarcher.javafx.gui.scene.FormScene;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class AppWindow extends Application {

	/**
	 * Needed in order to avoid a RuntimeException
	 */
	public static void main(String[] args) {
		launch();
	}

	private final AppState state = AppState.INSTANCE;

	private final BusinessClass businessLogic = new BusinessClass();

	private Stage stage;

	private void goToScene(SceneDefinition newScene) {
		Objects.requireNonNull(stage);
		stage.setScene(newScene.getScene(state));
		stage.show();
	}

	private SceneDefinition getInfoScene() {
    String text = state.doesCallLogic()
        ? String.format("The value in uppercase is: '%s'",
						businessLogic.toUppercase(state.getValue()))
        : String.format("The value unchanged is: '%s'",
						state.getValue());
		return new InfoScene(Platform::exit, text);
	}

  @Override
  public void start(Stage stage) {
		this.stage = stage;
		Scene teamNamesScene = new FormScene(() -> {
        goToScene(getInfoScene());
      }).getScene(state);
		stage.setScene(teamNamesScene);
		stage.show();
  }

}