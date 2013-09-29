package cn.page;

import android.view.View;

public interface IPage {
	
	void onResume();
	void onPause();
	void onDestroy();
	
	View getView();
	
	void onSelected();
}
