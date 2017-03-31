package suwuttipoj.nantapak.takienfloatingmarket;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by MI6 on 9/3/2560.
 */

public class InitialFonts extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
        .setDefaultFontPath("fonts/bangna.ttf")
        .setFontAttrId(R.attr.fontPath)
        .build());
    }

}
