package com.example.dnt.workshopdemo.data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dnt.workshopdemo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dnt on 7.2.2017 г..
 */

public class FractionAdapter  extends RecyclerView.Adapter<FractionAdapter.MyViewHolder> {
    List<Fraction> mData;
    private LayoutInflater inflater;
    private Context mContext;

    public FractionAdapter(Context context, List<Fraction> data) {
        this.mContext = context;
        inflater = LayoutInflater.from(context);
        this.mData = data;
    }


    @Override
    public FractionAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_fraction, parent, false);
        FractionAdapter.MyViewHolder holder = new FractionAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(FractionAdapter.MyViewHolder holder, int position) {
        Fraction current = mData.get(position);
        holder.setData(current,position);
//        holder.setListeners();
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
        Fraction current;
        int superheroId;
        int position;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.name = (TextView)itemView.findViewById(R.id.tvFractionName);
            this.secretIdentity= (TextView) itemView.findViewById(R.id.tvFractionSecretIdentity);
            this.imageUrl =(ImageView) itemView.findViewById(R.id.ivImage);
        }

        public void setData(Fraction current, int position) {
            this.name.setText(current.getName());
            this.secretIdentity.setText(current.getSecretIdentity());
            this.position = position;
            Picasso.with(mContext).load(current.getImageUrl()).into(this.imageUrl);
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
//                    myCommunicator.displaySuperheroDetails(superheroId);
//                }
//            });
//        }
    }
}
