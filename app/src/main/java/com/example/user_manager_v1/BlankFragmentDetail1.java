package com.example.user_manager_v1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentDetail1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentDetail1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragmentDetail1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragmentDetail1.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentDetail1 newInstance(String param1, String param2) {
        BlankFragmentDetail1 fragment = new BlankFragmentDetail1();
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
        View view =inflater.inflate(R.layout.fragment_blank_detail1, container, false);


        TextView MyTextView= (TextView) view.findViewById(R.id.buttongoRelance);

        MyTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setReorderingAllowed(true)

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_acceuil2, new BlankFragmentDeatail2() ).addToBackStack("state1").commit();
            }
        });




        // Inflate the layout for this fragment
        return view;

    }
}