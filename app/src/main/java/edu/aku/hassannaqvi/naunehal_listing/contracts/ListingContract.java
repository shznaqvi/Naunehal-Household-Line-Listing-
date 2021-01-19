package edu.aku.hassannaqvi.naunehal_listing.contracts;

import android.provider.BaseColumns;

/**
 * Created by hassan.naqvi on 10/18/2016.
 */
public class ListingContract {

    public static String CONTENT_AUTHORITY = "edu.aku.hassannaqvi.naunehal_listing";


    public static abstract class TableListings implements BaseColumns {

        public static final String TABLE_NAME = "listings";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_NAME_UID = "UID";
        public static final String COLUMN_NAME_HHDT = "hhDT";
        public static final String COLUMN_NAME_HL01 = "hl01";
        public static final String COLUMN_NAME_HL02 = "hl02";
        public static final String COLUMN_NAME_HL03 = "hl03";
        public static final String COLUMN_NAME_HL04 = "hl04";
        public static final String COLUMN_NAME_HL04X = "hl04x";
        public static final String COLUMN_NAME_HL05 = "hl05";
        public static final String COLUMN_NAME_HL06 = "hl06";
        public static final String COLUMN_NAME_HLDELETE = "hlDelete";
        public static final String COLUMN_NAME_HL07 = "hl07";
        public static final String COLUMN_NAME_HL0796X = "hl0796x";
        public static final String COLUMN_NAME_HL08 = "hl08";
        public static final String COLUMN_NAME_HL09 = "hl09";
        public static final String COLUMN_NAME_HL09X = "hl09x";
        public static final String COLUMN_NAME_HL10 = "hl10";
        public static final String COLUMN_NAME_HL11 = "hl11";
        public static final String COLUMN_NAME_HL12 = "hl12";
        public static final String COLUMN_NAME_HL12D = "hl12d";
        public static final String COLUMN_NAME_HL13 = "hl13";
        public static final String COLUMN_NAME_HL13X = "hl13x";
        public static final String COLUMN_NAME_HL14 = "hl14";
        public static final String COLUMN_NAME_HL14X = "hl14x";
        public static final String COLUMN_NAME_PROJECTNAME = "projectName";
        public static final String COLUMN_NAME_USERNAME = "userName";
        public static final String COLUMN_NAME_SYSDATE = "sysDate";
        public static final String COLUMN_NAME_DCODE = "dcode";
        public static final String COLUMN_NAME_UCODE = "ucode";
        public static final String COLUMN_NAME_CLUSTER = "cluster";
        public static final String COLUMN_NAME_DEVICEID = "deviceId";
        public static final String COLUMN_NAME_DEVICETAG = "deviceTag";
        public static final String COLUMN_NAME_APPVER = "appver";
        public static final String COLUMN_NAME_GPS = "gps";
        public static final String COLUMN_NAME_ENDTIME = "endTime";
        public static final String COLUMN_NAME_STATUS = "status";
        public static final String COLUMN_NAME_SYNCED = "synced";
        public static final String COLUMN_NAME_SYNCDATE = "syncDate";

    }
}