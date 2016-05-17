package www.suonsamnang.com.spinnerexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import petrov.kristiyan.colorpicker.ColorPicker;

public class MainActivity extends AppCompatActivity {

    Spinner ddlSnacks;
    Button btnColorPicker;
    Spinner ddlTextSize;
    int couleurChoisie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<String> data = new ArrayList<>();
        data.add("Cupcake");
        data.add("Donut");
        data.add("Eclair");
        data.add("Froyo");
        data.add("Gingerbread");
        data.add("Honeycomb");
        data.add("Icre Cream Sandwich");
        data.add("Jelly Bean");
        data.add("Kitkat");
        data.add("Lollipop");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_layout, data);
        ddlSnacks = (Spinner) findViewById(R.id.ddlCandy);
        ddlSnacks.setAdapter(adapter);
        ddlSnacks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ddlSnacks.setBackgroundColor(couleurChoisie);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnColorPicker = (Button) findViewById(R.id.btnColorPicker);
        btnColorPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorPicker colorPicker = new ColorPicker(MainActivity.this);
                colorPicker.setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                    @Override
                    public void onChooseColor(int position, int color) {
                        couleurChoisie = color;
                        btnColorPicker.setBackgroundColor(color);
                        TextView spinnerLayout = (TextView) findViewById(R.id.spinnerTarget);
                        spinnerLayout.setBackgroundColor(color);
                    }
                }).show();
            }
        });

        List<Integer> textSize = new ArrayList<>();
        textSize.add(5);
        textSize.add(10);
        textSize.add(15);
        textSize.add(20);
        textSize.add(25);
        textSize.add(30);
        ArrayAdapter<Integer> textSizeAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, textSize);
        ddlTextSize = (Spinner) findViewById(R.id.ddlTextSize);
        ddlTextSize.setAdapter(textSizeAdapter);
        ddlTextSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView spinnerLayout = (TextView) findViewById(R.id.spinnerTarget);
                spinnerLayout.setTextSize(Integer.parseInt( ddlTextSize.getSelectedItem().toString() ));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
