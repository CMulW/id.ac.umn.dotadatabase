package id.ac.umn.dotadatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HeroesMenuActivity extends AppCompatActivity {
    protected ImageView heroesMenuIvStrength;
    protected ImageView heroesMenuIvAgility;
    protected ImageView heroesMenuIvIntelligence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes_menu);
        heroesMenuIvStrength = findViewById(R.id.heroesMenuIvStrength);
        heroesMenuIvAgility = findViewById(R.id.heroesMenuIvAgility);
        heroesMenuIvIntelligence = findViewById(R.id.heroesMenuIvIntelligence);

        heroesMenuIvStrength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(HeroesMenuActivity.this, ListActivity.class)
                                .putExtra("data", new DotaData.StrengthHeroesData())
                );
            }
        });
        heroesMenuIvAgility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(HeroesMenuActivity.this, ListActivity.class)
                                .putExtra("data", new DotaData.AgilityHeroesData())
                );
            }
        });
        heroesMenuIvIntelligence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(HeroesMenuActivity.this, ListActivity.class)
                                .putExtra("data", new DotaData.IntelligenceHeroesData())
                );
            }
        });
    }
}