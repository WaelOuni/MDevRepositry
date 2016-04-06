package android.rnu.iit.premierapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TestSimpleListView extends AppCompatActivity {

ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        lv = (ListView) findViewById(R.id.dataListe);
        final String[] data = {"Android components", "Activity", "Content provider", "Broadcast receiver","Service", "Others features", "Fragments", "Toast", "ListView","Adapter", "ScrollView", "Intent"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item, data);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "Item "+ position+1 +" : "+ data[position], Toast.LENGTH_LONG).show();
            }
        });
    }
}
