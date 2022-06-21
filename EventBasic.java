
/****************************************/ 
/*author:名久井愛紗 6/19更新 
/*C2:基本画面処理部所属 
/*EventBasic: 
/*GUI表示に必要な基礎的な処理を記述する
/****************************************/

package application;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class EventBasic {
	SceneBasic basic;
	
	EventBasic(SceneBasic basic)
	{
		this.basic = basic;
	}
	
	void clickWindow()
	{
		basic.getScene().addEventHandler(MouseEvent.MOUSE_CLICKED, 
			(MouseEvent) -> { basic.assignSceneToStage("home"); });
	}
	
	void transitionPreference(Button bt)
	{
		bt.setOnAction((ActionEvent) ->
			{ basic.assignSceneToStage("preference"); });
	}
	
	void transitionClothing(Button bt)
	{ 
		bt.setOnAction((ActionEvent) ->
			/*{
				boolean check = new CreateAlert().confirm("処理完了しました。");
				if(check == true)
				{
					System.out.println("true");
				} else {
					System.out.println("false");
				}
			});*/
		{ basic.assignSceneToStage("area"); });
	}
	
	void transitionFeedback(Button bt)
	{
		bt.setOnAction((ActionEvent) ->
			{ basic.assignSceneToStage("feedback"); });
	}
	
	void transitionGender(Button bt)
	{
		bt.setOnAction((ActionEvent) ->
			{ basic.assignSceneToStage("gender"); });
	}
	
	void transitionWeight(Button bt)
	{
		bt.setOnAction((ActionEvent) ->
			{ basic.assignSceneToStage("weight"); });
	}
	
	void transitionAddition(Button bt)
	{
		bt.setOnAction((ActionEvent) ->
			{ basic.assignSceneToStage("addition"); });
	}
	
	void transitionHome(Button bt)
	{
		bt.setOnAction((ActionEvent) ->
			{ basic.assignSceneToStage("home"); });
	}
}
