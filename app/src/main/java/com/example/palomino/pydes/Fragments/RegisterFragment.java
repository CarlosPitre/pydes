package com.example.palomino.pydes.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.palomino.pydes.MainActivity;
import com.example.palomino.pydes.Fragments.RegisterFragment;
import com.example.palomino.pydes.R;


public class RegisterFragment extends BaseFragment {

    private Button Btnlogin;
    private ArrayAdapter<CharSequence>  adapter ;
    private Spinner SpSoy;


    public RegisterFragment() {
        // Required empty public constructor
    }

    public static RegisterFragment newInstance() {
        RegisterFragment fragment = new RegisterFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        // Inflate the layout for this fragment
          final View view = inflater.inflate(R.layout.fragment_register, container, false);
          ((MainActivity) getActivity()).getSupportActionBar().setTitle("Registro");
           return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        // cargar un Spiner(combo) con el array de opciones
        SpSoy = (Spinner) view.findViewById(R.id.SpSoy);
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.mobile_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpSoy.setAdapter(adapter);

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
