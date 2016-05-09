package com.jason.minniejasonwedding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onPhotoViewButtonClick(View v) {
        Intent intent = new Intent(this, PhotoViewActivity.class);
        startActivity(intent);
    }

    public void onTaipeiWeddingPartyButtonClick(View v) {
        Intent intent = new Intent(this, WeddingPartyActivity.class);
        intent.putExtra("location","Taipei");
        startActivity(intent);
    }

    public void onTaitungWeddingPartyButtonClick(View v) {
        Intent intent = new Intent(this, WeddingPartyActivity.class);
        intent.putExtra("location","Taitung");
        startActivity(intent);
    }
}
