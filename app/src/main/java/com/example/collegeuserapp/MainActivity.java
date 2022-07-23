package com.example.collegeuserapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Bottom Navigation
        BottomNavigation();

    }
    //method to replace screen after click bottom sheet Navigation item
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

}