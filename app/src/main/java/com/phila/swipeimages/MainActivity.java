package com.phila.swipeimages;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewpager);
        ArrayList<Integer> images = new ArrayList(Arrays.asList(R.drawable.kermit_break,
                R.drawable.kermit_goes_shopping, R.drawable.kermit_opening_bottle,
                R.drawable.kermit_drunk));
        ImageAdapter adapter = new ImageAdapter(this, images);
        viewPager.setAdapter(adapter);

    }

    public class ImageAdapter extends PagerAdapter {

        Context context;
        private ArrayList<Integer> imageResourceList;

        public ImageAdapter(Context context, ArrayList<Integer> imageResourceList) {
            this.context = context;
            this.imageResourceList = imageResourceList;
        }

        @Override
        public int getCount() {
            return imageResourceList.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView iv = new ImageView(context);
            iv.setImageResource(imageResourceList.get(position));
            container.addView(iv);
            return iv;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((ImageView) object);
        }
    }
}
