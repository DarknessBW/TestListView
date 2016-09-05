package cn.edu.bistu.cs.se.testlistview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    final static String NAME = "name";
    final static String AGE = "age";
    final static String CLASS = "class";
    final static String SEX = "sex";
    final static String TEL = "tel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] names = {"John","Lisa"};
        String[] ages = {"18","20"};
        String[] classes = {"one","three"};
        String[] sex = {"male","female"};
        String[] tels = {"122595","7754189"};

        List<Map<String,Object>> items = new ArrayList<Map<String,Object>>();

        for(int i=0; i<names.length; i++) {
            Map<String,Object> item = new HashMap<String, Object>();
            item.put(NAME,names[i]);
            item.put(AGE,ages[i]);
            item.put(CLASS,classes[i]);
            item.put(SEX,sex[i]);
            item.put(TEL,tels[i]);
            items.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,items,R.layout.item,new String[]{NAME,AGE,CLASS,SEX,TEL},
                new int[]{R.id.txtName,R.id.txtAge,R.id.txtClass,R.id.txtSex,R.id.txtTel});

        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
