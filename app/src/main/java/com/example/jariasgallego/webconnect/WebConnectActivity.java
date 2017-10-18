package com.example.jariasgallego.webconnect;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.id.content;

public class WebConnectActivity extends AppCompatActivity {

    TextView content;
    EditText edit_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_connect);

        // canviem els atributs amb el onCreate, així quan s'inicia l'app, s'inicien els camps
       content = (TextView) findViewById(R.id.content);
       edit_url = (EditText) findViewById(R.id.url);
    }

    public void connect(View view) {

        String surl = edit_url.getText().toString(); // el text que has posat al edittext

        String cont = WebFetcher.getUrl(surl); // de la classe WebFetcher cridem la funció estàtica getURL
        content.setText(cont);

        new WebFetcherTask().execute(surl);  // nova tasca
    }


    private class WebFetcherTask extends AsyncTask<String, Void, String> {
        // la classe nova és un AsyncTask amb els paràmetres String, void i String.
        // El AsyncTask demana uns methods (alt+Enter) i et possa el DoInBackground (en segon pla)

        @Override
        protected String doInBackground(String... surls) { // és una taula pero nosaltres nomès farem servir una
            String cont = WebFetcher.getUrl(surls[0]);
            return cont;
        }

        @Override
        protected void onPostExecute(String cont) { // tornem al pla principal i actualitzem el TextView
            content.setText(cont);
        }
    }
}
