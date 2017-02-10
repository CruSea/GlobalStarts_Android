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

public class Goal_Sowing_Evangelism extends AppCompatActivity {
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
        image.setImageResource(R.drawable.img_sowing);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        detail_image = (ImageView) findViewById(R.id.detail_image);
        tv_title = (TextView) findViewById(R.id.txt_news_detail_title);
        tv_content = (TextView) findViewById(R.id.txt_news_detail_content);

        title = "Sowing and Evangelism.. ";
        content = "Sowing and Evangelism with access to the school" +
                "\n\nTalk to teachers, headmasters, principals, students, churches and parents to find the schools that are most open to you serving them and/or having a Christian influence. In some schools you will be able to talk about Christ. In other schools you will only be able to talk about felt needs and share Christ outside of the school." +
                "Become an insider within the school through serving them. As you serve you can meet and begin to develop relationships with students in school, at lunch, after school, or any way that you can gain access to them. \n" +

                "\n\nIdeas to serve the school: " +
                "\n• Offer school-wide events and programs through athletic competitions, motivational speakers and fun activities. " +
                "\n• Tutor students. " +
                "\n• Speak in classes about morals, values, character or felt needs. " +
                "\n• Volunteer at school events. • Get involved with musical groups, leadership students or clubs. " +
                "\n• Take cookies or food to the administrators and let them know that you are praying for them."+

                "\n\nTaking Action: "+
                "\n1. What are the felt needs and the real needs of the school, the administration and the students? " +
                "\n2. List all the ways that you can serve the school so you can develop relationships and have an opportunity to share the Gospel. " +
                "\n3. Talk to the principal and teachers to offer your help. " +
                "\n4. When you meet students, always ask for their contact information and set up appointments after school to share Christ with them. " +
                "\n5. In classrooms or large events, always have comment cards to get students’ contact information and interest in meeting with you. Set up appointments to share Christ with those who are interested." +

                "\n\nSowing and Evangelism with NO access to the school"+
                "\n\nWhere can you find access to students? There are ways to meet students and have opportunities to share your faith even if you never go to campus. Find out where students go after school or where they gather in the evenings and on the weekends.  Initiate conversations with students and take opportunities to talk to them about God." +
                "\n\nPartner with churches and train the Christian students to share their faith. You can send the students back to their schools to share Christ with their friends and then invite their friends to activities off campus. Students can have outreaches and parties in their homes, in parks, at restaurants or in many other locations. " +
                "\n\nCan you use social media to meet kids and build trust in relationships with those you have met? \n" +
                "\nInvite students to fun activities, English corners, sports competitions and weekly meetings at student’s homes that include games and a short biblical message."+

                "\n\nTaking Action: "+
                "\n1. Where are places that you could go to be around teenagers? Where do they gather together?  Where do they spend their free time? In what groups outside of school do they participate? What are creative ways to meet students?  " +
                "\n2. Go to where students are and develop relationships, praying that God will raise up spiritually interested students.  " +
                "\n3. Where can you find Christian teenagers who you can challenge and train to reach out to their friends at school? " +
                "\n4. What churches can you work alongside or partner with to train their students? " +
                "\n5. What activities and outreaches can you have that Christian students can invite their unbelieving friends to attend?";

//        String title = getIntent().getExtras().getString("title");
//        String content = getIntent().getExtras().getString("desc");

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(title);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

        detail_image.setImageResource(R.drawable.img_sowing2);
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
