
/****************************************/ 
/*author:名久井愛紗 6/28更新 
/*C5:服装提案部所属 
/*SceneArea: 
/*服装提案部での画面作成処理を記述する
/****************************************/

package application;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

class SceneArea extends SceneMain
{
	Scene scene;
	//public String areaname;
	
	//コンストラクタ生成
	SceneArea(Stage stage)
	{
		super(stage);
	}
	
	//-------------------------------------------- 
	//void createArea() 
	////W5地域入力画面作成
	//--------------------------------------------
	void createArea()
	{
		BorderPane bp = new BorderPane(); //ボーダーペイン作成
		EventArea event = new EventArea(this); //イベントオブジェクト作成
		
		//ラベルリスト作成
		List<Label> lb = new ArrayList<Label>();
		List<Label> lb2 = new ArrayList<Label>();
		lb.add(new Label("服装提案"));
		lb.add(new Label("お住まいの地域を入力してください"));
		for(int i = 0; i < 2; i++)
		{
			lb.get(i).setFont(Font.font
					(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		}
		
		lb2.add(new Label("地域:"));
		for(int i = 0; i < 1; i++)
		{
			lb2.get(i).setFont(Font.font
					(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		}
		
		/*
		ComboBox names = new ComboBox();
		names.getItems().addAll(
				"札幌", "釧路", "仙台", "新潟", "東京", 
				"金沢", "名古屋", "大阪", "広島", "高知",
				"福岡", "鹿児島", "那覇");
		names.setPrefSize(180,40);
		names.setValue("地域");
		*/
		
		ListView<String> lv = new ListView<>(); //リストビュー作成
		//リストビューに地域名を挿入
		ObservableList<String> items = FXCollections.observableArrayList(
				"札幌", "釧路", "仙台", "新潟", "東京", "金沢", "名古屋",
				"大阪", "広島", "高知","福岡", "鹿児島", "那覇");
		lv.setItems(items);
		//areaname = lv.getSelectionModel().getSelectedItem();;
		
		//ボタンリスト作成
		List<Button> bt = new ArrayList<Button>();
		bt.add(new Button("服装提案開始"));
		for(int i = 0; i < bt.size(); i++) 
		{
			bt.get(i).setFont(Font.font
					(Constant.FONTFAMILY,Constant.FONTWEIGHT,25));
		}
		
		List<Button> bt2 = new ArrayList<Button>();
		bt2.add(new Button("キャンセル"));
		for(int i = 0; i < bt2.size(); i++)
		{
			bt2.get(i).setFont(Font.font
					(Constant.FONTFAMILY,Constant.FONTWEIGHT,25));
		}
		
		//ラベルとボタンをVBoxとHBoxに割り当てる
		//"服装提案"ラベル
		VBox vb = new VBox();
		vb.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(lb);
		
		//"地域:"ラベル,リストビュー
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.getChildren().addAll(lb2);
		//hb.getChildren().addAll(names);
		hb.getChildren().addAll(lv);
		
		//"服装提案開始"ボタン
		VBox vb2 = new VBox();
		vb2.setAlignment(Pos.BOTTOM_RIGHT);
		vb2.setPadding(new Insets(10, 10, 10, 10));
		vb2.setSpacing(30);
		vb2.getChildren().addAll(bt);
		
		//"キャンセル"ボタン		
		VBox vb3 = new VBox();
		vb3.setAlignment(Pos.BOTTOM_LEFT);
		vb3.setPadding(new Insets(10, 10, 10, 10));
		vb3.setSpacing(30);
		vb3.getChildren().addAll(bt2);
		
		//ペイン割り当て
		bp.setTop(vb); //"服装提案"ラベル
		bp.setRight(vb2); //"地域:"ラベル,リストビュー
		bp.setLeft(vb3); //"服装提案開始"ボタン
		bp.setCenter(hb); //"キャンセル"ボタン
		
		//ボタンにイベント割り当て
		event.transitionResult(bt.get(0), lv); //"服装提案開始"ボタン
		event.transitionHome(bt2.get(0)); //"キャンセル"ボタン
		
		//シーンの作成
		scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
	}
	
	//-------------------------------------------- 
	//void createClothing() 
	////W6服装提案画面作成
	//--------------------------------------------
	void createClothing()
	{
		 BorderPane bp = new BorderPane(); //ボーダーペイン作成
		
		 //ラベルリスト作成
		List<Label> lb = new ArrayList<Label>();
		lb.add(new Label("服装提案"));
		lb.add(new Label("提案された服装"));
		for(int i = 0; i < 2; i++)
		{
			lb.get(i).setFont(Font.font
						(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		}
		
		//提案された服装のラベルリスト作成
		List<Label> lb2 = new DataClothing().getResult();
		for(int i = 0; i < lb2.size(); i++)
		{
			lb2.get(i).setFont(Font.font
						(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		}
		
		//天気情報を格納しラベルリスト作成
		String[] st = new DataClothing().getWeather(EventArea.areaname); 
		List<Label> lb3 = new ArrayList<Label>()
		{
			{
				add(new Label(st[0]));
				add(new Label(st[1]));
				add(new Label(st[2]));
			}
		};
		for(int i = 0; i < lb3.size(); i++)
		{
			lb3.get(i).setFont(Font.font
						(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		}
		
		//ラベルをVBoxとHBoxに割り当てる
		//"服装提案""提案された服装"ラベル
		VBox vb = new VBox();
		vb.setAlignment(Pos.BASELINE_LEFT);
		vb.getChildren().addAll(lb);
		
		//提案された服装のラベル
		VBox vb2 = new VBox();
		vb2.setAlignment(Pos.BASELINE_LEFT);
		vb2.getChildren().addAll(lb2);
		
		//天気情報のラベル
		HBox hb = new HBox();
		hb.setAlignment(Pos.BASELINE_LEFT);
		hb.getChildren().addAll(lb3);
		
		//ペイン割り当て
		bp.setTop(vb); //"服装提案""提案された服装"ラベル
		bp.setCenter(vb2); //提案された服装のラベル
		bp.setBottom(hb); //天気情報のラベル
		
		//シーンの作成
		scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
			
	}

	//画面生成
	Scene getScene()
	{
		return scene;
	}	
	
}
