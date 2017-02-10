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


public class Goal_Build extends AppCompatActivity {
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
        image.setImageResource(R.drawable.img_build);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        detail_image = (ImageView) findViewById(R.id.detail_image);
        tv_title = (TextView) findViewById(R.id.txt_news_detail_title);
        tv_content = (TextView) findViewById(R.id.txt_news_detail_content);

        title = "Build .. ";
        content = "In Matthew 28:19-20, Jesus says, “Therefore go and make disciples of all nations, baptizing them in the name of the Father and of the Son and of the Holy Spirit, and teaching them to obey everything I have commanded you. And surely I am with you always, to the very end of the age.” \\n\\n Jesus spent time with His disciples, modeling His life and ministry and helping them grow into people who would continue a ministry of evangelism and discipleship long after He was gone (John 14:12)." +
                "\n\nSpecific things that Jesus taught His disciples:"+
                "\n• The importance of time with the Lord (Mark 1:35) " +
                "\n• Dependence on God (John 18:28,29) " +
                "\n• How to pray (Luke 11:1-4) " +
                "\n• Truth through Jesus’ teachings that caused a deeper thirst " +
                "\n• To put His words into action (Matthew 7:24-29) " +
                "\n• Evangelism and ministering to others (Throughout the Gospels, the disciples were learning from Jesus as they observed and participated in ministry together.) " +
                "\n• How to be multipliers of their faith (Mark 3:13-19) " +

                "\n\nTaking Action: "+
                "\n1. Make a list of the biblical truths and spiritual disciplines that you want new believers to know and understand. " +
                "\n2. What are ways that your discipleship of teenagers could be modeled after Jesus’ discipleship of His 12? " +
                "\n3. What are creative ways to teach them truths and train them to share their faith? " +
                "\n4. How can you utilize fun activities, discipleship groups, retreats and conferences to help develop disciples of Christ?";

//        String title = getIntent().getExtras().getString("title");
//        String content = getIntent().getExtras().getString("desc");

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(title);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

        detail_image.setImageResource(R.drawable.img_howtolearn);
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
