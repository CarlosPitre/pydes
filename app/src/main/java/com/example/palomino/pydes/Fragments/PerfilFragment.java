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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.palomino.pydes.MainActivity;
import com.example.palomino.pydes.R;

public class PerfilFragment extends BaseFragment {


    private ArrayAdapter<CharSequence>  adapter ;
    private Spinner SpSoy;
    private Spinner SpCountry;


    private Button BtnRegister;
    private CheckBox ChBoxHombre;
    private CheckBox ChBoxMujer;
    private CheckBox ChBoxParejas;
    private CheckBox ChBoxTSTVTG;

    private EditText TxtMounth;
    private EditText TxtDay;
    private EditText TxtYear;



    private OnFragmentInteractionListener mListener;

    public PerfilFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance() {
        PerfilFragment fragment = new PerfilFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Perfil");
        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       // profils = new Profils ();


        // cargar un Spiner(combo) con el array de opciones (quien soy)
        SpSoy = (Spinner) view.findViewById(R.id.SpSoy);
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.mobile_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpSoy.setAdapter(adapter);

        // cargar un Spiner(combo) con el array de opciones (Countrics)
        SpCountry = (Spinner) view.findViewById(R.id.SpCountry);
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Countrics_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpCountry.setAdapter(adapter);

        ChBoxHombre = (CheckBox)  view.findViewById(R.id.ChBoxHombre);
        ChBoxMujer = (CheckBox)  view.findViewById(R.id.ChBoxMujer);
        ChBoxParejas = (CheckBox)  view.findViewById(R.id.ChBoxParejas);
        ChBoxTSTVTG = (CheckBox)  view.findViewById(R.id.ChBoxTSTVTG);

        TxtMounth =  (EditText) view.findViewById(R.id.TxtMounth);
        TxtDay =  (EditText) view.findViewById(R.id.TxtMounth);
        TxtYear =  (EditText) view.findViewById(R.id.TxtMounth);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
