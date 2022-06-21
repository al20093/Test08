package application;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

//イベント処理クラス
class EventFeedback
{
	SceneFeedback_old feedback;
	int radioValue;
	int registerCount;
	
	EventFeedback(SceneFeedback_old feedback)
	{
		this.feedback = feedback;
	}
	
	void clickRegister(Button bt)
	{
		bt.setOnAction((ActionEvent) ->
		{
			System.out.println(radioValue);
			registerCount++;
			System.out.println(registerCount);
		});
	}
	
	void clickRadio(RadioButton rb)
	{
		rb.setOnAction((ActionEvent) ->
		{ 
				radioValue = Integer.parseInt(rb.getText());
		});
	}
}