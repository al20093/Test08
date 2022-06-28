/**********************************************/
/*author:金　東柱 6/25更新
/*C4:重み処理部所属
/*EventWeight:
/*重み設定画面のイベント処理を記述したクラス
/**********************************************/

package application;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

//イベント処理クラス
public class EventWeight
{
	SceneWeight weight;
	
	EventWeight(SceneWeight weight)
	{
		this.weight = weight;
	}
	
	void clickCancel(Button bt)
	{
		bt.setOnAction((ActionEvent) ->
		{ 
			new CreateAlert().confirm(Constant.CANCELMESSAGE);
			weight.assignSceneToStage("preference"); 
		});
	}
	
	void clickRegister(Button bt, List<TextField> chtf)
	{
		bt.setOnAction((ActionEvent) ->
		{ 	
			List<Double> wdata = new ArrayList<Double>();
			int checkdata = 0;   //正しく入力されたデータの個数をチェック
			for(int i = 0; i < chtf.size();++i)
			{
				boolean output = true;
				String input = chtf.get(i).getText();  //inputにTextFieldの内容を入力
				if(input == null || input.trim().isEmpty())   // inputが空の場合の処理
				{
					new CreateAlert().failure("1から11までの数字を半角で入力してください。");
					weight.assignSceneToStage("weight");
					break;
				}else{
					//入力されたデータが数字かないかを判別
					try 
					{
						Double.parseDouble(input);
						output = true;
					} catch(NumberFormatException e) {
						output = false;
					}
					//入力されたinputが数字の場合、outputの値がtrueのため以下の処理を行う
					if(output == true)
					{
						if(input.length() <= 3)
						{
							double k = Double.parseDouble(chtf.get(i).getText());
							//入力された数字が1から11の範囲だったらListのwdataに値を入れる
							if(k >= 1 && k <= 11)
							{
								wdata.add(k);
								checkdata++;
							} else {
								new CreateAlert().failure("1から11までの数字を半角で入力してください。");
								weight.assignSceneToStage("weight");
								break;
							}
						} else {
							new CreateAlert().failure("3文字以内で入力してください。");
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
			if(checkdata == 5) //正しく入力されたデータが5つの場合に以下を実行する。
			{
				new DataWeight().weightSave(wdata);
				new CreateAlert().complete("重みの登録が完了しました。");
				weight.assignSceneToStage("preference");
			}
		});
	}
}