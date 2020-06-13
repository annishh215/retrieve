package com.example.retrieve;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.viewholder> {

    private List<user> li;
    private Context c;

    public adapter(List<user> li, Context c) {
        this.li = li;
        this.c = c;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.userlist, parent,false);
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        user Li = li.get(position);
        holder.tv5.setText(Li.getId());
        holder.tv3.setText(Li.getName());
        holder.tv4.setText(Li.getCals());

    }

    @Override
    public int getItemCount() {
        return li.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        private TextView tv3;
        private TextView tv4;
        private TextView tv5;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            tv3 = (TextView)itemView.findViewById(R.id.tv3);
            tv4 = (TextView)itemView.findViewById(R.id.tv4);
            tv5 = (TextView)itemView.findViewById(R.id.tv5);
        }
    }
}
