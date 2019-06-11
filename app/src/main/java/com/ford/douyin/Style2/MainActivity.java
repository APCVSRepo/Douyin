package com.ford.douyin.Style2;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.ford.douyin.R;
import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity
{
    private ImageView mMainImageView;
    private RecyclerView mVideoWallView;
    private Animation mAniFadeIn;
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

    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener()
    {

        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState)
        {
            super.onScrollStateChanged(recyclerView, newState);

            if (newState == RecyclerView.SCROLL_STATE_IDLE)
            {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager)
                {
                    LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;

                    int pos = linearManager.findFirstCompletelyVisibleItemPosition();
                    mMainImageView.setImageResource(((CardAdapter)recyclerView.getAdapter()).getItemImageID(pos - 1));
                    mMainImageView.startAnimation(mAniFadeIn);
//                    Toast.makeText(MainActivity.this, "" + pos, Toast.LENGTH_SHORT).show();
                }
            }

        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.style2_activity_main);
        mVideoWallView = findViewById(R.id.video_wall);
        mMainImageView = findViewById(R.id.main_image_view);
        mAniFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        hideBar();

        // 设置布局管理器
        final RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mVideoWallView.setLayoutManager(mLayoutManager);
        mVideoWallView.setHasFixedSize(true);

        // 设置adapter
        final CardAdapter adapter = new CardAdapter(mList);
        mVideoWallView.setAdapter(adapter);
        mVideoWallView.addOnScrollListener(mScrollListener);
    }


    private void hideBar()
    {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();

    }

}
