package com.example.apiproject2.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apiproject2.R;
import com.example.apiproject2.adapter.CountryAdapter;
import com.example.apiproject2.model.Countries;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CountryFragment extends Fragment {
    public CountryFragment() {
    }
    View view;
    RecyclerView recyclerView_country;
    TextView text_sea;
    ArrayList<Countries> listCountries=new ArrayList<Countries>();
    RequestQueue requestQueue;
    CountryAdapter adapter;

    String api_url="https://api.covid19api.com/summary";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_country, container, false);
        text_sea=view.findViewById(R.id.tv_search);
        recyclerView_country=view.findViewById(R.id.recyc_coun);
        recyclerView_country.setHasFixedSize(true);
        LinearLayoutManager layoutManager=new LinearLayoutManager(requireContext());
      layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
       recyclerView_country.setLayoutManager(layoutManager);


        //req_Vol
        requestQueue= Volley.newRequestQueue(getContext());

        StringRequest stringRequest=new StringRequest(Request.Method.GET, api_url, response -> {
            try {
                JSONObject jsonObject=new JSONObject(response);

                JSONArray countries=jsonObject.getJSONArray("Countries");

                GsonBuilder gsonBuilder=new GsonBuilder();
                Gson  gson=gsonBuilder.create();

                //display jsondata
                for(int i = 0; i<countries.length() ; i++){
                    Countries countries1 = gson.fromJson(String.valueOf(countries.getJSONObject(i)),Countries.class);
                    listCountries.add(countries1);
                }
                adapter=new CountryAdapter(getContext(),listCountries);
                recyclerView_country.setAdapter(adapter);


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d( "onErrorResponse: ",error.getMessage()+"");

            }
        });
        requestQueue.add(stringRequest);
        return  view;

    }
}