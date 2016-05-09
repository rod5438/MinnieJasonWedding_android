package com.jason.minniejasonwedding;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import uk.co.senab.photoview.PhotoView;

public class PhotoViewActivity extends Activity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        setContentView(mViewPager);
        mViewPager.setAdapter(new SamplePagerAdapter());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    static class SamplePagerAdapter extends PagerAdapter {

        private static final int[] sDrawables = {
                R.drawable.ds_18327,
                R.drawable.ds_18334,
                R.drawable.ds_18336,
                R.drawable.ds_18337,
                R.drawable.ds_18357,
                R.drawable.ds_18358,
                R.drawable.ds_18362,
                R.drawable.ds_18365,
                R.drawable.ds_18372,
                R.drawable.ds_18376,
                R.drawable.ds_18380,
                R.drawable.ds_18413,
                R.drawable.ds_18415,
                R.drawable.ds_18422,
                R.drawable.ds_18430,
                R.drawable.ds_18433,
                R.drawable.ds_18435,
                R.drawable.ds_18443,
                R.drawable.ds_18445,
                R.drawable.ds_18446,
                R.drawable.ds_18459,
                R.drawable.ds_18465,
                R.drawable.ds_18468,
                R.drawable.ds_18469,
                R.drawable.ds_18470,
                R.drawable.ds_18485,
                R.drawable.ds_18492,
                R.drawable.ds_18500,
                R.drawable.ds_18501,
                R.drawable.ds_18509,
                R.drawable.ds_18519,
                R.drawable.ds_18520,
                R.drawable.ds_18527,
                R.drawable.ds_18530,
                R.drawable.ds_18532,
                R.drawable.ds_18540,
                R.drawable.ds_18563,
                R.drawable.ds_18565,
                R.drawable.ds_18567,
                R.drawable.ds_18573,
                R.drawable.ds_18574,
                R.drawable.ds_18575,
                R.drawable.ds_18576,
                R.drawable.ds_18578,
                R.drawable.ds_18584,
                R.drawable.ds_18586,
                R.drawable.ds_18590,
                R.drawable.ds_18591,
                R.drawable.ds_18606,
                R.drawable.ds_18608,
                R.drawable.ds_18621,
                R.drawable.ds_18627,
                R.drawable.ds_18640,
                R.drawable.ds_18646,
                R.drawable.ds_18650,
                R.drawable.ds_18684,
                R.drawable.ds_18698,
                R.drawable.ds_18699,
                R.drawable.ds_18723,
                R.drawable.ds_18726,
                R.drawable.ds_18736,
                R.drawable.ds_18739,
                R.drawable.ds_18760,
                R.drawable.ds_18764,
                R.drawable.ds_18765,
        };

        @Override
        public int getCount() {
            return sDrawables.length;
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(container.getContext());
            photoView.setImageResource(sDrawables[position]);

            // Now just add PhotoView to ViewPager and return it
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

    }
}