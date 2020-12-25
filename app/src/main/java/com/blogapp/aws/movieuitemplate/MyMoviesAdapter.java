package com.blogapp.aws.movieuitemplate;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyMoviesAdapter extends RecyclerView.Adapter<MyMoviesAdapter.ViewHolder> {

    Context context;
    List<MyMoiveClass> myMoiveClasses;
    MovieItemClickListener movieItemClickListener;

    public MyMoviesAdapter(Context context, List<MyMoiveClass> list) {
        this.context = context;
        this.myMoiveClasses = list;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return myMoiveClasses.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(myMoiveClasses.get(position).getTitle());
        Glide.with(context).load(myMoiveClasses.get(position).getImage()).into(holder.imageView);

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_movie_img);
            textView = itemView.findViewById(R.id.item_movie_title);


            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, MovieDetailActivity.class);
                    intent.putExtra("title", myMoiveClasses.get(getAdapterPosition()).getTitle());
                    intent.putExtra("image", myMoiveClasses.get(getAdapterPosition()).getImage());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    context.getApplicationContext().startActivity(intent);

                    Toast.makeText(context.getApplicationContext(), myMoiveClasses.get(getAdapterPosition()).getTitle(), Toast.LENGTH_SHORT).show();
                 }
            });
        }
    }
}
