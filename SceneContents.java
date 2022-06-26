/**********************************************/
/*author:佐野　渉 6/18更新
/*C1:UI処理部所属
/*SceneContents:
/*画面作成に利用する基本機能をまとめたクラス
/**********************************************/
package application;

import java.util.HashMap;
import java.util.Map;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class SceneContents
{
	//シーン情報を格納するマップ
	static Map<String, Scene> sceneMap = new HashMap<String, Scene>();
	
	//--------------------------------------------------
	//Scene getSmap(String name)
	//シーンマップからシーンを取得するメソッド
	//sceneName:呼び出すシーンのマップキー
	//sceneMap.get(sceneName):マップキーに対応するシーン
	//--------------------------------------------------
	static Scene getSmap(String sceneName)
	{
		return sceneMap.get(sceneName);
	}
	
	//-------------------------------------------------------------
	//void createScene(SceneMain sceneMain)
	//システムのすべてのシーンを作成するメソッド
	//sceneMain:すべてのシーンのスーパークラスとなるSceneMainクラス
	//-------------------------------------------------------------
	static void createScene(SceneMain sceneMain)
	{
		SceneBasic initial = new SceneBasic(sceneMain.getStage());
		SceneBasic home = new SceneBasic(sceneMain.getStage());
		SceneBasic preference = new SceneBasic(sceneMain.getStage());
		SceneFeedback feedback = new SceneFeedback(sceneMain.getStage());
		SceneArea area = new SceneArea(sceneMain.getStage());
		SceneArea proposal = new SceneArea(sceneMain.getStage());
		SceneWeight weight = new SceneWeight(sceneMain.getStage());
		SceneSettingClothing addition = new SceneSettingClothing(sceneMain.getStage());
		SceneSettingClothing delete = new SceneSettingClothing(sceneMain.getStage());
		
		initial.createInitial();
		home.createHome();
		preference.createPreference();
		feedback.createFeedback();
		area.createArea();
		proposal.createClothing();
		weight.createWeight();
		addition.createAddition();
		delete.createDelete();
		
		sceneMap.put("initial", initial.getScene());
		sceneMap.put("home", home.getScene());
		sceneMap.put("preference", preference.getScene());
		sceneMap.put("feedback", feedback.getScene());
		sceneMap.put("area", area.getScene());
		sceneMap.put("clothing", proposal.getScene());
		sceneMap.put("weight", weight.getScene());
		sceneMap.put("addition", addition.getScene());
		sceneMap.put("delete", delete.getScene());
	}
	
	//----------------------------------------------------------------------
	//StackPane subTitle(String title)
	//各シーンの左上に表示するサブタイトルを作成するメソッド
	//sceneName:呼び出すシーンのマップキー
	//StackPane:サブタイトルのペイン
	//			サブペインとして他のペインに割り当てる
	//----------------------------------------------------------------------
	static StackPane subTitle(String title)
	{
		StackPane sp = new StackPane();
		Rectangle rect = new Rectangle(50, 50, 150, 30);
		Label lb = new Label(title);
		
		lb.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		
		rect.setFill(Color.LIGHTSKYBLUE);
		rect.setStroke(Color.BLACK);
		rect.setArcWidth(10);
		rect.setArcHeight(10);
		
		sp.getChildren().addAll(rect, lb);
		sp.setAlignment(Pos.CENTER);
		sp.setTranslateX(-120);
		return sp;
	}
	
	static double Lagrange(double x, double...pos)
	{
		double result = 0.0;
		return result;
 	}
}