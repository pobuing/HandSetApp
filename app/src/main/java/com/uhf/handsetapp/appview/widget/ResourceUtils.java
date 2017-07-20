package com.uhf.handsetapp.appview.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/**
 * explain:
 * Describe：
 * wx
 * 2017/7/20 14:35
 * Good Luck
 */

public class ResourceUtils {
    /**
     * 获取资源字符串
     *
     * @param context
     * @param strId
     * @return
     */
    public static String getStringResource(Context context, int strId) {
        if (strId != 0) {
            return context.getResources().getString(strId);
        }

        return null;
    }

    /**
     * 读取application 节点  meta-data 信息
     */
    public static String readMetaDataFromApplication(Context context, String key) {
        try {
            ApplicationInfo appInfo = context.getPackageManager()
                    .getApplicationInfo(context.getPackageName(),
                            PackageManager.GET_META_DATA);
            return appInfo.metaData.getString(key);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
