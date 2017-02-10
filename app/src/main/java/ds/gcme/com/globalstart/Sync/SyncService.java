package ds.gcme.com.globalstart.Sync;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import ds.gcme.com.globalstart.News_Feed.NewsFeed;
import ds.gcme.com.globalstart.News_Feed.NewsFeedDetail;
import ds.gcme.com.globalstart.News_Feed.NewsFeed_Fragment;

/**
 * Created by bengeos on 1/18/17.
 */

public class SyncService {
    private static String TAG = "SyncService";
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference myNewsRef;

    private Context myContext;
    private FirebaseAuth myAuth;

    public static List<NewsFeed> myNewsFeeds;

    public SyncService(Context myContext) {
        this.myContext = myContext;
        Log.i(TAG,"Getting Firebase Reference");
        myNewsFeeds = new ArrayList<NewsFeed>();

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        firebaseDatabase = FirebaseDatabase.getInstance();
        myNewsRef = firebaseDatabase.getReference("News");
    }

    public void StartSyncing(){
        myAuth = FirebaseAuth.getInstance();
        FirebaseUser user = myAuth.getCurrentUser();
        if(user !=null){
            SyncNews();
            Log.d(TAG, "Start Sign in Checked Signed in:" + user.getUid());
        }else {
            Log.d(TAG, "Try Sign in Again");
            myAuth.signInWithEmailAndPassword("george.beng@gmail.com","passben").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        SyncNews();
                        Log.d(TAG, "Start Sign in Checked Signed in again:");
                    }else {
                        Log.d(TAG, "Sign in Failed : "+task.getException());
                    }
                }
            });
        }

    }

    private void SyncNews() {
        myNewsRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                try{
                    Log.d(TAG, "Adding News:-> " + dataSnapshot.getKey());
                    ds.gcme.com.globalstart.News_Feed.NewsFeed news = dataSnapshot.getValue(ds.gcme.com.globalstart.News_Feed.NewsFeed.class);
                    news.setUUID(dataSnapshot.getKey());
                    for(int i=0;i<myNewsFeeds.size();i++){
                        if(myNewsFeeds.get(i).getUUID().equals(news.getUUID())){
                            myNewsFeeds.remove(i);
                        }
                    }
                    myNewsFeeds.add(news);
                    try{
                        NewsFeed_Fragment.update_view();
                    }catch (Exception e){

                    }
                    try{
                        NewsFeedDetail.updateView();
                    }catch (Exception e){

                    }
                    Log.d(TAG, "News Added: " + dataSnapshot.getChildren());
                }catch (Exception e){

                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                try{
                    Log.d(TAG, "Updating News:-> " + dataSnapshot.getKey());
                    ds.gcme.com.globalstart.News_Feed.NewsFeed news = dataSnapshot.getValue(ds.gcme.com.globalstart.News_Feed.NewsFeed.class);
                    news.setUUID(dataSnapshot.getKey());
                    for(int i=0;i<myNewsFeeds.size();i++){
                        if(myNewsFeeds.get(i).getUUID().equals(news.getUUID())){
                            myNewsFeeds.get(i).setTitle(news.getTitle());
                            myNewsFeeds.get(i).setDetail(news.getDetail());
                            myNewsFeeds.get(i).setImageURL(news.getImageURL());
                            myNewsFeeds.get(i).setPubDate(news.getPubDate());
                        }
                    }
                    try{
                        NewsFeed_Fragment.update_view();
                    }catch (Exception e){

                    }
                    try{
                        NewsFeedDetail.updateView();
                    }catch (Exception e){

                    }
                    Log.d(TAG, "News Updated: " + dataSnapshot.getChildren());
                }catch (Exception e){

                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                try{
                    Log.d(TAG, "Updating News:-> " + dataSnapshot.getKey());
                    ds.gcme.com.globalstart.News_Feed.NewsFeed news = dataSnapshot.getValue(ds.gcme.com.globalstart.News_Feed.NewsFeed.class);
                    news.setUUID(dataSnapshot.getKey());
                    for(int i=0;i<myNewsFeeds.size();i++){
                        if(myNewsFeeds.get(i).getUUID().equals(news.getUUID())){
                            myNewsFeeds.remove(i);
                        }
                    }
                    try{
                        NewsFeed_Fragment.update_view();
                    }catch (Exception e){

                    }
                    try{
                        NewsFeedDetail.updateView();
                    }catch (Exception e){

                    }
                    Log.d(TAG, "News Updated: " + dataSnapshot.getChildren());
                }catch (Exception e){

                }
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
