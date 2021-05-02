package flarcher.javafx.gui;

/**
 * A mutable class that describes the application state.
 */
public enum AppState {

	INSTANCE;

	private String value = "";
  private boolean callLogic = true;

	//-- getters and setters

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

  public boolean doesCallLogic() {
    return callLogic;
  }

  public void setCallLogic(boolean callLogic) {
    this.callLogic = callLogic;
  }

}
