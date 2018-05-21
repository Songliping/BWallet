package bw.bwallet.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bw.bwallet.BaseActivity;
import bw.bwallet.R;

public class ChangePwdActivity extends BaseActivity {


    /**
     * 修改密码
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pwd);
    }
}
