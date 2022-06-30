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
	//フィードバック結果を格納する変数
	List<Integer> radioValue = new ArrayList<Integer>();
	
	int counter; //何回目かをカウントする変数"counter"
	
	
	//-------------------------------------------- 
	//EventFeedback(SceneFeedback feedback)
	//画面作成部のインスタンスを受け取るコンストラクタ
	//feedback:画面作成部のインスタンス
	//--------------------------------------------
	EventFeedback(SceneFeedback feedback)
	{
		this.feedback = feedback;
	}
	
	//-------------------------------------------- 
	//void clickCancel(Button cancel)
	//キャンセルを押した時に実行するイベント処理
	//cancel:キャンセルボタン
	//--------------------------------------------
	void clickCancel(Button cancel)
	{
		cancel.setOnAction((ActionEvent) ->
		{ 
			new CreateAlert().confirm(Constant.CANCELMESSAGE);
			feedback.assignSceneToStage("home"); 
		}); //キャンセルボタンを押したらW4画面へ遷移
	}
	
	//-------------------------------------------- 
	//void clickRegister(Button register, int size,
	//					 List<Label> labelList)
	//登録を押した時に実行するイベント処理
	//register:登録ボタン
	//size:提案された服装の数
	//labelList:服装名称
	//--------------------------------------------
	void clickRegister(Button register, int size, List<Label> labelList)
	{
		
		register.setOnAction((ActionEvent) ->
		{	
			//ラジオボタンが選択されていないとき
			if(tempValue == null)
			{
				new CreateAlert().failure(Constant.EMPTYRADIOERROR);
				return;
			} else {
				counter++; //カウンターを1進める
				radioValue.add(tempValue); //ラジオボタンの値を保存
			}
				
			if(counter == size)  //提案された服装分評価した場合
			{
				labelList.get(counter - 2).setTextFill(Color.BLACK);
				DataFeedback df = new DataFeedback();
				df.writeUser(df.calculateFeedback(df.getWeight(radioValue)));
				//登録完了アラート画面表示
				new CreateAlert().complete(Constant.REGISTERMESSAGE);
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
	
	//-------------------------------------------- 
	//void clickRadio(RadioButton rb)
	//ラジオボタンが選択された時に実行するイベント処理
	//rb:ラジオボタン
	//--------------------------------------------
	void clickRadio(RadioButton rb)
	{
		rb.setOnAction((ActionEvent) ->
		{
			//選択されているラジオボタンの値をtempValueに保管
			tempValue = Integer.parseInt(rb.getText());			
		});
	}
}