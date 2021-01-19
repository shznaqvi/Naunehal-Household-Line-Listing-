package edu.aku.hassannaqvi.naunehal_listing.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import edu.aku.hassannaqvi.naunehal_listing.R;
import edu.aku.hassannaqvi.naunehal_listing.contracts.ListingContract;
import edu.aku.hassannaqvi.naunehal_listing.core.MainApp;
import edu.aku.hassannaqvi.naunehal_listing.database.DatabaseHelper;
import edu.aku.hassannaqvi.naunehal_listing.databinding.ActivityFamilyListingBinding;

import static edu.aku.hassannaqvi.naunehal_listing.core.MainApp.hl10;

public class FamilyListing extends AppCompatActivity {

    private static final String TAG = "FamilyListing";
    ActivityFamilyListingBinding bi;

    public static void updateCluster(String clusterCode, String structureNo) {

        SharedPreferences.Editor editor = MainApp.sharedPref.edit();
        editor.putString(clusterCode, structureNo).apply();
        Log.d(TAG, "Updated Cluster: " + clusterCode + " " + structureNo);

    }

    public static void updateResidencial(String clusterCode, String structureNo) {

        SharedPreferences.Editor editor = MainApp.sharedPref.edit();
        editor.putString(clusterCode + "Res", String.valueOf(hl10)).apply();
        Log.d(TAG, "Updated Cluster: " + clusterCode + " " + structureNo);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_family_listing);

        MainApp.listing.setHl10(String.valueOf(hl10 + 1));
        MainApp.listing.setHl11("");
        MainApp.listing.setHl12("");
        MainApp.listing.setHl13("");
        MainApp.listing.setHl13x("");
        MainApp.listing.setHl14("");
        MainApp.listing.setHl14x("");
        MainApp.listing.setHl15("");
        bi.setListing(MainApp.listing);
        setSupportActionBar(bi.toolbar);
        MainApp.listing.setHl06(String.format("%03d", ++MainApp.hhNo));


    }

    public void ContinueListing(View view) {

        switch (view.getId()) {
            case R.id.btnAddFamily:
                if (formValidation()) {
                    if (updateDB()) {
                        startActivity(new Intent(this, FamilyListing.class));
                        finish();
                    } else {
                        Toast.makeText(this, "Database Error!", Toast.LENGTH_SHORT).show();
                    }
                }
                // SaveDraft(); //<== This function is no longer needed after DataBinding
                break;

            case R.id.btnAddStructure:
                if (formValidation()) {
                    if (updateDB()) {
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
                        startActivity(new Intent(this, SetupActivity.class));
                        finish();
                    } else {
                        Toast.makeText(this, "Database Error!", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }

    private boolean formValidation() {

        return true;
    }

    private boolean updateDB() {

        DatabaseHelper db = new DatabaseHelper(this);
        long rowId = db.addListing(MainApp.listing);
        MainApp.listing.setID(String.valueOf(rowId));
        if (rowId > 0) {
            MainApp.listing.setUID(MainApp.listing.getDeviceId() + MainApp.listing.getID());
            db.updateListingUID(ListingContract.TableListings.COLUMN_NAME_UID, MainApp.listing.getUID());
            updateCluster(MainApp.clusterCode, String.valueOf(MainApp.structureNo));

            // set residence count in sharedpref if household is valid
            if (!bi.hh17.getText().toString().equals("")) {

                updateResidencial(MainApp.clusterCode, String.valueOf(++MainApp.hl10));
            }
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}