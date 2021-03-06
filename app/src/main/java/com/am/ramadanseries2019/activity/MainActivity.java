package com.am.ramadanseries2019.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import com.am.ramadanseries2019.model.Episode;
import com.am.ramadanseries2019.model.Series;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.am.ramadanseries2019.R;
import com.am.ramadanseries2019.adapter.SeriesAdapter;
import com.am.ramadanseries2019.adapter.SliderPagerAdapter;
import com.am.ramadanseries2019.databinding.ActivityMainBinding;
import com.am.ramadanseries2019.databinding.ContentMainBinding;
import com.am.ramadanseries2019.model.Category;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ActivityMainBinding mLayout;
    private ContentMainBinding mContentLayout;
    private SeriesAdapter mSeriesAdapter;

    private FirebaseFirestore mFireStore;
    private CollectionReference mCategoriesRef;
    private CollectionReference mSeriesListRef;
    private CollectionReference mEpisodesRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayout = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mContentLayout = mLayout.contentMain;
        setSupportActionBar(mLayout.toolbar);
        setupFireStore();
        setupDrawer();
        setupSlider();
        setupFirstCategoryRecyclerView();
        setupSecondCategoryRecyclerView();
        setupThirdCategoryRecyclerView();

    }
    public void setupFireStore() {
        mFireStore = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        mFireStore.setFirestoreSettings(settings);
        mCategoriesRef = mFireStore.collection("/Categories");
        mSeriesListRef = mFireStore.collection("/Categories/hGbpMXruaszrEEjpFYuu/seriesList");
        mEpisodesRef = mFireStore.collection("/Categories/hGbpMXruaszrEEjpFYuu/seriesList/deYdCF7MMGVe15bJrPKa/episodeList");
    }
    private void getCategories() {

        mCategoriesRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                List<Category> categoryList = task.getResult().toObjects(Category.class);
                categoryList.get(0).setId(task.getResult().getDocuments().get(0).getId());
                task.getResult().getDocuments().get(0).
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

            } else {
                Logger.e("Error getting documents.", task.getException());
            }
        });

        mSeriesListRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                List<Series> seriesList = task.getResult().toObjects(Series.class);

                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            } else {
                Logger.e("Error getting documents.", task.getException());
            }
        });

        mEpisodesRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                List<Episode> episodeList = task.getResult().toObjects(Episode.class);

                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            } else {
                Logger.e("Error getting documents.", task.getException());
            }
        });



    }



    private void setupDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mLayout.drawerLayout, mLayout.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mLayout.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        mLayout.navView.setNavigationItemSelectedListener(this);
    }


    private void setupFirstCategoryRecyclerView() {
        mContentLayout.categoryOneRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mSeriesAdapter = new SeriesAdapter(this, (view, position, model) -> {
//            Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
//            startActivity(new Intent(MainActivity.this, SeriesActivity.class));
            getCategories();
        });
        mContentLayout.categoryOneRecyclerView.setAdapter(mSeriesAdapter);
    }

    private void setupSecondCategoryRecyclerView() {
        mContentLayout.categoryTwoRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mSeriesAdapter = new SeriesAdapter(this, (view, position, model) -> {
            Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, SeriesActivity.class));
        });
        mContentLayout.categoryTwoRecyclerView.setAdapter(mSeriesAdapter);
    }

    private void setupThirdCategoryRecyclerView() {
        mContentLayout.categoryThreeRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mSeriesAdapter = new SeriesAdapter(this, (view, position, model) -> {
            Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, SeriesActivity.class));
        });
        mContentLayout.categoryThreeRecyclerView.setAdapter(mSeriesAdapter);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

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
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            mContentLayout.sliderDots.addView(dots[i], params);
        }
        reverseLinerLayoutViews();

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
        timer.scheduleAtFixedRate(new SliderTimerTask(), 6000, 6000);
    }

    private void reverseLinerLayoutViews() {
        ArrayList<View> views = new ArrayList<>();
        for (int x = 0; x < mContentLayout.sliderDots.getChildCount(); x++) {
            views.add(mContentLayout.sliderDots.getChildAt(x));
        }
        mContentLayout.sliderDots.removeAllViews();
        for (int x = views.size() - 1; x >= 0; x--) {
            mContentLayout.sliderDots.addView(views.get(x));
        }
    }

    public class SliderTimerTask extends TimerTask {
        @Override
        public void run() {

            MainActivity.this.runOnUiThread(() -> {

                switch (mContentLayout.sliderPager.getCurrentItem()) {
                    case 3:
                        mContentLayout.sliderPager.setCurrentItem(2);
                        break;
                    case 2:
                        mContentLayout.sliderPager.setCurrentItem(1);
                        break;
                    case 1:
                        mContentLayout.sliderPager.setCurrentItem(0);
                        break;
                    default:
                        mContentLayout.sliderPager.setCurrentItem(3);
                        break;
                }

            });
        }
    }
}


