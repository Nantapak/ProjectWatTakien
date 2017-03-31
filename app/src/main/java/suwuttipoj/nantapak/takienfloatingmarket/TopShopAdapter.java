//package suwuttipoj.nantapak.takienfloatingmarket;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.squareup.picasso.Picasso;
//
///**
// * Created by masterUNG on 12/23/2016 AD.
// */
//
//public class TopShopAdapter extends BaseAdapter{
//
//    //Explicit
//    private Context context;
//    private String[] iconStrings, nameStrings, detailStrings, scoreStrings;
//    private ImageView imageView;
//    private TextView nameTextView, detailTextView, scoreTextView;
//
//    public TopShopAdapter(Context context,
//                          String[] iconStrings,
//                          String[] nameStrings,
//                          String[] detailStrings,
//                          String[] scoreStrings) {
//        this.context = context;
//        this.iconStrings = iconStrings;
//        this.nameStrings = nameStrings;
//        this.detailStrings = detailStrings;
//        this.scoreStrings = scoreStrings;
//    }
//
//    @Override
//    public int getCount() {
//        int i = iconStrings.length;
//        if (i >= 10) {
//            i = 10;
//        }
//        return i;  // only TopTen Shop
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//
//        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view1 = layoutInflater.inflate(R.layout.top_listview_layout, viewGroup, false);
//
//        //Bind Widget
//        nameTextView = (TextView) view1.findViewById(R.id.textView6);
//        detailTextView = (TextView) view1.findViewById(R.id.textView7);
//        scoreTextView = (TextView) view1.findViewById(R.id.textView11);
//        imageView = (ImageView) view1.findViewById(R.id.imageView16);
//
//        //Show View
//        nameTextView.setText(nameStrings[i]);
//        detailTextView.setText(setupDetail(detailStrings[i]));
//        scoreTextView.setText(scoreStrings[i] + " คะแนน");
//        Picasso.with(context).load(iconStrings[i]).into(imageView);
//
//        return view1;
//    }
//
//    private String setupDetail(String detailString) {
//
//        String strResult = null;
//
//        if (detailString.length() <= 80) {
//            strResult = detailString;
//        } else {
//            strResult = detailString.substring(0, 40) + "...";
//        }
//        return strResult;
//    }
//}   // Main Class
