package com.xinyuan.xyshop.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xinyuan.xyshop.R;
import com.xinyuan.xyshop.entity.GoodsVo;
import com.xinyuan.xyshop.ui.mine.info.AddressEven;
import com.xinyuan.xyshop.util.GlideImageLoader;
import com.xinyuan.xyshop.widget.dialog.color.ColorDialog;
import com.youth.xframe.widget.XToast;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by Administrator on 2017/6/5.
 */

public class GoodsGridAdapter extends BaseQuickAdapter<GoodsVo, BaseViewHolder> {


	public GoodsGridAdapter(@LayoutRes int layoutResId, @Nullable List<GoodsVo> data) {
		super(layoutResId, data);
	}

	@Override
	protected void convert(final BaseViewHolder helper, GoodsVo item) {
		if (item.getImageSrc() != null) {

			ImageView goodsImg = helper.getView(R.id.ivGoodPic);
			GlideImageLoader.setImage(mContext, item.getImageSrc(), goodsImg);
			TextView tv_goods_name = helper.getView(R.id.tv_goods_name);
			tv_goods_name.setText(item.getGoodsName());
			TextView tv_goods_price = helper.getView(R.id.tv_goods_price);
			tv_goods_price.setText("￥" + String.valueOf(item.getAppPriceMin()));
			TextView tv_goods_sellnum = helper.getView(R.id.tv_goods_sellnum);
			tv_goods_sellnum.setText("月销量:" + item.getGoodsSaleNum() + "件");
		}
	}
}
