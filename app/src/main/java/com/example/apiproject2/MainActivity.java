package com.example.apiproject2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.apiproject2.Fragments.CountryFragment;
import com.example.apiproject2.Fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemReselectedListener {
    TextView title1;
    BottomNavigationView bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HomeFragment homeFragment=new HomeFragment();
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,homeFragment);
        fragmentTransaction.commit();



        setContentView(R.layout.activity_main);
        title1=findViewById(R.id.title);

        bottomNavigation=findViewById(R.id.bottomNavigation);
        bottomNavigation.setOnNavigationItemReselectedListener(this);
    }
    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.nav_home:
                HomeFragment homeFragment=new HomeFragment();
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,homeFragment);
                fragmentTransaction.commit();
                title1.setText("صفحه اصلی");

                break;
            case R.id.nav_country:
                CountryFragment countryFragment=new CountryFragment();
                FragmentTransaction fragmentTransaction1 =getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.frameLayout,countryFragment);
                fragmentTransaction1.commit();
                title1.setText("کشورها");

                break;

        }


    }
}