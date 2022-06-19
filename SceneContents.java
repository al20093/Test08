/**********************************************/
/*author:佐野　渉 6/18更新
/*C1:UI処理部所属
/*SceneContents:
/*画面作成に利用する基本機能をまとめたクラス
/**********************************************/
package application;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.Scene;

public class SceneContents
{
	//シーンマップ
	static Map<String, Scene> sceneMap = new HashMap<String, Scene>();
	
	SceneContents()
	{
	}
	
	static Scene getSmap(String name)
	{
		return sceneMap.get(name);
	}
	
	static void createScene(SceneMain sceneMain) {
		SceneBasic initial = new SceneBasic(sceneMain.getStage());
		SceneBasic home = new SceneBasic(sceneMain.getStage());
		SceneFeedback feedback = new SceneFeedback(sceneMain.getStage());
		SceneArea area = new SceneArea(sceneMain.getStage());
		
		initial.createInitial();
		home.createHome();
		feedback.createFeedback();
		area.createArea();
		sceneMap.put("initial", initial.getScene());
		sceneMap.put("home", home.getScene());
		sceneMap.put("feedback", feedback.getScene());
		sceneMap.put("area", area.getScene());
	}
}