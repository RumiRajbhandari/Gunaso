package com.example.root.gunaso;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.util.ArrayList;

public class ListOfContrator extends AppCompatActivity {
    private ArrayList<ContratorModel> manpowerModels=new ArrayList<>();
    RecyclerView recyclerView;
    private Context context;

    private RecyclerView.LayoutManager mLayoutManage;
    CustomAdapter adapter;
    String url = "https://raw.githubusercontent.com/sushmagiri/json/master/d.json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_contrator);

        Intent intent = getIntent();
        String value = intent.getStringExtra("rumi");



        recyclerView=(RecyclerView)findViewById(R.id.list_of_contractor);
        recyclerView.setHasFixedSize(true);
        mLayoutManage=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManage);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        Gson gson=new Gson();
                        ArrayList<ContratorModel> manpowerItemList=gson.fromJson(response.toString(),new TypeToken<ArrayList<ContratorModel>>(){}.getType());
                        adapter=new CustomAdapter(manpowerItemList,ListOfContrator.this);
                        recyclerView.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

// Adding request to request queue
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonArrayRequest);
//        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS * 2, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
////        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
////                30000,
////                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
////                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//        Volley.newRequestQueue(this).add(jsonArrayRequest);

    }
}

