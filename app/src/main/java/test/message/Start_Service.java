package test.message;

import android.app.Application;
import android.content.Intent;

/**
 * Created by Syaiful Fikri on 15/6/2017.
 */

public class Start_Service extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        startService(new Intent(this, Background_Service.class));
    }
}

