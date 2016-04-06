package harrabi.kais.iset.examapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Date;

public class ResultatActivity extends AppCompatActivity {

    String reponse1,reponse2, reponse3, reponse4, nom, classe;
    EditText dateEdit, nomPrenEdit, classeEdit, scoreEdit;
    Button quitter;
    long count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        Intent recevoir;
        recevoir = getIntent();
        if (recevoir.getExtras() != null) {
            nom = recevoir.getExtras().getString("nom");
            classe = recevoir.getExtras().getString("classe");
            reponse1 = recevoir.getExtras().getString("rep1");
            reponse2 = recevoir.getExtras().getString("rep2");
            reponse3 = recevoir.getExtras().getString("rep3");
            reponse4 = recevoir.getExtras().getString("rep4");
          }

        dateEdit = (EditText) findViewById(R.id.dateEdit);
        nomPrenEdit = (EditText) findViewById(R.id.nomPreonEditRes);
        classeEdit = (EditText) findViewById(R.id.classeEditRes);
        scoreEdit = (EditText) findViewById(R.id.scoreEdit);
        quitter = (Button) findViewById(R.id.finBtn);

        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        dateEdit.setText(currentDateTimeString);

        if (TextUtils.equals(reponse1,getResources().getString(R.string.rep_juste))){

            Log.i("rep1"," "+  reponse1);
            count++;
        }
        if (!TextUtils.isEmpty(reponse2)){

            Log.i("rep2"," "+ reponse2);
            count++;}
        if (!TextUtils.isEmpty(reponse3)){

            Log.i("rep3"," "+  reponse3);
            count++;}
        if (TextUtils.isEmpty(reponse4)){

            Log.i("rep4"," "+  reponse4);
            count++;}

        long result = (count * 100) / 4;

        Log.i("test", reponse1 + reponse2 + reponse3 + reponse4);
        nomPrenEdit.setText(nom);
        classeEdit.setText(classe);
        scoreEdit.setText(" " + result);
        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"A bientot :)", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
