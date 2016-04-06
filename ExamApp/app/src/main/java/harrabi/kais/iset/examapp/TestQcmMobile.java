package harrabi.kais.iset.examapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.Date;

public class TestQcmMobile extends AppCompatActivity {

    EditText date, nomPren, classe;
    Button eval;
    String dateTxt, nomPrenTxt, classeTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_qcm_mobile);
        date = (EditText) findViewById(R.id.dateEdit);
        nomPren = (EditText) findViewById(R.id.nomPrenEdit);
        classe = (EditText) findViewById(R.id.classeEdit);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        date.setText(currentDateTimeString);
        eval = (Button) findViewById(R.id.evalBtn);
        eval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dateTxt = date.getText().toString();
                nomPrenTxt = nomPren.getText().toString();
                classeTxt = classe.getText().toString();
                Intent send = new Intent(getApplicationContext(), QcmActivity.class);
             //   send.putExtra("date", dateTxt);
                send.putExtra("nomPren", nomPrenTxt);
                send.putExtra("classe", classeTxt);
                startActivity(send);
                finish();

            }
        });
    }
}
