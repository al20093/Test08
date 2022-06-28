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
			List<Integer> wdata = new ArrayList<Integer>();
			for(int i = 0; i < chtf.size();++i)
			{
				wdata.add(Integer.parseInt(chtf.get(i).getText()));
			}
			new DataWeight().weightSave(wdata);
			new CreateAlert().complete("重みの登録が完了しました。");
			weight.assignSceneToStage("preference");
		});
	}
}