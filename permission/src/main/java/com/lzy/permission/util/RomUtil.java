package com.lzy.permission.util;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import java.io.IOException;

/**
 * @author: cyli8
 * @date: 2018/7/30 17:40
 */
public class RomUtil {
    public static final String BRAND_XIAOMI = "xiaomi";
    public static final String BRAND_HUAWEI = "huawei";
    public static final String BRAND_OPPO = "oppo";
    public static final String BRAND_VIVO = "vivo";
    public static final String BRAND_SUMSUNG = "samsung";
    public static final String BRAND_COOLPAD = "coolpad";
    public static final String BRAND_CUHIZI = "smartisan";
    public static final String BRAND_MEIZU = "meizu";
    public static final String BRAND_LENOVO = "lenovo";
    public static final String BRAND_GIONEE = "GiONEE";
    public static final String BRAND_HONOR = "Honor";
    public static final String BRAND_LETV = "Letv";
    public static final String BRAND_QIKU = "QiKu";
    public static final String BRAND_SPRD = "SPRD";
    public static final String BRAND_LEECO = "LeEco";
    public static final String BRAND_NUBIA = "nubia";
    public static final String BRAND_OTHER = "other";
    private static String mPhoneType = null;


    /**
     * 获取手机类型
     *
     * @return
     */
    public static String getPhoneType() {
        if (null != mPhoneType) {
            return mPhoneType;
        }
        String brand = Build.BRAND;
        String user = Build.USER;
        String host = Build.HOST;
        String product = Build.PRODUCT;
        Log.e("cyli8", "brand = " + brand + ", user = " + user + ", host = " + host + ",product = " + product);

        if (BRAND_XIAOMI.equalsIgnoreCase(brand) || BRAND_XIAOMI.equalsIgnoreCase(user)) {
            mPhoneType = BRAND_XIAOMI;
        }
        if (BRAND_HUAWEI.equalsIgnoreCase(brand) || BRAND_HUAWEI.equalsIgnoreCase(user) || BRAND_HONOR.equalsIgnoreCase(brand)) {
            mPhoneType = BRAND_HUAWEI;
        }
        if (BRAND_OPPO.equalsIgnoreCase(brand) || BRAND_OPPO.equalsIgnoreCase(user)) {
            mPhoneType = BRAND_OPPO;
        }
        if (BRAND_VIVO.equalsIgnoreCase(brand) || BRAND_VIVO.equalsIgnoreCase(user)) {
            mPhoneType = BRAND_VIVO;
        }
        if (BRAND_SUMSUNG.equalsIgnoreCase(brand) || BRAND_SUMSUNG.equalsIgnoreCase(user)) {
            mPhoneType = BRAND_SUMSUNG;
        } else if (BRAND_COOLPAD.equalsIgnoreCase(brand) || BRAND_COOLPAD.equalsIgnoreCase(user)) {
            mPhoneType = BRAND_COOLPAD;
        } else if (BRAND_CUHIZI.equalsIgnoreCase(brand) || BRAND_CUHIZI.equalsIgnoreCase(user)) {
            mPhoneType = BRAND_CUHIZI;
        } else if (BRAND_MEIZU.equalsIgnoreCase(brand) || BRAND_MEIZU.equalsIgnoreCase(user)) {
            mPhoneType = BRAND_MEIZU;
        } else if (BRAND_LENOVO.equalsIgnoreCase(brand) || BRAND_LENOVO.equalsIgnoreCase(user)) {
            mPhoneType = BRAND_LENOVO;
        } else if (BRAND_GIONEE.equalsIgnoreCase(brand) || BRAND_GIONEE.equalsIgnoreCase(user)) {
            mPhoneType = BRAND_GIONEE;
        } else if (BRAND_LETV.equalsIgnoreCase(brand)) {
            mPhoneType = BRAND_LETV;
        } else if (BRAND_QIKU.equalsIgnoreCase(brand)) {
            mPhoneType = BRAND_QIKU;
        } else if (BRAND_SPRD.equalsIgnoreCase(brand)) {
            mPhoneType = BRAND_SPRD;
        } else if (BRAND_LEECO.equalsIgnoreCase(brand)) {
            mPhoneType = BRAND_LEECO;
        } else if (BRAND_NUBIA.equalsIgnoreCase(brand)) {
            mPhoneType = BRAND_NUBIA;
        }

        if (null == mPhoneType) {
            if (null == host) {
                host = "";
            } else {
                host = host.toLowerCase();
            }
            if (null == product) {
                product = "";
            } else {
                product = product.toLowerCase();
            }
            if (BRAND_XIAOMI.contains(host) || BRAND_XIAOMI.contains(product)) {
                mPhoneType = BRAND_XIAOMI;
            }
            if (BRAND_HUAWEI.contains(host) || BRAND_HUAWEI.contains(product)) {
                mPhoneType = BRAND_HUAWEI;
            }
            if (BRAND_OPPO.contains(host) || BRAND_OPPO.contains(product)) {
                mPhoneType = BRAND_OPPO;
            }
            if (BRAND_VIVO.contains(host) || BRAND_VIVO.contains(product)) {
                mPhoneType = BRAND_VIVO;
            }
            if (BRAND_SUMSUNG.contains(host) || BRAND_SUMSUNG.contains(product)) {
                mPhoneType = BRAND_SUMSUNG;
            }
            if (BRAND_COOLPAD.contains(host) || BRAND_COOLPAD.contains(product)) {
                mPhoneType = BRAND_COOLPAD;
            }
            if (BRAND_CUHIZI.contains(host) || BRAND_CUHIZI.contains(product)) {
                mPhoneType = BRAND_CUHIZI;
            }
            if (BRAND_MEIZU.contains(host) || BRAND_MEIZU.contains(product)) {
                mPhoneType = BRAND_MEIZU;
            }
            if (BRAND_LENOVO.contains(host) || BRAND_LENOVO.contains(product)) {
                mPhoneType = BRAND_LENOVO;
            }
            if (BRAND_GIONEE.contains(host) || BRAND_GIONEE.contains(product)) {
                mPhoneType = BRAND_GIONEE;
            } else if (BRAND_LETV.contains(host) || BRAND_LETV.contains(product)) {
                mPhoneType = BRAND_LETV;
            } else if (BRAND_QIKU.contains(host) || BRAND_QIKU.contains(product)) {
                mPhoneType = BRAND_QIKU;
            } else if (BRAND_SPRD.contains(host) || BRAND_SPRD.contains(product)) {
                mPhoneType = BRAND_SPRD;
            } else if (BRAND_LEECO.contains(host) || BRAND_LEECO.contains(product)) {
                mPhoneType = BRAND_LEECO;
            } else if (BRAND_NUBIA.contains(host) || BRAND_NUBIA.contains(product)) {
                mPhoneType = BRAND_NUBIA;
            }
        }
        if (null == mPhoneType) {
            mPhoneType = BRAND_OTHER;
        }

        return mPhoneType;
    }

    final static String MIUI_V5 = "v5";
    final static String MIUI_V6 = "v6";
    final static String MIUI_V7 = "v7";
    final static String MIUI_V8 = "v8";
    final static String MIUI_V9 = "v9";

    public static boolean isMIUI5(Context context) {
        String result = "";

        try {
            result = BuildProperties.newInstance().getProperty("ro.miui.ui.version.name");
        } catch (IOException var3) {
            var3.printStackTrace();
        }

        return "v5".equalsIgnoreCase(result);
    }

    public static boolean isMIUI6OrHigher(Context context) {
        String result = "";

        try {
            result = BuildProperties.newInstance().getProperty("ro.miui.ui.version.name");
        } catch (IOException var3) {
            var3.printStackTrace();
        }

        return "v6".equalsIgnoreCase(result) || "v7".equalsIgnoreCase(result) || "v8".equalsIgnoreCase(result) || "v9".equalsIgnoreCase(result);
    }
}
