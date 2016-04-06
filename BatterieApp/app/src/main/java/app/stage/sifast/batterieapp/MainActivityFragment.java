package app.stage.sifast.batterieapp;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ProgressBar bar=null;
    private ImageView status=null;
    private ImageView status_2=null;
    private TextView level=null;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_main, container, false);
        bar=(ProgressBar)result.findViewById(R.id.bar);
        status=(ImageView)result.findViewById(R.id.status);
        status_2=(ImageView)result.findViewById(R.id.status_2);
        level=(TextView)result.findViewById(R.id.level);
        return(result);
    }

    @Override
    public void onResume() {
        super.onResume();
        IntentFilter f=new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        getActivity().registerReceiver(onBattery, f);
    }

    @Override
    public void onPause() {
        getActivity().unregisterReceiver(onBattery);
        super.onPause();
    }

    BroadcastReceiver onBattery=new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            int pct=        100 * intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 1)
                            / intent.getIntExtra(BatteryManager.EXTRA_SCALE, 1);
            bar.setProgress(pct);
            level.setText(String.valueOf(pct));

            switch (intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)) {
                case BatteryManager.BATTERY_STATUS_CHARGING:
                    status.setImageResource(R.drawable.charging);
                    break;
                case BatteryManager.BATTERY_STATUS_FULL:
                    int plugged=
                            intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);

                    if (plugged == BatteryManager.BATTERY_PLUGGED_AC
                            || plugged == BatteryManager.BATTERY_PLUGGED_USB) {
                        status.setImageResource(R.drawable.full);
                    }
                    else {
                        status.setImageResource(R.drawable.unnplugged);
                    }
                    break;

                default:
                    status.setImageResource(R.drawable.unnplugged);
                    break;
            }
        }
    };
}