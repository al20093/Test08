/****************************************/ 
/*author:名久井　愛紗 6/28更新 
/*		 佐野　渉 7/01更新 
/*C5:服装提案部所属 
/*SceneProposal: 
/*服装提案部での画面作成処理を記述する
/****************************************/

package application;

import java.util.Date;
import java.text.SimpleDateFormat;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

class SceneProposal extends SceneMain
{
	Scene scene;
	static BorderPane bpProposal;
	static List<Label> lbClothes;
	static List<Label> lbWeather;
	
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
		event.clickCancel(bt.get(0)); //"キャンセル"ボタン
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
		//イベントオブジェクト作成
		EventProposal event = new EventProposal(this);
		//ボーダーペイン作成
		bpProposal = new BorderPane();
			
		//メッセージラベル作成
		Label title = new Label("提案された服装");
		
		//ラベルフォント設定
		title.setFont(Font.font
				(Constant.FONTFAMILY,Constant.FONTWEIGHT,25));
		
		title.setTranslateX(20);
		
		//リストラベル作成
		lbClothes = new ArrayList<Label>();
		lbWeather = new ArrayList<Label>();

		//ラベルをVBoxとHBoxに割り当てる
		//"服装提案""提案された服装"ラベル
		VBox vbTop = new VBox();
		vbTop.setAlignment(Pos.CENTER_LEFT);
		vbTop.setSpacing(0);
		vbTop.setPadding(new Insets(0, 0, 0 ,0));
		vbTop.getChildren().addAll(SceneContents.subTitle("服装提案"), title);
		
		//ペイン割り当て
		bpProposal.setTop(vbTop); //"服装提案""提案された服装"ラベル
		
		//シーンの作成
		scene = new Scene(bpProposal, Constant.WIDTH, Constant.HEIGHT);
		
		//イベント割り当て
		event.clickWindow();
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
	
	//-------------------------------------------- 
	//void assignPane()
	//提案する服装と天候情報のラベルを
	//ペインに反映する
	//--------------------------------------------
	void assignPane()
	{
		//日付情報取得
		String strDate = new SimpleDateFormat("MM月dd日").format(new Date());	
		
		//天気情報ラベルを作成
		Label date = new Label(strDate + "の天候");
		date.setFont(Font.font
				(Constant.FONTFAMILY,Constant.FONTWEIGHT,25));
		
		//提案された服装のラベル
		VBox vbCenter = new VBox();
		vbCenter.setAlignment(Pos.BASELINE_LEFT);
		vbCenter.getChildren().addAll(lbClothes);
		vbCenter.setTranslateX(20);
		
		//天気情報のラベル
		GridPane gpWeather = new GridPane();
		gpWeather.setPadding(new Insets(10, 10, 10, 10));
		gpWeather.setVgap(5);
		gpWeather.setHgap(70);
		gpWeather.setAlignment(Pos.CENTER);
		
		//グリッドペインに天気情報ラベルを割り当てる
		for(int i = 0; i < lbWeather.size(); ++i)
		{
			gpWeather.add(lbWeather.get(i), i % (lbWeather.size() / 2), i / (lbWeather.size() / 2));
		}
		
		//画面下部のラベル
		VBox vbBottom = new VBox();
		vbBottom.setAlignment(Pos.CENTER_LEFT);
		vbBottom.getChildren().add(date);
		vbBottom.getChildren().addAll(gpWeather);
		date.setTranslateX(20);
		
		bpProposal.setCenter(vbCenter); //提案された服装のラベル
		bpProposal.setBottom(vbBottom); //天気情報のラベル
	}
	
	//-------------------------------------------- 
	//void setClothes(List<Clothes> clothes)
	//ラベルリストに提案する服装の名称を追加する
	//clothes:追加する服装のリスト
	//--------------------------------------------
	void setClothes(List<Clothes> clothes)
	{
		//ラベルリストにラベル追加
		for(int i = 0; i < clothes.size(); ++i)
		{
			lbClothes.add(new Label("・" + clothes.get(i).name));
			//フォント設定
			lbClothes.get(i).setFont(Font.font
					(Constant.FONTFAMILY,Constant.FONTWEIGHT,25));;
		}
	}
	
	//-------------------------------------------- 
	//void setWeather(String[] weatherData)
	//ラベルリストに天気情報を追加する
	//weatherData:天気情報を格納した配列
	//--------------------------------------------
	void setWeather(String[] weatherData)
	{
		//ラベルリストにラベル追加
		lbWeather.add(new Label("平均気温"));
		lbWeather.add(new Label("湿度"));
		lbWeather.add(new Label("天気"));
		lbWeather.add(new Label(weatherData[0] + "℃"));
		lbWeather.add(new Label(weatherData[1] + "％"));
		lbWeather.add(new Label(weatherData[2]));
		//フォント設定
		for(int i = 0; i < weatherData.length * 2; ++i)
		{
			lbWeather.get(i).setFont(Font.font
					(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		}
	}
	
	//-------------------------------------------- 
	//void resetList
	//ラベルリストを初期化する
	//--------------------------------------------
	void resetList()
	{
		lbClothes.clear();
		lbWeather.clear();
	}
	
	List<Label> getClothes()
	{
		return lbClothes; 
	}
}