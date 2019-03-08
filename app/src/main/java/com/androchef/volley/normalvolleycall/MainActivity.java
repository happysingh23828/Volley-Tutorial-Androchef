package com.androchef.volley.normalvolleycall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.androchef.volley.R;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnLoadList;
    ProgressBar progressBar;
    RecyclerView recyclerView;
    CustomRecyclerAdapter adapter;
    List<Worldpopulation> listOfWorldPopulations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setRecyclerView();
        onClicks();
    }

    private void init() {
        btnLoadList = findViewById(R.id.btn_load_list);
        progressBar = findViewById(R.id.progress_bar);
        recyclerView = findViewById(R.id.flag_list_recyclerView);
        adapter = new CustomRecyclerAdapter(listOfWorldPopulations, this);
    }


    private void setRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }


    private void onClicks() {
        btnLoadList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadWorldPopulationListFromVolley();
            }
        });
    }

    private void loadWorldPopulationListFromVolley() {
        //Showing Progress while fetching data from server
        progressBar.setVisibility(View.VISIBLE);

        //Our End point from where we will get our json data
        String url = "http://androchef.com/wp-content/uploads/2019/03/world-population-androchef.txt";

        //We will get response as string and we will convert it into List<WorldPopulation> object
        StringRequest fetchWorldPopulationRequest = new StringRequest(StringRequest.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                //converting json string response to List of WorldPopulation objects :-)
                List<Worldpopulation> worldpopulationList = new Gson().fromJson(response, new TypeToken<List<Worldpopulation>>(){}.getType());

                //updating or notifying adapter to show latest fetched list
                listOfWorldPopulations.clear();
                listOfWorldPopulations.addAll(worldpopulationList);
                adapter.notifyDataSetChanged();

                //hide progress bar
                progressBar.setVisibility(View.GONE);
            }

            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                //hide progress bar
                progressBar.setVisibility(View.GONE);

                //when we got some network error while fetching data
                Toast.makeText( MainActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }

        });

        //Creating a new request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //adding this fetchWorldPopulationRequest to in queue and executing it.
        requestQueue.add(fetchWorldPopulationRequest);
    }
}
