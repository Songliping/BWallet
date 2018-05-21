package bw.bwallet.user;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bw.bwallet.R;
import bw.bwallet.transfer.TransferRecordActivity;
import bw.bwallet.utils.Constant;
import bw.bwallet.utils.RxBus;


public class UserFragment extends Fragment implements View.OnClickListener{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private TextView manage_wallet,trade_record;


    public UserFragment() {
        // Required empty public constructor
    }

    public static UserFragment newInstance(String param1, String param2) {
        UserFragment fragment = new UserFragment();
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
        View view =  inflater.inflate(R.layout.fragment_user, container, false);
        initView(view);
        return view;
    }

    private void initView(View view){

        manage_wallet = view.findViewById(R.id.manage_wallet_tv);
        trade_record = view.findViewById(R.id.trade_record_tv);

        manage_wallet.setOnClickListener(this);
        trade_record.setOnClickListener(this);

    }
    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.manage_wallet_tv:
                RxBus.get().post(Constant.REPLACE_FRAGMENT,Constant.MANAGE_WALLET_FRAGMENT);
                break;

            case R.id.trade_record_tv:
                Intent intent = new Intent(getActivity(), TransferRecordActivity.class);
                getActivity().startActivity(intent);
                break;

        }
    }
}
