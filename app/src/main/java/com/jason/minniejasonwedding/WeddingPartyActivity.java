package com.jason.minniejasonwedding;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WeddingPartyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wedding_party);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        WeddingPartyInfoAdapter adapter = null;
        String title = null;
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        if (location.equalsIgnoreCase("Taipei")) {
            adapter = new WeddingPartyInfoAdapter(WeddingPartyInfo.generateTaipeiPartyInfoList());
            title = getResources().getString(R.string.title_activity_wedding_party_taipei);
        } else if (location.equalsIgnoreCase("Taitung")) {
            adapter = new WeddingPartyInfoAdapter(WeddingPartyInfo.generateTaitungPartyInfoList());
            title = getResources().getString(R.string.title_activity_wedding_party_taitung);
        }
        if (adapter != null) {
            recyclerView.setAdapter(adapter);
            final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
        }
        if (title != null) {
            setTitle(title);
        }
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

    public class WeddingPartyInfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public class ItemViewHolder extends RecyclerView.ViewHolder {
            public TextView textView;
            public ItemViewHolder(View itemView){
                super(itemView);

                textView = (TextView) itemView.findViewById(R.id.textview);
            }
        }

        public class PhotoViewHolder extends RecyclerView.ViewHolder {
            public ImageView imageView;
            public PhotoViewHolder(View itemView){
                super(itemView);

                imageView = (ImageView) itemView.findViewById(R.id.imageview);
            }
        }

        public class CategoryViewHolder extends RecyclerView.ViewHolder {
            public TextView textView;
            public CategoryViewHolder(View itemView){
                super(itemView);

                textView = (TextView) itemView.findViewById(R.id.textview);
            }
        }

        private List<WeddingPartyInfo> mInfos;

        public WeddingPartyInfoAdapter(List<WeddingPartyInfo> infos){
            mInfos = infos;
        }

        @Override
        public int getItemCount() {
            return mInfos.size();
        }

        @Override
        public int getItemViewType(int position) {
            WeddingPartyInfo info = mInfos.get(position);
            return info.getType().ordinal();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            if (viewType == WeddingPartyInfoType.Category.ordinal()) {
                Context context = viewGroup.getContext();
                View infoView = LayoutInflater.from(context).inflate(R.layout.item_wedding_party_category, viewGroup, false);
                RecyclerView.ViewHolder viewHolder = new CategoryViewHolder(infoView);
                return viewHolder;
            } else if (viewType == WeddingPartyInfoType.Info.ordinal()) {
                Context context = viewGroup.getContext();
                View infoView = LayoutInflater.from(context).inflate(R.layout.item_wedding_party_info, viewGroup, false);
                RecyclerView.ViewHolder viewHolder = new ItemViewHolder(infoView);
                return viewHolder;
            } else if (viewType == WeddingPartyInfoType.Photo.ordinal()) {
                Context context = viewGroup.getContext();
                View infoView = LayoutInflater.from(context).inflate(R.layout.item_wedding_party_photo, viewGroup, false);
                RecyclerView.ViewHolder viewHolder = new PhotoViewHolder(infoView);
                return viewHolder;
            }

            throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
            if (viewHolder instanceof CategoryViewHolder) {
                WeddingPartyInfo info = mInfos.get(position);
                TextView textView = ((CategoryViewHolder)viewHolder).textView;
                textView.setText(info.getText());
            } else if (viewHolder instanceof ItemViewHolder) {
                WeddingPartyInfo info = mInfos.get(position);
                TextView textView = ((ItemViewHolder)viewHolder).textView;
                textView.setText(info.getText());
            } else if (viewHolder instanceof PhotoViewHolder) {
                WeddingPartyInfo info = mInfos.get(position);
                ImageView imageView = ((PhotoViewHolder)viewHolder).imageView;
                imageView.setImageResource(info.getRes());
            }
        }
    }
}
