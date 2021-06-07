package id.ac.umn.dotadatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class HeroesListActivity extends AppCompatActivity {
    protected RecyclerView heroesListRecyclerView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes_list);
        heroesListRecyclerView1 = findViewById(R.id.heroesListRecyclerView1);

        //String strengthHeroNames[] = {"Abbadon", "Alchemist", "Axe", "Beastmaster", "Brewmaster", "Bristleback", "Centaur Warruner", "Chaos Knight", "Clockwerk", "Dawnbreaker", "Doom", "Dragon Knight", "Earth Spirit", "Earthshaker", "Elder Titan", "Huskar", "Io", "Kunkka", "Legion Commander", "Lifestealer", "Lycan", "Magnus", "Mars", "Night Stalker", "Omniknight", "Phoenix", "Pudge", "Sand King", "Slardar", "Snapfire", "Spirit Breaker", "Sven", "Tidehunter", "Timbersaw", "Tiny", "Treant Protector", "Tusk", "Underlord", "Undying", "Wraith King"};
        //int strengthHeroPortraitResourceIds[] = {R.drawable.abba, R.drawable.alchemist, R.drawable.axe, R.drawable.beastmaster, R.drawable.brewmaster, R.drawable.bristleback, R.drawable.centaur, R.drawable.chaos_knight, R.drawable.clockwerk, R.drawable.dawnbreaker, R.drawable.doom, R.drawable.dragon_knight, R.drawable.earth_spirit, R.drawable.earthshaker, R.drawable.elder_titan, R.drawable.huskar, R.drawable.io, R.drawable.kunkka, R.drawable.legion, R.drawable.lifestealer, R.drawable.lycan, R.drawable.magnus, R.drawable.mars, R.drawable.night_stalker, R.drawable.omni, R.drawable.phoenix, R.drawable.pudge, R.drawable.sand_king, R.drawable.slardar, R.drawable.snapfire, R.drawable.spirit_breaker, R.drawable.sven, R.drawable.tidehunter, R.drawable.timber, R.drawable.tiny, R.drawable.treant, R.drawable.tusk, R.drawable.underlord, R.drawable.undying, R.drawable.wraith};

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(
                ( (DotaData.DataBank) getIntent().getSerializableExtra("data") ).getTexts(),
                ( (DotaData.DataBank) getIntent().getSerializableExtra("data") ).getResourceIds()
        );
        heroesListRecyclerView1.setLayoutManager(new LinearLayoutManager(this));
        heroesListRecyclerView1.setAdapter(recyclerViewAdapter);
    }
}