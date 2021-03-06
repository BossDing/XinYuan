package com.xinyuan.xyshop.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xinyuan.xyshop.R;
import com.xinyuan.xyshop.entity.HomeMultipleItem;
import com.xinyuan.xyshop.model.HomeModel;
import com.xinyuan.xyshop.mvp.presenter.HomePresenterImpl;
import com.xinyuan.xyshop.ui.goods.detail.GoodDetailsActivity;
import com.xinyuan.xyshop.ui.goods.store.StoreActivity;
import com.xinyuan.xyshop.ui.home.WebViewActivity;
import com.xinyuan.xyshop.util.CommUtil;
import com.xinyuan.xyshop.util.GlideImageLoader;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by fx on 2017/5/2 0002.
 */

public class HomeMultipleItemAdapter extends BaseMultiItemQuickAdapter<HomeMultipleItem, BaseViewHolder> {


	public static List<HomeModel.HomeModule> dataList;

	public HomeMultipleItemAdapter(Context mContext, List data) {
		super(data);
		addItemType(HomeMultipleItem.AD, R.layout.fragment_home_item_ad);
		addItemType(HomeMultipleItem.TAB, R.layout.fragment_home_item_tab);
		addItemType(HomeMultipleItem.TAB2, R.layout.fragment_home_item_tab2);
		addItemType(HomeMultipleItem.CATEGORY, R.layout.fragment_home_item_category);
		dataList = HomePresenterImpl.getModuleList();

	}

	@Override
	protected void convert(BaseViewHolder helper, HomeMultipleItem item) {


		switch (item.getItemType()) {
			case HomeMultipleItem.AD:

				List<HomeModel.HomeModule.HomeModuleData> adlist = dataList.get(helper.getLayoutPosition() + 2).getDataList();


				ImageView ad_view = helper.getView(R.id.home_ad_img);
				GlideImageLoader.setImage(mContext, adlist.get(0).getImageUrl(), ad_view);
				OnImageViewClick(ad_view, adlist.get(0).getType(), adlist.get(0).getData(), false);

				break;
			case HomeMultipleItem.TAB:


				ImageView iv_tab_title = helper.getView(R.id.iv_tab_title);
				TextView tv_tab_title_cn = helper.getView(R.id.tv_tab_title_cn);
				TextView tv_tab_title_en = helper.getView(R.id.tv_tab_title_en);
				HomeModel.HomeModule homeModel = dataList.get(helper.getLayoutPosition() + 2);


				ImageView tab_view1 = helper.getView(R.id.home_tab_img1);
				ImageView tab_view2 = helper.getView(R.id.home_tab_img2);
				ImageView tab_view3 = helper.getView(R.id.home_tab_img3);
				ImageView tab_view4 = helper.getView(R.id.home_tab_img4);
				ImageView tab_view5 = helper.getView(R.id.home_tab_img5);
				ImageView tab_view6 = helper.getView(R.id.home_tab_img6);

				List<HomeModel.HomeModule.HomeModuleData> tablist = homeModel.getDataList();
				GlideImageLoader.setImage(mContext, tablist.get(0).getImageUrl(), tab_view1);
				GlideImageLoader.setImage(mContext, tablist.get(1).getImageUrl(), tab_view2);
				GlideImageLoader.setImage(mContext, tablist.get(2).getImageUrl(), tab_view3);
				GlideImageLoader.setImage(mContext, tablist.get(3).getImageUrl(), tab_view4);
				GlideImageLoader.setImage(mContext, tablist.get(4).getImageUrl(), tab_view5);
				GlideImageLoader.setImage(mContext, tablist.get(5).getImageUrl(), tab_view6);


				OnImageViewClick(tab_view1, tablist.get(0).getType(), tablist.get(0).getData(), false);
				OnImageViewClick(tab_view2, tablist.get(1).getType(), tablist.get(1).getData(), false);
				OnImageViewClick(tab_view3, tablist.get(2).getType(), tablist.get(2).getData(), false);
				OnImageViewClick(tab_view4, tablist.get(3).getType(), tablist.get(3).getData(), false);
				OnImageViewClick(tab_view5, tablist.get(4).getType(), tablist.get(4).getData(), false);
				OnImageViewClick(tab_view6, tablist.get(5).getType(), tablist.get(5).getData(), false);


				GlideImageLoader.setImage(mContext, homeModel.getItemtitleImage(), iv_tab_title);
				helper.setText(R.id.tv_tab_title_cn, homeModel.getItemtitleCN());
				helper.setText(R.id.tv_tab_title_en, homeModel.getItemtitleEN());
				helper.setTextColor(R.id.tv_tab_title_cn, Color.parseColor(homeModel.getItemtitleColor()));

				break;
			case HomeMultipleItem.TAB2:

				ImageView iv_tab2_title = helper.getView(R.id.iv_tab_title);
				TextView tv_tab2_title_cn = helper.getView(R.id.tv_tab_title_cn);
				TextView tv_tab2_title_en = helper.getView(R.id.tv_tab_title_en);

				ImageView home_tab2_img1 = helper.getView(R.id.home_tab2_img1);
				ImageView home_tab2_img2 = helper.getView(R.id.home_tab2_img2);
				ImageView home_tab2_img3 = helper.getView(R.id.home_tab2_img3);
				HomeModel.HomeModule tab2homeModel = dataList.get(helper.getLayoutPosition() + 2);


				List<HomeModel.HomeModule.HomeModuleData> tab2list = tab2homeModel.getDataList();
				GlideImageLoader.setImage(mContext, tab2list.get(0).getImageUrl(), home_tab2_img1);
				GlideImageLoader.setImage(mContext, tab2list.get(1).getImageUrl(), home_tab2_img2);
				GlideImageLoader.setImage(mContext, tab2list.get(2).getImageUrl(), home_tab2_img3);
				OnImageViewClick(home_tab2_img1, tab2list.get(0).getType(), tab2list.get(0).getData(), false);
				OnImageViewClick(home_tab2_img2, tab2list.get(1).getType(), tab2list.get(1).getData(), false);
				OnImageViewClick(home_tab2_img3, tab2list.get(2).getType(), tab2list.get(2).getData(), false);
				GlideImageLoader.setImage(mContext, tab2homeModel.getItemtitleImage(), iv_tab2_title);
				helper.setText(R.id.tv_tab_title_cn, tab2homeModel.getItemtitleCN());
				helper.setText(R.id.tv_tab_title_en, tab2homeModel.getItemtitleEN());
				helper.setTextColor(R.id.tv_tab_title_cn, Color.parseColor(tab2homeModel.getItemtitleColor()));

				break;
			case HomeMultipleItem.CATEGORY:


				List<HomeModel.HomeModule.HomeModuleData> catrgorylist = dataList.get(helper.getLayoutPosition() + 2).getDataList();

				ImageView catrgory_view = helper.getView(R.id.home_catrgory_img);
				GlideImageLoader.setImage(mContext, catrgorylist.get(0).getImageUrl(), catrgory_view);
				OnImageViewClick(catrgory_view, catrgorylist.get(0).getType(), catrgorylist.get(0).getData(), false);


				ImageView iv_ca_title = helper.getView(R.id.iv_tab_title);
				TextView tv_ca_title_cn = helper.getView(R.id.tv_tab_title_cn);
				TextView tv_ca_title_en = helper.getView(R.id.tv_tab_title_en);

				HomeModel.HomeModule cahomeModel = dataList.get(helper.getLayoutPosition() + 2);

				GlideImageLoader.setImage(mContext, cahomeModel.getItemtitleImage(), iv_ca_title);
				helper.setText(R.id.tv_tab_title_cn, cahomeModel.getItemtitleCN());
				helper.setText(R.id.tv_tab_title_en, cahomeModel.getItemtitleEN());
				helper.setTextColor(R.id.tv_tab_title_cn, Color.parseColor(cahomeModel.getItemtitleColor()));

				break;
			default:
				break;

		}


	}


	private void OnImageViewClick(View view, final String type, final String data, boolean isAD) {
		view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Map<String, String> params = new HashMap();

				if (type.equals("good")) {
					params.put("goodId", data);
					CommUtil.gotoActivity(mContext, GoodDetailsActivity.class, false, params);
				} else if (type.equals("store")) {

					params.put("storeId", data);
					CommUtil.gotoActivity(mContext, StoreActivity.class, false, params);
				} else if (type.equals("html")) {

					params.put("url", data);
					CommUtil.gotoActivity(mContext, WebViewActivity.class, false, params);
				}
			}
		});

	}

}
