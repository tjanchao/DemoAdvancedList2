package be.ehb.demoadvancedlist.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import be.ehb.demoadvancedlist.R;
import be.ehb.demoadvancedlist.model.Fruit;
import be.ehb.demoadvancedlist.util.FruitListAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView lvFruit;
    private FruitListAdapter mFruitListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvFruit = findViewById(R.id.lv_fruit);

        Fruit apple = new Fruit("apple",1.50f);
        Fruit pear = new Fruit("pear", 2.50f);
        Fruit orange = new Fruit("orange", 3.50f);

        //deze arraylist wordt doorgegeven aan FruitListAdapter
        ArrayList<Fruit> fruitList = new ArrayList<>();
        fruitList.add(apple);
        fruitList.add(pear);
        fruitList.add(orange);

        mFruitListAdapter = new FruitListAdapter(fruitList, this);
        lvFruit.setAdapter(mFruitListAdapter);

        lvFruit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Fruit selectedFruit = (Fruit) mFruitListAdapter.getItem(position);

                //navigeren naar detailscherm en geef geselecteerde fruit door
                Intent i = new Intent(getApplicationContext(),DetailsActivity.class);
                i.putExtra("fruit", selectedFruit);
                startActivity(i);

                Toast.makeText(getApplicationContext(),selectedFruit.getName(),Toast.LENGTH_SHORT).show();


            }
        });
    }
}
