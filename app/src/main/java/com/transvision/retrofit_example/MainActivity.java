package com.transvision.retrofit_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.transvision.retrofit_example.online.Response123;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button test_btn, post_btn;
    ApiInterface apiService;
    StringBuilder stringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test_btn = findViewById(R.id.test_button);
        post_btn = findViewById(R.id.post_button);

        test_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringBuilder = new StringBuilder();
                apiService = ApiClient.getTest1Client().create(ApiInterface.class);
                Call<Response123> call = apiService.getresponse();
                call.enqueue(new Callback<Response123>() {
                    @Override
                    public void onResponse(Call<Response123> call, Response<Response123> response) {
                        for (int i = 0; i < response.body().getItems().size(); i++) {
                            Log.d("debug", response.body().getItems().get(i).getSnippet().getTitle());
                        }
                    }

                    @Override
                    public void onFailure(Call<Response123> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });

        post_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringBuilder = new StringBuilder();
                apiService = ApiClient.getTestClient().create(ApiInterface.class);
                Call<List<MRLogin>> call = apiService.getlogin("54003799", "354016070557564", "12345");
                call.enqueue(new Callback<List<MRLogin>>() {
                    @Override
                    public void onResponse(Call<List<MRLogin>> call, Response<List<MRLogin>> response) {
                        /*for (int i = 0; i < response.body().size(); i++) {
                            Log.d("debug", ""+i+"\n"+response.body().get(i).getMRCODE());
                        }
                        */if (response.body().get(0).getMessage().equals("Success")) {
                            Toast.makeText(MainActivity.this, "Rocking Retrofit..", Toast.LENGTH_SHORT).show();
                        } else Toast.makeText(MainActivity.this, "Retrofit Failed..", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<List<MRLogin>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });
    }
}