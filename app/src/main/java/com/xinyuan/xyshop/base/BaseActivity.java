package com.xinyuan.xyshop.base;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;

import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.RxLifecycle;
import com.trello.rxlifecycle.android.ActivityEvent;
import com.trello.rxlifecycle.android.RxLifecycleAndroid;
import com.xinyuan.xyshop.MyShopApplication;
import com.xinyuan.xyshop.R;
import com.youth.xframe.base.ICallback;
import com.youth.xframe.base.XActivity;
import com.youth.xframe.common.XActivityStack;
import com.youth.xframe.utils.log.XLog;
import com.youth.xframe.utils.permission.XPermission;
import com.youth.xframe.utils.statusbar.XStatusBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;
import rx.Observable;
import rx.subjects.BehaviorSubject;

import com.trello.rxlifecycle.LifecycleProvider;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by fx on 2017/5/2 0002.
 */

public abstract class BaseActivity extends SupportActivity implements ICallback, LifecycleProvider<ActivityEvent> {


	private final BehaviorSubject<ActivityEvent> lifecycleSubject = BehaviorSubject.create();

	protected MyShopApplication application;
	Unbinder mUnbinder;
	private static String TAG = "";

	@Override
	@CallSuper
	protected void onCreate(Bundle savedInstanceState) {
		XLog.v("Activity:---onCreate:创建！");
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		XActivityStack.getInstance().addActivity(this);
		super.onCreate(savedInstanceState);
		if (getLayoutId() > 0) {
			setContentView(getLayoutId());
		}
		this.application = MyShopApplication.getInstance();
		ButterKnife.bind(this);
		mUnbinder = ButterKnife.bind(this);
		initData(savedInstanceState);
		initView();
		lifecycleSubject.onNext(ActivityEvent.CREATE);

	}

	@Override
	public void setContentView(int layoutResID) {
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.setContentView(layoutResID);

		//setStatusBar();
	}


	protected void setStatusBar() {
		XStatusBar.setColor(this, getResources().getColor(R.color.colorTransparency), 0);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * Android M 全局权限申请回调
	 *
	 * @param requestCode
	 * @param permissions
	 * @param grantResults
	 */
	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[]
			grantResults) {
		XPermission.onRequestPermissionsResult(requestCode, permissions, grantResults);
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
	}

	@Override
	protected void onDestroy() {
		XLog.v("Activity:---onDestroy：销毁！");
		super.onDestroy();
		lifecycleSubject.onNext(ActivityEvent.DESTROY);
		mUnbinder.unbind();
		EventBus.getDefault().unregister(this);//反注册
		XActivityStack.getInstance().finishActivity();


	}

	@Override
	@CallSuper
	protected void onResume() {
		super.onResume();
		XLog.v("Activity:---onResume：可见！");

		lifecycleSubject.onNext(ActivityEvent.RESUME);

	}

	@Override
	@CallSuper
	protected void onPause() {
		XLog.v("Activity:---onPause：屏蔽！");

		lifecycleSubject.onNext(ActivityEvent.PAUSE);
		super.onPause();
	}

	@Override
	@CallSuper
	protected void onStop() {
		XLog.v("Activity:---onStop：停止 ！");

		lifecycleSubject.onNext(ActivityEvent.STOP);
		super.onStop();
	}


	@Override
	@CallSuper
	protected void onStart() {
		XLog.v("Activity:---onStop：启动 ！");
		super.onStart();
		lifecycleSubject.onNext(ActivityEvent.START);

	}


	@Override
	@NonNull
	@CheckResult
	public final Observable<ActivityEvent> lifecycle() {
		return lifecycleSubject.asObservable();
	}


	@Override
	@NonNull
	@CheckResult
	public final <T> LifecycleTransformer<T> bindUntilEvent(@NonNull ActivityEvent event) {
		return RxLifecycle.bindUntilEvent(lifecycleSubject, event);
	}

	@Override
	@NonNull
	@CheckResult
	public final <T> LifecycleTransformer<T> bindToLifecycle() {
		return RxLifecycleAndroid.bindActivity(lifecycleSubject);
	}


}
