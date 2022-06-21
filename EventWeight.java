package application;

import javafx.scene.control.Button;

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
		{ weight.assignSceneToStage("home"); });
	}
	

}