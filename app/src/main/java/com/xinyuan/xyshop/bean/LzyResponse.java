package com.xinyuan.xyshop.bean;

import com.xinyuan.xyshop.entity.ApiSpecialItem;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fx on 2017/5/3 0003.
 */

public class LzyResponse<T> implements Serializable {

	private static final long serialVersionUID = 5213230387175987834L;

	public int code;
	public T datas;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getDatas() {
		return datas;
	}

	public void setDatas(T datas) {
		this.datas = datas;
	}

	@Override
	public String toString() {
		return "LzyResponse{" +
				"code=" + code +
				", datas=" + datas +
				'}';
	}




}
