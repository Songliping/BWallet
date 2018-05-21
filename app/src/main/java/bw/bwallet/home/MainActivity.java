package bw.bwallet.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import java.util.function.Consumer;

import bw.bwallet.BaseActivity;
import bw.bwallet.R;
import bw.bwallet.asset.AddNewAssetFragment;
import bw.bwallet.asset.AssetFragment;
import bw.bwallet.asset.ManageWalletFragment;
import bw.bwallet.quotation.QuotationFragment;
import bw.bwallet.user.UserFragment;
import bw.bwallet.utils.Constant;
import bw.bwallet.utils.RxBus;
import io.reactivex.android.schedulers.AndroidSchedulers;
import rx.Observable;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {


    private RadioGroup tapView;

    private FragmentManager mFragmentManager;

    Fragment willShowFragment = null;//
    private Observable<Integer> mUpdateDataObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }


    private void initView() {

        mFragmentManager = getSupportFragmentManager();
        willShowFragment = AssetFragment.newInstance("", "");
        showFragment(willShowFragment);

        tapView = findViewById(R.id.radioGroup);

        tapView.setOnCheckedChangeListener(this);


//        mUpdateDataObservable = RxBus.get().register(Constant.REPLACE_FRAGMENT);
//        mUpdateDataObservable.observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer updateFragment) throws Exception {
//                        if (Constant.ADD_NEW_WALLET==updateFragment) {
//
//                            willShowFragment = AddNewAssetFragment.newInstance("", "");
//                            showFragment(willShowFragment);
//                        }else if (Constant.MANAGE_WALLET_FRAGMENT==updateFragment){
//                            willShowFragment = ManageWalletFragment.newInstance("", "");
//                            showFragment(willShowFragment);
//                        }
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//
//                    }
//                });
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.radio0:
                willShowFragment = AssetFragment.newInstance("", "");
                break;

            case R.id.radio1:
                willShowFragment = QuotationFragment.newInstance("", "");
                break;

            case R.id.radio2:
                willShowFragment = UserFragment.newInstance("", "");
                break;
        }


//        FragmentTransaction transaction = mFragmentManager.beginTransaction();
//        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//
//        transaction.replace(R.id.fragment_container, willShowFragment);
//        transaction.show(willShowFragment).commitAllowingStateLoss();


        showFragment(willShowFragment);
    }


    private void showFragment(Fragment fragment) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        transaction.replace(R.id.fragment_container, willShowFragment);
        transaction.show(willShowFragment).commitAllowingStateLoss();
    }
}
