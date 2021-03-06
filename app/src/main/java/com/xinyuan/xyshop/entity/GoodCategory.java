package com.xinyuan.xyshop.entity;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Title:
 * Description:
 * Created by Administrator on 2017/5/10.
 * 作者：fx on 2017/5/10 22:00
 */

public class GoodCategory implements Serializable {
	private static final long serialVersionUID = -244458282214364556L;
	private int categoryId;
	private String categoryName;
	private int categorySort;
	private String categoryImageUrl;
	private int deep = 0;
	private int parentId = 0;

	private List<GoodCategory> categoryList = new ArrayList();


	public int getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public int getCategorySort() {
		return categorySort;
	}

	public String getCategoryImageUrl() {
		return categoryImageUrl;
	}


	public int getDeep() {
		return deep;
	}

	public int getParentId() {
		return parentId;
	}

	public List<GoodCategory> getCategoryList() {
		return categoryList;
	}
}
