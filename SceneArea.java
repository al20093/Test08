
/****************************************/ 
/*author:名久井愛紗 6/19更新 
/*C5:服装提案部所属 
/*SceneArea: 
/*服装提案部での画面作成処理を記述する
/****************************************/

package application;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

class SceneArea extends SceneMain{
	Scene scene;
	
	SceneArea(Stage stage)
	{
		super(stage);
	}
	
	void createArea(){
		BorderPane bp = new BorderPane();
		EventArea event = new EventArea(this);
		//ラベルリスト作成
		List<Label> lb = new ArrayList<Label>();
		List<Label> lb2 = new ArrayList<Label>();
		lb.add(new Label("服装提案"));
		lb.add(new Label("お住まいの地域を入力してください"));
		for(int i=0; i<2; i++) {
			lb.get(i).setFont(Font.font
					(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		}
		
		lb2.add(new Label("地域:"));
		for(int i=0; i<1; i++) {
			lb2.get(i).setFont(Font.font
					(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		}
		
		ComboBox names = new ComboBox();
		names.getItems().addAll(
				"札幌", "釧路", "仙台", "新潟", "東京", 
				"金沢", "名古屋", "大阪", "広島", "高知",
				"福岡", "鹿児島", "那覇");
		names.setPrefSize(180,40);
		names.setValue("地域");
		
		
		
		List<Button> bt = new ArrayList<Button>();
		bt.add(new Button("服装提案開始"));
		for(int i=0; i<bt.size(); i++) {
			bt.get(i).setFont(Font.font
					(Constant.FONTFAMILY,Constant.FONTWEIGHT,25));
		}
		
		List<Button> bt2 = new ArrayList<Button>();
		bt2.add(new Button("キャンセル"));
		for(int i=0; i<bt2.size(); i++) {
			bt2.get(i).setFont(Font.font
					(Constant.FONTFAMILY,Constant.FONTWEIGHT,25));
		}
		//ラベルをVBoxに割り当てる
		VBox vb = new VBox();
		vb.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(lb);
				
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.getChildren().addAll(lb2);
		hb.getChildren().addAll(names);
		
		VBox vb2 = new VBox();
		vb2.setAlignment(Pos.BOTTOM_RIGHT);
		vb2.setPadding(new Insets(10, 10, 10, 10));
		vb2.setSpacing(30);
		vb2.getChildren().addAll(bt);
				
		VBox vb3 = new VBox();
		vb3.setAlignment(Pos.BOTTOM_LEFT);
		vb3.setPadding(new Insets(10, 10, 10, 10));
		vb3.setSpacing(30);
		vb3.getChildren().addAll(bt2);
		//ペイン割り当て
		bp.setTop(vb);
		bp.setRight(vb2);
		bp.setLeft(vb3);
		bp.setCenter(hb);
		//ボタンにイベント割り当て
		event.transitionClothingresult(bt.get(0));
		event.transitionHome(bt2.get(0));
		//シーンの作成
		scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
	}
	
	void createClothing() {
		 BorderPane bp = new BorderPane();
		//ラベルリスト作成
		List<Label> lb = new ArrayList<Label>();
		lb.add(new Label("服装提案"));
		lb.add(new Label("提案された服装"));
		for(int i=0; i<2; i++) {
			lb.get(i).setFont(Font.font
						(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		}
		//ラベルをVBoxに割り当てる
		VBox vb = new VBox();
		vb.setAlignment(Pos.BASELINE_LEFT);
		vb.getChildren().addAll(lb);
		//ペイン割り当て
		bp.setTop(vb);
		//シーンの作成
		scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
			
	}

	Scene getScene()
	{
	return scene;
	}	
	
}
