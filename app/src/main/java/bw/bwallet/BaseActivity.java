package bw.bwallet;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;

import com.trello.rxlifecycle2.components.support.RxFragmentActivity;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.util.function.Consumer;

import bw.bwallet.asset.AddNewAssetFragment;
import bw.bwallet.asset.ManageWalletFragment;
import bw.bwallet.utils.Constant;
import bw.bwallet.utils.RxBus;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import rx.Observable;

public class BaseActivity extends RxFragmentActivity {


    private int states = 1;
    public Web3j web3;
    private Observable<Integer> mUpdateDataObservable;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSysTextSize();//一定要放在setContentView之前，全局改变字体大小
        setContentView(R.layout.activity_base);
        ActivityStacks.get().onCreate(this);
        initWeb3j();

    }


    private void initWeb3j(){

        io.reactivex.Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> e) throws Exception {
                web3 = Web3jFactory.build(new HttpService());  // defaults to http://localhost:8545/
                Web3ClientVersion web3ClientVersion = null;
                try {
                    web3ClientVersion = web3.web3ClientVersion().send();
                    String clientVersion = web3ClientVersion.getWeb3ClientVersion();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new io.reactivex.functions.Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean value) throws Exception {
//                        isinit = value;
//                        Log.i(TAG, "logsdk初始化结果：" + value);
                    }
                });

    }
//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
//            View decorView = getWindow().getDecorView();
//            decorView.setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
////                            | View.SYSTEM_UI_FLAG_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//        }
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityStacks.get().onDestroy(this);
    }

    private void  setSysTextSize(){
        if (1 == states) {
            setTheme(R.style.Default_TextSize_Small);


        } else if (2 == states) {


            setTheme(R.style.Default_TextSize_Middle);
        } else {


            setTheme(R.style.Default_TextSize_Big);


        }
    }
}
