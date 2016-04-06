package ouni.wael.mdev.testdistantdatabasegson;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestDistantDbGson extends AppCompatActivity {
    public static String SERVER_URL = "http://10.0.2.2/testdb.php";
    private RecyclerView lv;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_distant_db_gson);
        new TestParser().execute();
    }
    public String getJSON(String url, int timeout) {
        HttpURLConnection c = null;
        try {
            URL u = new URL(url);
            c = (HttpURLConnection) u.openConnection();
            c.setRequestMethod("GET");
            c.setRequestProperty("Content-length", "0");
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);
            c.setConnectTimeout(timeout);
            c.setReadTimeout(timeout);
            c.connect();
            int status = c.getResponseCode();
            switch (status) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();
                    return sb.toString();
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (c != null) {
                try {
                    c.disconnect();
                } catch (Exception ex) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    public void loadFromWebService(TestItem[] items) {

        for (int i = 0; i <items.length ; i++
                ) {
            Log.i("bd data", items[i].getNom());
        }
    }

    private class TestParser extends AsyncTask<Void, Void, String[]> {
        private static final String TAG = "TestDBParser";

        @Override
        protected String[] doInBackground(Void... params) {
            String data = getJSON(SERVER_URL, 50000);
            String[] datas = new String[1];
            datas[0] = data;
            return datas;
        }

        @Override
        protected void onPostExecute(String[] datas) {
            super.onPostExecute(datas);
            TestItem[] testdb;
            testdb = new Gson().fromJson(datas[0], TestItem[].class);
            loadFromWebService(testdb);
            lv = (RecyclerView) findViewById(R.id.lv);

            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            lv.setHasFixedSize(true);

            // use a linear layout manager
            mLayoutManager = new LinearLayoutManager(TestDistantDbGson.this);
            lv.setLayoutManager(mLayoutManager);

            // specify an adapter (see also next example)
            mAdapter = new MyAdapter(testdb);
            lv.setAdapter(mAdapter);

        }
    }

}
