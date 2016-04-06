package tn.calculator.squeezer.calculatormaterialdesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonFloatSmall;
import com.gc.materialdesign.views.ButtonRectangle;

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
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

    public void eraseHandle(View view) {
        ButtonRectangle bc = (ButtonRectangle) view;
        Toast.makeText(getApplicationContext(), "erase", Toast.LENGTH_LONG).show();
        EditText editText = (EditText) findViewById(R.id.result);
        if (editText.getText().length() > 0)
            editText.setText("");
    }

    public void parenthHandler(View view) {
        ButtonRectangle bc = (ButtonRectangle) view;
        EditText editText = (EditText) findViewById(R.id.result);
        if (editText.getText().toString().contains("("))
            editText.setText(editText.getText().toString() + ")");
        else editText.setText(editText.getText().toString() + "(");

    }

    public void septHandler(View view) {
        ButtonRectangle b7 = (ButtonRectangle) view;
        EditText editText = (EditText) findViewById(R.id.result);

        editText.setText(editText.getText().toString() + "7");
    }

    public void huitHandler(View view) {

        ButtonRectangle b8 = (ButtonRectangle) view;
        EditText editText = (EditText) findViewById(R.id.result);

        editText.setText(editText.getText().toString() + "8");
    }

    public void neufHandler(View view) {

        ButtonRectangle b9 = (ButtonRectangle) view;
        EditText editText = (EditText) findViewById(R.id.result);

        editText.setText(editText.getText().toString() + "9");
    }

    public void foisHandler(View view) {

        ButtonRectangle bfois = (ButtonRectangle) view;
        EditText editText = (EditText) findViewById(R.id.result);

        editText.setText(editText.getText().toString() + "*");
    }

    public void quatreHandler(View view) {

        ButtonRectangle b4 = (ButtonRectangle) view;
        EditText editText = (EditText) findViewById(R.id.result);

        editText.setText(editText.getText().toString() + "4");
    }

    public void cinkHandler(View view) {

        ButtonRectangle b5 = (ButtonRectangle) view;
        EditText editText = (EditText) findViewById(R.id.result);

        editText.setText(editText.getText().toString() + "5");
    }

    public void sixHandler(View view) {

        ButtonRectangle b6 = (ButtonRectangle) view;
        EditText editText = (EditText) findViewById(R.id.result);

        editText.setText(editText.getText().toString() + "6");
    }

    public void moinsHandler(View view) {

        ButtonRectangle bmoins = (ButtonRectangle) view;
        EditText editText = (EditText) findViewById(R.id.result);

        editText.setText(editText.getText().toString() + "-");
    }

    public void unHandler(View view) {
        ButtonRectangle b1 = (ButtonRectangle) view;
        EditText editText = (EditText) findViewById(R.id.result);
        editText.setText(editText.getText().toString() + "1");
    }

    public void deuxHandler(View view) {

        ButtonRectangle b2 = (ButtonRectangle) view;
        EditText editText = (EditText) findViewById(R.id.result);

        editText.setText(editText.getText().toString() + "2");
    }

    public void troisHandler(View view) {

        ButtonRectangle b3 = (ButtonRectangle) view;
        EditText editText = (EditText) findViewById(R.id.result);

        editText.setText(editText.getText().toString() + "3");
    }

    public void plusHandler(View view) {

        ButtonRectangle bplus = (ButtonRectangle) view;
        EditText editText = (EditText) findViewById(R.id.result);

        editText.setText(editText.getText().toString() + "+");
    }

    public void virgHandler(View view) {

        ButtonRectangle bvirg = (ButtonRectangle) view;
        EditText editText = (EditText) findViewById(R.id.result);

        editText.setText(editText.getText().toString() + ",");
    }

    public void zeroHandler(View view) {

        ButtonRectangle b0 = (ButtonRectangle) view;
        EditText editText = (EditText) findViewById(R.id.result);

        editText.setText(editText.getText().toString() + "0");
    }

    public void negPosHandler(View view) {

        ButtonRectangle bnegPos = (ButtonRectangle) view;
        EditText editText = (EditText) findViewById(R.id.result);

        if (editText.getText().toString().lastIndexOf('-') > editText.getText().toString().lastIndexOf('+'))
            editText.setText(editText.getText().toString() + "+");
        else
            editText.setText(editText.getText().toString() + "-");
    }


    // fonction qui permet
    public void equalHandler(View view) {
        ButtonFloatSmall beq = (ButtonFloatSmall) view;
        Log.i("Result : ", "En cours...");
        EditText editText = (EditText) findViewById(R.id.result);
        editText.setText("it's only a template" +
                "");
    }

    // fonction qui permet de calculer le pourcentage
    public void pourcentHandler(View view) {
        ButtonRectangle b0 = (ButtonRectangle) view;
        EditText editText = (EditText) findViewById(R.id.result);

        editText.setText(editText.getText().toString() + "%");
    }

    public void divHandler(View view) {
        ButtonRectangle bdiv = (ButtonRectangle) view;
        EditText editText = (EditText) findViewById(R.id.result);

        editText.setText(editText.getText().toString() + "/");

    }
}
