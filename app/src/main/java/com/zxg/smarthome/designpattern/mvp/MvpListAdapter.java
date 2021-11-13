package com.zxg.smarthome.designpattern.mvp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zxg.smarthome.R;

import java.util.List;

public class MvpListAdapter extends RecyclerView.Adapter<MvpListAdapter.MvpViewHolder> {

    private List<String> datas;

    public MvpListAdapter(List<String> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public MvpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.mvp_list_item_layout, parent, false);
        MvpViewHolder mvpViewHolder = new MvpViewHolder(inflate);
        return mvpViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MvpViewHolder holder, int position) {
        if (position % 2 == 0){
            holder.mItemImage.setImageResource(R.mipmap.image00);
        } else {
            holder.mItemImage.setImageResource(R.mipmap.image01);
        }
        holder.mItemText.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas != null ? datas.size() : 0;
    }

    static class MvpViewHolder extends RecyclerView.ViewHolder{

        public ImageView mItemImage;
        public TextView mItemText;

        public MvpViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemImage = itemView.findViewById(R.id.mvp_list_image);
            mItemText = itemView.findViewById(R.id.mvp_list_text);
        }
    }
}
