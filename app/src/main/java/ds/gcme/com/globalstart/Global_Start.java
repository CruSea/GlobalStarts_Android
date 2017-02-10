package ds.gcme.com.globalstart;

import android.app.Application;
import android.support.annotation.NonNull;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import ds.gcme.com.globalstart.Database.MyDatabase;
import ds.gcme.com.globalstart.News_Feed.*;
import ds.gcme.com.globalstart.News_Feed.NewsFeed;
import ds.gcme.com.globalstart.Sync.FileManager;
import ds.gcme.com.globalstart.Sync.SyncService;

/**
 * Created by BENGEOS on 3/17/16.
 */
public class Global_Start extends Application {

    private static String TAG = "SyncService";
    private SyncService mySyncService;

    @Override
    public void onCreate() {
        super.onCreate();
        mySyncService = new SyncService(this);
        mySyncService.StartSyncing();

    }
}
