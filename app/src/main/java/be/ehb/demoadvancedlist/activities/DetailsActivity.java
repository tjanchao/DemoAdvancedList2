package be.ehb.demoadvancedlist.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import be.ehb.demoadvancedlist.R;
import be.ehb.demoadvancedlist.model.Fruit;

public class DetailsActivity extends AppCompatActivity {

    private TextView tvDetailsName;

    @Override //bij foutmelding op alt enter klikken en import R Class
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Fruit passedFruit = (Fruit) getIntent().getSerializableExtra("fruit");

        tvDetailsName = findViewById(R.id.tv_detail_name);

        tvDetailsName.setText(passedFruit.getName() + ", euro " + passedFruit.getPrice());
    }
}
