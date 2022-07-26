package com.example.collegeuserapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.collegeuserapp.Fragments.AboutFragment;
import com.example.collegeuserapp.Fragments.GalleryFragment;
import com.example.collegeuserapp.Fragments.HomeFragment;
import com.example.collegeuserapp.Fragments.NoticeFragment;
import com.example.collegeuserapp.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Navigation Drawer
        NavigationDrawer();

        //Bottom Navigation
        BottomNavigation();

    }


//    //method to replace screen after click bottom sheet Navigation item
    private void BottomNavigation(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        HomeFragment fragment1 = new HomeFragment();
        transaction.replace(R.id.containers,fragment1);
        transaction.commit();

//        add bottomNavigation in layout xml and create menu folder inside res and add menu item
        binding.BottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch(item.getItemId()){
                    case R.id.homefragment:
                        HomeFragment fragment1 = new HomeFragment();
                        transaction.replace(R.id.containers,fragment1);
                        break;
                    case R.id.noticefragment:
                        NoticeFragment fragment2 = new NoticeFragment();
                        transaction.replace(R.id.containers,fragment2);
                        break;
                    case R.id.galleryfragment:
                        GalleryFragment fragment3 = new GalleryFragment();
                        transaction.replace(R.id.containers,fragment3);
                        break;
                    case R.id.aboutfragment:
                        AboutFragment fragment4 = new AboutFragment();
                        transaction.replace(R.id.containers,fragment4);
                        break;
                }
                transaction.commit();
                return false;
            }
        });
    }


//method for Navigation drawer
    private void NavigationDrawer(){
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //for Navigation drawer
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}