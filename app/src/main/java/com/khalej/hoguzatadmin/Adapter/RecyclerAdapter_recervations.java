package com.khalej.hoguzatadmin.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.khalej.hoguzatadmin.Activity.Order_detail;
import com.khalej.hoguzatadmin.R;
import com.khalej.hoguzatadmin.model.contact_order;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter_recervations extends RecyclerView.Adapter<RecyclerAdapter_recervations.MyViewHolder> {
    Typeface myTypeface;
    private Context context;
    List<contact_order> contactslist;

    public RecyclerAdapter_recervations(Context context, List<contact_order> contactslist){
        this.contactslist=contactslist;
        this.context=context;


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_recervation,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {


        holder.Name.setText("اسم صاحب الطلب :"+contactslist.get(position).getName());
        holder.finish_date.setText("الهاتف :" +contactslist.get(position).getPhone());
        holder.price.setText("البريد الألكتروني :" +contactslist.get(position).getAddress());
        holder.idd.setText(contactslist.get(position).getPrice()+"");


       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(context, Order_detail.class);
               intent.putExtra("name",contactslist.get(position).getName());
               intent.putExtra("phone",contactslist.get(position).getPhone());
               intent.putExtra("details",contactslist.get(position).getDetails());
               intent.putExtra("address",contactslist.get(position).getAddress());
               intent.putExtra("id",contactslist.get(position).getId());
               intent.putExtra("charge",contactslist.get(position).getCharge());
               intent.putExtra("price",contactslist.get(position).getPrice()+"");
               context.startActivity(intent);
           }
       });
    }
    @Override
    public int getItemCount() {
        return contactslist.size();
    }

public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name,finish_date,price,idd;

    public MyViewHolder(View itemView) {
        super(itemView);

        Name=(TextView)itemView.findViewById(R.id.txt_fish_title);
        finish_date=(TextView)itemView.findViewById(R.id.txt_title);
        price=(TextView)itemView.findViewById(R.id.txt_);
        idd=itemView.findViewById(R.id.idd);


    }
}

}