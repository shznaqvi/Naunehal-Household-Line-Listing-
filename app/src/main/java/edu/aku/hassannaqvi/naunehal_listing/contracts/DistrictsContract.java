package edu.aku.hassannaqvi.naunehal_listing.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 10/31/2016.
 */

public class DistrictsContract {

    private String district;
    private String dist_id;


    public DistrictsContract() {
    }

    public DistrictsContract sync(JSONObject jsonObject) throws JSONException {
        this.dist_id = jsonObject.getString(TableDistricts.COLUMN_DISTRICT_CODE);
        this.district = jsonObject.getString(TableDistricts.COLUMN_DISTRICT_NAME);

        return this;
    }

    public DistrictsContract hydrate(Cursor cursor) {
        this.dist_id = cursor.getString(cursor.getColumnIndex(TableDistricts.COLUMN_DISTRICT_CODE));
        this.district = cursor.getString(cursor.getColumnIndex(TableDistricts.COLUMN_DISTRICT_NAME));

        return this;
    }

    public String getDist_id() {
        return dist_id;
    }

    public void setDist_id(String dist_id) {
        this.dist_id = dist_id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public static abstract class TableDistricts implements BaseColumns {

        public static final String TABLE_NAME = "Districts";
        public static final String COLUMN_NAME_NULLABLE = "nullColumnHack";
        public static final String _ID = "_ID";
        public static final String COLUMN_DISTRICT_CODE = "districtCode";
        public static final String COLUMN_DISTRICT_NAME = "districtName";

    }

}
