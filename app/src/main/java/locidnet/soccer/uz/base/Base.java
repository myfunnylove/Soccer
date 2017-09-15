package locidnet.soccer.uz.base;

import android.app.Application;
import android.content.Context;


import locidnet.soccer.uz.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Sarvar on 15.09.2017.
 */

public class Base extends Application {

    public static String TAG = "APPNAME";

    private static Context ctx;
    @Override
    public void onCreate() {
        super.onCreate();
        ctx = getApplicationContext();
        CalligraphyConfig.initDefault(
                new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/regular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build());

    }
    public static Context context(){
        return ctx;
    }

}
