package com.aureliafriska;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.aureliafriska.Helper.CustomAdapter;
import com.aureliafriska.Helper.DatabaseHelper;
import com.aureliafriska.Model.Data;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;


public class FragmentMusik extends Fragment {
    private DatabaseHelper databaseHelper;
    ListView lv;
    CustomAdapter adapter;
    public FragmentMusik() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_musik, container, false);
        databaseHelper = new DatabaseHelper(getActivity());
        lv = (ListView) view.findViewById(android.R.id.list);
        ArrayList<Data> Array = databaseHelper.getAllData();
        adapter = new CustomAdapter(getContext(),Array);
        lv.setAdapter(adapter);

        return view;
    }
    
}
