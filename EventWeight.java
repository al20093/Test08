/**********************************************/
/*author:金　東柱 7/5更新
/*C4:重み処理部所属
/*EventWeight:
/*重み入力画面のイベント処理を記述したクラス
/**********************************************/

package application;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EventWeight
{
	SceneWeight weight;
	
	//------------------------------------------------ 
	//EventWeight(SceneWeight weight)
	//画面作成部のインスタンスを受け取るコンストラクタ
	//weight:画面作成部のインスタンス
	//------------------------------------------------	
	EventWeight(SceneWeight weight)
	{
		this.weight = weight;
	}
	
	//-------------------------------------------- 
	//void clickCancel(Button bt)
	//キャンセルを押した時に実行するイベント処理
	//bt:キャンセルボタン
	//--------------------------------------------
	void clickCancel(Button bt)
	{
		bt.setOnAction((ActionEvent) ->
		{ 
			boolean check = new CreateAlert().confirm(Constant.CANCELMESSAGE);
			if(check)
			{
				if(new DataWeight().getBoot())
				{
					weight.assignSceneToStage("preference");
				} else {
					weight.assignSceneToStage("gender");
				}
			}
		});
	}
	
	//---------------------------------------------------- 
	//void clickRegister(Button bt, List<TextField> chtf)
	//登録を押した時に実行するイベント処理
	//bt:登録ボタン
	//chtf:入力されたデータのリスト
	//----------------------------------------------------
	void clickRegister(Button bt, List<TextField> chtf)
	{
		bt.setOnAction((ActionEvent) ->
		{ 	
			List<Double> wdata = new ArrayList<Double>(); //データを渡す時使うList<Double>を生成
			int checkdata = 0;   //正しく入力されたデータの個数をチェック
			for(int i = 0; i < chtf.size(); ++i)
			{
				boolean output = true; //入力さてたデータがdouble型なのか判断用のboolean
				String input = chtf.get(i).getText();  //TextFieldの内容をStringで受け取るinput
				if(input == null || input.trim().isEmpty())   // inputが空の場合の処理
				{
					new CreateAlert().failure("1から11までの数字を半角で入力してください。");
					weight.assignSceneToStage("weight");
					break;
				} else {
					try //入力されたデータが数字かないかを判別
					{
						Double.parseDouble(input);
						output = true; //数字の場合trueを返す
					} catch(NumberFormatException e) {
						output = false;
					}
					if(output == true) //入力されたデータが数字の場合の処理
					{
						
						double k = Double.parseDouble(chtf.get(i).getText());
						//入力された数字が1から11の範囲だったらListのwdataに値を入れる
						if(k >= 1 && k < 10)
						{	
							if(input.length() <= 4) //入力された数字が小数点第2位までかを判別
							{
								wdata.add(k);
								checkdata++;
							} else {
								new CreateAlert().failure("小数点第2位まで入力してください。");
								weight.assignSceneToStage("weight");
								break;
							}
						} else if(k >= 10 && k <= 11) {
							if(input.length() <= 5) 
							{
								wdata.add(k);
								checkdata++;
							} else {
								new CreateAlert().failure("小数点第2位まで入力してください。");
								weight.assignSceneToStage("weight");
								break;
							}
						} else {
							new CreateAlert().failure("1から11までの数字を半角で入力してください。");
							weight.assignSceneToStage("weight");
							break;
						}
						
					} else {
						new CreateAlert().failure("1から11までの数字を半角で入力してください。");
						weight.assignSceneToStage("weight");
						break;
					}
				}
			}
			if(checkdata == 5) //正しく入力されたデータが5つの場合に以下を実行する
			{
				new DataWeight().weightSave(wdata);
				new CreateAlert().complete(Constant.REGISTERMESSAGE);
				if(new DataWeight().getBoot())
				{
					weight.assignSceneToStage("preference");
				} else {
					weight.assignSceneToStage("home");
					new DataWeight().onBoot();
				}
			}
		});
	}
}