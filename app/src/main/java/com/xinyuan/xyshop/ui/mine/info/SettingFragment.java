package com.xinyuan.xyshop.ui.mine.info;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xinyuan.xyshop.R;
import com.xinyuan.xyshop.base.BaseFragment;
import com.xinyuan.xyshop.even.MainFragmentStartEvent;
import com.xinyuan.xyshop.ui.mine.MsgActivity;
import com.xinyuan.xyshop.ui.mine.pro.AccountFragment;
import com.xinyuan.xyshop.util.CommUtil;
import com.xinyuan.xyshop.util.SystemBarHelper;
import com.xinyuan.xyshop.widget.dialog.color.ColorDialog;
import com.xinyuan.xyshop.widget.dialog.color.PromptDialog;
import com.youth.xframe.widget.XToast;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

import static com.xinyuan.xyshop.util.CommUtil.getInAnimationTest;
import static com.xinyuan.xyshop.util.CommUtil.getOutAnimationTest;

/**
 * Created by Administrator on 2017/6/27.
 */

public class SettingFragment extends BaseFragment {
	@BindView(R.id.toolbar_iv)
	Toolbar msg_toolbar;
	@BindView(R.id.tv_header_center)
	TextView tv_header_center;

	@BindView(R.id.iv_header_left)
	ImageView iv_header_left;
	@BindView(R.id.iv_header_right)
	ImageView iv_header_right;

	public static SettingFragment newInstance() {
		SettingFragment fragment = new SettingFragment();
		return fragment;
	}

	@Override
	public int getLayoutId() {
		return R.layout.fragment_setting;
	}

	@Override
	public void initData(Bundle savedInstanceState) {

	}


	@Override
	public void initView() {
		if (msg_toolbar != null) {
			SystemBarHelper.immersiveStatusBar(getActivity(), 0); //设置状态栏透明
			SystemBarHelper.setHeightAndPadding(getActivity(), msg_toolbar);
			tv_header_center.setText("用户设置");
		}
		CommUtil.initToolBar(_mActivity, context, iv_header_left, iv_header_right);
	}

	@OnClick({R.id.bt_setting_address, R.id.bt_setting_cache, R.id.bt_setting_sugges, R.id.bt_setting_security})
	public void OnClick(View view) {
		switch (view.getId()) {
			case R.id.bt_setting_address:
				start(AddressFragment.newInstance());
				break;
			case R.id.bt_setting_security:
				start(SecurityFragment.newInstance());
				break;
			case R.id.bt_setting_cache:
				ColorDialog dialog = new ColorDialog(getContext());
				dialog.setTitle("清理缓存");
				dialog.setAnimationEnable(true);
				dialog.setContentText("确定要清理APP图片缓存吗？");
				dialog.setAnimationIn(getInAnimationTest(getActivity()));
				dialog.setAnimationOut(getOutAnimationTest(getActivity()));
				dialog.setPositiveListener("清理", new ColorDialog.OnPositiveListener() {
					@Override
					public void onClick(ColorDialog dialog) {

						dialog.dismiss();

						XToast.info("清理完成！");
					}
				})
						.setNegativeListener("取消", new ColorDialog.OnNegativeListener() {
							@Override
							public void onClick(ColorDialog dialog) {
								dialog.dismiss();
							}
						}).show();
				break;
			case R.id.bt_setting_sugges:

				start(SuggesFragment.newInstance());
				break;

		}

	}


}
