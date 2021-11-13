package com.example.pemesanan.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pemesanan.R;
import com.example.pemesanan.model.HomeModel;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<HomeModel> rvData;
    private ItemAdapterCallback itemAdapterCallback;

    public HomeAdapter (List<HomeModel> listData,ItemAdapterCallback mitemAdapterCallback){
        rvData = listData;
        itemAdapterCallback = mitemAdapterCallback;
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_diskon, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
        holder.tvDiskon.setText(rvData.get(position).getDiskonproduct());
        holder.ivPoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemAdapterCallback.onClick(view);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView ivPoster;
        public TextView tvDiskon;

        public ViewHolder (View view){
            super(view);
            tvDiskon = view.findViewById(R.id.tv_diskon);
            ivPoster = view.findViewById(R.id.iv_poster);
        }
    }

    public interface ItemAdapterCallback{
        void onClick(View view);
    }
}
