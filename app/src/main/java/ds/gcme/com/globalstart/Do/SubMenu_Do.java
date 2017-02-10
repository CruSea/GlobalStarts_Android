package ds.gcme.com.globalstart.Do;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import ds.gcme.com.globalstart.Director;
import ds.gcme.com.globalstart.Model.SubMenuItem;
import ds.gcme.com.globalstart.R;

/**
 * Created by Roger on 6/15/2016.
 */
public class SubMenu_Do extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submenu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.submenutoolbar);
        toolbar.setTitle("Do");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.listview);
//
//        String[] id = getIntent().getExtras().getStringArray("ids");
//        String[] title = getIntent().getExtras().getStringArray("titles");
//        String[] desc = getIntent().getExtras().getStringArray("descs");

        String[] id = new String[]{"0","1","2"};
        String[] title = new String[]{"Prayer","Find Others to Help","Take Action"};
        String[] desc = new String[]{"Prayer is very important","You need people who will join you","What to do?"};

        ArrayList<SubMenuItem> menuItems = new ArrayList<SubMenuItem>();

        for(int i = 0; i<id.length ; i++){
            SubMenuItem item = new SubMenuItem();
            item.setId(id[i]);
            item.setTitle(title[i]);
            item.setDesc(desc[i]);
            menuItems.add(item);
        }

        MyAdapter myAdapter = new MyAdapter(this,menuItems);

        listView.setAdapter(myAdapter);

    }


    public static class MyAdapter extends BaseAdapter
    {
        public static ArrayList<SubMenuItem> menus;
        public Context context;
        private int mCount;

        public MyAdapter(Context context, ArrayList<SubMenuItem> menu)
        {
            this.context = context;
            this.menus = menu;
            mCount = menus.size();
            Log.i("LoadTest","Count Length at start "+mCount);
        }


        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mCount;
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
                return null;
        }


        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflate.inflate(R.layout.single_layout, null);

            if (position <= mCount) {
                TextView tv_title = (TextView) convertView.findViewById(R.id.sub_menu_title);
                TextView tv_definition = (TextView) convertView.findViewById(R.id.sub_menu_desc);

                final String title = menus.get(position).getTitle();
                final String definition = menus.get(position).getDesc();
                tv_title.setText(title);
                tv_definition.setText(definition);

                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = Director.getDo(context, Integer.parseInt(menus.get(position).getId()));
                        context.startActivity(intent);
                    }
                });
            }
            return convertView;
        }
    }
}
