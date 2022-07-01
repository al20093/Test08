/**********************************************/
/*author:佐野　渉 6/28更新
/*C2:基本画面処理部所属
/*EventBasic:
/*初期画面・ホーム画面・設定選択画面のイベント
/*処理を行うクラス
/**********************************************/
package application;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

class EventBasic {
	SceneBasic basic;
	
	EventBasic(SceneBasic basic)
	{
		this.basic = basic;
	}
	
	void clickWindow()
	{
		basic.getScene().addEventHandler(MouseEvent.MOUSE_CLICKED, 
			(MouseEvent) -> { basic.assignSceneToStage("gender"); });
	}
	
	void transitionPreference(Button bt)
	{
		bt.setOnAction((ActionEvent) ->
			{ basic.assignSceneToStage("preference"); });
	}
	
	void transitionClothing(Button bt)
	{ 
		bt.setOnAction((ActionEvent) ->
		{ basic.assignSceneToStage("area"); });
	}
	
	void transitionFeedback(Button bt)
	{
		bt.setOnAction((ActionEvent) ->
			{ 
				if(new UserData().flagRead())
				{
					//ペイン割り当て
					new SceneFeedback(basic.getStage()).assignPane();
					basic.assignSceneToStage("feedback");
				} else {
					new CreateAlert().complete(Constant.FLAGMESSAGE);
				}
			});
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
