package com.xinyuan.xyshop.common;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by Administrator on 2017/5/26.
 */

public class ShopHelper {
	public static String getPriceString(double price) {
		return new DecimalFormat("0.00").format(price);
	}

	public static String getPriceString(BigDecimal price) {
		if (price != null) {
			return new DecimalFormat("0.00").format(price);
		}
		return "0.00";
	}
}
