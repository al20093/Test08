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
			gender.assignSceneToStage("preference");
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
			gender.assignSceneToStage("preference");
		});
		
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
			boolean check = new CreateAlert().confirm(Constant.CANCELMESSAGE);
			if(check == true)
			{
				gender.assignSceneToStage("preference");
			}
		});
	}
	
}