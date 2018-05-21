package bw.bwallet.asset;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import bw.bwallet.R;
import bw.bwallet.utils.Constant;
import bw.bwallet.utils.RxBus;


public class AssetFragment extends Fragment implements View.OnClickListener{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ArrayList<View> pageview;
    private ViewPager viewPager;
    private Button asset_add_btn;

    public AssetFragment() {
        // Required empty public constructor
    }


    public static AssetFragment newInstance(String param1, String param2) {
        AssetFragment fragment = new AssetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_asset, container, false);
        initView(view);
        return view;
    }



    private void initView(View view){
        viewPager = (ViewPager) view.findViewById(R.id.asset_viewPager);
        asset_add_btn = view.findViewById(R.id.asset_add_btn);




        asset_add_btn.setOnClickListener(this);
        //查找布局文件用LayoutInflater.inflate
        LayoutInflater inflater =getLayoutInflater();
        View view1 = inflater.inflate(R.layout.asset_item_layout, null);
        View view2 = inflater.inflate(R.layout.asset_item_layout, null);
        View view3 = inflater.inflate(R.layout.asset_item_layout, null);

        //将view装入数组
        pageview =new ArrayList<View>();
        pageview.add(view1);
        pageview.add(view2);
        pageview.add(view3);

        //绑定适配器
        viewPager.setAdapter(mPagerAdapter);
    }



    //数据适配器
    PagerAdapter mPagerAdapter = new PagerAdapter(){

        @Override
        //获取当前窗体界面数
        public int getCount() {
            // TODO Auto-generated method stub
            return pageview.size();
        }

        @Override
        //断是否由对象生成界面
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0==arg1;
        }
        //是从ViewGroup中移出当前View
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView(pageview.get(arg1));
        }

        //返回一个对象，这个对象表明了PagerAdapter适配器选择哪个对象放在当前的ViewPager中
        public Object instantiateItem(View arg0, int arg1){
            ((ViewPager)arg0).addView(pageview.get(arg1));
            return pageview.get(arg1);
        }


    };


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.asset_add_btn:
                RxBus.get().post(Constant.REPLACE_FRAGMENT,Constant.ADD_NEW_WALLET);

                break;
        }
    }
}
