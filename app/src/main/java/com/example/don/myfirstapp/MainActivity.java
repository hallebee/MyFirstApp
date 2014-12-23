package com.example.don.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void translate(View v){
        EditText localText = (EditText)findViewById(R.id.input1Text);


        String cleanedText = localText.getText().toString().toLowerCase().replaceAll("[^a-z]","");

        String response = "Eepbay!  Eeepbay!  Oesday otnay omputecay!!!";
        String resp1 = "initial";
        String resp2 = "initial";

        if( cleanedText.length() > 0) {
            String[] resps = cleanedText.split("[aeiouAEIOU]", 2);
            resp1 = resps[0];
            Integer resp1Length = resp1.length();
            resp2 = cleanedText.substring(resp1Length);

            if (resp1Length > 0) {
                response = resp2 + resp1 + "ay";
            } else {
                response = resp2 + resp1 + "way";
            }
        }

        String output = response.substring(0, 1).toUpperCase() + response.substring(1);

        if( cleanedText.length() > 10) {
            output = "Ermiekay!!!";
        }

        TextView translatedText =(TextView)findViewById(R.id.tranlatedText);
        translatedText.setText(output);
    }

    public void clearInput(View v){
        TextView inputText = (TextView)findViewById(R.id.input1Text);
        TextView translatedText =(TextView)findViewById(R.id.tranlatedText);

        inputText.setText("");
        translatedText.setText("");
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
