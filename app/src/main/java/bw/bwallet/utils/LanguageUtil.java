package bw.bwallet.utils;

/**
 * Created by Administrator on 2018/5/9.
 */

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

import java.util.Locale;

/**
 * 语言切换
 * Created by 41455 on 2016/10/13.
 */
public class LanguageUtil {
    /**
     * @param isEnglish true  ：点击英文，把中文设置未选中
     *                  false ：点击中文，把英文设置未选中
     */
    public static void set(Context context,boolean isEnglish) {

        Configuration configuration = context.getResources().getConfiguration();
        DisplayMetrics displayMetrics =context.getResources().getDisplayMetrics();
        if (isEnglish) {
            //设置英文
            configuration.locale = Locale.ENGLISH;
        } else {
            //设置中文
            configuration.locale = Locale.SIMPLIFIED_CHINESE;
        }
        //更新配置
        context.getResources().updateConfiguration(configuration, displayMetrics);
    }

}
