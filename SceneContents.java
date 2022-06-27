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
		SceneGender gender = new SceneGender(sceneMain.getStage());	
		gender.createGender();
		sceneMap.put("gender", gender.getScene());
	
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
	
	//-------------------------------------------- 
	//static double Lagrange(double x, double...pos)
	//ラグランジュ補完を行う 
	//x:ラグランジュの補間公式に代入する値 pos:通る点のx座標とy座標を交互に入れる 
	//--------------------------------------------
	static double Lagrange(double x, double...pos)
	{
		double sum = 0; //求めた値を足していく変数
        for (int i = 1; i < pos.length/2; i+= 2) {
            double y = pos[i]; //y座標
            for (int j = 0; j <= pos.length/2; j+= 2) {
                if ( (j + 1) != i)
                    y *= (x - pos[j]) / (pos[i - 1] - pos[j]);
            }
            sum += y;
        }
	return sum;
	}
}