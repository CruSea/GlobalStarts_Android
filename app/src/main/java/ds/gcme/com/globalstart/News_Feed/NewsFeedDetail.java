package ds.gcme.com.globalstart.News_Feed;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import ds.gcme.com.globalstart.Global_Start;
import ds.gcme.com.globalstart.R;
import ds.gcme.com.globalstart.Sync.SyncService;


/**
 * Created by BENGEOS on 4/16/16.
 */
public class NewsFeedDetail extends AppCompatActivity {
    private String news_id;
    private NewsFeed newsFeed;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private static ImageView NewsImage;
    private static TextView Title;
    private static TextView Content;
    private static TextView PubDate;
    private static NewsFeed myNewsFeed;
    private static String newsUUID;
    private static Context myContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_feed_detail);
        setSupportActionBar((Toolbar) findViewById(R.id.news_feed_detail_toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myContext = this;
        newsUUID = getIntent().getExtras().getString("UUID");
        NewsImage = (ImageView) findViewById(R.id.news_feed_detail_image);
        Title = (TextView) findViewById(R.id.news_feed_detail_title);
        Content = (TextView) findViewById(R.id.news_feed_detail_content);
        PubDate = (TextView) findViewById(R.id.news_feed_detail_date);
        //collapsing toolbar
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.news_feed_detail_collapsing_toolbar);
        news_id = getIntent().getExtras().getString("news_id");
//        newsFeed = Global_Start.myDatabase.get_NewsFeed_by_NewsID(news_id);
        collapsingToolbarLayout.setTitle("Deep Life NewsFeeds");
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        Toast.makeText(this,""+newsUUID,Toast.LENGTH_LONG).show();
        updateView();
    }
    public static void updateView(){
        for(int i = 0; i< SyncService.myNewsFeeds.size(); i++){
            if(SyncService.myNewsFeeds.get(i).getUUID().equals(newsUUID)){
                myNewsFeed = SyncService.myNewsFeeds.get(i);
            }
        }
        if(myNewsFeed != null){
            Glide.with(myContext)
                    .load(myNewsFeed.getImageURL())
                    .into(NewsImage);
            Title.setText(""+myNewsFeed.getTitle());
            Content.setText(""+myNewsFeed.getDetail());
            PubDate.setText(""+myNewsFeed.getPubDate());
        }
    }
}
