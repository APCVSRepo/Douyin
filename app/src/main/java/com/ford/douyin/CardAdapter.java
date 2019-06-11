package com.ford.douyin;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>
{
    private List<Integer> mList;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private ImageView mImageView;
        private int mResID;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mImageView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view)
        {
//            Toast.makeText(view.getContext(), "No." + mImageView.getTag().toString(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(view.getContext(), VideoActivity.class);
            intent.putExtra(VideoActivity.EXTRA_RES_ID, mResID);
            view.getContext().startActivity(intent);
        }
    }

    public CardAdapter(List<Integer> mList)
    {
        this.mList = mList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_card_item, viewGroup, false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i)
    {
        final int resID = mList.get(i % mList.size());

        //先设置图片占位符
        viewHolder.mImageView.setImageResource(R.color.color_blank_card);

        //为imageView设置Tag,内容是该imageView等待加载的图片url
        viewHolder.mResID = resID;
        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(Void... params) {
                return BitmapFactory.decodeResource(viewHolder.mImageView.getResources(), resID);
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                //加载完毕后判断该imageView等待的图片url是不是加载完毕的这张
                //如果是则为imageView设置图片,否则说明imageView已经被重用到其他item
                if (resID == viewHolder.mResID)
                {
                    viewHolder.mImageView.setImageBitmap(bitmap);
                }
            }
        }.execute();





    }


    @Override
    public int getItemCount()
    {
        return Integer.MAX_VALUE;
    }
}
