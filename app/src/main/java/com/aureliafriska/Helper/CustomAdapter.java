package com.aureliafriska.Helper;

/**
 * Created by user on 21/07/2017.
 */
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;


import com.aureliafriska.Model.Data;
import com.aureliafriska.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

/**
 * Created by Oclemy on 7/15/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class CustomAdapter  extends BaseAdapter{

    Context c;
    ArrayList<Data> data;
    public CustomAdapter(Context c, ArrayList<Data> Data_list) {
        this.c = c;
        this.data = Data_list;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view==null)
        {
            view=LayoutInflater.from(c).inflate(R.layout.model,viewGroup,false);

        }

        TextView tanggalTxt= (TextView) view.findViewById(R.id.tanggal);
        TextView keluhanTxt= (TextView) view.findViewById(R.id.keluhan);
        TextView statusTxt= (TextView) view.findViewById(R.id.status);
        Data data= (Data) this.getItem(i);

        final String tanggal=data.getNama();
        final String keluhan= data.getEmail();
        final String status = data.getAsalIns();

        tanggalTxt.setText(tanggal);
        keluhanTxt.setText(keluhan);
        statusTxt.setText(status);

        if (i % 2 == 0) {
            view.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            view.setBackgroundColor(Color.parseColor("#f2efef"));
        }
        return view;
    }


}
