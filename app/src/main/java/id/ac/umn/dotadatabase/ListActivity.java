package id.ac.umn.dotadatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ListActivity extends AppCompatActivity {
    protected RecyclerView heroesListRecyclerView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        heroesListRecyclerView1 = findViewById(R.id.heroesListRecyclerView1);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(
                ( (DotaData.DataBank) getIntent().getSerializableExtra("data") ).getTexts(),
                ( (DotaData.DataBank) getIntent().getSerializableExtra("data") ).getResourceIds()
        );
        heroesListRecyclerView1.setLayoutManager(new LinearLayoutManager(this));
        heroesListRecyclerView1.setAdapter(recyclerViewAdapter);
    }
}