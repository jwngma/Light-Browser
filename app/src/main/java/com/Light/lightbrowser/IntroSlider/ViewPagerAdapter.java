package com.Light.lightbrowser.IntroSlider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.Light.lightbrowser.R;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;


    public ViewPagerAdapter(Context context) {
        this.context = context;
    }


    private int[] images = {
            R.drawable.account,
            R.drawable.ai,
            R.drawable.garbage,
            R.drawable.graph,
            R.drawable.pdf,
            R.drawable.person
    };
    private String[] tiltles = {
            " Add", " Collar", "Lethal", "Cloud", "Coin", "Coffe"
    };

    private String[] desc = {
            "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.",
            "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.",
            "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.",
            "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.",
            "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.",
            "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.",
    };

    @Override
    public int getCount() {
        return images.length;

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_single_layout, container, false);

        ImageView slider_image=view.findViewById(R.id.slider_image);
        TextView slider_title=view.findViewById(R.id.slider_title);
        TextView slider_desc=view.findViewById(R.id.slider_desc);

        slider_image.setImageResource(images[position]);
        slider_title.setText(tiltles[position]);
        slider_desc.setText(desc[position]);


        container.addView(view);
        return view;


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
