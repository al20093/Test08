/**********************************************/
/*author:西村　美玖 6/21更新
/*		 佐野　渉 6/28更新
/*C6:フィードバック処理部所属
/*EventFeedback:
/*Feedbackモードでのイベント処理を記述したクラス
/**********************************************/
package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;

//イベント処理クラス
class EventFeedback
{
	SceneFeedback feedback;
	
	Integer tempValue;
	List<Integer> radioValue = new ArrayList<Integer>(); //指数を格納する変数
	
	int counter; //何回目かのカウント変数
	
	EventFeedback(SceneFeedback feedback)
	{
		this.feedback = feedback;
	}
	
	void clickCancel(Button cancel)
	{
		cancel.setOnAction((ActionEvent) ->
		{ 
			new CreateAlert().confirm(Constant.CANCELMESSAGE);
			feedback.assignSceneToStage("home"); 
		}); //キャンセルボタンを押したらW4画面へ遷移
	}
	
	void clickRegister(Button register, int size, List<Label> labelList)
	{
		
		register.setOnAction((ActionEvent) ->
		{	
			if(tempValue == null)
			{
				new CreateAlert().failure(Constant.EMPTYRADIOERROR);
				return;
			} else {
				counter++;
				radioValue.add(tempValue);	
			}
				
			if(counter == size) 
			{
				labelList.get(counter - 2).setTextFill(Color.BLACK);
				DataFeedback df = new DataFeedback();
				df.writeUser(df.calculateFeedback(df.getWeight(radioValue)));
				new CreateAlert().complete(Constant.REGISTERMESSAGE); //登録完了アラート画面表示
				df.flagReset();
				feedback.assignSceneToStage("home");
			} else {
				labelList.get(counter - 1).setTextFill(Color.RED);
				if(1 < counter)
				{
					labelList.get(counter - 2).setTextFill(Color.BLACK);
				}
			}
			
		});
		
		
	}
	
	void clickRadio(RadioButton rb)
	{
		rb.setOnAction((ActionEvent) ->
		{
			tempValue = Integer.parseInt(rb.getText());			
		});
	}
}