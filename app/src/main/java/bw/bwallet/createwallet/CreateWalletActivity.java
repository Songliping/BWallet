package bw.bwallet.createwallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import bw.bwallet.BaseActivity;
import bw.bwallet.R;

public class CreateWalletActivity extends BaseActivity implements View.OnClickListener {



    private TextView create_wallet_btn,import_wallet_btn;
    private EditText name,pwd,repeat_pwd,prompt;
    private String name_value,pwd_value,repeat_pwd_value,prompt_value;
    private CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_wallet);

        initView();



    }


    private void initView(){
        name = findViewById(R.id.name_wallet_et);
        pwd = findViewById(R.id.pwd_wallet_et);
        repeat_pwd = findViewById(R.id.repeat_pwd_wallet_et);
        prompt = findViewById(R.id.prompt_pwd_info_wallet_et);
        cb = findViewById(R.id.user_protocol_cb);

        create_wallet_btn = findViewById(R.id.create_wallet_btn);
        import_wallet_btn = findViewById(R.id.import_wallet_btn);
        create_wallet_btn.setOnClickListener(this);
        import_wallet_btn.setOnClickListener(this);

    }

    private String getString(){

        name_value = name.getText().toString().trim();
        pwd_value = pwd.getText().toString().trim();
        repeat_pwd_value = repeat_pwd.getText().toString().trim();
        prompt_value = prompt.getText().toString().trim();

        if (TextUtils.isEmpty(name_value)){
            return getString(R.string.name_not_empty);
        }
        if (TextUtils.isEmpty(pwd_value)){
            return getString(R.string.pwd_not_empty);
        }
        if (!pwd_value.equals(repeat_pwd_value)){
            return getString(R.string.pwd_not_same);
        }
        if (!cb.isChecked()){
            return getString(R.string.choose_user_protocol);
        }

        return "";
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.create_wallet_btn:
                String str = getString();
                if (!TextUtils.isEmpty(str)){
                    Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    ECKeyPair keyPair = Keys.createEcKeyPair();
                    String publicKey = Numeric.toHexStringNoPrefix(keyPair.getPublicKey());
                    String privatecKey = Numeric.toHexStringNoPrefix(keyPair.getPrivateKey());
                    String addr= "0x"+ Keys.getAddress(publicKey);

                    Log.e("MM","privatekey="+privatecKey+",publicKey="+publicKey+",addr="+addr);

                } catch (InvalidAlgorithmParameterException e) {
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (NoSuchProviderException e) {
                    e.printStackTrace();
                }

                Intent intent1 = new Intent(this,BackupWalletActivity.class);
                startActivity(intent1);
                break;

            case R.id.import_wallet_btn:
                Intent intent = new Intent(this,ImportWalletActivity.class);
                startActivity(intent);
                break;

        }
    }
}
