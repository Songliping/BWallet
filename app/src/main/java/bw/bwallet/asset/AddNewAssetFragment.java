package bw.bwallet.asset;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import bw.bwallet.R;
import bw.bwallet.adapter.CommonAdapter;
import bw.bwallet.adapter.SpacesItemDecoration;
import bw.bwallet.adapter.ViewHolder;


public class AddNewAssetFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView newAssetRcyView;
    private LinearLayoutManager mLayoutManager;
    private CommonAdapter<String> mAdapter;
    private List<String> list;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public AddNewAssetFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static AddNewAssetFragment newInstance(String param1, String param2) {
        AddNewAssetFragment fragment = new AddNewAssetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list = new ArrayList<String>();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_new_asset, container, false);

        initView(view);
        request();

        return view;
    }

    private void initView(View view){

        newAssetRcyView = view.findViewById(R.id.new_asset_kind_rv);

        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        newAssetRcyView.setLayoutManager(mLayoutManager);
        int itemSpace = getResources().
                getDimensionPixelSize(R.dimen.length_10dp);
        newAssetRcyView.addItemDecoration(new SpacesItemDecoration(itemSpace,itemSpace));
        DefaultItemAnimator animator = new DefaultItemAnimator();
        newAssetRcyView.setItemAnimator(animator);

        mAdapter = new CommonAdapter<String>(getContext(),R.layout.new_add_asset_item,list) {

            @Override
            protected void convert(ViewHolder holder, String str, int position) {

                holder.setText(R.id.add_new_asset_item_kind,str);
            }
        };

        newAssetRcyView.setAdapter(mAdapter);
    }


    private void request(){

        for (int i=0;i<4;i++){
            list.add("ETH");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

}
