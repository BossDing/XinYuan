package com.xinyuan.xyshop.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by fx on 2017/5/4 0004.
 * 首页模块视图实体类
 */


public class HomeMultipleItem implements MultiItemEntity {
	public static final int AD = 1;
	public static final int NOTICE = 2;
	public static final int TAB_TITLE = 3;
	public static final int TAB = 4;
	public static final int TAB2 = 5;
	public static final int CATEGORY = 6;
	public static final int GOODS = 7;

	public static final int AD_SPAN_SIZE = 4;
	public static final int NOTICE_SPAN_SIZE = 4;
	public static final int TAB_TITLE_SPAN_SIZE = 4;
	public static final int TAB2_SPAN_SIZE = 4;
	public static final int TAB_SPAN_SIZE = 4;
	public static final int CATEGORY_SPAN_SIZE = 4;
	public static final int GOODS_SPAN_SIZE = 2;

	public int itemType;
	public int spanSize;


	public HomeMultipleItem(int itemType, int spanSize) {
		this.itemType = itemType;
		this.spanSize = spanSize;

	}

	@Override
	public int getItemType() {
		return itemType;
	}

	public int getSpanSize() {
		return spanSize;
	}

	public void setSpanSize(int spanSize) {
		this.spanSize = spanSize;
	}

	@Override
	public String toString() {
		return "HomeMultipleItem{" +
				"itemType=" + itemType +
				", spanSize=" + spanSize +
				'}';
	}
}
