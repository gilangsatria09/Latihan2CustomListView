package com.example.superhero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Hero> heroList;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heroList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView);

        heroList.add(new Hero(R.drawable.spiderman,"Spiderman","Avengers"));
        heroList.add(new Hero(R.drawable.joker,"Joker","Injustice Gang"));
        heroList.add(new Hero(R.drawable.ironman,"Iron Man","Avengers"));
        heroList.add(new Hero(R.drawable.doctorstrange,"Doctor Strange","Avengers"));
        heroList.add(new Hero(R.drawable.captainamerica,"Captain America","Avengers"));
        heroList.add(new Hero(R.drawable.batman,"Batman","Justice League"));
        heroList.add(new Hero(R.drawable.art_clear,"Clear","Weather"));
        heroList.add(new Hero(R.drawable.art_rain,"Rain","Weather"));


        MyListAdapter adapter = new MyListAdapter(this,R.layout.listview_layout,heroList);
        listView.setAdapter(adapter);


    }
}
