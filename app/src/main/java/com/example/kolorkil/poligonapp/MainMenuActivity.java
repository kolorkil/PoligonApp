package com.example.kolorkil.poligonapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainMenuActivity extends ActionBarActivity {

    int x=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
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

    public void openConverterActivity(View view) {
        Intent intent = new Intent(this, UnitConverterActivity.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        if(x==0){
            Toast toast = Toast.makeText(
                    getApplicationContext(),
                    "Jeśli chcesz wyjść naciśnij 'Wstecz' ponownie",
                    Toast.LENGTH_SHORT);
            toast.show();
            x++;
        }
        else{
            System.exit(0);
        }
        Log.d("Tu dac package", "testowy komentarzownik");
    }
}
