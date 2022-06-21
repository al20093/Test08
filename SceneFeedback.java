/**********************************************/
/*author:西村　美玖 6/21更新
/*C6:フィードバック処理部所属
/*SceneFeedback:
/*Feedbackモードの際に表示する画面を作成したクラス
/**********************************************/
package application;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class SceneFeedback extends SceneMain 
{
	Scene scene;
	
	SceneFeedback(Stage stage)
	{
		super(stage);
	}
	
	void createFeedback()
	{
		BorderPane bp = new BorderPane();
		//イベントオブジェクトの作成
		EventFeedback event = new EventFeedback(this);
		
		
		//List<RadioButton> rb = CreateRadioList("1","2","3","4","5","6","7","8","9","10","11"); //服装指数の選択式ラジオボタン"rb"
		List<RadioButton> rb = new ArrayList<RadioButton>()
		{
			{
				for(int i=1; i<=11; i++)
				{
					add(new RadioButton(Integer.toString(i)));
				}
			}
		};
		
		ToggleGroup tg = new ToggleGroup(); //rbの中で選択が1つのみになる処理
		for(int i=0; i<rb.size(); ++i) {
			rb.get(i).setToggleGroup(tg);
			//rb.get(i).setOnAction(new FeedbackEventHandler());
		}
		
		HBox hb_rb = new HBox(); //rbを水平に並べたかたまり"hb_rb"
		hb_rb.getChildren().addAll(rb);
		
		
		Label cold = new Label("←寒い"); //寒いラベル"cold"
		Label appropriate = new Label("適切"); //適切ラベル"appropriate"
		Label hot = new Label("暑い→"); //暑いラベル"hot"
		
		HBox hb_thermometer = new HBox(); //cold,appropraite, hotの3つのラベルを水平に並べたかたまり"hb_thermometer"
		hb_thermometer.getChildren().addAll(cold, appropriate, hot);
		hb_thermometer.setSpacing(100);
		
		
		Label day = new Label("\n\n\n\n〇月〇日の評価"); //日付表示ラベル"day"
		
		
		Label hat = new Label("帽子"); //帽子ラベル"hat"
		Label hand = new Label("手袋"); //手袋ラベル"hand"
		Label outerwear = new Label("上着"); //上着ラベル"outerwear"
		Label pants = new Label("ズボン"); //ズボンラベル"pants"
		Label socks = new Label("靴下"); //靴下ラベル"socks"
		
		
		
		VBox vb_clothing = new VBox(); //帽子、手袋、上着、ズボン、靴下を垂直に塊にしたグループ"clothing"
		vb_clothing.getChildren().addAll(hat, hand, outerwear, pants, socks);
		vb_clothing.setSpacing(20);
		
		
		VBox vb_center = new VBox(); //日付、服装、服装指数、メータを垂直に1つにまとめた真ん中に配置するグループ
		vb_center.getChildren().addAll(day, vb_clothing, hb_rb, hb_thermometer);
		vb_center.setSpacing(20);
		
		
		
		Button register = new Button("登録"); //登録ボタン"register"
		register.setPrefSize(100, 20); //ボタンサイズ
		Button cancel = new Button("キャンセル"); //キャンセルボタン"cancel"
		cancel.setPrefSize(100, 20); //ボタンサイズ
		
		HBox hb_button = new HBox(); //registerとcancelを水平に並べたかたまり"hb_button"
		hb_button.getChildren().addAll(cancel, register);
		hb_button.setSpacing(100); //cancelとregisterの距離
		
		vb_center.setAlignment(Pos.CENTER);
		hb_button.setAlignment(Pos.CENTER);
		
		bp.setTop(vb_center); //ペイン割り当て
		bp.setBottom(hb_button);
		
		//イベント割り当て
		int size = 5; //ラベルの数だけ
		event.clickRegister(register, size+1);
		for(int i = 0; i < rb.size(); i++ )
		{
			event.clickRadio(rb.get(i));
		}
		
		//シーンの作成
		this.scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
	}
	
	Scene getScene() 
	{
		return this.scene;
	}
}