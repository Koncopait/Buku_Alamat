package com.aureliafriska;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.aureliafriska.Helper.DatabaseHelper;
import com.aureliafriska.Model.Data;

import org.w3c.dom.Text;

import java.util.Locale;


public class FragmentBuku extends Fragment {

    public FragmentBuku() {}
    private EditText et_nama,et_email,et_nohp,et_asalIns,et_alamatIns,et_noTelp,et_fax;
    private TextView bruto,ppn,pph,netto;
    AlertDialog alertDialog;
    ProgressDialog pDialog;
    RadioGroup rg;
    Button simpan;
    private DatabaseHelper databaseHelper;
    private RadioButton rb1,rb2,rb3,rb4;
    double pajak;
    Data data;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buku, container, false);
        et_nama = (EditText) view.findViewById(R.id.et_Nama);
        et_email = (EditText) view.findViewById(R.id.et_Email);
        et_nohp = (EditText) view.findViewById(R.id.et_noHp);
        et_asalIns = (EditText) view.findViewById(R.id.et_Instansi);
        et_alamatIns = (EditText) view.findViewById(R.id.et_AlamatIns);
        et_noTelp = (EditText) view.findViewById(R.id.et_NoTelp);
        et_fax = (EditText) view.findViewById(R.id.et_Fax);
        simpan = (Button) view.findViewById(R.id.btn_simpan);
        databaseHelper = new DatabaseHelper(getActivity());
        data = new Data();
        alertDialog = new AlertDialog.Builder(getActivity()).create();
        pDialog = new ProgressDialog(getActivity());


        final TextInputLayout lay_nama = (TextInputLayout) view.findViewById(R.id.input_layout_Nama);
        final TextInputLayout lay_email = (TextInputLayout) view.findViewById(R.id.input_layout_Email);
        final TextInputLayout lay_noHp = (TextInputLayout) view.findViewById(R.id.input_layout_noHp);
        final TextInputLayout lay_asalIns = (TextInputLayout) view.findViewById(R.id.input_layout_Instansi);
        final TextInputLayout lay_alamatIns = (TextInputLayout) view.findViewById(R.id.input_layout_AlamatIns);
        final TextInputLayout lay_noTelp = (TextInputLayout) view.findViewById(R.id.input_layout_NoTelp);
        final TextInputLayout lay_fax = (TextInputLayout) view.findViewById(R.id.input_layout_Fax);
        et_nama.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(et_nama.getText().toString())){
                    lay_nama.setError("Masukkan Nama");
                }else {
                    lay_nama.setError(null);
                }
            }
        });

        et_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(et_email.getText().toString())){
                    lay_email.setError("Masukkan Email");
                }else {
                    lay_email.setError(null);
                }
            }
        });

        et_nohp.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(et_nohp.getText().toString())){
                    lay_noHp.setError("Masukkan No Hp");
                }else {
                    lay_noHp.setError(null);
                }
            }
        });

        et_asalIns.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(et_asalIns.getText().toString())){
                    lay_asalIns.setError("Masukkan Asal Instansi");
                }else {
                    lay_asalIns.setError(null);
                }
            }
        });

        et_alamatIns.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(et_alamatIns.getText().toString())){
                    lay_alamatIns.setError("Masukkan Alamat Instansi");
                }else {
                    lay_alamatIns.setError(null);
                }
            }
        });

        et_noTelp.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(et_noTelp.getText().toString())){
                    lay_noTelp.setError("Masukkan No Telepon");
                }else {
                    lay_noTelp.setError(null);
                }
            }
        });

        et_fax.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(et_fax.getText().toString())){
                    lay_fax.setError("Masukkan Nomor Fax");
                }else {
                    lay_fax.setError(null);
                }
            }
        });

        simpan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                alertDialog.setTitle("Status");
                pDialog.setMessage("Mohon Tunggu...");
                pDialog.setIndeterminate(false);
                pDialog.setCancelable(false);
                pDialog.show();
                String nama = et_nama.getText().toString();
                String email = et_email.getText().toString();
                String noHp = et_nohp.getText().toString();
                String asalIns = et_asalIns.getText().toString();
                String alamatIns = et_alamatIns.getText().toString();
                String noTelp = et_noTelp.getText().toString();
                String fax = et_fax.getText().toString();


                data.setNama(nama);
                data.setEmail(email);
                data.setNoHp(noHp);
                data.setAsalIns(asalIns);
                data.setAlamatIns(alamatIns);
                data.setNoTelp(noTelp);
                data.setFax(fax);
                databaseHelper.addUser(data);

                new CountDownTimer(5000, 5000) {
                    public void onFinish() {
                        pDialog.dismiss();
                        alertDialog.setMessage("Data Berhasil Dimasukkan");
                        alertDialog.show();
                    }

                    public void onTick(long millisUntilFinished) {
                        // millisUntilFinished    The amount of time until finished.
                    }
                }.start();

            }
        });
        return view;
    }

}
