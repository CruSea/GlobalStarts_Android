package ds.gcme.com.globalstart.News_Feed;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ds.gcme.com.globalstart.Database.MyDatabase;
import ds.gcme.com.globalstart.Global_Start;
import ds.gcme.com.globalstart.R;
import ds.gcme.com.globalstart.Sync.SyncService;

/**
 * Created by BENGEOS on 3/17/16.
 */
public class NewsFeed_Fragment extends Fragment {
    private static RecyclerView myRecyclerView;
    private static RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static MyDatabase myDatabase;
    private static Context myContext;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.newsfeed_page,container,false);
        myContext = getContext();
        myRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        myRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new NewsFeed_Adapter(getActivity(), SyncService.myNewsFeeds);
        myRecyclerView.setAdapter(mAdapter);
        myContext = getActivity();
        return view;
    }
    public static void update_view(){
        mAdapter = new NewsFeed_Adapter(myContext, SyncService.myNewsFeeds);
        myRecyclerView.setAdapter(mAdapter);
    }
}
