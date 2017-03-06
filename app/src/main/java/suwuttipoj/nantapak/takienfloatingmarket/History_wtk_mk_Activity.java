//package suwuttipoj.nantapak.takienfloatingmarket;
//
//import android.content.Intent;
//import android.support.v4.app.FragmentActivity;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//public class History_wtk_mk_Activity extends FragmentActivity {
//    MypageAdapter adapter;
//    ViewPager pager;
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_history);
//
//        adapter = new MypageAdapter(getSupportFragmentManager());
//
//        pager = (ViewPager) findViewById(R.id.pager);
//        pager.setAdapter(adapter);
//
//        Button btn_next = (Button) findViewById(R.id.btnnext);
//        btn_next.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                pager.setCurrentItem(pager.getCurrentItem() + 1);
//            }
//        });
//
//        Button btn_prev = (Button) findViewById(R.id.btnprev);
//        btn_prev.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                pager.setCurrentItem(pager.getCurrentItem() - 1);
//            }
//        });
//
//    }
//}