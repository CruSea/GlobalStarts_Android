package ds.gcme.com.globalstart.Goal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import ds.gcme.com.globalstart.R;
import ds.gcme.com.globalstart.Share;

public class Goal_Know_Goal extends AppCompatActivity {
    CollapsingToolbarLayout collapsingToolbarLayout;
    ImageView image,detail_image;
    TextView tv_title, tv_content;

    String title;
    String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        image = (ImageView) findViewById(R.id.image);
        image.setImageResource(R.drawable.img_know_goal);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        detail_image = (ImageView) findViewById(R.id.detail_image);
        tv_title = (TextView) findViewById(R.id.txt_news_detail_title);
        tv_content = (TextView) findViewById(R.id.txt_news_detail_content);

        title = "Know the Goal .. ";
        content = "Jesus went from town to town preaching the Good News. He spoke to the masses and ate dinner with individuals. He chose 12 ordinary men to disciple, train and pour His life into. Jesus modeled His life and taught them to love, serve, pray, and minister to others. Then He equipped them with the Word and the Holy Spirit and sent them out to disciple the nations." +
                "\n\nJesus had three main aspects to His movement:"+
                "\n\n1. Win - people to Himself through evangelism " +
                "\n2. Build - disciples – teaching them to be in relationship with Him and training them to do the work that He was doing " +
                "\n3. Send - them out to multiply their faith and help fulfill the Great Commission.";

//        String title = getIntent().getExtras().getString("title");
//        String content = getIntent().getExtras().getString("desc");

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(title);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

       // detail_image.setImageResource(R.drawable.pic);
        tv_title.setText(title);
        tv_content.setText(content);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id==R.id.action_share){
            Intent shareintent = Share.share(content);
            startActivity(Intent.createChooser(shareintent, getResources().getString(R.string.app_name)));

        }
        return super.onOptionsItemSelected(item);
    }


}
