package com.xinyuan.xyshop.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.xinyuan.xyshop.R;
import com.xinyuan.xyshop.adapter.ExpandableItemAdapter;
import com.xinyuan.xyshop.adapter.SearchGoodListAdapter;
import com.xinyuan.xyshop.adapter.SelectDialogAdapter;
import com.xinyuan.xyshop.bean.ExpandItem;
import com.xinyuan.xyshop.entity.Menu;
import com.xinyuan.xyshop.entity.SelectFilterTest;
import com.xinyuan.xyshop.util.CommUtil;
import com.youth.xframe.utils.log.XLog;

import butterknife.BindView;
import butterknife.ButterKnife;

import java.util.ArrayList;
import java.util.List;


public class SearchGoodSelectDialog extends Dialog {
	@BindView(R.id.search_goods_filter)
	RecyclerView RV_filter;
	private Context context;
	private static SelectFilterTest selectFilterTests;
	private List<SelectFilterTest.FilterKey> filterKeyList;

	public SearchGoodSelectDialog(Context context) {
		super(context);
		this.context = context;

	}

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_good_select);
		ButterKnife.bind((Dialog) this);
		getWindow().setLayout((CommUtil.getScreenWeight(context) / 5) * 4, -1);
		getWindow().setWindowAnimations(R.style.AnimationFade);
		getWindow().setGravity(5);
		if (selectFilterTests != null) {
			filterKeyList = selectFilterTests.getKeyList();
		}

		int menucount = filterKeyList.size();
		ArrayList<MultiItemEntity> res = new ArrayList<>();
		for (SelectFilterTest.FilterKey key : filterKeyList) {
			ExpandItem expandItem = new ExpandItem("", key.getCategoryName());
			for (SelectFilterTest.FilterKey.KeyItem item : key.getKeyitem()) {
				expandItem.addSubItem(new Menu("", item.getCategoryName()));
			}
			res.add(expandItem);
		}
		XLog.list(res);
		final SelectDialogAdapter selectDialogAdapter = new SelectDialogAdapter(res, filterKeyList);
		final GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
		manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
			@Override
			public int getSpanSize(int position) {
				return selectDialogAdapter.getItemViewType(position) == SelectDialogAdapter.TYPE_ITEM ? 1 : manager.getSpanCount();
			}
		});
		RV_filter.setAdapter(selectDialogAdapter);
		selectDialogAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
		RV_filter.setLayoutManager(manager);


	}

	public static void setFilter(SelectFilterTest selectFilterTest) {
		selectFilterTests = selectFilterTest;
		XLog.v(selectFilterTests.toString());
	}


}
