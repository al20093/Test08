/****************************************/ 
/*author:名久井愛紗 6/28更新 
/*C5:服装提案部所属 
/*EventProposal: 
/*服装提案部でのイベント処理を記述する
/****************************************/

package application;

import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class EventProposal
{
	SceneProposal area;
	static String areaname; //地域名
	
	//コンストラクタ
	EventProposal(SceneProposal area)
	{
		this.area = area;
	}
	
	//-----------------------------------------------------
	//void transitionResult(Button bt, ListView<String> lv) 
	//"服装提案開始"ボタンが押されたら
	//W5地域入力画面作成からW6服装提案画面に遷移
	//bt:"服装提案"ボタン lv:地域名称のリストビュー
	//-----------------------------------------------------
	void transitionResult(Button bt, ListView<String> lv)
	{
		bt.setOnAction((ActionEvent) ->
			{ 
				try 
				{
					area.assignSceneToStage("clothing"); //W6服装提案画面に遷移
					//String areaname;
					//areaname = lv.getItems(items);
					areaname = lv.getSelectionModel().getSelectedItem(); //選択された地域名称を取得
					List<Clothes> result = new DataProposal().getClothes(areaname); //地域名称から天気情報を取得し提案された服装を格納
					new DataProposal().orderList(result); //服装データリスト作成
				} catch(ArrayIndexOutOfBoundsException e) {
					//地域名称が選択されていなかった場合、エラーのアラート表示
					new CreateAlert().failure(Constant.EMPTYAREAERROR);
				} catch (Exception e) {
					//それ以外の場合
					new CreateAlert().failure(Constant.UNKNOWNERROR);
					e.printStackTrace();
				}
			});
	}
	
	//-----------------------------------------------------
	//void transitionResult(Button bt) 
	//"キャンセル"ボタンが押されたら
	//W5地域入力画面作成からW4ホーム画面に遷移
	//bt:"服装提案"ボタン
	//-----------------------------------------------------
	void transitionHome(Button bt)
	{
		bt.setOnAction((ActionEvent) ->
			{ area.assignSceneToStage("home"); }); //W4ホーム画面に遷移
	}
}