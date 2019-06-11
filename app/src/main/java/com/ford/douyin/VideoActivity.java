package com.ford.douyin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class VideoActivity extends Activity implements View.OnClickListener
{
    public static final String EXTRA_RES_ID = "res_id";
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        mImageView = findViewById(R.id.imageView);
        int resID = getIntent().getIntExtra(EXTRA_RES_ID, 0);
        mImageView.setImageResource(resID);
    }

    @Override
    public void onClick(View view)
    {
        finish();
    }
}
