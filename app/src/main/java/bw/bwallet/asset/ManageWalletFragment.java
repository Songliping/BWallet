package bw.bwallet.asset;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bw.bwallet.R;


public class ManageWalletFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView wallet_list_view;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ManageWalletFragment() {
        // Required empty public constructor
    }


    public static ManageWalletFragment newInstance(String param1, String param2) {
        ManageWalletFragment fragment = new ManageWalletFragment();
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

        View view = inflater.inflate(R.layout.fragment_manage_wallet, container, false);
        initView(view);
        return view;
    }


    private void initView(View view){
        wallet_list_view = view.findViewById(R.id.wallet_list_view);
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

}
