package com.example.palomino.pydes.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.palomino.pydes.MainActivity;
import com.example.palomino.pydes.R;


public class InicioFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Inicio");

        Button buttonChangeText = (Button) view.findViewById(R.id.buttonFragmentInbox);

         final TextView textViewInboxFragment = (TextView) view.findViewById(R.id.textViewInboxFragment);

        buttonChangeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewInboxFragment.setText(" Fragment inicio");
            }
        });

        return view;
    }

}
