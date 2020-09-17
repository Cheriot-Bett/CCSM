package com.example.ccsm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private  RecyclerView.LayoutManager mLayoutManager;
    private static final String Tag = "MyActivity";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      //  recyclerView = findViewById(R.id.recycler);
        //recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
       // recyclerView.setLayoutManager(mLayoutManager);





        cmInterface cmInterface = RetrofitInstance.getRetrofitInstance().create(cmInterface.class);
        Call<List<Currencies>> call= cmInterface.getCurrencies();
        call.enqueue(new Callback<List<Currencies>>() {
            @Override
            public void onResponse(Call<List<Currencies>> call, Response<List<Currencies>> response) {
                if(!response.isSuccessful()) {
                List<Currencies>mCurrencies =response.body();
                 MyAdapter  myAdapter = new MyAdapter(mCurrencies,getApplicationContext());
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(mLayoutManager);

                    myAdapter.setCurrencies(mCurrencies);
                 recyclerView.setAdapter(myAdapter);


                    /*** .setText("code:" + response.code());***/


                    /***loop all over the data in our list
                     * append the data to our recycler view
                     */


                }
                Log.e( "success  no list",response.body().toString());
            }



            @Override
            public void onFailure(Call<List<Currencies>> call, Throwable t) {
                String error = t.getMessage();
                Log.e("failure",t.getLocalizedMessage());



            }
        });



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}