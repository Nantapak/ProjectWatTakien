package suwuttipoj.nantapak.takienfloatingmarket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import suwuttipoj.nantapak.takienfloatingmarket.R;

/**
 * Created by MI6 on 11/27/2016.
 */

public class ShopAdapter extends BaseAdapter{

    //Expilcit
    private Context context;
    private String[] iconStrings, nameStrings, detailStrings;
    private ImageView imageView;
    private TextView nameTextView, detailTextView;

    public ShopAdapter(String[] detailStrings,
                       Context context,
                       String[] iconStrings,
                       String[] nameStrings) {
        this.detailStrings = detailStrings;
        this.context = context;
        this.iconStrings = iconStrings;
        this.nameStrings = nameStrings;
    }

    @Override
    public int getCount() {
        return iconStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.shop_listview, parent, false);

        //Bind Wiget
        imageView = (ImageView) view.findViewById(R.id.imageView12);
        nameTextView = (TextView) view.findViewById(R.id.textView12);
        detailTextView = (TextView) view.findViewById(R.id.textView18);

        //Show View
        Picasso.with(context).load(iconStrings[position]).into(imageView);
        nameTextView.setText(nameStrings[position]);
        detailTextView.setText(setupDetail(detailStrings[position]));


        return view;
    }

    private String setupDetail(String detailString) {

        String strResult = null;

        if (detailString.length() <= 80) {
            strResult = detailString;
        } else {
            strResult = detailString.substring(0, 40) + "...";
        }
        return strResult;
    }
}   // Main Class
