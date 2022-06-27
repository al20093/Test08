/****************************************/ 
/*author:名久井愛紗 6/19更新 
/*C5:服装提案部所属 
/*EventArea: 
/*服装提案部でのイベント処理を記述する
/****************************************/

package application;

import javafx.scene.control.Button;

public class EventArea {
SceneArea area;
	
	EventArea(SceneArea area)
	{
		this.area = area;
	}
	
	void transitionResult(Button bt)
	{
		bt.setOnAction((ActionEvent) ->
			{ area.assignSceneToStage("clothing"); });
	}
	
	void transitionHome(Button bt)
	{
		bt.setOnAction((ActionEvent) ->
			{ area.assignSceneToStage("home"); });
	}
}