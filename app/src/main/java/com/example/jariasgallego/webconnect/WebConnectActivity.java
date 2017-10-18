package com.example.jariasgallego.webconnect;

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

    }
}
