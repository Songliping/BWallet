package bw.bwallet.createwallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import bw.bwallet.BaseActivity;
import bw.bwallet.PwdDialog;
import bw.bwallet.R;

public class BackupWalletActivity extends BaseActivity implements View.OnClickListener{



    private TextView backup_wallet,important_prompt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backup_wallet);
        initView();
    }


    private void initView(){
        backup_wallet = findViewById(R.id.backup_wallet_tv);
        important_prompt = findViewById(R.id.important_prompt);
        backup_wallet.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.backup_wallet_tv:
                important_prompt.setVisibility(View.GONE);
                PwdDialog.showPwdDialog(this);
            break;


        }

    }
}
