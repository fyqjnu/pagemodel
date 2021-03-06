package cn.page;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class SimplePageAdapter extends PagerAdapter {
	
	private List<IPage> pages;
	
	public SimplePageAdapter(List<IPage> p) {
		this.pages = p;
	}

	@Override
	public int getCount() {
		return pages.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		IPage page = (IPage) arg1;
		return arg0 == page.getView();
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		IPage page = pages.get(position);
		container.addView(page.getView(), -1, -1);
		return page;
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		IPage page = pages.get(position);
		container.removeView(page.getView());
	}

}
