package com.example.kolorkil.poligonapp;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class UnitConverterActivity extends ActionBarActivity {

    EditText editFrom;
    EditText editTo;
    Button unit1Button;
    Button unit2Button;
    Button catButton;
    Integer selection=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter);
         editFrom = (EditText)findViewById(R.id.editText);
         editTo=(EditText)findViewById(R.id.editText2);
         unit1Button=(Button)findViewById(R.id.button);
         unit2Button=(Button)findViewById(R.id.button2);
         catButton=(Button)findViewById(R.id.button4);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_unit_converter, menu);
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

    public void change1Unit(View view) {
    }

    public void change2Unit(View view) {
    }

    public void changeCategory(View view) {
        final String[] kategorie = {"Temperatura","Odległość", "Waluta", "Prędkość"};
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Wybierz kategorię");
        dialog.setItems(kategorie, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                catButton.setText(kategorie[which]);
            }
        });
        dialog.create();
        dialog.show();
    }

    public void count(View view) {

    }

    public void copyData(View view) {
        int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.text.ClipboardManager clipboardManager = (android.text.ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            clipboardManager.setText(editTo.getText().toString());
        }
    }

    public void pasteData(View view) {
        android.text.ClipboardManager clipboardManager = (android.text.ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        editFrom.setText(clipboardManager.getText());
    }
}
