package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;

//イベント処理クラス
class EventFeedback
{
	SceneFeedback feedback;
	
	EventFeedback(SceneFeedback feedback)
	{
		this.feedback = feedback;
	}
	
	
	public void handle(ActionEvent e) {
		RadioButton tmp = (RadioButton) e.getSource();
		int res = Integer.parseInt(tmp.getText());
	}
}