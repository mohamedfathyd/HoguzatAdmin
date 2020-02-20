package com.khalej.hoguzatadmin.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.khalej.hoguzatadmin.Activity.Add_servcies_;
import com.khalej.hoguzatadmin.Activity.Add_stuff_;
import com.khalej.hoguzatadmin.R;
import com.khalej.hoguzatadmin.model.apiinterface_home;
import com.khalej.hoguzatadmin.model.contact_category;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter_first_stuff extends RecyclerView.Adapter<RecyclerAdapter_first_stuff.MyViewHolder> {
    Typeface myTypeface;
    private Context context;
    List<contact_category> contactslist;
     apiinterface_home apiinterface;
    public RecyclerAdapter_first_stuff(Context context, List<contact_category> contactslist){
        this.contactslist=contactslist;
        this.context=context;


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_delete,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {


    holder.Name.setText(contactslist.get(position).getName());

        Glide.with(context).load(contactslist.get(position).getImage()).error(R.drawable.logo).into(holder.image);
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent =new Intent(context, Add_stuff_.class);
               intent.putExtra("id",contactslist.get(position).getId());
               context.startActivity(intent);
           }
       });
    }
    @Override
    public int getItemCount() {
        return contactslist.size();
    }

public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name;
        ImageView image;

        ImageView delete;
    public MyViewHolder(View itemView) {
        super(itemView);
        Name=(TextView)itemView.findViewById(R.id.txt_fish_title);
        image=(ImageView)itemView.findViewById(R.id.imageView3);
        delete=(ImageView)itemView.findViewById(R.id.delete);

    }
}

}