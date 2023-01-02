package com.example.apiproject2.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apiproject2.R;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;


public class HomeFragment extends Fragment {
    View view;
    TextView NewConfirmed,TotalConfirmed,NewDeaths,TotalDeaths,NewRecovered,TotalRecovered;
    RequestQueue requestQueue;
    String api_url="https://api.covid19api.com/summary";

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        requestQueue= Volley.newRequestQueue(getContext());


        NewConfirmed=view.findViewById(R.id.NewConfirmed);
        TotalConfirmed=view.findViewById(R.id.TotalConfirmed);
        NewDeaths=view.findViewById(R.id.NewDeaths);
        TotalDeaths=view.findViewById(R.id.TotalDeaths);
        NewRecovered=view.findViewById(R.id.NewRecovered);
        TotalRecovered=view.findViewById(R.id.TotalRecovered);

        StringRequest stringRequest=new StringRequest(Request.Method.GET, api_url, response -> {
            try {
                JSONObject jsonObject=new JSONObject(response);
                JSONObject global=jsonObject.getJSONObject("Global");

                String NewConfirmed_=global.getString("NewConfirmed");
                NewConfirmed.setText(NewConfirmed_);

                String TotalConfirmed_=global.getString("TotalConfirmed");
                TotalConfirmed.setText(TotalConfirmed_);

                String NewDeaths_=global.getString("NewDeaths");
                NewDeaths.setText(NewDeaths_);

                String TotalDeaths_=global.getString("TotalDeaths");
                TotalDeaths.setText(TotalDeaths_);

                String NewRecovered_=global.getString("NewRecovered");
                NewRecovered.setText(NewRecovered_);

                String TotalRecovered_=global.getString("TotalRecovered");
                TotalRecovered.setText(TotalRecovered_);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> Log.d("Error",error.getMessage()+" ")
        );
        requestQueue.add(stringRequest);
        return  view;


    }

      /*
        "NewConfirmed": 100282,
    "TotalConfirmed": 1162857,
    "NewDeaths": 5658,
    "TotalDeaths": 63263,
    "NewRecovered": 15405,
    "TotalRecovered": 230845
         */

}