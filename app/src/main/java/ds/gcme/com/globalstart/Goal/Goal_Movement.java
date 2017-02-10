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

public class Goal_Movement extends AppCompatActivity {
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
        image.setImageResource(R.drawable.img_movement);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        detail_image = (ImageView) findViewById(R.id.detail_image);
        tv_title = (TextView) findViewById(R.id.txt_news_detail_title);
        tv_content = (TextView) findViewById(R.id.txt_news_detail_content);

        title = "Build spiritual movements ";
        content = "\nJesus trained and equipped men and women and challenged them to help fulfill the Great Commission. Many of them were faithful to do what God called them to do and that is the reason we know Jesus today. We want to continue that call by building spiritual movements!" +
                "\n\nA spiritual movement is God working through a team of likehearted disciples to win, build and send toward the fulfillment of the Great Commission." +
                "\n\nBuilding a movement involves encouraging students to fall in love with Jesus, walk by faith in the power of the Holy Spirit, and become spiritual multipliers at their high schools by sharing their faith and discipling those who respond. As a result, God will change lives, campuses and countries for eternity as students multiply their faith for a lifetime."+
                "\n\nAre you ready to trust God to see this happen?  " +

                "\n\nTaking Action: "+
                "\n1. Teenagers can have a significant impact in their high schools. Will you pray for students who will come to Christ, be discipled and leave a lasting impact in their schools?  " +
                "\n2. Teenagers can leave their high schools and make an impact on their college campuses. Will you pray and trust God to develop disciples who will continue to grow and disciple others on their college campuses?  " +
                "\n3. Teenagers can be a part of helping fulfill the Great Commission for a lifetime. Will you pray and trust God to develop lifetime laborers who will go into all the world and make disciples of all nations?";

//        String title = getIntent().getExtras().getString("title");
//        String content = getIntent().getExtras().getString("desc");

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(title);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

        detail_image.setImageResource(R.drawable.img_movement_plan);
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
