/**********************************************/
/*author:西村　美玖 6/21更新
/*C7:服装設定処理部所属
/*EventSettingClothing:
/*服装設定モードのイベント処理を記述したクラス
/**********************************************/
package application;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class EventSettingClothing 
{
	SceneSettingClothing settingclothing;
	
	EventSettingClothing(SceneSettingClothing settingclothing)
	{
		this.settingclothing = settingclothing;
	}
	
	void clickCancel(Button cancel)
	{
		cancel.setOnAction((ActionEvent) ->
		{settingclothing.assignSceneToStage("preference");}); //キャンセルボタンを押したらW10画面へ遷移
	}
	
	void clickRegister1(Button register, TextField nameData, TextField clothingTypeData, TextField bodyTypeData, TextField clothingNumberData)
	{
		register.setOnAction((ActionEvent) -> 
		{
			//String clothingName;
			//String clothingClass;
			//String bodyClass;
			//double clothingValue;
			
			Clothes clothes = new Clothes();
			
			
			
			clothes.name = nameData.getText();
			clothes.kind = clothingTypeData.getText();
			clothes.part = bodyTypeData.getText();
			clothes.index = Double.parseDouble(clothingNumberData.getText());
			
			//データ処理部の書き込みメソッドを呼び出す
			 new DataSettingClothing().addClothes(clothes);
			
			//確認用
			System.out.println(clothes.name);
			System.out.println(clothes.kind);
			System.out.println(clothes.part);
			System.out.println(clothes.index);
			
			boolean check = new CreateAlert().confirm("登録が完了しました。"); //登録完了アラート画面表示
			if(check == true)
			{
				System.out.println("true");
			}else{
				System.out.println("false");
			}
			
		}); 
	}
	
	void clickRegister2(Button register, ObservableList<String> ol, ListView<String> lv)
	{
		register.setOnAction((ActionEvent) -> 
		{
			String deleteClothing;
			String name;
			deleteClothing = lv.getSelectionModel().getSelectedItem();
			
			//名前を取り出す
			name = deleteClothing;
			//データ処理部を呼び出す,消すアイテムをclotheにいれる
			Clothes clothes = new DataSettingClothing().matching(name);
			for(int i = 0; i < ol.size(); i++)
			{
				if(ol.get(i).equals(clothes.name)) ol.remove(i);
			}
			
			//確認用
			System.out.println(deleteClothing);
			
			boolean check = new CreateAlert().confirm("削除が完了しました。"); //登録完了アラート画面表示
			if(check == true)
			{
				System.out.println("true");
			}else{
				System.out.println("false");
			}
			
		}); 
	}
	
	void clickDelete(Button delete)
	{
		delete.setOnAction((ActionEvent) ->
		{settingclothing.assignSceneToStage("delete");}); //削除ボタンを押したらW9画面へ移動
	}
	
	void clickAdd(Button add)
	{
		add.setOnAction((ActionEvent) ->
		{settingclothing.assignSceneToStage("add");}); //追加ボタンを押したらW9画面へ移動
	}
}

/*public class EventClothingList
{
	SceneClothingList clothinglist;
	
	EventClothingList(SceneInputClothing clothinglist)
	{
		this.clothinglist = clothinglist;
	}
	
	void clickRegister(Button register, ListView<String> lv)
	{
		register.setOnAction((ActionEvent) -> 
		{
			String deleteClothing;
			deleteClothing = lv.getSelectionModel().getSelectedItem();
			
			//確認用
			System.out.println(deleteClothing);
			
			boolean check = new CreateAlert().confirm("削除が完了しました。"); //登録完了アラート画面表示
			if(check == true)
			{
				System.out.println("true");
			}else{
				System.out.println("false");
			}
			
		}); 
	}
	
	void clickAdd(Button add)
	{
		add.setOnAction((ActionEvent) ->
		{clothinglist.assignSceneToStage("add");}); //追加ボタンを押したらW9画面へ移動
	}
}*/
