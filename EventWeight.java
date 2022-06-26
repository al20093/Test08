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
	
	void weightCancel(Button bt)
	{
		bt.setOnAction((ActionEvent) ->
		{ weight.assignSceneToStage("preference"); });
	}
	
	void weightSave(Button bt, List<TextField> chtf)
	{
		bt.setOnAction((ActionEvent) ->
		{ 	
			ArrayList<Double> wdata = new ArrayList<>();
			for(int i = 0; i < chtf.size();++i)
			{
				wdata.add(Double.parseDouble(chtf.get(i).getText()));
			}
			
			System.out.println(wdata);
			UserData uData = new UserData();
			uData.weightWrite(wdata);
		});
	}

}