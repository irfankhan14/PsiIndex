package com.irfan.singapore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.irfan.singapore.R;
import com.irfan.singapore.model.ReadingDetailsPair;

import java.util.ArrayList;

public class ReadingItemsAdapter extends RecyclerView.Adapter<ReadingItemsAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<ReadingDetailsPair> readingDetailsPairsList;
    TextView readingItems;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View view) {
            super(view);
        }
    }

    public ReadingItemsAdapter(Context context, ArrayList<ReadingDetailsPair> list) {
        this.context = context;
        this.readingDetailsPairsList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reading_list_items, parent, false);

        readingItems = itemView.findViewById(R.id.readingItems);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String title = readingDetailsPairsList.get(position).getTitle();
        String value = readingDetailsPairsList.get(position).getValue();
        readingItems.setText(title + " : " + value);
    }

    @Override
    public int getItemCount() {
        return readingDetailsPairsList.size();
    }
}
