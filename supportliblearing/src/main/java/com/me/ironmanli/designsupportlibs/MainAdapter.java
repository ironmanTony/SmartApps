package com.me.ironmanli.designsupportlibs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ironman.li on 2015/8/28.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context context;
    private List<Content> dataSet;

    public MainAdapter(List<Content> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_list_item, viewGroup, false);
        ImageView ivLeft = (ImageView) rootView.findViewById(R.id.main_list_item_iv_left);
        TextView tvTitle = (TextView) rootView.findViewById(R.id.main_list_item_tv_title);
        TextView tvContent = (TextView) rootView.findViewById(R.id.main_list_item_tv_content);
        return new ViewHolder(rootView, ivLeft, tvTitle, tvContent);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (dataSet != null && dataSet.size() > i) {
            Content content = dataSet.get(i);
            if (content != null) {
                viewHolder.ivMain.setImageDrawable(context.getResources().getDrawable(R.drawable.my_girl));
                viewHolder.tvTitle.setText(content.title);
                viewHolder.tvContent.setText(content.content);
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataSet == null ? 0 : dataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivMain;
        public TextView tvTitle;
        public TextView tvContent;

        public ViewHolder(View itemView, ImageView ivMain, TextView tvTitle, TextView tvContent) {
            super(itemView);
            this.ivMain = ivMain;
            this.tvTitle = tvTitle;
            this.tvContent = tvContent;
        }
    }
}
