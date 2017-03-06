package suwuttipoj.nantapak.takienfloatingmarket;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;


public class TabsMarketActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_market);




        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container02);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs02);
        tabLayout.setupWithViewPager(mViewPager);



    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {


        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        } //PlaceholderFragment

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                View rootView = inflater.inflate(R.layout.activity_marketfloating, container, false);
                ListView listView = (ListView) rootView.findViewById(R.id.livShop);

                try {

                    SynShop synShop = new SynShop(getContext());
                    synShop.execute();

                    String strJSON = synShop.get();

                    Log.d("27novV1", "JSON ==>" + strJSON);

                    JSONArray jsonArray = new JSONArray(strJSON);

                    final String[] nameStrings = new String[jsonArray.length()];
                    final String[] detailStrings = new String[jsonArray.length()];
                    final String[] iconStrings = new String[jsonArray.length()];

                    for (int i=0;i<jsonArray.length();i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        nameStrings[i] = jsonObject.getString("SHOP_NAME");
                        detailStrings[i] = jsonObject.getString("SHOP_DETAIL");
                        iconStrings[i] = jsonObject.getString("SHOP_IMAGE_FILE");
                    }   //for

                    ShopAdapter shopAdapter = new ShopAdapter(detailStrings,
                            getContext(), iconStrings, nameStrings);
                    listView.setAdapter(shopAdapter);

//                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                            Intent intent = new Intent(getContext(), DetailShopActivity.class);
//                            intent.putExtra("Image", iconStrings[position]);
//                            intent.putExtra("Name", nameStrings[position]);
//                            intent.putExtra("Detail", detailStrings[position]);
//                            startActivity(intent);
//
//                        }       //onItemClick
//                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return rootView;
            }
            else if (getArguments().getInt(ARG_SECTION_NUMBER) == 2)
            {   // Part 2
                View rootView = inflater.inflate(R.layout.top_listview, container, false);

                ListView listView = (ListView) rootView.findViewById(R.id.livTopShop);

                try {

                    SynScore synScore = new SynScore(getContext());
                    synScore.execute();
                    String s = synScore.get();
                    Log.d("23decV1", "JSON ==> " + s);

                    JSONArray jsonArray = new JSONArray(s);
                    final String[] nameStrings = new String[jsonArray.length()];
                    final String[] detailStrings = new String[jsonArray.length()];
                    final String[] scoreStrings = new String[jsonArray.length()];
                    final String[] iconStrings = new String[jsonArray.length()];

                    for (int i=0;i<jsonArray.length();i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        nameStrings[i] = jsonObject.getString("SHOP_NAME");
                        detailStrings[i] = jsonObject.getString("SHOP_DETAIL");
                        scoreStrings[i] = jsonObject.getString("Score");
                        iconStrings[i] = jsonObject.getString("SHOP_IMAGE_FILE");
                    }   //for

                    //Create ListView
                    TopShopAdapter topShopAdapter = new TopShopAdapter(getContext(),
                            iconStrings, nameStrings, detailStrings, scoreStrings);
                    listView.setAdapter(topShopAdapter);

//                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                            Intent intent = new Intent(getContext(), DetailShopActivity.class);
//                            intent.putExtra("Name", nameStrings[position]);
//                            intent.putExtra("Image", iconStrings[position]);
//                            intent.putExtra("Detail", detailStrings[position]);
//                            intent.putExtra("Score", scoreStrings[position] + " คะแนน");
//                            startActivity(intent);
//
//
//                        }// onItemClick
//                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }   // try

                return rootView;

            }   // end Part 2
            else if (getArguments().getInt(ARG_SECTION_NUMBER) == 3)
            {
                View rootView = inflater.inflate(R.layout.activity_diagramth, container, false);
                return rootView;
            }
            else
            {
                View rootView = inflater.inflate(R.layout.fragment_tabs_market, container, false);
                TextView textView = (TextView) rootView.findViewById(R.id.section_label02);
                textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
                return rootView;
            }

        } // onCreateView
    } //onPlateHolder

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "ร้านค้า";
                case 1:
                    return "ร้านค้ายอดนิยม";
                case 2:
                    return "พื้นที่ร้านค้า";
            }
            return null;
        }
    }
}   // Main Class
