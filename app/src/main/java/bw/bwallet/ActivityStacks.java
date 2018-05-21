package bw.bwallet;

import android.app.Activity;

import java.util.Stack;

/**
 * 项目名称:         CBoxTV
 * 包名:            tv.newtv
 * 创建事件:         18:23
 * 创建人:           weihaichao
 * 创建日期:          2018/5/7
 */
public class ActivityStacks {

    private static ActivityStacks instance;
    private Stack<BaseActivity> activities = new Stack<>();

    public static ActivityStacks get() {
        if (instance == null) {
            synchronized (ActivityStacks.class) {
                if (instance == null) instance = new ActivityStacks();
            }
        }
        return instance;
    }

    public void onCreate(BaseActivity activity) {
        activities.push(activity);
    }

    /**
     * 获取当前Activity
     *
     * @return
     */
    public BaseActivity getCurrentActivity() {
        return activities.peek();
    }


    /**
     * 关闭当前Acitivity
     */
    public void FinishActivity() {
        activities.pop().finish();
    }

    /**
     * finish all Activity
     */
    public void finishAllActivity() {
        if (activities == null) {
            return;
        }
        try {
            for (Activity activity : activities) {
                activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        activities.clear();
    }


    /**
     * 销毁Activity
     *
     * @param activity
     */
    public void onDestroy(BaseActivity activity) {
        if (!activities.empty()) {
            if (activities.peek() == activity) {
                activities.pop();
            } else {
                int index = activities.search(activity);
                if (index != -1 && index < activities.size()) {
                    activities.remove(index);
                }
            }
        }
    }


}
