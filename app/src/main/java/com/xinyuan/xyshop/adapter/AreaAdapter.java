package com.xinyuan.xyshop.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xinyuan.xyshop.R;
import com.xinyuan.xyshop.entity.AreaBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */

public class AreaAdapter extends BaseQuickAdapter<AreaBean, BaseViewHolder> {
	public AreaAdapter(@LayoutRes int layoutResId, @Nullable List<AreaBean> data) {
		super(layoutResId, data);
	}

	@Override
	protected void convert(BaseViewHolder helper, AreaBean item) {
		TextView textVie =helper.getView(R.id.tv_address);
		textVie.setText(item.getAreaName());
	}
}
