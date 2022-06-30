/****************************************/ 
/*author:名久井　愛紗 6/28更新 
/*		 佐野　渉 6/30更新 
/*C5:服装提案部所属 
/*SceneProposal: 
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

class SceneProposal extends SceneMain
{
	Scene scene;
	List<Label> lbClothes;
	List<Label> lbWeather;
	
	//-------------------------------------------- 
	//SceneProposal(Stage stage)
	//スーパークラスからステージ情報を受け取る
	//stage:シーンの割り当てられたステージ
	//--------------------------------------------
	SceneProposal(Stage stage)
	{
		super(stage);
	}
	
	//-------------------------------------------- 
	//void createArea() 
	//W5地域入力画面作成
	//--------------------------------------------
	void createArea()
	{
		//オブジェクト作成
		BorderPane bp = new BorderPane();
		EventProposal event = new EventProposal(this);
		Label lb = new Label("お住まいの地域を入力してください");
		//リストビュー作成
		ListView<String> lv = new ListView<>();
		//ボタンリスト作成
		List<Button> bt = new ArrayList<Button>()
		{
			{
				add(new Button("キャンセル"));
				add(new Button("決定"));
			}
		};
		//リストビューに地域名を挿入
		ObservableList<String> items = FXCollections.observableArrayList
										(Constant.AREANAMES);
		
		lv.setItems(items);
		//フォント設定
		lb.setFont(Font.font
				(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		bt.get(0).setFont(Font.font
				(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		bt.get(1).setFont(Font.font
				(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		
		//ラベルとボタンをVBoxとHBoxに割り当てる
		//"服装提案"・"説明"ラベル
		VBox vbTop = new VBox();
		vbTop.setAlignment(Pos.CENTER);
		vbTop.setSpacing(10);
		vbTop.getChildren().addAll(SceneContents.subTitle("服装提案"), lb);
		
		//"キャンセル"・"決定"ボタン		
		HBox hbBottom = new HBox();
		hbBottom.setAlignment(Pos.CENTER);
		hbBottom.setPadding(new Insets(9, 9, 9, 9));
		hbBottom.setSpacing(171);
		hbBottom.getChildren().addAll(bt);
		//ペイン割り当て
		bp.setTop(vbTop); //"服装提案"・"説明"ラベル
		bp.setCenter(lv); //リストビュー
		bp.setBottom(hbBottom);//"キャンセル"・"決定"ボタン
		
		//ボタンにイベント割り当て
		event.transitionHome(bt.get(0)); //"キャンセル"ボタン
		event.transitionResult(bt.get(1), lv); //"決定"ボタン
		
		//シーンの作成処理
		scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
	}
	//-------------------------------------------- 
	//void createProposal() 
	//W6服装提案画面作成
	//--------------------------------------------
	void createProposal()
	{
		BorderPane bp = new BorderPane(); //ボーダーペイン作成
			
		//メッセージラベル作成
		Label title = new Label("提案された服装");
		Label date = new Label("〇月〇日の天候");
		
		//ラベルフォント設定
		title.setFont(Font.font
				(Constant.FONTFAMILY,Constant.FONTWEIGHT,25));
		date.setFont(Font.font
				(Constant.FONTFAMILY,Constant.FONTWEIGHT,25));
		
		title.setTranslateX(20);
		
		//リストラベル作成
		lbClothes = new ArrayList<Label>();
		lbWeather = new ArrayList<Label>();
		/*//提案された服装のラベルリスト作成
		List<Label> lbClothes = new DataProposal().getResult();
		
		for(int i = 0; i < lbClothes.size(); i++)
		{
			lbClothes.get(i).setFont(Font.font
						(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		}
		
		//天気情報を格納しラベルリスト作成
		String[] weatherData = new DataProposal().getWeather(EventProposal.areaname); 
		List<Label> lbWeather = new ArrayList<Label>()
		{
			{
				add(new Label(weatherData[0]));
				add(new Label(weatherData[1]));
				add(new Label(weatherData[2]));
			}
		};
		for(int i = 0; i < lbWeather.size(); i++)
		{
			lbWeather.get(i).setFont(Font.font
						(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		}*/
		
		//ラベルをVBoxとHBoxに割り当てる
		//"服装提案""提案された服装"ラベル
		VBox vbTop = new VBox();
		vbTop.setAlignment(Pos.CENTER_LEFT);
		vbTop.setSpacing(0);
		vbTop.setPadding(new Insets(0, 0, 0 ,0));
		vbTop.getChildren().addAll(SceneContents.subTitle("服装提案"), title);
		
		//提案された服装のラベル
		VBox vbCenter = new VBox();
		vbCenter.setAlignment(Pos.BASELINE_LEFT);
		vbCenter.getChildren().addAll(lbClothes);
		
		//天気情報のラベル
		HBox hbBottom = new HBox();
		hbBottom.setAlignment(Pos.CENTER_LEFT);
		hbBottom.getChildren().add(date);
		hbBottom.getChildren().addAll(lbWeather);
		
		//ペイン割り当て
		bp.setTop(vbTop); //"服装提案""提案された服装"ラベル
		bp.setCenter(vbCenter); //提案された服装のラベル
		bp.setBottom(hbBottom); //天気情報のラベル
		
		//シーンの作成
		scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
	}
	//-------------------------------------------- 
	//void getScene()
	//シーン情報を返すメソッド
	//画面遷移に利用する
	//scene:シーンのレイアウト情報
	//--------------------------------------------
	Scene getScene()
	{
		return scene;
	}	
	
}