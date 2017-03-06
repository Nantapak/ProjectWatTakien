package suwuttipoj.nantapak.takienfloatingmarket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class EditUser extends AppCompatActivity {

    //Expilcit
    private String tab = "23DecV3", tag1 = "23decV4", tag2 = "23decV5", tag3 = "27decV1";
    private String userIDString, PREFIX_ID, showPREFIX,
            PROVINCE_ID, showPROVINCE, AMPHUR_ID, showAMPHUR;
    private TextView prefixTextView;
    private Spinner prefixSpinner;
    private TextView provinceTextView;
    private Spinner provinceSpinner;
    private TextView amphurTextView;
    private Spinner amphurSpinner;
    private EditText MEM_FIRSTNAMEditText;
    private EditText MEM_LASTNAMEditText;
    private EditText MEM_ADDRESSEditText;
    private Button button;
    private String updateMEM_FIRSTNAME, updatePREFIX_ID, updateMEM_LASTNAME,
    updateMEM_ADDRESS, updatePROVINCE_ID, updateAMPHUR_ID;
    private boolean prefixABoolean, provinceABoolean, amphurABoolean = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        //Bind Widget
        bindWidget();

        //Setup
        userIDString = getIntent().getStringExtra("USER_ID");
        Log.d(tab, "USER_ID ==>" + userIDString);


        //Get Value From menID
        getValueFormMemID();

        //Create Prefix Spinner
        createPrefixSpinner();

        //Create Province Spinner
        createProvinceSpinner();

        //Create Amphur Spinner
        createAmphurSpinner();

        //Button Controller
        buttonController();


    }   // Main method

    private void buttonController() {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateMEM_FIRSTNAME = MEM_FIRSTNAMEditText.getText().toString();
                updateMEM_LASTNAME = MEM_LASTNAMEditText.getText().toString();
                updateMEM_ADDRESS = MEM_ADDRESSEditText.getText().toString();

                Log.d("23decV6", "updatePREFIX ==>" + updatePREFIX_ID);
                Log.d("23decV6", "updateMEM_FIRSTNAME ==>" + updateMEM_FIRSTNAME);
                Log.d("23decV6", "updateMEM_LASTNAME ==>" + updateMEM_LASTNAME);
                Log.d("23decV6", "updateMEM_ADDRESS ==>" + updateMEM_ADDRESS);
                Log.d("23decV6", "updatePROVINCE_ID ==>" + updatePROVINCE_ID);
                Log.d("23decV6", "updateAMPHUR_ID ==>" + updateAMPHUR_ID);



            }   // onClick
        });

    }

    private void createPrefixSpinner() {

        String urlJSON = "http://swiftcodingthai.com/ton/get_prefix.php";

        try {

            MySynAll mySynAll = new MySynAll(EditUser.this);
            mySynAll.execute(urlJSON);
            String s = mySynAll.get();
            Log.d(tag2, "JSON ==>" + s);
            final boolean[] b = {false};

            JSONArray jsonArray = new JSONArray(s);
            final String[] prefixStrings = new String[jsonArray.length()];
            for (int i=0;i<jsonArray.length();i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                prefixStrings[i] = jsonObject.getString("PREFIX_NAME");

            }//for

            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(EditUser.this,
                    android.R.layout.simple_list_item_1, prefixStrings);
            prefixSpinner.setAdapter(stringArrayAdapter);

            prefixSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    if (b[0]) {
                        prefixTextView.setText(prefixStrings[position]);

                        Log.d("23decV6", "Work in onItem");

                        if (prefixABoolean) {
                            updatePREFIX_ID = Integer.toString(position + 1);
                        } else {

                            prefixABoolean = true;
                        }

                        Log.d("23decV6", "updatePRE ==>" + updatePREFIX_ID);

                    } else {
                        b[0] = true;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        } catch (Exception e) {
            Log.d(tag2, "e createSpinner ==>" + e.toString());

        }
    } //PREFIX

    private void createProvinceSpinner() {

        String urlJSON = "http://swiftcodingthai.com/ton/get_province.php";

        try {

            MySynAll mySynAll = new MySynAll(EditUser.this);
            mySynAll.execute(urlJSON);
            String s = mySynAll.get();
            Log.d(tag3, "JSON ==>" + s);
            final boolean[] b = {false};

            JSONArray jsonArray = new JSONArray(s);
            final String[] provinceStrings = new String[jsonArray.length()];
            for (int i=0;i<jsonArray.length();i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                provinceStrings[i] = jsonObject.getString("PROVINCE_NAME");

            }//for

            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(EditUser.this,
                    android.R.layout.simple_list_item_1, provinceStrings);
            provinceSpinner.setAdapter(stringArrayAdapter);

            provinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    if (b[0]) {
                        provinceTextView.setText(provinceStrings[position]);

                        Log.d("27decV2", "Work in onItem");

                        if (provinceABoolean) {
                            updatePROVINCE_ID = Integer.toString(position + 1);
                        } else {

                            provinceABoolean = true;
                        }

                        Log.d("27decV2", "updatePRO ==>" + updatePROVINCE_ID);

                    } else {
                        b[0] = true;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        } catch (Exception e) {
            Log.d(tag3, "e createSpinner ==>" + e.toString());

        }
    } //PROVINCE

    private void createAmphurSpinner() {

        String urlJSON = "http://swiftcodingthai.com/ton/get_amphur.php";

        try {

            MySynAll mySynAll = new MySynAll(EditUser.this);
            mySynAll.execute(urlJSON);
            String s = mySynAll.get();
            Log.d(tag3, "JSON ==>" + s);
            final boolean[] b = {false};

            JSONArray jsonArray = new JSONArray(s);
            final String[] amphurStrings = new String[jsonArray.length()];
            for (int i=0;i<jsonArray.length();i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                amphurStrings[i] = jsonObject.getString("AMPHUR_NAME");

            }//for

            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(EditUser.this,
                    android.R.layout.simple_list_item_1, amphurStrings);
            amphurSpinner.setAdapter(stringArrayAdapter);

            amphurSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    if (b[0]) {
                        amphurTextView.setText(amphurStrings[position]);

                        Log.d("27decV2", "Work in onItem");

                        if (amphurABoolean) {
                            updateAMPHUR_ID = Integer.toString(position + 1);
                        } else {

                            amphurABoolean = true;
                        }

                        Log.d("27decV2", "updateAMPHUR ==>" + updateAMPHUR_ID);

                    } else {
                        b[0] = true;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        } catch (Exception e) {
            Log.d(tag3, "e createSpinner ==>" + e.toString());

        }
    } //AMPHUR

    private void bindWidget() {

        prefixTextView = (TextView) findViewById(R.id.textView24);
        prefixSpinner = (Spinner) findViewById(R.id.spinner4);
        provinceTextView = (TextView) findViewById(R.id.textView31);
        provinceSpinner = (Spinner) findViewById(R.id.spinner5);
        amphurTextView = (TextView) findViewById(R.id.textView32);
        amphurSpinner = (Spinner) findViewById(R.id.spinner6);
        MEM_FIRSTNAMEditText = (EditText) findViewById(R.id.editText5);
        MEM_LASTNAMEditText = (EditText) findViewById(R.id.editText6);
        MEM_ADDRESSEditText = (EditText) findViewById(R.id.editText11);
        button = (Button) findViewById(R.id.button);


    }

    public void  getValueFormMemID() {

        String urlJSON = "http://swiftcodingthai.com/ton/get_member_where_menID.php";

        try {
            MySynchronize mySynchronize = new MySynchronize(EditUser.this);
            mySynchronize.execute("MEM_ID", userIDString, urlJSON);
            String s = mySynchronize.get();
            Log.d(tab, "JSON of getValueFromMenID ==>" + s);

            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);

            PREFIX_ID = jsonObject.getString("PREFIX_ID");
            updatePREFIX_ID = PREFIX_ID;
            Log.d(tag1, "PREFIX_ID ==>" + PREFIX_ID);
            showPREFIX = findPREFIX(PREFIX_ID);
            prefixTextView.setText(showPREFIX);

            PROVINCE_ID = jsonObject.getString("PROVINCE_ID");
            updatePROVINCE_ID = PROVINCE_ID;
            Log.d(tag1, "PROVINCE_ID ==>" + PROVINCE_ID);
            showPROVINCE = findPROVINCE(PROVINCE_ID);
            provinceTextView.setText(showPROVINCE);

            AMPHUR_ID = jsonObject.getString("AMPHUR_ID");
            updateAMPHUR_ID = AMPHUR_ID;
            Log.d(tag1, "AMPHUR_ID ==>" + AMPHUR_ID);
            showAMPHUR = findAMPHUR(AMPHUR_ID);
            amphurTextView.setText(showAMPHUR);



            MEM_FIRSTNAMEditText.setText(jsonObject.getString("MEM_FIRSTNAME"));
            MEM_LASTNAMEditText.setText(jsonObject.getString("MEM_LASTNAME"));
            MEM_ADDRESSEditText.setText(jsonObject.getString("MEM_ADDRESS"));

            mySynchronize.cancel(true);

        } catch (Exception e) {

            Log.d(tab, "e getValue ==>" + e.toString());
        }
    }   //getValue

    private String findPREFIX(String prefix_id) {

        String result = null;
        String urlJSON = "http://swiftcodingthai.com/ton/get_prefix_where.php";

        try {

            MySynchronize mySynchronize = new MySynchronize(EditUser.this);
            mySynchronize.execute("PREFIX_ID", prefix_id, urlJSON);
            String s = mySynchronize.get();
            Log.d(tag1, "JSON ==>" + s);

            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            result = jsonObject.getString("PREFIX_NAME");



        } catch (Exception e) {
            Log.d(tag1, "e findPREFIX ==> " + e.toString());
        }

        return result;
    }   //PREFIX

    private String findPROVINCE(String province_id) {
        String result = null;
        String urlJSON = "http://swiftcodingthai.com/ton/get_province_where.php";

        try {
            MySynchronize mySynchronize = new MySynchronize(EditUser.this);
            mySynchronize.execute("PROVINCE_ID", province_id, urlJSON);
            String s = mySynchronize.get();
            Log.d("28decV1", "JSON ==> " + s);

            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            result = jsonObject.getString("PROVINCE_NAME");

        } catch (Exception e) {
            Log.d("28decV1", "e findPROVINCE ==>" + e.toString());
        }
        return result;
    }   //PROVINCE

    private String findAMPHUR(String amphur_id) {
        String result = null;
        String urlJSON = "http://swiftcodingthai.com/ton/get_amphur_where_province.php";

        try {
            MySynchronize mySynchronize = new MySynchronize(EditUser.this);
            mySynchronize.execute("AMPHUR_ID", amphur_id, urlJSON);
            String s = mySynchronize.get();
            Log.d("28decV1", "JSON ==> " + s);

            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            result = jsonObject.getString("AMPHUR_NAME");

        } catch (Exception e) {
            Log.d("28decV1", "e findAMPHUR ==>" + e.toString());
        }
        return result;
    }   //AMPHUR
}   //Main Class
