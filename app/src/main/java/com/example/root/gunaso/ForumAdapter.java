package com.example.root.gunaso;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by root on 2/25/17.
 */

public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.MyViewHolder> {

    private List<ForumModel> forumModelList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,sub,body;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.txt_name);
            sub = (TextView) view.findViewById(R.id.txt_sub);
            body = (TextView) view.findViewById(R.id.txt_body);
        }
    }


    public ForumAdapter(List<ForumModel> forumModelList) {
        this.forumModelList = forumModelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_forum, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ForumModel forumModel = forumModelList.get(position);
        holder.name.setText(forumModel.getName());
        holder.sub.setText(forumModel.getSubject());
        holder.body.setText(forumModel.getBody());
    }

    @Override
    public int getItemCount() {
        return forumModelList.size();
    }


}
