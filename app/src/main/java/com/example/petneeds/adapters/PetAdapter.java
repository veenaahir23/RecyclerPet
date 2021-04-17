package com.example.petneeds.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petneeds.R;
import com.example.petneeds.models.PetInfo;

import java.util.List;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.ViewHolder> {

    Context context;
    List<PetInfo> info;

    public PetAdapter(Context context, List<PetInfo> info) {
        this.context = context;
        this.info = info;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View petView = LayoutInflater.from(context).inflate(R.layout.petdetails, parent, false);
        return new ViewHolder(petView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PetInfo pInfo = info.get(position);
        holder.bind(pInfo);
    }

    @Override
    public int getItemCount() {
        return info.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvVicinity;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvVicinity = itemView.findViewById(R.id.tvVicinity);



        }

        public void bind(PetInfo pInfo) {
            tvName.setText(pInfo.getName());
            tvVicinity.setText(pInfo.getVicinity());
        }
    }
}
