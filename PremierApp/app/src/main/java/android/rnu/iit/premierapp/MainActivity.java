package android.rnu.iit.premierapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    EditText loginEdit , passwordEdit;
    String logStr, passwordStr;
    String login= "mdev";
    String password = "mdev";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginEdit = (EditText)findViewById(R.id.loginEdit);
        passwordEdit = (EditText)findViewById(R.id.passwordEdit);
    }

    public void clickButton(View view) {

        logStr=loginEdit.getText().toString();
        passwordStr=passwordEdit.getText().toString();
        if (logStr.equals(login) && passwordStr.equals(password))
        {
            intent = new Intent(getApplicationContext(), Main2Activity.class);
            intent.putExtra("login", logStr);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Verifié (y)", Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), "Hello android developer :)", Toast.LENGTH_LONG).show();
            finish();
        }
        else Toast.makeText(getApplicationContext(), "votre authentification est erroné !", Toast.LENGTH_LONG).show();
    }
}
