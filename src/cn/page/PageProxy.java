package cn.page;

import java.util.Random;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class PageProxy extends SimplePage {
	
	private ViewGroup view;
	
	private Context ctx;
	private IPage page;
	private String title;
	private IPageFactory factory;
	
	public PageProxy(Context ctx, String title, IPageFactory factory) {
		this.title = title;
		this.factory = factory;
		this.ctx = ctx;
		view = new LinearLayout(ctx);
		view.setBackgroundColor(new Random().nextInt(255));
	}
	
	public void onSelected() {
		if (page == null) {
			page = factory.createPage(title);
			view.addView(page.getView(), -1, -1);
		}
	}
	
	public View getView() {
		return view;
	}

}
