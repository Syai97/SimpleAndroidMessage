package test.message;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class displayMessage extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView message2;
    Button back, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        message2 = (TextView) findViewById(R.id.message);
        back = (Button) findViewById(R.id.back);
        clear = (Button) findViewById(R.id.clear);
        sharedPreferences = getSharedPreferences("Message", Context.MODE_PRIVATE);
        String message = sharedPreferences.getString("MessageText",null);

        message2.setText(message);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message2.setText(null);

                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.clear();
                edit.apply();
            }
        });
    }
}
