package com.example.walkietalkiedefinitivo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ConversacionAdapter extends RecyclerView.Adapter<ConversacionAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onNotasClick(int position);
        void onPlayClick(int position);
    }

    private final List<String> items;
    private final OnItemClickListener listener;

    public ConversacionAdapter(List<String> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ConversacionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_conversacion, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ConversacionAdapter.ViewHolder holder, int position) {
        String title = items.get(position);
        holder.tvTitulo.setText(title);

        holder.btnNotas.setOnClickListener(v -> {
            if (listener != null) listener.onNotasClick(holder.getAdapterPosition());
        });

        holder.btnPlay.setOnClickListener(v -> {
            if (listener != null) listener.onPlayClick(holder.getAdapterPosition());
        });
    }

    @Override
    public int getItemCount() { return items.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo;
        Button btnNotas;
        Button btnPlay;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            btnNotas = itemView.findViewById(R.id.btnNotas);
            btnPlay = itemView.findViewById(R.id.btnPlay);
        }
    }
}


