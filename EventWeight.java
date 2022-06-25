/**********************************************/
/*author:金　東柱 6/25更新
/*C4:重み処理部所属
/*EventWeight:
/*重み設定画面のイベント処理を記述したクラス
/**********************************************/

package application;

import java.util.ArrayList;

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
	
	void weightSave(Button bt, TextField chtf1, TextField chtf2, 
							TextField chtf3, TextField chtf4, TextField chtf5)
	{
		bt.setOnAction((ActionEvent) ->
		{ 	
			ArrayList<Double> wdata = new ArrayList<>();
			wdata.add(Double.parseDouble(chtf1.getText()));
			wdata.add(Double.parseDouble(chtf2.getText()));
			wdata.add(Double.parseDouble(chtf3.getText()));
			wdata.add(Double.parseDouble(chtf4.getText()));
			wdata.add(Double.parseDouble(chtf5.getText()));
			
			System.out.println(wdata);
			UserData uData = new UserData();
			uData.weightWrite(wdata);
		});
	}

}