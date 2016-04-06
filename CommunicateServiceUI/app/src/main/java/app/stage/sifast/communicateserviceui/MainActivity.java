package app.stage.sifast.communicateserviceui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends ActionBarActivity implements MyService.Callbacks{

    ToggleButton toggleButton;
    ToggleButton tbStartTask;
    TextView tvServiceState;
    TextView tvServiceOutput;
    Intent serviceIntent;
    MyService myService;
    int seconds;
    int minutes;
    int hours;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serviceIntent = new Intent(MainActivity.this, MyService.class);
        setViewsWidgets();
    }

    private void setViewsWidgets() {
        toggleButton = (ToggleButton)findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(btListener);
        tbStartTask = (ToggleButton)findViewById(R.id.tbStartServiceTask);
        tbStartTask.setOnClickListener(btListener);
        tvServiceState = (TextView)findViewById(R.id.tvServiceState);
        tvServiceOutput = (TextView)findViewById(R.id.tvServiceOutput);
    }

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            Toast.makeText(MainActivity.this, "onServiceConnected called", Toast.LENGTH_SHORT).show();
            // We've binded to LocalService, cast the IBinder and get LocalService instance
            MyService.LocalBinder binder = (MyService.LocalBinder) service;
            myService = binder.getServiceInstance(); //Get instance of your service!
            myService.registerClient(MainActivity.this); //Activity register in the service as client for callabcks!
            tvServiceState.setText("Connected to service...");
            tbStartTask.setEnabled(true);
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            Toast.makeText(MainActivity.this, "onServiceDisconnected called", Toast.LENGTH_SHORT).show();
            tvServiceState.setText("Service disconnected");
            tbStartTask.setEnabled(false);
        }
    };

    View.OnClickListener btListener =  new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v == toggleButton){
                if(toggleButton.isChecked()){
                    startService(serviceIntent); //Starting the service
                    bindService(serviceIntent, mConnection, Context.BIND_AUTO_CREATE); //Binding to the service!
                    Toast.makeText(MainActivity.this, "Button checked", Toast.LENGTH_SHORT).show();
                    tbStartTask.setEnabled(true);
                }else{
                    unbindService(mConnection);
                    stopService(serviceIntent);
                    Toast.makeText(MainActivity.this, "Button unchecked", Toast.LENGTH_SHORT).show();
                    tvServiceState.setText("Service disconnected");
                    tbStartTask.setEnabled(false);
                }
            }

            if(v == tbStartTask){
                if(tbStartTask.isChecked()){
                    myService.startCounter();
                }else{
                    myService.stopCounter();
                }

    }
        }
    };

    @Override
    public void updateClient(long millis) {
        seconds = (int) (millis / 1000) % 60 ;
        minutes = (int) ((millis / (1000*60)) % 60);
        hours   = (int) ((millis
 / (1000*60*60)) % 24);
        Log.i("time", (hours > 0 ? String.format("%d:", hours) : "") + ((this.minutes < 10 && this.hours > 0) ? "0" + String.format("%d:", minutes) : String.format("%d:", minutes)) + (this.seconds < 10 ? "0" + this.seconds : this.seconds));
        tvServiceOutput.setText((hours>0 ? String.format("%d:", hours) : "") + ((this.minutes<10 && this.hours > 0)? "0" + String.format("%d:", minutes) :  String.format("%d:", minutes)) + (this.seconds<10 ? "0" + this.seconds: this.seconds));
    }
}
