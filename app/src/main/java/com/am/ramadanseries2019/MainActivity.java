package com.am.ramadanseries2019;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.am.ramadanseries2019.adapter.SliderPagerAdapter;
import com.am.ramadanseries2019.databinding.ActivityMainBinding;
import com.am.ramadanseries2019.databinding.ContentMainBinding;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ActivityMainBinding mLayout;
    ContentMainBinding mContentLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayout = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mContentLayout = mLayout.contentMain;
        setSupportActionBar(mLayout.toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mLayout.drawerLayout, mLayout.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mLayout.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mLayout.navView.setNavigationItemSelectedListener(this);

        setupSlider();
    }

    @Override
    public void onBackPressed() {

        if (mLayout.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mLayout.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }


        mLayout.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    private void setupSlider() {
        int dotCount;
        ImageView[] dots;
        SliderPagerAdapter viewPageAdapter = new SliderPagerAdapter(this);
        mContentLayout.sliderPager.setAdapter(viewPageAdapter);
        dotCount = viewPageAdapter.getCount();
        dots = new ImageView[dotCount];

        for (int i = 0; i < dotCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dot_non_active));
            mContentLayout.sliderDots.addView(dots[i]);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dot_active));
        mContentLayout.sliderPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotCount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dot_non_active));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dot_active));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new myTimerTask(), 4000, 4000);
    }

    public class myTimerTask extends TimerTask {
        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (mContentLayout.sliderPager.getCurrentItem() == 0) {
                        mContentLayout.sliderPager.setCurrentItem(1);
                    } else if (mContentLayout.sliderPager.getCurrentItem() == 1) {
                        mContentLayout.sliderPager.setCurrentItem(2);
                    } else {
                        mContentLayout.sliderPager.setCurrentItem(0);
                    }

                }
            });
        }
    }
}


