/**********************************************/
/*author:原田　拓十 6/27更新
/*C3:性別処理部所属
/*EventGender:
/*イベント処理を行う
/**********************************************/

package application;
import javafx.scene.control.Button;

public class EventGender 
{
	SceneGender gender;
	
	EventGender(SceneGender gender)
	{
		this.gender = gender;
	}
	
	//-------------------------------------------- 
	//void selectionMan(Button bt) 
	//引数のボタンに男性を選択した場合のイベントを取り付ける
	//bt:イベントをつけたいボタン
	//--------------------------------------------
	void selectionMan(Button bt) 
	{
		bt.setOnAction((ActionEvent) ->
		{ 
			new CreateAlert().complete("登録完了");
			new DataGender().dataMan();
			transaction();
		});
		
	}
	
	//-------------------------------------------- 
	//void selectionWoman(Button bt) 
	//引数のボタンに女性を選択した場合のイベントを取り付ける
	//bt:イベントをつけたいボタン
	//--------------------------------------------
	void selectionWoman(Button  bt) 
	{
		bt.setOnAction((ActionEvent) ->
		{ 
			new CreateAlert().complete(Constant.REGISTERMESSAGE);
			new DataGender().dataWoman();
			transaction();
		});
		
	}
	
	//-------------------------------------------- 
	//void selectionWoman(Button bt) 
	//画面遷移を行うメソッド
	//初期起動かどうかによる分岐を行う
	//--------------------------------------------
	void transaction()
	{
		if(new DataGender().getBoot())
		{
			gender.assignSceneToStage("preference");
		} else {
			gender.assignSceneToStage("weight");
		}
	}
	
	//-------------------------------------------- 
	//void selectionMan(Button bt) 
	//引数のボタンにキャンセルを選択した場合のイベントを取り付ける
	//bt:イベントをつけたいボタン
	//--------------------------------------------
	void selectionCancel(Button  bt) 
	{
		bt.setOnAction((ActionEvent) ->
		{ 
			if(new DataGender().getBoot())
			{
				gender.assignSceneToStage("preference");
			} else {
				gender.assignSceneToStage("initial");
			}
		});
	}
	
}