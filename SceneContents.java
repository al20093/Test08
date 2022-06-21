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
	static Map<String, Scene> scene_map = new HashMap<String, Scene>();
	
	SceneContents()
	{
	}
	
	static Scene getSmap(String name)
	{
		return scene_map.get(name);
	}
	
	static void createScene(SceneMain sceneMain) {
		SceneBasic initial = new SceneBasic(sceneMain.getStage());
		SceneBasic home = new SceneBasic(sceneMain.getStage());
		SceneBasic preference = new SceneBasic(sceneMain.getStage());		
		SceneFeedback feedback = new SceneFeedback(sceneMain.getStage());
		SceneArea area = new SceneArea(sceneMain.getStage());
		SceneArea clothing = new SceneArea(sceneMain.getStage());
		
		
		initial.createInitial();
		home.createHome();
		feedback.createFeedback();
		area.createArea();
		clothing.createClothing();
		preference.createPreference();
		scene_map.put("initial", initial.getScene());
		scene_map.put("home", home.getScene());
		scene_map.put("feedback", feedback.getScene());
		scene_map.put("area", area.getScene());
		scene_map.put("clothing", clothing.getScene());
		scene_map.put("preference", preference.getScene());
	}
}