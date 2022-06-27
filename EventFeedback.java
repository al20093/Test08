/**********************************************/
/*author:西村　美玖 6/21更新
/*C6:フィードバック処理部所属
/*EventFeedback:
/*Feedbackモードでのイベント処理を記述したクラス
/**********************************************/
package application;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

//イベント処理クラス
class EventFeedback
{
	SceneFeedback feedback;
	
	double radioValue; //指数を格納する変数
	
	int counter; //何回目かのカウント変数
	
	EventFeedback(SceneFeedback feedback)
	{
		this.feedback = feedback;
	}
	
	void clickCancel(Button cancel)
	{
		cancel.setOnAction((ActionEvent) ->
		{ feedback.assignSceneToStage("preference"); }); //キャンセルボタンを押したらW10画面へ遷移
	}
	
	void clickRegister(Button register, int size)
	{
		
		register.setOnAction((ActionEvent) ->
		{
			Clothes clothes = new Clothes();
			
			System.out.println(radioValue);
			clothes.index = radioValue; //フィードバック指数はclothesリストの服装指数に格納?ラグランジュ関数に渡す別の変数?
			counter++;
			if(counter == size) 
			{
				new CreateAlert().complete("登録が完了しました。"); //登録完了アラート画面表示
			}
			
		});
		
		
	}
	
	void clickRadio(RadioButton rb)
	{
		rb.setOnAction((ActionEvent) ->
		{
			radioValue = Double.parseDouble(rb.getText());
		});
	}
}