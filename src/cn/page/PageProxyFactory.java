package cn.page;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;

/**
 * 会员专区Page工厂
 * @author Administrator
 *
 */
public class PageProxyFactory implements IPageFactory {
	
	
	private Map<String, IPage> mPageCache = new HashMap<String, IPage>();
	private IPageFactory factory;
	
	public PageProxyFactory(Activity act, IPageFactory factory) {
		this.act = act;
		this.factory = factory;
	}
	
	private Activity act;
	
	@Override
	public IPage createPage(String tag) {
		IPage p = mPageCache.get(tag);
		if (p != null) {
			return p;
		}
		p = new PageProxy(act, tag, factory);
		mPageCache.put(tag, p);
		return p;
	}
	
	public IPage createRealPage(String tag) {
		IPage p = mPageCache.get(tag);
		if (p != null) {
			return p;
		}
		p = factory.createPage(tag);
		mPageCache.put(tag, p);
		return p;
	}

}
