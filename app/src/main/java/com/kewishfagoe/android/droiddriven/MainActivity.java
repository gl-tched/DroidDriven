package com.kewishfagoe.android.droiddriven;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
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


    public void loginCheck(View view) {
        EditText username = (EditText) findViewById(R.id.usernameField);
        String usernameValue = String.valueOf(username.getText());

        EditText password = (EditText) findViewById(R.id.passwordField);
        String passwordValue = String.valueOf(password.getText());

        String notification = "Verkeerde Username of Password. \n Probeer het nogmaals.";

        if (usernameValue.equals("Kewish") && passwordValue.equals("Kewish")) {
            onClickLoadDashboard();
        } else {
            Snackbar.make(view, notification, Snackbar.LENGTH_LONG).setAction("Action", null).show();
            //Toast.makeText(this, notification, Toast.LENGTH_LONG).show();
        }
    }

    public void onClickLoadDashboard() {
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }


}
