package com.example.timeline_two;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.allPost> {

    ArrayList<Timeline> allPosts;

    public Adapter(ArrayList<Timeline> allPosts ){ // CONSTRUCTOR OF THIS CLASS
        this.allPosts = allPosts;
    }

    @NonNull
    @Override
    public allPost onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View activity = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_post,parent,false);
        return new allPost(activity);
    }

    @Override
    public void onBindViewHolder(@NonNull allPost holder, int position) {
        holder._name.setText(allPosts.get(position).getUserName());
        holder._description.setText(allPosts.get(position).getContent());
        holder._post_date.setText(allPosts.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return allPosts.size();
    }

    class allPost extends RecyclerView.ViewHolder{
        TextView _name,_description,_post_date;

        public allPost(@NonNull View itemView) {
            super(itemView);        // CAN GET UI VARIABLES FROM ANY LAYOUT
            _name = itemView.findViewById(R.id.single_post_name);
            _description = itemView.findViewById(R.id.single_post_description);
            _post_date = itemView.findViewById(R.id.single_post_date);
        }
    }
}
