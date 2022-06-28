
/****************************************/
/*author:佐野　渉 6/21更新 
/*author:名久井愛紗 6/28更新 
/*C2:基本画面処理部所属 
/*SceneBasic: 
/*基本画面処理部での画面作成処理を記述する
/****************************************/
package application;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SceneBasic extends SceneMain
{
	Scene scene;
	
	SceneBasic(Stage stage)
	{
		super(stage);
	}
	
	//-------------------------------------------- 
	//void createInitial() 
	////W1初期設定画面作成
	//--------------------------------------------
	void createInitial()
	{
		//ペイン作成
		BorderPane bp = new BorderPane();
		//ラベルリスト作成
		List<Label> lb = new ArrayList<Label>();
		//イベントオブジェクト作成
		EventBasic event = new EventBasic(this);
		
		lb.add(new Label("初期設定を行います"));
		lb.add(new Label("画面内をクリックしてください"));
		for(int i = 0; i < 2; i++)
		{
			lb.get(i).setFont(Font.font
					(Constant.FONTFAMILY,Constant.FONTWEIGHT,25));
		}
		//ラベルをVBoxに割り当てる
		VBox vb = new VBox();
		vb.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(lb);
		//ペイン割り当て
		bp.setCenter(vb);
		bp.setTop(SceneContents.subTitle("初期設定"));
		//シーンの作成
		scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
		//イベント割り当て
		event.clickWindow();
	}
	
	//-------------------------------------------- 
	//void createHome() 
	////W4ホーム画面作成
	//--------------------------------------------
	void createHome()
	{
		Label lb = new Label("服装提案を行うアプリケーションです"); //ラベル作成
		BorderPane bp = new BorderPane(); //ボーダーペイン作成
		EventBasic event = new EventBasic(this); //イベントオブジェクト作成
		//ボタンリスト作成
		List<Button> bt = new ArrayList<Button>()
		{
			{
				add(new Button("設定"));
				add(new Button("服装提案"));
				add(new Button("フィードバック"));
			}
		};
		for(int i = 0; i < bt.size(); i++)
		{
			bt.get(i).setFont(Font.font(
					Constant.FONTFAMILY,Constant.FONTWEIGHT,30));
		}
		
		//ラベルとボタンをVBoxに割り当てる
		VBox vb = new VBox();
		VBox vb2 = new VBox();
		vb.setAlignment(Pos.CENTER);
		vb2.setAlignment(Pos.CENTER);
		vb.setPadding(new Insets(0, 0, 0, 0));
		vb2.setPadding(new Insets(0, 0, 0, 0));
		vb.setSpacing(30);
		vb2.setSpacing(10);
		vb.getChildren().addAll(bt); //"設定""服装提案""フィードバック"ボタン
		vb2.getChildren().addAll(SceneContents.subTitle("ホーム画面"), lb); //"服装提案を行うアプリケーションです"ラベル
		vb.setTranslateY(-10);
		
		//上部メッセージ作成
		lb.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		
		//ペイン割り当て
		bp.setCenter(vb); //"設定""服装提案""フィードバック"ボタン
		bp.setTop(vb2); //"服装提案を行うアプリケーションです"ラベル
		BorderPane.setAlignment(lb, Pos.CENTER);
		
		//ボタンにイベント割り当て
		event.transitionPreference(bt.get(0)); //"設定"ボタン
		event.transitionClothing(bt.get(1)); //"服装提案"ボタン
		event.transitionFeedback(bt.get(2)); //"フィードバック"ボタン
		
		//シーンの作成
		scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
	}
	
	//-------------------------------------------- 
	//void createHome() 
	////W10設定画面作成
	//--------------------------------------------
	void createPreference()
	{
		Label lb = new Label("設定したい項目を選択してください"); //ラベル作成
		BorderPane bp = new BorderPane(); //ボーダーペイン作成
		EventBasic event = new EventBasic(this); //イベントオブジェクト作成
		//ボタンリスト作成
		List<Button> bt = new ArrayList<Button>()
		{
			{
				add(new Button("性別"));
				add(new Button("重み設定"));
				add(new Button("服装追加"));
				add(new Button("キャンセル"));
			}
		};
		for(int i = 0; i < bt.size(); i++)
		{
			bt.get(i).setFont(Font.font(
					Constant.FONTFAMILY,Constant.FONTWEIGHT,30));
		}
		bt.get(3).setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		
		//ラベルやボタンをVBoxに割り当てる
		VBox vb = new VBox();
		VBox vb2 = new VBox();
		vb.setAlignment(Pos.CENTER);
		vb2.setAlignment(Pos.CENTER);
		vb.setPadding(new Insets(0, 0, 0, 0));
		vb2.setPadding(new Insets(0, 0, 0, 0));
		vb.setSpacing(30);
		vb2.setSpacing(10);
		vb.getChildren().addAll(bt); //"性別""重み設定""服装追加""キャンセル"ボタン
		vb2.getChildren().addAll(SceneContents.subTitle("設定"), lb); //"設定したい項目を選択してください"ラベル
		vb.setTranslateY(10);
		bt.get(3).setTranslateX(-120);
		
		//上部メッセージ作成
		lb.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		
		//ペイン割り当て
		bp.setCenter(vb); //"性別""重み設定""服装追加""キャンセル"ボタン
		bp.setTop(vb2); //"設定したい項目を選択してください"ラベル
		BorderPane.setAlignment(lb, Pos.CENTER);
		
		//ボタンにイベント割り当て
		event.transitionGender(bt.get(0)); //"性別"ボタン
		event.transitionWeight(bt.get(1)); //"重み追加"ボタン
		event.transitionAddition(bt.get(2)); //"服装追加"ボタン
		event.transitionHome(bt.get(3)); //"キャンセル"ボタン
		
		//シーンの作成
		scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
	}
	
	//画面作成
	Scene getScene()
	{
		return scene;
	}
}
