/**********************************************/
/*author:西村　美玖 6/21更新
/		 佐野　渉 6/29更新
/*C7:服装設定処理部所属
/*EventSettingClothing:
/*服装設定モードのイベント処理を記述したクラス
/**********************************************/
package application;

import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class EventSettingClothing 
{
	SceneSettingClothing settingClothing;
	
	//-------------------------------------------- 
	//EventSettingClothing(SceneSettingClothing settingclothing)
	//
	//settingclothing:
	//--------------------------------------------
	EventSettingClothing(SceneSettingClothing settingclothing)
	{
		this.settingClothing = settingclothing;
	}
	
	//-------------------------------------------- 
	//void clickCancel(Button cancel)
	//キャンセルを押した時に実行するイベント処理
	//cancel:キャンセルボタン
	//--------------------------------------------
	void clickCancel(Button cancel)
	{
		cancel.setOnAction((ActionEvent) ->
		{ settingClothing.assignSceneToStage("preference"); }); //キャンセルボタンを押したらW10画面へ遷移
	}
	
	//-------------------------------------------- 
	//void clickRegister1(Button register, List<TextField> tf)
	//服装追加モードで登録を押した時に実行するイベント処理
	//register:登録ボタン tf:4つのテキストフィールド
	//--------------------------------------------
	void clickRegister1(Button register, List<TextField> tf)
	{
		register.setOnAction((ActionEvent) -> 
		{
			try
			{
				Clothes clothes = new Clothes();
				
				//テキストボックスの値を格納
				clothes.name = tf.get(0).getText();
				clothes.kind = tf.get(1).getText();
				clothes.part = tf.get(2).getText();
				clothes.index = Double.parseDouble(tf.get(3).getText());
				
				//テキストボックスエラー処理
				switch(new DataSettingClothing().exceptionText(clothes))
				{
				case -1 :
					new CreateAlert().failure(Constant.NAMEERROR);
					return;
				case -2 :
					new CreateAlert().failure(Constant.CLOTHESERROR);
					return;
				case -3 :
					new CreateAlert().failure(Constant.PARTERROR);
					return;
				case -4 :
					new CreateAlert().failure(Constant.EMPTYERROR);
					return;
				case -5 :
					new CreateAlert().failure(Constant.INDEXERROR);
					return;
				}
				
				//登録完了アラート画面表示
				if(new DataSettingClothing().addClothes(clothes))
				{
					//リストに服装を追加
					settingClothing.getOList().add(clothes.name);
					
					//服装追加成功
					new CreateAlert().complete(Constant.REGISTERMESSAGE);
					
					//テキストフィールドをリセット
					settingClothing.resetText();
				} else {
					//服装追加失敗
					new CreateAlert().failure(Constant.ADDCLOTHESERROR);
				}
			} catch(NumberFormatException e) {
				//服装指数が無効な数字であった場合
				new CreateAlert().failure(Constant.INDEXERROR);
			} catch(Exception e) {
				//それ以外の場合
				new CreateAlert().failure(Constant.UNKNOWNERROR);
				e.printStackTrace();
			}
		}); 
	}
	
	//-------------------------------------------- 
	//void clickRegister2(Button register)
	//服装削除モードで登録を押した時に実行するイベント処理
	//register:登録ボタン
	//--------------------------------------------
	void clickRegister2(Button register)
	{
		register.setOnAction((ActionEvent) -> 
		{
			try
			{
				ObservableList<String> ol = settingClothing.getOList();
				ListView<String> lv = settingClothing.getVList();
				String deleteClothing;
				String name;
				
				//選択されたリストビューの項目名を格納
				deleteClothing = lv.getSelectionModel().getSelectedItem();
				
				//名前を取り出す
				name = deleteClothing;
				
				//データ処理部を呼び出す,消すアイテムをclothesにいれる
				Clothes clothes = new DataSettingClothing().matching(name);
				
				//削除確認アラート画面表示
				boolean check = new CreateAlert().confirm(Constant.DELETEQUESTION);
				if(check == true)
				{
					for(int i = 0; i < ol.size(); i++)
					{
						if(ol.get(i).equals(clothes.name)) ol.remove(i); //リストビューから削除
					}
					new DataSettingClothing().deleteClothes(clothes);
					new CreateAlert().complete(Constant.DELETECOMPLETE); //削除完了アラート表示
				}
			} catch(Exception e) { //例外処理
				new CreateAlert().failure(Constant.UNKNOWNERROR); //エラーアラート表示
				e.printStackTrace();
			}
		}); 
	}
	
	//-------------------------------------------- 
	//void clickDelete(Button delete)
	//削除ボタンが選択された時に実行するイベント処理(モード変更)
	//delete:削除ボタン
	//--------------------------------------------
	void clickDelete(Button delete)
	{
		delete.setOnAction((ActionEvent) ->
		{
			//削除ボタンを押したらW9削除モード画面へ移動
			settingClothing.assignSceneToStage("delete");
		});
	}
	
	//-------------------------------------------- 
	//void clickAddition(Button add)
	//追加ボタンが選択された時に実行するイベント処理(モード変更)
	//add:登録ボタン
	//--------------------------------------------
	void clickAddition(Button add)
	{
		add.setOnAction((ActionEvent) ->
		{
			//追加ボタンを押したらW8追加モード画面へ移動
			settingClothing.assignSceneToStage("addition");
		});
	}
}