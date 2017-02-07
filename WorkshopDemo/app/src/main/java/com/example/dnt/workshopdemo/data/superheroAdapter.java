package com.example.dnt.workshopdemo.data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dnt.workshopdemo.R;

import java.util.List;

/**
 * Created by dnt on 7.2.2017 г..
 */

public class superheroAdapter extends RecyclerView.Adapter<superheroAdapter.MyViewHolder> {

    List<Superhero> mData;
    private LayoutInflater inflater;
    private Context mContext;

    public superheroAdapter(Context context, List<Superhero> data) {
        this.mContext = context;
        inflater = LayoutInflater.from(context);
        this.mData = data;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_superhero, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Superhero current = mData.get(position);
        holder.setData(current,position);
        //holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView secretIdentity;
        TextView name;
        View itemView;
        ImageView imageUrl;
        Superhero current;
        int superheroId;
        int position;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.name = (TextView)itemView.findViewById(R.id.tvSuperheroName);
        }

        public void setData(Superhero current, int position) {
            this.name.setText(current.getName());
//            this.secretIdentity.setText(current.getSecretIdentity());
            this.position = position;
//            Picasso.with(mContext).load(current.getImageUrl()).into(this.imageUrl);
            this.superheroId = current.getId();
            this.current = current;
        }

//        public void setListeners() {
//
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    MyCommunicator myCommunicator = (MyCommunicator) mContext;
//                    myCommunicator.displayDetails(position);
//                }
//            });
//        }
    }
}
