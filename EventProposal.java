/****************************************/ 
/*author:名久井　愛紗 6/28更新 
/*		 佐野　渉 7/01更新 
/*C5:服装提案部所属 
/*EventProposal: 
/*服装提案部でのイベント処理を記述する
/****************************************/

package application;

import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class EventProposal
{
	SceneProposal proposal;
	static String areaName; //地域名
	
	//コンストラクタ
	EventProposal(SceneProposal proposal)
	{
		this.proposal = proposal;
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
					//選択された地域名称を取得
					areaName = lv.getSelectionModel().getSelectedItem();
					//地域名が選択されていない場合
					if(areaName == null)
					{
						new CreateAlert().failure(Constant.EMPTYAREAERROR);
						return;
					}
					boolean check = new CreateAlert().confirm(Constant.PROPOSALCONFIRM);
					if(check)
					{
						//天気情報を取得
						String[] weatherData = new DataProposal().getWeather(areaName);
						//天気情報から提案された服装を格納
						List<Clothes> result = new DataProposal().getClothes(weatherData);
						//提案服装の名称をシーンのラベルリストに格納する
						proposal.setClothes(result);
						//天気情報をシーンのラベルリストに格納する
						proposal.setWeather(weatherData);
						//シーンに画面を反映する
						proposal.assignPane();
						//服装データリスト作成
						new DataProposal().orderList(result);
						//W6服装提案画面に遷移
						proposal.assignSceneToStage("clothing");
					} else {
						return;
					}
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
	//void clickWindow()
	//画面がクリックされたら
	//W6服装提案画面からW4ホーム画面に遷移
	//-----------------------------------------------------
	void clickWindow()
	{
		proposal.getScene().addEventHandler(MouseEvent.MOUSE_CLICKED, 
			(MouseEvent) -> 
				{
					proposal.assignSceneToStage("home");
					//画面に表示する服装一覧と天気情報をクリアする
					proposal.resetList();
					//フィードバックフラグをONにする
					new DataProposal().flagOn();
				});
	}
	
	//-----------------------------------------------------
	//void clickCancel(Button bt) 
	//"キャンセル"ボタンが押されたら
	//W5地域入力画面作成からW4ホーム画面に遷移
	//bt:"キャンセル"ボタン
	//-----------------------------------------------------
	void clickCancel(Button bt)
	{
		bt.setOnAction((ActionEvent) ->
			{ proposal.assignSceneToStage("home"); }); //W4ホーム画面に遷移
	}
}
