package com.example.virtuallibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Book> books;
    private LayoutInflater layoutInflater;
    private ItemClickListener itemClickListener;

    public RecyclerViewAdapter(Context context, ArrayList<Book> books) {
        this.layoutInflater = LayoutInflater.from(context);
        this.books = books;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = books.get(position);
        holder.textView.setText(String.format((position + 1) + ".\t" + book.getName() +
                "\n\t\t\tby " + book.getAuthor()));
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public Book getItem(int id) {
        return books.get(id);
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.book);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null){
                itemClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}