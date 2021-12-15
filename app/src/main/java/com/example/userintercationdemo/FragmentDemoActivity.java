package com.example.userintercationdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

public class FragmentDemoActivity extends AppCompatActivity {

    private TabLayout tblFragment;
    private ViewPager  vpFragment;
    private Button btnRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
        tblFragment=(TabLayout) findViewById(R.id.tblFragment);
        vpFragment= findViewById(R.id.vpFragment);
        vpFragment.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        tblFragment.setupWithViewPager(vpFragment);
        btnRecyclerView=(Button)findViewById(R.id.btnGoReCycleView);
        tblFragment.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpFragment.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
      btnRecyclerView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i=new Intent(FragmentDemoActivity.this,RecyclerView.class);
              startActivity(i);

          }
      });

    }
    static class ViewPagerAdapter extends FragmentPagerAdapter{

        String data[]={"Java","Android","Ios"};

        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
           if(position==0){
               return new Java();
           }

           if(position==1){
               return new AndroidFragment();
           }
           if(position==2) {
               return new IosFragment();

           }
            return null;
        }

        @Override
        public int getCount() {
            return data.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return data[position];
        }
    }

}
