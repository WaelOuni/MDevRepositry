package android.rnu.iit.premierapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button geoButton, sendButton, appelButton, dataButton;
    Intent received;
    String loginReceived;
    Intent intent, chooser;
    String phone = "+21699663587";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        received = getIntent();
        loginReceived = received.getStringExtra("login");
        geoButton = (Button) findViewById(R.id.geoButton);
        sendButton = (Button) findViewById(R.id.sendButton);
        appelButton = (Button) findViewById(R.id.appelButton);
        dataButton = (Button) findViewById(R.id.showButton);


        geoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:35.0275393,9.4563917"));
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                else

                    chooser = intent.createChooser(intent, "Select geo application");
                startActivity(chooser);
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                //you   can
                String[] TO = {"waelounie@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, TO);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Salut, c'est message à part de mon application");
                intent.putExtra(Intent.EXTRA_TEXT, "opaa, Testez mon app ");
                intent.setType("message/rfc822");
                chooser = Intent.createChooser(intent, "Send mail");
                startActivity(chooser);

            }
        });

        dataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TestSimpleListView.class));
                Toast.makeText(getApplicationContext(), "redirect vers data show", Toast.LENGTH_LONG);

            }
        });



        appelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do    appel
                call();
            }
        });
    }

    public void call() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phone));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(callIntent);
    }


}
