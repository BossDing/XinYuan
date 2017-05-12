package com.xinyuan.xyshop.mvp.presenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import com.xinyuan.xyshop.adapter.ActHomePagerAdapter;
import com.xinyuan.xyshop.mvp.contract.MainContract;
import com.xinyuan.xyshop.ui.catrgory.CategoryFragment;
import com.xinyuan.xyshop.ui.home.HomeFragment;
import com.xinyuan.xyshop.ui.mine.MineFragment;
import com.xinyuan.xyshop.ui.shopcar.ShopCarFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fx on 2017/5/2 0002.
 */

public class MainPresenterImpl implements MainContract.IMainPresenter {
	private final MainContract.IMainView view;
	private FragmentPagerAdapter pagerAdapter;
	//声明一个集合用于存放Fragment
	private List<Fragment> fragments;

	public MainPresenterImpl(MainContract.IMainView view) {
		this.view = view;
		view.setPresenter(this);
	}


	@Override
	public void initData() {
		ViewPager viewPagerContent = view.getmActHomeVpContent();
		fragments = new ArrayList<>();
		fragments.add(new HomeFragment());
		fragments.add(new CategoryFragment() );
		fragments.add(new ShopCarFragment());
		fragments.add(new MineFragment());
		pagerAdapter = new ActHomePagerAdapter(view.getManager(), fragments);
		viewPagerContent.setAdapter(pagerAdapter);
		viewPagerContent.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return true;  //修改为true
			}

		});

	}
}