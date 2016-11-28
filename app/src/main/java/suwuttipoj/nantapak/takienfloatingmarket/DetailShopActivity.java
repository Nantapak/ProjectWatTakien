package suwuttipoj.nantapak.takienfloatingmarket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailShopActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private TextView detailView;
    private String textString, imageString, detailString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_shop);

        //Bind Widget
        imageView = (ImageView) findViewById(R.id.imageView13);
        textView = (TextView) findViewById(R.id.textView21);
        detailView = (TextView) findViewById(R.id.textView23);

        //Get Value From Intent
        textString = getIntent().getStringExtra("Name");
        imageString = getIntent().getStringExtra("Image");
        detailString = getIntent().getStringExtra("Detail");

        //Show View
        Picasso.with(DetailShopActivity.this).load(imageString).into(imageView);
        textView.setText(textString);
        detailView.setText(detailString);
    }
}
