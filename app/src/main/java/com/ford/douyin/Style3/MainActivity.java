package com.ford.douyin.Style3;


import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.ford.douyin.R;

import java.util.LinkedList;
import java.util.List;


public class MainActivity extends AppCompatActivity
{
    private RecyclerView mVideoWallView;
    private static final List<Integer> mList;
    static
    {
        mList = new LinkedList<>();
        mList.add(R.drawable.img1);
        mList.add(R.drawable.img2);
        mList.add(R.drawable.img3);
        mList.add(R.drawable.img4);
        mList.add(R.drawable.img5);
        mList.add(R.drawable.img6);
        mList.add(R.drawable.img7);
        mList.add(R.drawable.img8);
        mList.add(R.drawable.img9);
        mList.add(R.drawable.img10);
        mList.add(R.drawable.img11);
        mList.add(R.drawable.img12);
        mList.add(R.drawable.img13);
        mList.add(R.drawable.img14);
        mList.add(R.drawable.img15);
        mList.add(R.drawable.img16);
        mList.add(R.drawable.img17);
        mList.add(R.drawable.img18);
        mList.add(R.drawable.img19);
        mList.add(R.drawable.img20);
        mList.add(R.drawable.img21);
        mList.add(R.drawable.img22);
        mList.add(R.drawable.img23);
        mList.add(R.drawable.img24);
        mList.add(R.drawable.img25);
        mList.add(R.drawable.img26);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.style3_activity_main);
        mVideoWallView = findViewById(R.id.video_wall);

        hideBar();

        // 设置布局管理器
        final RecyclerView.LayoutManager mLayoutManager =
                new ZoomCenterLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mVideoWallView.setLayoutManager(mLayoutManager);
        mVideoWallView.setHasFixedSize(true);

        //keep middle
        LinearSnapHelper mLinearySnapHelper = new LinearSnapHelper();
        mLinearySnapHelper.attachToRecyclerView(mVideoWallView);

        // 设置adapter
        final CardAdapter adapter = new CardAdapter(mList);
        mVideoWallView.setAdapter(adapter);
        mVideoWallView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL));





    }


    private void hideBar()
    {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();

    }

}
