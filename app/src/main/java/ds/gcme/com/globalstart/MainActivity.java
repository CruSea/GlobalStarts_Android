package ds.gcme.com.globalstart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.goka.blurredgridmenu.GridMenu;
import com.goka.blurredgridmenu.GridMenuFragment;

import java.util.ArrayList;
import java.util.List;

import ds.gcme.com.globalstart.Do.SubMenu_Do;
import ds.gcme.com.globalstart.Goal.SubMenu_Goal;
import ds.gcme.com.globalstart.GodHeart.SubMenu_GodHeart;
import ds.gcme.com.globalstart.Learn.SubMenu_Learn;
import ds.gcme.com.globalstart.Menu_Options.ContactUsOptions;
import ds.gcme.com.globalstart.Menu_Options.MoreOptions;
import ds.gcme.com.globalstart.Menu_Options.SendTestimony;

public class MainActivity  extends AppCompatActivity {

    private GridMenuFragment mGridMenuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        /** Making this activity, full screen */
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        mGridMenuFragment = GridMenuFragment.newInstance(R.drawable.global_start);

//        findViewById(R.id.show_menu_button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
//                tx.replace(R.id.main_frame, mGridMenuFragment);
//                tx.addToBackStack(null);
//                tx.commit();
//            }
//        });

        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.main_frame, mGridMenuFragment);
//        tx.addToBackStack(null);
        tx.commit();

        setupGridMenu();

        mGridMenuFragment.setOnClickMenuListener(new GridMenuFragment.OnClickMenuListener() {
            @Override
            public void onClickMenu(GridMenu gridMenu, int position) {
//                Toast.makeText(MainActivity.this, "Title:" + gridMenu.getTitle() + ", Position:" + position,
//                        Toast.LENGTH_SHORT).show();
                chooseSubMenu(position);

            }
        });
    }

    public void chooseSubMenu(int position){
        if(position == 0){
            Toast.makeText(this,"NewsFeed", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this,NewsFeed.class);
            startActivity(intent);
        }else  if(position == 1){
            Intent intent = new Intent(MainActivity.this,Intro.class);
            startActivity(intent);
        }
        else if(position == 2){
            Intent intent = new Intent(MainActivity.this, SubMenu_GodHeart.class);

//            String[] ids = new String[]{"1","2","3"};
//            String[] titles = new String[]{"Teenagers","Biblical Examples","Take Action"};
//            String[] desc = new String[]{"teenagers","examples","action"};
//
//            Bundle b = new Bundle();
//            b.putStringArray("ids",ids);
//            b.putStringArray("titles",titles);
//            b.putStringArray("descs",desc);
//
//            intent.putExtras(b);

            startActivity(intent);
        }
        else if(position == 3){
            Intent intent = new Intent(MainActivity.this, SubMenu_Learn.class);

//            String[] ids = new String[]{"1","2","3","4"};
//            String[] titles = new String[]{"Understand The Youth","Jesus's Model","How to Learn","Take Action"};
//            String[] desc = new String[]{"youth","model","learn","action time"};
//
//            Bundle b = new Bundle();
//            b.putStringArray("ids",ids);
//            b.putStringArray("titles",titles);
//            b.putStringArray("descs",desc);
//
//            intent.putExtras(b);

            startActivity(intent);
        }
        else if(position == 4){
            Intent intent = new Intent(MainActivity.this, SubMenu_Do.class);

//            String[] ids = new String[]{"1","2","3"};
//            String[] titles = new String[]{"Prayer","Find Others to Help","Take Action"};
//            String[] desc = new String[]{"pray","help","Action time"};
//
//            Bundle b = new Bundle();
//            b.putStringArray("ids",ids);
//            b.putStringArray("titles",titles);
//            b.putStringArray("descs",desc);
//
//            intent.putExtras(b);

            startActivity(intent);
        }

        else if(position == 5){
            Intent intent = new Intent(MainActivity.this, SubMenu_Goal.class);

//            String[] ids = new String[]{"1","2","3","4","5","6"};
//            String[] titles = new String[]{"Know the Goal","Win","Sowing & Evangelism","Build","Send","Send Movements"};
//            String[] desc = new String[]{"goal","win","sow","build","send","movements"};
//
//            Bundle b = new Bundle();
//            b.putStringArray("ids",ids);
//            b.putStringArray("titles",titles);
//            b.putStringArray("descs",desc);
//
//            intent.putExtras(b);

            startActivity(intent);
        }
        else if(position==6){
            SendTestimony more = new SendTestimony();
            Bundle b = new Bundle();
            b.putString("Title","Contact Us");
            b.putString("Detail", "This App is a global start application which aims to bring about a chhnage in the way the society acts and walks in his way which Christ. \n");
            more.setArguments(b);
            more.show(getFragmentManager(),"Contact us");
        }
        else if(position==7){
            MoreOptions more = new MoreOptions();
            Bundle b = new Bundle();
            b.putString("Title","About Us");
            b.putString("Detail", "This App is a global start application which aims to bring about a change in the way the society acts and walks in his way which Christ. \n");
            more.setArguments(b);
            more.show(getFragmentManager(),"About us");
        }

        else if(position==8){
            ContactUsOptions more = new ContactUsOptions();
            Bundle b = new Bundle();
            b.putString("Title","Contact Us");
            b.putString("Detail", "This App is a global start application which aims to bring about a chhnage in the way the society acts and walks in his way which Christ. \n");
            more.setArguments(b);
            more.show(getFragmentManager(),"Contact us");
        }
    }
    private void setupGridMenu() {
        List<GridMenu> menus = new ArrayList<>();
        menus.add(new GridMenu("News Feed", R.drawable.home));
        menus.add(new GridMenu("Intro", R.drawable.calendar));
        menus.add(new GridMenu("God's Heart", R.drawable.overview));
        menus.add(new GridMenu("Learn", R.drawable.groups));
        menus.add(new GridMenu("Do", R.drawable.lists));
        menus.add(new GridMenu("Goal", R.drawable.profile));
        menus.add(new GridMenu("Testimony", R.drawable.profile));
        menus.add(new GridMenu("About", R.drawable.profile));
        menus.add(new GridMenu("Contact", R.drawable.profile));

        mGridMenuFragment.setupMenu(menus);
    }

    @Override
    public void onBackPressed() {
//        if (0 == getSupportFragmentManager().getBackStackEntryCount()) {
//            super.onBackPressed();
//        } else {
//            getSupportFragmentManager().popBackStack();
//        }
        super.onBackPressed();
        this.finish();

    }
}
