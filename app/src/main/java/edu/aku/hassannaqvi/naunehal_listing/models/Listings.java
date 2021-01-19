package edu.aku.hassannaqvi.naunehal_listing.models;


import android.database.Cursor;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.naunehal_listing.BR;
import edu.aku.hassannaqvi.naunehal_listing.contracts.ListingContract;
import edu.aku.hassannaqvi.naunehal_listing.contracts.ListingContract.TableListings;
import edu.aku.hassannaqvi.naunehal_listing.core.MainApp;

/**
 * Created by hassan.naqvi on 10/18/2016.
 */
public class Listings extends BaseObservable {

    private static final String TAG = "Listings";
    public String ID = "";
    public String UID = "";
    public String hhDT = "";
    public String hl01 = "";
    public String hl02 = "";
    public String hl03 = "";
    public String hl04 = "";
    public String hl04x = "";
    public String hl05 = "";
    public String hl06 = "";
    public String hlDelete = "";
    public String hl07 = "";
    public String hl0796x = "";
    public String hl08 = "";
    public String hl09 = "";
    public String hl09x = "";
    public String hl10 = "";
    public String hl11 = "";
    public String hl12 = "";
    public String hl12d = "";
    public String hl13 = "";
    public String hl13x = "";
    public String hl14 = "";
    public String hl14x = "";
    public String hl15 = "";

    // APP VARIABLES
    private String projectName = MainApp.PROJECT_NAME;
    private String userName;
    private String sysDate;
    private String dcode;
    private String ucode;
    private String cluster;
    private String deviceId;
    private String deviceTag;
    private String appver;
    private String gps;
    private String endTime;
    private String status;
    private String synced;
    private String syncDate;

    public Listings() {
    }

    public Listings(String ID) {
        this.ID = ID;
    }

    public Listings(String hl01, String hl02, String hl03, String hl04, String hl04x, String hl05, String hl06, String hl07, String DeviceID, String GPSLat, String GPSLng, String GPSTime, String GPSAcc) {
        this.hl01 = hl01;
        this.hl02 = hl02;
        this.hl03 = hl03;
        this.hl04 = hl04;
        this.hl04x = hl04x;
        this.hl05 = hl05;
        this.hl06 = hl06;
        this.hl07 = hl07;

    }


    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(TableListings._ID, this.ID);
        json.put(TableListings.COLUMN_NAME_UID, this.UID);
        json.put(TableListings.COLUMN_NAME_HHDT, this.hhDT);
        json.put(TableListings.COLUMN_NAME_HL01, this.hl01);
        json.put(TableListings.COLUMN_NAME_HL02, this.hl02);
        json.put(TableListings.COLUMN_NAME_HL03, this.hl03);
        json.put(TableListings.COLUMN_NAME_HL04, this.hl04);
        json.put(TableListings.COLUMN_NAME_HL04X, this.hl04x);
        json.put(TableListings.COLUMN_NAME_HL05, this.hl05);
        json.put(TableListings.COLUMN_NAME_HL06, this.hl06);
        json.put(TableListings.COLUMN_NAME_HLDELETE, this.hlDelete);
        json.put(TableListings.COLUMN_NAME_HL07, this.hl07);
        json.put(TableListings.COLUMN_NAME_HL0796X, this.hl0796x);
        json.put(TableListings.COLUMN_NAME_HL08, this.hl08);
        json.put(TableListings.COLUMN_NAME_HL09, this.hl09);
        json.put(TableListings.COLUMN_NAME_HL09X, this.hl09x);
        json.put(TableListings.COLUMN_NAME_HL10, this.hl10);
        json.put(TableListings.COLUMN_NAME_HL11, this.hl11);
        json.put(TableListings.COLUMN_NAME_HL12, this.hl12);
        json.put(TableListings.COLUMN_NAME_HL12D, this.hl12d);
        json.put(TableListings.COLUMN_NAME_HL13, this.hl13);
        json.put(TableListings.COLUMN_NAME_HL13X, this.hl13x);
        json.put(TableListings.COLUMN_NAME_HL14, this.hl14);
        json.put(TableListings.COLUMN_NAME_HL14X, this.hl14x);
        json.put(TableListings.COLUMN_NAME_PROJECTNAME, this.projectName);
        json.put(TableListings.COLUMN_NAME_USERNAME, this.userName);
        json.put(TableListings.COLUMN_NAME_SYSDATE, this.sysDate);
        json.put(TableListings.COLUMN_NAME_DCODE, this.dcode);
        json.put(TableListings.COLUMN_NAME_UCODE, this.ucode);
        json.put(TableListings.COLUMN_NAME_CLUSTER, this.cluster);
        json.put(TableListings.COLUMN_NAME_DEVICETAG, this.deviceTag);
        json.put(TableListings.COLUMN_NAME_DEVICEID, this.deviceId);
        json.put(TableListings.COLUMN_NAME_APPVER, this.appver);
        json.put(TableListings.COLUMN_NAME_GPS, this.gps);
        json.put(TableListings.COLUMN_NAME_ENDTIME, this.endTime);
        json.put(TableListings.COLUMN_NAME_STATUS, this.status);
        json.put(TableListings.COLUMN_NAME_SYNCED, this.synced);
        json.put(TableListings.COLUMN_NAME_SYNCDATE, this.syncDate);
        return json;
    }

    @Bindable
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Bindable
    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    @Bindable
    public String getHhDT() {
        return hhDT;
    }

    public void setHhDT(String hhDT) {
        this.hhDT = hhDT;
        notifyPropertyChanged(BR.hhDT);
    }

    @Bindable
    public String getHl01() {
        return hl01;
    }

    public void setHl01(String hl01) {
        this.hl01 = hl01;
        notifyPropertyChanged(BR.hl01);
    }

    @Bindable
    public String getHl02() {
        return hl02;
    }

    public void setHl02(String hl02) {
        this.hl02 = hl02;
        notifyPropertyChanged(BR.hl02);
    }

    @Bindable
    public String getHl03() {
        return hl03;
    }

    public void setHl03(String hl03) {
        this.hl03 = hl03;
        notifyPropertyChanged(BR.hl03);
    }

    @Bindable
    public String getHl04() {
        return hl04;
    }

    public void setHl04(String hl04) {
        this.hl04 = hl04;
        notifyPropertyChanged(BR.hl04);
    }

    @Bindable
    public String getHl04x() {
        return hl04x;
    }

    public void setHl04x(String hl04x) {
        this.hl04x = hl04x;
        notifyPropertyChanged(BR.hl04x);
    }

    @Bindable
    public String getHl05() {
        return hl05;
    }

    public void setHl05(String hl05) {
        this.hl05 = hl05;
        notifyPropertyChanged(BR.hl05);
    }

    @Bindable
    public String getHl06() {
        return hl06;
    }

    public void setHl06(String hl06) {
        this.hl06 = hl06;
        notifyPropertyChanged(BR.hl06);
    }

    @Bindable
    public String getHl07() {
        return hl07;
    }

    public void setHl07(String hl07) {
        this.hl07 = hl07;
        if (this.hl07 != "96") {
            setHl0796x("");
        }

        if (this.hl07 == "7") {
            setHl08("");
        }
        notifyPropertyChanged(BR.hl07);
    }

    @Bindable
    public String getHl0796x() {
        return hl0796x;
    }

    public void setHl0796x(String hl0796x) {
        this.hl0796x = hl0796x;
        notifyPropertyChanged(BR.hl0796x);
    }

    @Bindable
    public String getHl08() {
        Log.d(TAG, "getHl08: " + this.hl08);
        return hl08;
    }

    public void setHl08(String hl08) {
        this.hl08 = hl08;
        notifyPropertyChanged(BR.hl08);
        Log.d(TAG, "setHl08: " + this.hl08);
    }

    @Bindable
    public String getHl09() {
        return hl09;
    }

    public void setHl09(String hl09) {
        this.hl09 = hl09;
        if (this.hl09 != "1") {
            setHl09x("1");
        }

        notifyPropertyChanged(BR.hl09);
    }

    @Bindable
    public String getHl09x() {
        return hl09x;
    }

    public void setHl09x(String hl09x) {
        this.hl09x = hl09x;
        notifyPropertyChanged(BR.hl09x);
    }


    @Bindable
    public String getHl10() {
        return hl10;
    }

    public void setHl10(String hl10) {
        this.hl10 = hl10;
        notifyPropertyChanged(BR.hl10);
    }

    @Bindable
    public String getHl11() {
        return hl11;
    }

    public void setHl11(String hl11) {
        this.hl11 = hl11;
        notifyPropertyChanged(BR.hl11);
    }

    @Bindable
    public String getHl12() {
        return hl12;
    }

    public void setHl12(String hl12) {
        this.hl12 = hl12;
        notifyPropertyChanged(BR.hl12);
    }

    @Bindable
    public String getHl12d() {
        return hl12d;
    }

    public void setHl12d(String hl12d) {
        this.hl12d = hl12d;
        notifyPropertyChanged(BR.hl12d);
    }

    @Bindable
    public String getHl13() {
        return hl13;
    }

    public void setHl13(String hl13) {
        this.hl13 = hl13;
        if (this.hl13 != "1") {
            setHl13x("");
        }
        notifyPropertyChanged(BR.hl13);
    }

    @Bindable
    public String getHl13x() {
        return hl13x;
    }

    public void setHl13x(String hl13x) {
        this.hl13x = hl13x;
        notifyPropertyChanged(BR.hl13x);
    }

    @Bindable
    public String getHl14() {
        return hl14;
    }

    public void setHl14(String hl14) {
        this.hl14 = hl14;
        if (this.hl14 != "1") {
            setHl14x("");
        }
        notifyPropertyChanged(BR.hl14);
    }

    @Bindable
    public String getHl14x() {
        return hl14x;
    }

    public void setHl14x(String hl14x) {
        this.hl14x = hl14x;
        notifyPropertyChanged(BR.hl14x);
    }

    @Bindable
    public String getHl15() {
        return hl15;
    }

    public void setHl15(String hl15) {
        this.hl15 = hl15;
        notifyPropertyChanged(BR.hl15);
    }

    @Bindable
    public String getHlDelete() {
        return hlDelete;
    }

    public void setHlDelete(String hlDelete) {
        this.hlDelete = hlDelete;
        notifyPropertyChanged(BR.hlDelete);
    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSysDate() {
        return sysDate;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
    }

    public String getDcode() {
        return dcode;
    }

    public void setDcode(String dcode) {
        this.dcode = dcode;
    }

    public String getUcode() {
        return ucode;
    }

    public void setUcode(String ucode) {
        this.ucode = ucode;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }


    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceTag() {
        return deviceTag;
    }

    public void setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
    }

    public String getAppver() {
        return appver;
    }

    public void setAppver(String appver) {
        this.appver = appver;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }


    public Listings hydrate(Cursor cursor) {

        this.ID = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings._ID));
        this.UID = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_UID));
        this.hhDT = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_HHDT));
        this.hl01 = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_HL01));
        this.hl02 = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_HL02));
        this.hl03 = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_HL03));
        this.hl04 = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_HL04));
        this.hl04x = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_HL04X));
        this.hl05 = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_HL05));
        this.hl06 = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_HL06));
        this.hlDelete = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_HLDELETE));
        this.hl07 = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_HL07));
        this.hl0796x = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_HL0796X));
        this.hl08 = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_HL08));
        this.hl09 = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_HL09));
        this.hl09x = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_HL09X));
        this.hl10 = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_HL10));
        this.hl11 = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_HL11));
        this.hl12 = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_HL12));
        this.hl12d = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_HL12D));
        this.hl13 = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_HL13));
        this.hl13x = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_HL13X));
        this.hl14 = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_HL14));
        this.hl14x = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_HL14X));
        this.projectName = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_PROJECTNAME));
        this.userName = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_SYSDATE));
        this.dcode = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_DCODE));
        this.ucode = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_UCODE));
        this.cluster = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_CLUSTER));
        this.deviceTag = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_DEVICETAG));
        this.deviceId = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_DEVICEID));
        this.appver = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_APPVER));
        this.gps = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_GPS));
        this.endTime = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_ENDTIME));
        this.status = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_STATUS));
        this.synced = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndex(ListingContract.TableListings.COLUMN_NAME_SYNCDATE));
        return this;
    }

}