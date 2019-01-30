package com.am.ramadanseries2019.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.am.ramadanseries2019.R;

public class SliderPagerAdapter extends PagerAdapter {

    private Context mContext;
    private LayoutInflater layoutInflater;
    private int[] images = {R.drawable.poster, R.drawable.poster, R.drawable.poster, R.drawable.poster};

    public SliderPagerAdapter(Context context) {
        this.mContext = context;
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = layoutInflater.inflate(R.layout.slide, null);
        ImageView imageView = view.findViewById(R.id.slideImageView);

        imageView.setImageResource(images[position]);
        view.setOnClickListener(v -> {
            if (position == 0) {
                Toast.makeText(mContext, "Slide 1 Clicked ", Toast.LENGTH_SHORT).show();
            } else if (position == 1) {
                Toast.makeText(mContext, "Slide 2 Clicked ", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(mContext, "Slide 3 Clicked ", Toast.LENGTH_SHORT).show();
            }
        });

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);

    }
}
