package harrabi.kais.iset.examapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class QcmActivity extends AppCompatActivity {
    Intent recevoir;
    RadioGroup rg;
    CheckBox repChech1, repChech2, repChech3;
    RadioButton rep1, rep2, rep3, repSelected;
    Button eval;
    String reponse1,reponse2, reponse3, reponse4, nom, classe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qcm);

        recevoir = getIntent();
        if (recevoir.getExtras() != null) {
            nom = recevoir.getExtras().getString("nomPren");
            classe = recevoir.getExtras().getString("classe");
        }
        rg = (RadioGroup) findViewById(R.id.rg1);

        rep1 = (RadioButton) findViewById(R.id.rep1);
        rep2 = (RadioButton) findViewById(R.id.rep2);
        rep3 = (RadioButton) findViewById(R.id.rep3);

        repChech1 = (CheckBox) findViewById(R.id.repCheck1);
        repChech2 = (CheckBox) findViewById(R.id.repCheck2);
        repChech3 = (CheckBox) findViewById(R.id.repCheck3);
        repChech1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    reponse2=repChech1.getText().toString();
                }else{
                    reponse2="";
                }

            }
        });
        repChech2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    reponse3=repChech2.getText().toString();
                }else{
                    reponse3="";
                }

            }
        });

        repChech3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    reponse4=repChech3.getText().toString();
                }else{
                    reponse4="";
                }

            }
        });
        eval = (Button) findViewById(R.id.evaluer);

        eval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rg.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                if(rg.isSelected()) {
                    repSelected = (RadioButton) findViewById(selectedId);
                    reponse1 = repSelected.getText().toString();
                }
                else
                reponse1 = rep1.getText().toString();

                Intent send = new Intent(getApplicationContext(), ResultatActivity.class);
                //   send.putExtra("date", dateTxt);
                send.putExtra("nom", nom);
                send.putExtra("classe", classe);
                send.putExtra("rep1", reponse1);
                send.putExtra("rep2", reponse2);
                send.putExtra("rep3", reponse3);
                send.putExtra("rep4", reponse4);
                startActivity(send);
                Toast.makeText(getApplicationContext(), "Attendez le resultat S.V.P ... ", Toast.LENGTH_LONG).show();
                finish();
            }
        });


    }
}
