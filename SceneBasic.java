package application;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.*;

public class SceneBasic extends SceneMain {
	Scene scene;
	
	SceneBasic(Stage stage)
	{
		super(stage);
	}
	
	void createInitial() {
		//ペイン作成
		BorderPane bp = new BorderPane();
		//ラベルリスト作成
		List<Label> lb = new ArrayList<Label>();
		//イベントオブジェクト作成
		EventBasic event = new EventBasic(this);
		
		lb.add(new Label("初期設定を行います"));
		lb.add(new Label("画面内をクリックしてください"));
		for(int i=0; i<2; i++) {
			lb.get(i).setFont(Font.font
					(Constant.FONTFAMILY,Constant.FONTWEIGHT,25));
		}
		//ラベルをVBoxに割り当てる
		VBox vb = new VBox();
		vb.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(lb);
		//ペイン割り当て
		bp.setCenter(vb);
		//シーンの作成
		scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
		//イベント割り当て
		event.clickWindow();
	}
	
	void createHome() {
		Label lb = new Label("服装提案を行うアプリケーションです");
		BorderPane bp = new BorderPane();
		EventBasic event = new EventBasic(this);
		List<Button> bt = new ArrayList<Button>()
		{
			{
				add(new Button("設定"));
				add(new Button("服装提案"));
				add(new Button("フィードバック"));
			}
		};
		
		for(int i=0; i<bt.size(); i++)
		{
			bt.get(i).setFont(Font.font(
					Constant.FONTFAMILY,Constant.FONTWEIGHT,30));
		}
		//ボタンをVBoxに割り当てる
		VBox vb = new VBox();
		vb.setAlignment(Pos.CENTER);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.setSpacing(30);
		vb.getChildren().addAll(bt);
		//上部メッセージ作成
		lb.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		lb.setTranslateY(20);
		//ペイン割り当て
		bp.setCenter(vb);
		bp.setTop(lb);
		BorderPane.setAlignment(lb, Pos.CENTER);
		//ボタンにイベント割り当て
		event.transitionReference(bt.get(0));
		event.transitionClothing(bt.get(1));
		
		//シーンの作成
		scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
	}
	
	Scene getScene()
	{
		return scene;
	}
}
