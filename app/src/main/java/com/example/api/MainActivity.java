package com.example.api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView list;

    public final String URL="https://api.publicapis.org/entries";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=findViewById(R.id.list);



        APIinterface apIinterface =  ApiClient.getApiclient().create(APIinterface.class);
        apIinterface.getdata().enqueue(new Callback<Modelclass>() {
            @Override
            public void onResponse(Call<Modelclass> call, Response<Modelclass> response) {

                Modelclass modelclass = response.body();
                APIAdapter adapter = new APIAdapter(MainActivity.this,modelclass.getEntries());
                list.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                list.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<Modelclass> call, Throwable t) {



            }
        });

    }
}