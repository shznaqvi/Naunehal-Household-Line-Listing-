package edu.aku.hassannaqvi.naunehal_listing.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.naunehal_listing.R;
import edu.aku.hassannaqvi.naunehal_listing.contracts.ListingContract;
import edu.aku.hassannaqvi.naunehal_listing.core.MainApp;
import edu.aku.hassannaqvi.naunehal_listing.database.DatabaseHelper;
import edu.aku.hassannaqvi.naunehal_listing.databinding.ActivitySetupBinding;
import edu.aku.hassannaqvi.naunehal_listing.models.Listings;

public class SetupActivity extends AppCompatActivity {

    private static String deviceId;
    private static final String TAG = "SetupActivity";
    private final String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm", Locale.getDefault()).format(new Date().getTime());


    ActivitySetupBinding bi;

    public static void updateCluster(String clusterCode, String structureNo) {

        SharedPreferences.Editor editor = MainApp.sharedPref.edit();
        editor.putString(clusterCode, structureNo).apply();
        Log.d(TAG, "Updated Cluster: " + clusterCode + " " + structureNo);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_setup);

        MainApp.listing = new Listings();
        MainApp.hhNo = 0;
        initForm();
        MainApp.listing.setHl06(String.format("%04d", 0));
        MainApp.listing.setHl01(MainApp.districtsCode);
        MainApp.listing.setHl02(MainApp.ucCode);
        MainApp.listing.setHl03(MainApp.clusterCode);
        MainApp.listing.setHl05(String.format("%04d", ++MainApp.structureNo));

        bi.setListing(MainApp.listing);

        deviceId = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);
        setSupportActionBar(bi.toolbar);

        setupSkips();
    }

    public void setupSkips() {
        bi.hl08.setOnCheckedChangeListener((radioGroup, i) -> Clear.clearAllFields(bi.fldGrphl09));
    }

    public void ContinueListing(View view) {

        switch (view.getId()) {
            case R.id.btnAddFamily:
                if (formValidation()) {
                    initForm();
                    startActivity(new Intent(this, FamilyListing.class));
                    finish();
                }
                // SaveDraft(); //<== This function is no longer needed after DataBinding
                break;

            case R.id.btnAddStructure:
                if (formValidation()) {
                    if (updateDB()) {
                        initForm();
                        startActivity(new Intent(this, SetupActivity.class));
                        finish();
                    } else {
                        Toast.makeText(this, "Database Error!", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            case R.id.btnChangeCluster:
                if (!formValidation()) {
                    if (updateDB()) {
                        initForm();
                        startActivity(new Intent(this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(this, "Database Error!", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }

    private boolean formValidation() {

// TODO: Validation

        if (MainApp.listing.hl07.equals("")) {
            bi.hl07a.setError("Please select an answer");
            Toast.makeText(this, "No Option Selected ", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            bi.hl07a.setError(null);
        }

        if (MainApp.listing.hl07.equals("96") && MainApp.listing.hl0796x.equals("")) {
            bi.hl07x.setError("Please select an answer");
            Toast.makeText(this, "No answer entered", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            bi.hl07x.setError(null);
        }

        if (MainApp.listing.hl08.equals("")) {
            bi.hl0801.setError("Please select an answer");
            Toast.makeText(this, "No Option Selected ", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            bi.hl0801.setError(null);
        }

        if (MainApp.listing.hl09.equals("")) {
            bi.hl0901.setError("Please select an answer");
            Toast.makeText(this, "No Option Selected ", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            bi.hl0901.setError(null);
        }

        if (MainApp.listing.hl09.equals("1") && MainApp.listing.hl09x.equals("")) {
            bi.hl09x.setError("Please select an answer");
            Toast.makeText(this, "No answer entered", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            bi.hl09x.setError(null);
        }

        if (MainApp.listing.hl09.equals("1") && Integer.valueOf(MainApp.listing.hl09x) < 2) {
            bi.hl09x.setError("Entered value is invalid");
            Toast.makeText(this, "Entered value is invalid", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            bi.hl09x.setError(null);
        }

        return true;
    }

    private void initForm() {
        MainApp.listing.setSysDate(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        MainApp.listing.setUserName(MainApp.userName);
        MainApp.listing.setDcode(MainApp.districtsCode);
        MainApp.listing.setUcode(MainApp.ucCode);
        MainApp.listing.setCluster(MainApp.clusterCode);
        MainApp.listing.setDeviceId(MainApp.appInfo.getDeviceID());
        MainApp.listing.setDeviceTag(MainApp.appInfo.getTagName());
        MainApp.listing.setAppver(MainApp.appInfo.getAppVersion());
        MainApp.listing.setGps("");
    }

    private boolean updateDB() {

        MainApp.listing.setHl10(MainApp.listing.getHl10() + 1);
        DatabaseHelper db = new DatabaseHelper(this);
        long rowId = db.addListing(MainApp.listing);
        MainApp.listing.setID(String.valueOf(rowId));
        if (rowId > 0) {
            MainApp.listing.setUID(MainApp.listing.getDeviceId() + MainApp.listing.getID());
            db.updateListingUID(ListingContract.TableListings.COLUMN_NAME_UID, MainApp.listing.getUID());
            updateCluster(MainApp.clusterCode, String.valueOf(MainApp.structureNo));
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}


