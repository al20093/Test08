/**********************************************/
/*author:西村　美玖 6/21更新
/		 佐野　渉 6/28更新
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
	
	EventSettingClothing(SceneSettingClothing settingclothing, ObservableList<String> ol,
			ListView<String> lv)
	{
		this.settingClothing = settingclothing;
	}
	
	void clickCancel(Button cancel)
	{
		cancel.setOnAction((ActionEvent) ->
		{ settingClothing.assignSceneToStage("preference"); }); //キャンセルボタンを押したらW10画面へ遷移
	}
	
	void clickRegister1(Button register, List<TextField> tf)
	{
		register.setOnAction((ActionEvent) -> 
		{
			try
			{
				Clothes clothes = new Clothes();
			
				clothes.name = tf.get(0).getText();
				clothes.kind = tf.get(1).getText();
				clothes.part = tf.get(2).getText();
				clothes.index = Double.parseDouble(tf.get(3).getText());
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
				}
				
				//リストに服装を追加
				settingClothing.getOList().add(clothes.name);
				//登録完了アラート画面表示
				new DataSettingClothing().addClothes(clothes);
				new CreateAlert().complete(Constant.REGISTERMESSAGE);
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
				deleteClothing = lv.getSelectionModel().getSelectedItem();
				System.out.println(ol);
				//名前を取り出す
				name = deleteClothing;
				//データ処理部を呼び出す,消すアイテムをclothesにいれる
				Clothes clothes = new DataSettingClothing().matching(name);
				//登録完了アラート画面表示
				boolean check = new CreateAlert().confirm(Constant.DELETEQUESTION);
				if(check == true)
				{
					for(int i = 0; i < ol.size(); i++)
					{
						if(ol.get(i).equals(clothes.name)) ol.remove(i);
					}
					new DataSettingClothing().deleteClothes(clothes);
					new CreateAlert().complete(Constant.DELETECOMPLETE);
				}
			} catch(Exception e) {
				new CreateAlert().failure(Constant.UNKNOWNERROR);
				e.printStackTrace();
			}
		}); 
	}
	
	void clickDelete(Button delete)
	{
		delete.setOnAction((ActionEvent) ->
		{
			settingClothing.assignSceneToStage("delete");
		}); //削除ボタンを押したらW9画面へ移動
	}
	
	void clickAddition(Button add)
	{
		add.setOnAction((ActionEvent) ->
		{settingClothing.assignSceneToStage("addition");}); //追加ボタンを押したらW9画面へ移動
	}
}