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
	
	static void Lagrange(double x, double...pos)
	{
		
	}
}