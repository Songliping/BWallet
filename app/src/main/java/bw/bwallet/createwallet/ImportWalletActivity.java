package bw.bwallet.createwallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import bw.bwallet.BaseActivity;
import bw.bwallet.R;

public class ImportWalletActivity extends BaseActivity implements View.OnClickListener{

    private TextView getPrivateKey,start_import;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_wallet);
        initView();
    }

    private void initView(){
        getPrivateKey = findViewById(R.id.get_private_key_btn);
        start_import = findViewById(R.id.start_import_wallet_btn);

    }
    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.get_private_key_btn:
                Toast.makeText(this,"获取私钥",Toast.LENGTH_SHORT).show();
                break;
            case R.id.start_import_wallet_btn:
                Toast.makeText(this,"开始导入",Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
