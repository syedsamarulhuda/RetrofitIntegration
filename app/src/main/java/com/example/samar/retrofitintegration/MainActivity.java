package com.example.samar.retrofitintegration;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import retrofit.RestAdapter;

public class MainActivity extends AppCompatActivity {


    private static final String API_URL = "http://freemusicarchive.org/api";
    private static final String API_KEY = "-------";
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        BackgroundTask task = new BackgroundTask();
        task.execute();
    }


    private class BackgroundTask extends AsyncTask<Void, Void,
                Curator> {
        RestAdapter restAdapter;

        @Override
        protected void onPreExecute() {
            restAdapter = new RestAdapter.Builder()
                    .setEndpoint(API_URL)
                    .build();
        }

        @Override
        protected Curator doInBackground(Void... params) {
            IApiMethods methods = restAdapter.create(IApiMethods.class);
            Curator curators = methods.getCurators(API_KEY);

            return curators;
        }

        @Override
        protected void onPostExecute(Curator curators) {
            textView.setText(curators.title + "\n\n");
            for (Curator.Dataset dataset : curators.dataset) {
                textView.setText(textView.getText() + dataset.curator_title +
                        " - " + dataset.curator_tagline + "\n");
            }
        }
    }
}
