package suwuttipoj.nantapak.takienfloatingmarket;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.ibs.ctdm.chromecustomtab.customtab.CustomTabActivityHelper;
import com.ibs.ctdm.chromecustomtab.customtab.WebviewFallback;

public class MainActivity extends AppCompatActivity {

    private CustomTabActivityHelper mCustomTabActivityHelper;

    private String URL = "http://www.nantapak.wtkarea.com/Wattakien/index.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickMaps(View view) {
        // maps

        String destination = 13.828199+","+100.422972; // กำหนดปลายทางแบบพิกัด Lat ,Lng
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q="+destination));
        startActivity(intent);

    }

    public void clickMember(View view) {

        if(isOnline()){
            setupCustomTabHelper();
            openCustomTab();
        }else
        {
            Toast.makeText(this, "No Internet ", Toast.LENGTH_SHORT).show();
        }

//        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//        startActivity(intent);

    }
    public void clickWattakien(View view) {


        Intent intent = new Intent(MainActivity.this, Mainactivity_Psalm.class);
        startActivity(intent);


    }
    public void clickMarketfloting(View view) {


                Intent intent = new Intent(MainActivity.this, Travel_MainActivity.class);
        startActivity(intent);


    }
    public void clickInformation(View view) {

        Intent intent = new Intent(MainActivity.this, Mainactivity_News.class);
        startActivity(intent);

    }
//    public void clickReligious(View view) {
//        //  Activity
//        Intent intent = new Intent(MainActivity.this, ReligiousActivity.class);
//        startActivity(intent);
//
//    }
    public void clickHistory (View view) {
        if (LocaleHelper.getLanguage(getApplicationContext()).equals("th")) {
            File_Confix_Data.position_id_lng = 0;
            File_Confix_Data.titel_lng = "ภาษาไทย";
            Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
            startActivity(intent);

        } else {
            File_Confix_Data.position_id_lng = 1;
            LocaleHelper.setLocale(getApplicationContext(), "en");
            File_Confix_Data.titel_lng = "ภาษาอังกฤษ";
            Intent intent = new Intent(MainActivity.this, HistoryActivity2.class);
            startActivity(intent);
        }
    }


    private void setupCustomTabHelper() {
        mCustomTabActivityHelper = new CustomTabActivityHelper();
        mCustomTabActivityHelper.setConnectionCallback(mConnectionCallback);
        mCustomTabActivityHelper.mayLaunchUrl(Uri.parse(URL), null, null);
    }
    private void openCustomTab() {

        //ตัวแปรนี้จะให้ในการกำหนดค่าต่างๆ ที่ข้างล่างนี้
        CustomTabsIntent.Builder intentBuilder = new CustomTabsIntent.Builder();
        //กำหนดสีของ Action bar
        intentBuilder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary));


//        //กำหนดชื่อบน Action bar
//        intentBuilder.setShowTitle(true);
//
//        //กำหนดรูปให้ปุ่ม back, default จะเป็นปุ่มกากบาท
//        intentBuilder.setCloseButtonIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_arrow_back)); //ควรไปทำใน background thread

//        //สร้างปุ่มบน Option Menu item แบบมีรูป
//        intentBuilder.setActionButton(BitmapFactory.decodeResource(getResources(), R.drawable.ic_share), "Share", createPendingShareIntent()); //ปุ่ม share ที่มี icon

//        //สร้างปุ่มบน Option Menu item แบบไม่มีรูป
//        PendingIntent menuItemPendingIntent = createPendingShareIntent();
//        intentBuilder.addMenuItem("Share", menuItemPendingIntent);
//
//        //กำหนดให้มี Animation เมื่อ Custom tab เข้ามาและออกไป ถ้าไม่มีจะเหมือน Activity ที่เด้งเข้ามาเลย
        setAnimation(intentBuilder);

        //Launch Custome tab ให้ทำงาน
        CustomTabActivityHelper.openCustomTab(
                this, intentBuilder.build(), Uri.parse(URL), new WebviewFallback());
    }
    private void setAnimation(CustomTabsIntent.Builder intentBuilder) {
        intentBuilder.setStartAnimations(this, android.R.anim.slide_out_right, android.R.anim.slide_in_left);
        intentBuilder.setExitAnimations(this, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    // You can use this callback to make UI changes
    private CustomTabActivityHelper.ConnectionCallback mConnectionCallback = new CustomTabActivityHelper.ConnectionCallback() {
        @Override
        public void onCustomTabsConnected() {
            Toast.makeText(MainActivity.this, "Connected to service", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCustomTabsDisconnected() {
            Toast.makeText(MainActivity.this, "Disconnected from service", Toast.LENGTH_SHORT).show();
        }
    };
    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}
