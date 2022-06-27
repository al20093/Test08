/**********************************************/
/*author:原田　拓十 6/27更新
/*C3:性別処理部所属
/*DataGender:
/*性別データを受け渡すクラス
/**********************************************/
package application;

public class DataGender 
{
	
	//男性の情報を送る
	void dataMan() 
	{
		boolean gender = true; //性別情報
		new UserDate().genderWrite(gender);	
	}
	     
	//女性の情報を送る
	void dataWoman() 
	{
		boolean gender = false; //性別情報
		new UserDate().genderWrite(gender);
	}
}