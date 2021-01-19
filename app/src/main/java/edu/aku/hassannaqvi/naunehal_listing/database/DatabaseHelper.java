package edu.aku.hassannaqvi.naunehal_listing.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.aku.hassannaqvi.naunehal_listing.contracts.ClustersContract;
import edu.aku.hassannaqvi.naunehal_listing.contracts.ClustersContract.TableClusters;
import edu.aku.hassannaqvi.naunehal_listing.contracts.DistrictsContract;
import edu.aku.hassannaqvi.naunehal_listing.contracts.DistrictsContract.TableDistricts;
import edu.aku.hassannaqvi.naunehal_listing.contracts.ListingContract.TableListings;
import edu.aku.hassannaqvi.naunehal_listing.contracts.UCsContract;
import edu.aku.hassannaqvi.naunehal_listing.contracts.UCsContract.TableUCs;
import edu.aku.hassannaqvi.naunehal_listing.core.MainApp;
import edu.aku.hassannaqvi.naunehal_listing.models.Listings;

import static edu.aku.hassannaqvi.naunehal_listing.core.MainApp.PROJECT_NAME;


/**
 * Created by hassan.naqvi on 10/18/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // The name of database.
    public static final String DATABASE_NAME = PROJECT_NAME + ".db";
    // Change this when you change the database schema.
    private static final int DATABASE_VERSION = 1;
    public static String TAG = "DatabaseHelper";
    public static String DB_FORM_ID;
    public static String DB_NAME = PROJECT_NAME + "_copy.db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a table to hold Listings.
        final String SQL_CREATE_LISTING_TABLE = "CREATE TABLE " + TableListings.TABLE_NAME + " (" +
                TableListings._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                TableListings.COLUMN_NAME_UID + " TEXT, " +
                TableListings.COLUMN_NAME_HHDT + " TEXT, " +
                TableListings.COLUMN_NAME_HL01 + " TEXT, " +
                TableListings.COLUMN_NAME_HL02 + " TEXT, " +
                TableListings.COLUMN_NAME_HL03 + " TEXT, " +
                TableListings.COLUMN_NAME_HL04 + " TEXT, " +
                TableListings.COLUMN_NAME_HL04X + " TEXT, " +
                TableListings.COLUMN_NAME_HL05 + " TEXT, " +
                TableListings.COLUMN_NAME_HL06 + " TEXT, " +
                TableListings.COLUMN_NAME_HLDELETE + " TEXT, " +
                TableListings.COLUMN_NAME_HL07 + " TEXT, " +
                TableListings.COLUMN_NAME_HL0796X + " TEXT, " +
                TableListings.COLUMN_NAME_HL08 + " TEXT, " +
                TableListings.COLUMN_NAME_HL09 + " TEXT, " +
                TableListings.COLUMN_NAME_HL09X + " TEXT, " +
                TableListings.COLUMN_NAME_HL10 + " TEXT, " +
                TableListings.COLUMN_NAME_HL11 + " TEXT, " +
                TableListings.COLUMN_NAME_HL12 + " TEXT, " +
                TableListings.COLUMN_NAME_HL12D + " TEXT, " +
                TableListings.COLUMN_NAME_HL13 + " TEXT, " +
                TableListings.COLUMN_NAME_HL13X + " TEXT, " +
                TableListings.COLUMN_NAME_HL14 + " TEXT, " +
                TableListings.COLUMN_NAME_HL14X + " TEXT, " +
                TableListings.COLUMN_NAME_PROJECTNAME + " TEXT, " +
                TableListings.COLUMN_NAME_USERNAME + " TEXT, " +
                TableListings.COLUMN_NAME_SYSDATE + " TEXT, " +
                TableListings.COLUMN_NAME_DCODE + " TEXT, " +
                TableListings.COLUMN_NAME_UCODE + " TEXT, " +
                TableListings.COLUMN_NAME_CLUSTER + " TEXT, " +
                TableListings.COLUMN_NAME_DEVICETAG + " TEXT, " +
                TableListings.COLUMN_NAME_DEVICEID + " TEXT, " +
                TableListings.COLUMN_NAME_APPVER + " TEXT, " +
                TableListings.COLUMN_NAME_GPS + " TEXT, " +
                TableListings.COLUMN_NAME_ENDTIME + " TEXT, " +
                TableListings.COLUMN_NAME_STATUS + " TEXT, " +
                TableListings.COLUMN_NAME_SYNCED + " TEXT, " +
                TableListings.COLUMN_NAME_SYNCDATE + " TEXT " +

                " );";

        final String SQL_CREATE_DISTRICT_TABLE = "CREATE TABLE " + TableDistricts.TABLE_NAME + " (" +
                TableDistricts._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                TableDistricts.COLUMN_DISTRICT_CODE + " TEXT, " +
                TableDistricts.COLUMN_DISTRICT_NAME + " TEXT " +
                ");";

        final String SQL_CREATE_CLUSTER_TABLE = "CREATE TABLE " + TableClusters.TABLE_NAME + " (" +
                TableClusters._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                TableClusters.COLUMN_CLUSTER_CODE + " TEXT, " +
                TableClusters.COLUMN_CLUSTER_NAME + " TEXT, " +
                TableClusters.COLUMN_UC_CODE + " TEXT " +
                ");";

        final String SQL_CREATE_UC_TABLE = "CREATE TABLE " + TableUCs.TABLE_NAME + " (" +
                TableUCs._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                TableUCs.COLUMN_DISTRICT_CODE + " TEXT, " +
                TableUCs.COLUMN_UC_NAME + " TEXT, " +
                TableUCs.COLUMN_UC_CODE + " TEXT " +
                ");";


        // Do the creating of the databases.
        db.execSQL(SQL_CREATE_LISTING_TABLE);
        db.execSQL(SQL_CREATE_DISTRICT_TABLE);
        db.execSQL(SQL_CREATE_CLUSTER_TABLE);
        db.execSQL(SQL_CREATE_UC_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Simply discard all old data and start over when upgrading.
       /* db.execSQL("DROP TABLE IF EXISTS " + TableListings.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TableDistricts.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TableClusters.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TableUCs.TABLE_NAME);*/
        onCreate(db);
    }

    public Long lastInsertId() {
        Long id = null;
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "SELECT last_insert_rowid()";
        Cursor c = db.rawQuery(qry, null);
        if (c != null && c.moveToFirst()) {
            id = Long.valueOf(c.getString(0));
            c.close();
        } else {
            id = Long.valueOf(-1);
        }

        return id;
    }

    public Long addListing(Listings lc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(TableListings.COLUMN_NAME_UID, lc.getUID());
        values.put(TableListings.COLUMN_NAME_HHDT, lc.getHhDT());
        values.put(TableListings.COLUMN_NAME_HL01, lc.getHl01());
        values.put(TableListings.COLUMN_NAME_HL02, lc.getHl02());
        values.put(TableListings.COLUMN_NAME_HL03, lc.getHl03());
        values.put(TableListings.COLUMN_NAME_HL04, lc.getHl04());
        values.put(TableListings.COLUMN_NAME_HL04X, lc.getHl04x());
        values.put(TableListings.COLUMN_NAME_HL05, lc.getHl05());
        values.put(TableListings.COLUMN_NAME_HL06, lc.getHl06());
        values.put(TableListings.COLUMN_NAME_HLDELETE, lc.getHlDelete());
        values.put(TableListings.COLUMN_NAME_HL07, lc.getHl07());
        values.put(TableListings.COLUMN_NAME_HL0796X, lc.getHl0796x());
        values.put(TableListings.COLUMN_NAME_HL08, lc.getHl08());
        values.put(TableListings.COLUMN_NAME_HL09, lc.getHl09());
        values.put(TableListings.COLUMN_NAME_HL09X, lc.getHl09x());
        values.put(TableListings.COLUMN_NAME_HL10, lc.getHl10());
        values.put(TableListings.COLUMN_NAME_HL11, lc.getHl11());
        values.put(TableListings.COLUMN_NAME_HL12, lc.getHl12());
        values.put(TableListings.COLUMN_NAME_HL12D, lc.getHl12d());
        values.put(TableListings.COLUMN_NAME_HL13, lc.getHl13());
        values.put(TableListings.COLUMN_NAME_HL13X, lc.getHl13x());
        values.put(TableListings.COLUMN_NAME_HL14, lc.getHl14());
        values.put(TableListings.COLUMN_NAME_HL14X, lc.getHl14x());
        values.put(TableListings.COLUMN_NAME_PROJECTNAME, lc.getProjectName());
        values.put(TableListings.COLUMN_NAME_USERNAME, lc.getUserName());
        values.put(TableListings.COLUMN_NAME_SYSDATE, lc.getSysDate());
        values.put(TableListings.COLUMN_NAME_DCODE, lc.getDcode());
        values.put(TableListings.COLUMN_NAME_UCODE, lc.getUcode());
        values.put(TableListings.COLUMN_NAME_CLUSTER, lc.getCluster());
        values.put(TableListings.COLUMN_NAME_DEVICEID, lc.getDeviceId());
        values.put(TableListings.COLUMN_NAME_DEVICETAG, lc.getDeviceTag());
        values.put(TableListings.COLUMN_NAME_APPVER, lc.getAppver());
        values.put(TableListings.COLUMN_NAME_GPS, lc.getGps());
        values.put(TableListings.COLUMN_NAME_ENDTIME, lc.getEndTime());
        values.put(TableListings.COLUMN_NAME_STATUS, lc.getStatus());
        values.put(TableListings.COLUMN_NAME_SYNCED, lc.getSynced());
        values.put(TableListings.COLUMN_NAME_SYNCDATE, lc.getSysDate());

        long newRowId;
        newRowId = db.insert(
                TableListings.TABLE_NAME,
                TableListings.COLUMN_NAME_NULLABLE,
                values);
        DB_FORM_ID = String.valueOf(newRowId);

        return newRowId;
    }

    public Long addDistrict(DistrictsContract dc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(TableDistricts.COLUMN_DISTRICT_CODE, dc.getDist_id());
        values.put(TableDistricts.COLUMN_DISTRICT_NAME, dc.getDistrict());

        long newRowId;
        newRowId = db.insert(
                TableDistricts.TABLE_NAME,
                TableDistricts.COLUMN_NAME_NULLABLE,
                values);

        return newRowId;
    }

    public void updateListingUID(String columnNameUid, String uid) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(TableListings.COLUMN_NAME_UID, MainApp.listing.getUID());

// Which row to update, based on the title
        String where = TableListings._ID + " = ?";
        String[] whereArgs = {MainApp.listing.getID()};
        db.update(
                TableListings.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public Collection<Listings> getAllListings() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                TableListings._ID,
                TableListings.COLUMN_NAME_UID,
                TableListings.COLUMN_NAME_HHDT,
                TableListings.COLUMN_NAME_HL01,
                TableListings.COLUMN_NAME_HL02,
                TableListings.COLUMN_NAME_HL03,
                TableListings.COLUMN_NAME_HL04,
                TableListings.COLUMN_NAME_HL04X,
                TableListings.COLUMN_NAME_HL05,
                TableListings.COLUMN_NAME_HL06,
                TableListings.COLUMN_NAME_HLDELETE,
                TableListings.COLUMN_NAME_HL07,
                TableListings.COLUMN_NAME_HL0796X,
                TableListings.COLUMN_NAME_HL08,
                TableListings.COLUMN_NAME_HL09,
                TableListings.COLUMN_NAME_HL09X,
                TableListings.COLUMN_NAME_HL10,
                TableListings.COLUMN_NAME_HL11,
                TableListings.COLUMN_NAME_HL12,
                TableListings.COLUMN_NAME_HL12D,
                TableListings.COLUMN_NAME_HL13,
                TableListings.COLUMN_NAME_HL13X,
                TableListings.COLUMN_NAME_HL14,
                TableListings.COLUMN_NAME_HL14X,
                TableListings.COLUMN_NAME_PROJECTNAME,
                TableListings.COLUMN_NAME_USERNAME,
                TableListings.COLUMN_NAME_SYSDATE,
                TableListings.COLUMN_NAME_DCODE,
                TableListings.COLUMN_NAME_UCODE,
                TableListings.COLUMN_NAME_CLUSTER,
                TableListings.COLUMN_NAME_DEVICEID,
                TableListings.COLUMN_NAME_DEVICETAG,
                TableListings.COLUMN_NAME_APPVER,
                TableListings.COLUMN_NAME_GPS,
                TableListings.COLUMN_NAME_ENDTIME,
                TableListings.COLUMN_NAME_STATUS,
                TableListings.COLUMN_NAME_SYNCED,
                TableListings.COLUMN_NAME_SYNCDATE,

        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                TableListings._ID + " ASC";

        Collection<Listings> allLC = new ArrayList<Listings>();
        try {
            c = db.query(
                    TableListings.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allLC.add(new Listings().hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allLC;
    }

    public Collection<DistrictsContract> getAllDistricts() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                TableDistricts._ID,
                TableDistricts.COLUMN_DISTRICT_CODE,
                TableDistricts.COLUMN_DISTRICT_NAME
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                TableDistricts._ID + " ASC";

        Collection<DistrictsContract> allDC = new ArrayList<DistrictsContract>();
        try {
            c = db.query(
                    TableDistricts.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                DistrictsContract dc = new DistrictsContract();
                allDC.add(dc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
    }

    public Collection<ClustersContract> getAllClustersByUC(String ucCode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                TableClusters._ID,
                TableClusters.COLUMN_CLUSTER_CODE,
                TableClusters.COLUMN_CLUSTER_NAME,
                TableClusters.COLUMN_UC_CODE
        };

        String whereClause = TableClusters.COLUMN_UC_CODE + " = ?";
        String[] whereArgs = {ucCode};
        String groupBy = null;
        String having = null;

        String orderBy =
                TableClusters.COLUMN_CLUSTER_CODE + " ASC";

        Collection<ClustersContract> allPC = new ArrayList<ClustersContract>();
        try {
            c = db.query(
                    TableClusters.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ClustersContract pc = new ClustersContract();
                allPC.add(pc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allPC;
    }

    public List<UCsContract> getAllUCByDistrict(String district_code) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                TableUCs._ID,
                TableUCs.COLUMN_UC_CODE,
                TableUCs.COLUMN_UC_NAME,
                TableUCs.COLUMN_DISTRICT_CODE
        };

        String whereClause = TableUCs.COLUMN_DISTRICT_CODE + " = ?";
        String[] whereArgs = {district_code};
        String groupBy = null;
        String having = null;

        String orderBy =
                TableUCs.COLUMN_UC_NAME + " ASC";

        List<UCsContract> allPC = new ArrayList<UCsContract>();
        try {
            c = db.query(
                    TableUCs.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                UCsContract uc = new UCsContract();
                allPC.add(uc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allPC;
    }





    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"mesage"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);


        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);


            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {


                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }


    }

    public int syncDistricts(JSONArray Districtslist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DistrictsContract.TableDistricts.TABLE_NAME, null, null);
        int insertCount = 0;
        try {
            for (int i = 0; i < Districtslist.length(); i++) {
                JSONObject jsonObjectDistrict = Districtslist.getJSONObject(i);
                DistrictsContract District = new DistrictsContract();
                District.sync(jsonObjectDistrict);
                ContentValues values = new ContentValues();

                values.put(TableDistricts.COLUMN_DISTRICT_CODE, District.getDist_id());
                values.put(TableDistricts.COLUMN_DISTRICT_NAME, District.getDistrict());
                long rowID = db.insert(TableDistricts.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }

        } catch (Exception e) {
            Log.d(TAG, "syncDistrict(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }

    public int syncCluster(JSONArray clusterList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TableClusters.TABLE_NAME, null, null);
        int insertCount = 0;
        try {

            for (int i = 0; i < clusterList.length(); i++) {
                JSONObject jsonObjectCluster = clusterList.getJSONObject(i);
                ClustersContract cluster = new ClustersContract();
                cluster.sync(jsonObjectCluster);
                ContentValues values = new ContentValues();

                values.put(TableClusters.COLUMN_CLUSTER_CODE, cluster.getClusterCode());
                values.put(TableClusters.COLUMN_CLUSTER_NAME, cluster.getClustername());
                values.put(TableClusters.COLUMN_UC_CODE, cluster.getUcCode());

                long rowID = db.insert(TableClusters.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }
            db.close();

        } catch (Exception e) {
            Log.d(TAG, "syncCluster(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }


    public int syncUCs(JSONArray ucList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TableUCs.TABLE_NAME, null, null);
        int insertCount = 0;
        try {

            for (int i = 0; i < ucList.length(); i++) {
                JSONObject jsonObjectUc = ucList.getJSONObject(i);
                UCsContract uc = new UCsContract();
                uc.sync(jsonObjectUc);
                ContentValues values = new ContentValues();

                values.put(TableUCs.COLUMN_UC_CODE, uc.getUcCode());
                values.put(TableUCs.COLUMN_UC_NAME, uc.getUcName());
                values.put(TableUCs.COLUMN_DISTRICT_CODE, uc.getDistrictCode());

                long rowID = db.insert(TableUCs.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }
            db.close();

        } catch (Exception e) {
            Log.d(TAG, "syncUc(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }


    public boolean checkUsers() {

        return true;
    }


}
