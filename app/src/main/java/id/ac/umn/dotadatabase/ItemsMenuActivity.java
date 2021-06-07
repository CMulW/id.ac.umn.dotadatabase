package id.ac.umn.dotadatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ItemsMenuActivity extends AppCompatActivity {
    protected ImageButton consumables;
    protected ImageButton attributes;
    protected ImageButton equipment;
    protected ImageButton misc;
    protected ImageButton secret;
    protected ImageButton roshan;
    protected ImageButton accessories;
    protected ImageButton support;
    protected ImageButton magical;
    protected ImageButton armor;
    protected ImageButton weapon;
    protected ImageButton artifacts;
    protected ImageButton tier1;
    protected ImageButton tier2;
    protected ImageButton tier3;
    protected ImageButton tier4;
    protected ImageButton tier5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_menu);
        consumables = findViewById(R.id.consumables);
        attributes = findViewById(R.id.attributes);
        equipment = findViewById(R.id.equipment);
        misc = findViewById(R.id.misc);
        secret = findViewById(R.id.secret);
        roshan = findViewById(R.id.roshan);
        accessories = findViewById(R.id.accessories);
        support = findViewById(R.id.support);
        magical = findViewById(R.id.magical);
        armor = findViewById(R.id.armor);
        weapon = findViewById(R.id.weapon);
        artifacts = findViewById(R.id.artifacts);
        tier1 = findViewById(R.id.tier1);
        tier2 = findViewById(R.id.tier2);
        tier3 = findViewById(R.id.tier3);
        tier4 = findViewById(R.id.tier4);
        tier5 = findViewById(R.id.tier5);

        consumables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(ItemsMenuActivity.this, ListActivity.class)
                                .putExtra("data", new DotaData.ConsumablesData())
                );
            }
        });
        attributes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(ItemsMenuActivity.this, ListActivity.class)
                                .putExtra("data", new DotaData.AttributesData())
                );
            }
        });
        equipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(ItemsMenuActivity.this, ListActivity.class)
                                .putExtra("data", new DotaData.EquipmentData())
                );
            }
        });
        misc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(ItemsMenuActivity.this, ListActivity.class)
                                .putExtra("data", new DotaData.MiscData())
                );
            }
        });
        secret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(ItemsMenuActivity.this, ListActivity.class)
                                .putExtra("data", new DotaData.SecretData())
                );
            }
        });
        roshan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(ItemsMenuActivity.this, ListActivity.class)
                                .putExtra("data", new DotaData.RoshanData())
                );
            }
        });
        accessories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(ItemsMenuActivity.this, ListActivity.class)
                                .putExtra("data", new DotaData.AccessoriesData())
                );
            }
        });
        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(ItemsMenuActivity.this, ListActivity.class)
                                .putExtra("data", new DotaData.SupportData())
                );
            }
        });

        magical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(ItemsMenuActivity.this, ListActivity.class)
                                .putExtra("data", new DotaData.MagicalData())
                );
            }
        });
        armor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(ItemsMenuActivity.this, ListActivity.class)
                                .putExtra("data", new DotaData.ArmorData())
                );
            }
        });
        weapon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(ItemsMenuActivity.this, ListActivity.class)
                                .putExtra("data", new DotaData.WeaponData())
                );
            }
        });
        artifacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(ItemsMenuActivity.this, ListActivity.class)
                                .putExtra("data", new DotaData.ArtifactsData())
                );
            }
        });
        tier1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(ItemsMenuActivity.this, ListActivity.class)
                                .putExtra("data", new DotaData.Tier1Data())
                );
            }
        });
        tier2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(ItemsMenuActivity.this, ListActivity.class)
                                .putExtra("data", new DotaData.Tier2Data())
                );
            }
        });
        tier3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(ItemsMenuActivity.this, ListActivity.class)
                                .putExtra("data", new DotaData.Tier3Data())
                );
            }
        });
        tier4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(ItemsMenuActivity.this, ListActivity.class)
                                .putExtra("data", new DotaData.Tier4Data())
                );
            }
        });
        tier5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(ItemsMenuActivity.this, ListActivity.class)
                                .putExtra("data", new DotaData.Tier5Data())
                );
            }
        });
    }
}