package test.message;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.*;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity{
    Button act, view;
    EditText nama, kp;
    SharedPreferences st;
    String android_id;

//    String status = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        act = (Button) findViewById(R.id.Activate);
        view = (Button) findViewById(R.id.view);
        nama = (EditText) findViewById(R.id.nama);
        kp = (EditText) findViewById(R.id.kp);
        android_id = Settings.Secure.getString( getBaseContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        FirebaseMessaging.getInstance().subscribeToTopic("test");
        FirebaseInstanceId.getInstance().getToken();


//        reg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Toast.makeText(MainActivity.this, "Berjaya", Toast.LENGTH_LONG).show();
//            }
//        });

//        st = getSharedPreferences("status", Context.MODE_PRIVATE);
//        status = st.getString("Status", null);

//        if(status.equals("active")){
//            act.setEnabled(false);
//        }
//        else
//            act.setEnabled(true);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent(getApplicationContext(), displayMessage.class);
                startActivity(i);
            }
        });


        act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInfo(android_id, nama.getText().toString(), kp.getText().toString());
                Toast.makeText(MainActivity.this, "Berjaya", Toast.LENGTH_LONG).show();
            }
        });


    }

    private void updateInfo(String token, String nama, String kp) {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("Token",token)
                .add("Nama",nama)
                .add("ic",kp)
                .build();

        Request UpdateReq = new Request.Builder()
                .url("http://192.168.1.104/androidMessage/update.php")
                .post(body)
                .build();

        try {
            client.newCall(UpdateReq).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
