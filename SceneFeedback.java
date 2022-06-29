/**********************************************/
/*author:西村　美玖 6/21更新
/* 		 佐野　渉 6/28更新
 *       西村　美玖 6/29更新
 */
/*C6:フィードバック処理部所属
/*SceneFeedback:
/*Feedbackモードの際に表示する画面を作成したクラス
/**********************************************/
package application;

import java.util.ArrayList;
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
	
	//-------------------------------------------- 
	//SceneProposal(Stage stage)
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
	//引数なし
	//--------------------------------------------
	void createFeedback()
	{
		BorderPane bp = new BorderPane();
		
		ToggleGroup tg = new ToggleGroup(); //rbの中で選択が1つのみになる処理のための変数tg
		
		//イベントオブジェクトの作成
		EventFeedback event = new EventFeedback(this);
		
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
		
		//rbの中で選択が1つのみになる処理
		for(int i = 0; i < rb.size(); ++i) 
		{
			rb.get(i).setToggleGroup(tg);
			//rb.get(i).setOnAction(new FeedbackEventHandler());
		}
		
		//ラベル作成処理
		Label title = new Label("提案された服装を段階的に評価します"); //上部メッセージラベル"title"
		Label day = new Label("〇月〇日の評価"); //日付表示ラベル"day"
		
		Label cold = new Label("←寒い"); //寒いラベル"cold"
		Label appropriate = new Label("適切"); //適切ラベル"appropriate"
		Label hot = new Label("暑い→"); //暑いラベル"hot"
		
		Button register = new Button("登録"); //登録ボタン"register"
		Button cancel = new Button("キャンセル"); //キャンセルボタン"cancel"
		
		day.setTranslateX(-100);
		
		//ラベルのフォント設定処理
		title.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		day.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,15));
		register.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		cancel.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		cold.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		appropriate.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		hot.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		
		//ラベル作成
		//List<Clothes> clothes = new DataFeedback().getList();
		
		//ダミーデータここから
		List<Clothes> clothes = new ArrayList<Clothes>();
		clothes.add(new Clothes(1, "上着A", "上着", "上半身", 12.3));
		clothes.add(new Clothes(1, "上着A", "上着", "上半身", 12.3));
		clothes.add(new Clothes(1, "上着A", "上着", "上半身", 12.3));
		clothes.add(new Clothes(1, "上着A", "上着", "上半身", 12.3));
		clothes.add(new Clothes(1, "上着A", "上着", "上半身", 12.3));
		new UserData().createCList(clothes);
		//ダミーデータここまで　
		
		//Labelに提案された服装名称を追加する処理
		List<Label> label = new ArrayList<Label>()
		{
			{
				for(int i = 0; i < clothes.size(); i++)
				{
					add(new Label("・" + clothes.get(i).name));  
					
				}
			}
		};
		
		//ラベルのフォント設定処理
		for(int i = 0; i < label.size(); ++i)
		{
			label.get(i).setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,18));
		}
		
		//配置コントロール処理
		VBox vbTop = new VBox(); //"subTitle"と"title"を上部で垂直に並べた塊"vbTop"
		vbTop.setAlignment(Pos.CENTER);
		vbTop.setSpacing(10);
		vbTop.getChildren().addAll(SceneContents.subTitle("フィードバック"), title);
			
		VBox vbClothing = new VBox(); //服装名称ラベル"label"を垂直に並べた塊"vbClothing"
		vbClothing.getChildren().addAll(label);
		vbClothing.setSpacing(10);
		vbClothing.setAlignment(Pos.CENTER);
		vbClothing.setTranslateX(-100);
		
		HBox hbRb = new HBox(); //rbを水平に並べたかたまり"hbRb"
		hbRb.getChildren().addAll(rb);
		hbRb.setAlignment(Pos.CENTER);
		
		HBox hbThermometer = new HBox(); //cold,appropraite, hotのラベルを水平に並べた塊"hbThermometer"
		hbThermometer.getChildren().addAll(cold, appropriate, hot);
		hbThermometer.setSpacing(100);	
		hbThermometer.setAlignment(Pos.CENTER);
		
		VBox vbCenter = new VBox(); //"day", "vbClothing" "hbRb", "hbThermometer"を中央で垂直に並べた塊"vbCenter"
		vbCenter.setAlignment(Pos.CENTER);
		vbCenter.getChildren().addAll(day, vbClothing, hbRb, hbThermometer);
		vbCenter.setSpacing(20);
		
		HBox hbButton = new HBox(); //registerとcancelを水平に並べた塊"hbButton"
		hbButton.setAlignment(Pos.CENTER);
		hbButton.getChildren().addAll(cancel, register);
		hbButton.setPadding(new Insets(9, 9, 9, 9));
		hbButton.setSpacing(171); 
		
		//ペイン割り当て処理
		bp.setTop(vbTop);
		bp.setCenter(vbCenter); 
		bp.setBottom(hbButton);
		
		//イベント割り当て処理
		int size = 5; //ラベルの数を示す"size"
		event.clickRegister(register, (size + 1), label);
		for(int i = 0; i < rb.size(); i++ )
		{
			event.clickRadio(rb.get(i));
		}
		event.clickCancel(cancel);
		
		//シーンの作成処理
		this.scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
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
}