package ds.gcme.com.globalstart.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by BENGEOS on 3/17/16.
 */
public class SQL_Helper extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "Global_Start";
    private final static int DATABASE_VERSION = 1;
    public SQL_Helper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }
    public void createTables(String Db_Tables, String[] fields) {
        String str = "id INTEGER PRIMARY KEY AUTOINCREMENT,";
        if(fields.length>1){
            for(int x = 0; x<fields.length-1;x++){
                str = str + fields[x]+" TEXT, ";
            }
            str = str + fields[fields.length-1]+" TEXT);";
        }else {
            str = str + fields[0]+" TEXT);";
        }
        getWritableDatabase().execSQL("CREATE TABLE IF NOT EXISTS "+Db_Tables+" ("+str);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
