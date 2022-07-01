/**********************************************/
/*author:西村　美玖 6/29更新
/* 		 佐野　渉 7/1更新
/*C6:フィードバック処理部所属
/*SceneFeedback:
/*Feedbackモードの際に表示する画面を作成したクラス
/**********************************************/
package application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

class SceneFeedback extends SceneMain 
{
	Scene scene; //フィールド
	static BorderPane bpFeedback;
	
	//-------------------------------------------- 
	//SceneFeedback(Stage stage)
	//スーパークラスからステージ情報を受け取る
	//stage:シーンの割り当てられたステージ
	//--------------------------------------------
	SceneFeedback(Stage stage)
	{
		super(stage);
	}
	
	//-------------------------------------------- 
	//void createFeedback()
	//フィードバックモードでの画面配置を行う
	//--------------------------------------------
	void createFeedback()
	{
		bpFeedback = new BorderPane();
		
		//ラベル作成処理
		Label title = new Label("提案された服装を段階的に評価します");
		
		title.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		
		//上部コントロール
		VBox vbTop = new VBox();
		vbTop.setAlignment(Pos.CENTER);
		vbTop.setSpacing(10);
		vbTop.getChildren().addAll(SceneContents.subTitle("フィードバック"), title);
		
		//ペイン割り当て
		bpFeedback.setTop(vbTop);
		
		//シーンの作成処理
		this.scene = new Scene(bpFeedback, Constant.WIDTH, Constant.HEIGHT);
	}
	//-------------------------------------------- 
	//void getScene()
	//シーン情報を返すメソッド
	//画面遷移に利用する
	//scene:シーンのレイアウト情報
	//--------------------------------------------
	Scene getScene() 
	{
		return this.scene;
	}
	
	//-------------------------------------------- 
	//void assignPane()
	//提案する服装と日付のラベルを
	//ペインに反映する
	//--------------------------------------------
	void assignPane()
	{
		//rbの中で選択が1つのみになる処理
		ToggleGroup tg = new ToggleGroup();
		//イベントオブジェクトの作成
		EventFeedback event = new EventFeedback(this);
		Button cancel = new Button("キャンセル"); //キャンセルボタン"cancel"
		
		cancel.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		
		//ラジオボタンを11個作成する処理
		List<RadioButton> rb = new ArrayList<RadioButton>()
		{
			{
				for(int i = 1; i <= 11; i++)
				{
					add(new RadioButton(Integer.toString(i)));
				}
			}
		};
		for(int i=0; i<rb.size(); ++i) 
		{
			rb.get(i).setToggleGroup(tg);
		}
		Label day = new Label(new SimpleDateFormat("MM月dd日").
				format(new Date()) + "の評価"); //日付表示ラベル"day"
		
		Label cold = new Label("←寒い"); //寒いラベル"cold"
		Label appropriate = new Label("適切"); //適切ラベル"appropriate"
		Label hot = new Label("暑い→"); //暑いラベル"hot"
		
		Button register = new Button("登録"); //登録ボタン"register"
		
		day.setTranslateX(-100);
		
		day.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,15));
		register.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		cold.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		appropriate.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		hot.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		
		//中部コントロール
		HBox hbRb = new HBox(); //rbを水平に並べたかたまり"hb_rb"
		hbRb.getChildren().addAll(rb);
		hbRb.setAlignment(Pos.CENTER);
		
		HBox hbThermometer = new HBox(); //cold,appropraite, hotの3つのラベルを水平に並べたかたまり"hb_thermometer"
		hbThermometer.getChildren().addAll(cold, appropriate, hot);
		hbThermometer.setSpacing(100);	
		hbThermometer.setAlignment(Pos.CENTER);
		
		//服装ラベル作成
		List<Clothes> clothes = new DataFeedback().getList();
		//Labelに提案された服装名称を追加する処理
		List<Label> label = new ArrayList<Label>()
		{
			{
				for(int i = 0; i < clothes.size(); i++)
				{
					//Labelに服装名称を追加する
					add(new Label("・" + clothes.get(i).name));
					
				}
			}
		};
		
		//ラベルのフォント設定処理
		for(int i = 0; i < label.size(); ++i)
		{
			label.get(i).setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,18));
		}
		VBox vbClothing = new VBox(); //服装名称を垂直に塊にしたグループ"clothing"
		vbClothing.getChildren().addAll(label);
		vbClothing.setSpacing(10);
		vbClothing.setAlignment(Pos.CENTER);
		vbClothing.setTranslateX(-100);
		
		VBox vbCenter = new VBox(); //日付、服装、服装指数、メータを垂直に1つにまとめた真ん中に配置するグループ
		vbCenter.setAlignment(Pos.CENTER);
		vbCenter.getChildren().addAll(day, vbClothing, hbRb, hbThermometer);
		vbCenter.setSpacing(20);
		
		//下部コントロール
		HBox hbButton = new HBox(); //registerとcancelを水平に並べたかたまり"hb_button"
		hbButton.setAlignment(Pos.CENTER);
		hbButton.getChildren().addAll(cancel, register);
		hbButton.setPadding(new Insets(9, 9, 9, 9));
		hbButton.setSpacing(171); //cancelとregisterの距離
		
		bpFeedback.setCenter(vbCenter);
		bpFeedback.setBottom(hbButton);
		
		//イベント割り当て
		event.clickRegister(register, label);
		for(int i = 0; i < rb.size(); i++ )
		{
			event.clickRadio(rb.get(i));
		}
		event.clickCancel(cancel);
	}
}