package ds.gcme.com.globalstart.Do;

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

public class Do_Find_Others extends AppCompatActivity {
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
        image.setImageResource(R.drawable.img_findothers2);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        detail_image = (ImageView) findViewById(R.id.detail_image);
        tv_title = (TextView) findViewById(R.id.txt_news_detail_title);
        tv_content = (TextView) findViewById(R.id.txt_news_detail_content);

        title = "Find Others to help .. ";
        content = "Jesus chose 12 disciples and many others to help fulfill His purposes. He chose those who were teachable and willing to count the cost." +
                "\n\n1. You will also need people who will join you in the mission to reach high school students. There are many opportunities to help, such as being a part of your prayer team, helping to reach and disciple students, giving financially, providing access to the schools, helping with special events, providing food, giving administrative assistance, and so much more." +
                "\n\nHere are some things to look for in volunteers: " +
                "\n• A growing relationship with God and reliance on the power of the Holy Spirit " +
                "\n• A heart for high school students " +
                "\n• Faith to initiate relationships and share the gospel boldly " +
                "\n• A good moral and spiritual role model " +
                "\n• Time: Those who work directly with students should give at least 5 – 10 hours a week";

//        String title = getIntent().getExtras().getString("title");
//        String content = getIntent().getExtras().getString("desc");

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(title);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

        detail_image.setImageResource(R.drawable.img_jesusmodel);
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
