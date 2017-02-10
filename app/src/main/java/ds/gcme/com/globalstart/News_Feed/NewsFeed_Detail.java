package ds.gcme.com.globalstart.News_Feed;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import ds.gcme.com.globalstart.Model.News_Data;
import ds.gcme.com.globalstart.R;

/**
 * Created by BENGEOS on 3/17/16.
 */
public class NewsFeed_Detail extends AppCompatActivity {
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Button Send;
    private Context myContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newsfeed_details);
        toolbar = (Toolbar) findViewById(R.id.news_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Global Start");
        getSupportActionBar().setSubtitle("News Feed");
        myContext = this;
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        final List<News_Data> news = new ArrayList<News_Data>();
        News_Data N1= new News_Data();
        N1.setContent("This is Content");
        N1.setImage("This is Image");
        N1.setTitle("This is Title");
        news.add(N1);
        news.add(new News_Data());
        news.add(N1);
        final Gson gson = new Gson();

        Send = (Button) findViewById(R.id.btn_send);

        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(myContext,gson.toJson(news), Toast.LENGTH_LONG).show();
            }
        });
    }


}
