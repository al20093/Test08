/**********************************************/
/*author:西村　美玖 6/21更新
/*C7:服装設定処理部所属
/*SceneSettingClothing:
/*服装設定モードの際に表示する画面を作成したクラス
/**********************************************/
package application;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneSettingClothing extends SceneMain{
	
	Scene scene;
	
	SceneSettingClothing(Stage stage)
	{
		super(stage);
	}
	
	
	
	 
	
	
	 void createAdd() {
		 
		 //イベントオブジェクト作成
		 EventSettingClothing event = new EventSettingClothing(this);
		 
		 Label name = new Label("名称");//名称ラベル"name"
		 Label clothingType = new Label("服装分類");//服装分類ラベル"clothingType"
		 Label bodyType = new Label("部位分類"); //部位分類ラベル"bodyType"
		 Label clothingNumber = new Label("服装指数"); //服装指数ラベル"clothingNumber" 
			
		TextField nameData = new TextField(); //nameの入力部分
		TextField clothingTypeData = new TextField(); //clothingTypeの入力部分
		TextField bodyTypeData = new TextField(); //bodyTypeの入力部分
		TextField clothingNumberData = new TextField(); //clothingNumberの入力部分
		
		//stage.setHeight(500); //ウィンドウサイズ
		//stage.setWidth(500);
		
		
		nameData.setMaxWidth(200); //テキストボックスサイズ
		clothingTypeData.setMaxWidth(200);
		bodyTypeData.setMaxWidth(200);
		clothingNumberData.setMaxWidth(200);
		
		
		Button delete = new Button("削除"); //削除ボタン"delete"
		
		
		HBox hb_name_bt = new HBox();
		hb_name_bt.getChildren().addAll(name, delete); //名称と削除を水平に並べた
		hb_name_bt.setSpacing(190);
		hb_name_bt.setAlignment(Pos.CENTER_RIGHT);
		
		
		VBox vb_center = new VBox(); //中心におくかたまり
		vb_center.getChildren().addAll(hb_name_bt, nameData, clothingType, clothingTypeData, bodyType, bodyTypeData, clothingNumber, clothingNumberData );
		vb_center.setAlignment(Pos.CENTER);
		vb_center.setSpacing(10);
		
		
		Button cancel = new Button("キャンセル");//キャンセルボタン"cancel"
		Button register = new Button("登録"); //登録ボタン"register"
		
		HBox hb_button = new HBox(); //登録ボタンとキャンセルボタンの水平方向のかたまり"hb_button"
		hb_button.getChildren().addAll(cancel, register);
		hb_button.setSpacing(100);
		hb_button.setAlignment(Pos.CENTER);
				
		
		BorderPane bp = new BorderPane();
		
		
		bp.setCenter(vb_center);
		bp.setBottom(hb_button);
		
		this.scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
		
		//イベント処理系
		event.clickDelete(delete);
		event.clickCancel(cancel);
		event.clickRegister1(register,nameData, clothingTypeData, bodyTypeData, clothingNumberData);
		
		
		//Scene scene = new Scene(bp, 100, 300);
		
		//stage.setScene(scene);
		//stage.setTitle("サンプル");
		//stage.setX(stage.getX() + 30);
		//stage.show();
	}
	 void createDelete()
		{
		 
		 		
		 
		 		//イベントオブジェクト作成
		 		EventSettingClothing event = new EventSettingClothing(this);
		 		
		 		//Label lb;
		 		ListView<String> lv;
				
				//stage.setHeight(500); //ウィンドウサイズ
				//stage.setWidth(500);
				
				Button add = new Button("追加"); //追加ボタン"add"
				
				
				//lb = new Label("服装追加\n\n\n\n\n");
				lv = new ListView<String>();
			
				//データ処理部より服装データを取得するメソッドを呼び出す
				List<Clothes> clothes = new DataSettingClothing().getClothes();
				
				ObservableList<String> ol =
						FXCollections.observableArrayList();
					for(int i = 0; i < clothes.size(); i++)
					{
						ol.add(clothes.get(i).name);  //Labelに服装名称を追加する
					}
				
						
				lv.setItems(ol);
				
				lv.setPrefWidth(200); //リストビューサイズ
				lv.setPrefHeight(200);
				
				VBox vb_center = new VBox(); //中心におくかたまり(変更とリストビュー)
				vb_center.getChildren().addAll(add, lv);
				vb_center.setSpacing(50);
				vb_center.setAlignment(Pos.CENTER_RIGHT);
				
				Button cancel = new Button("キャンセル");//キャンセルボタン"cancel"
				Button register = new Button("登録"); //登録ボタン"register"
				
				HBox hb_button = new HBox(); //登録ボタンとキャンセルボタンの水平方向のかたまり"hb_button"
				hb_button.getChildren().addAll(cancel, register);
				hb_button.setSpacing(100);
				hb_button.setAlignment(Pos.CENTER);
						
				
				BorderPane bp = new BorderPane();
				
				//bp.setTop(lb);
				bp.setCenter(vb_center);
				bp.setBottom(hb_button);
				
				/*lv.getSelectionModel().selectedItemProperty()
					.addListener(new SampleChangeListener());*/
				
				this.scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
				
				//Scene scene = new Scene(bp, 100, 300);
				
				//stage.setScene(scene);
				//stage.setTitle("サンプル");
				//stage.setX(stage.getX() + 30);
				//stage.show();
				
				event.clickCancel(cancel);
				event.clickAdd(add);
				event.clickRegister2(register, ol, lv);
			}
	/*public static void main(String[] args) {
		launch(args);
	}*/
	 Scene getScene() 
		{
			return this.scene;
		}
}
