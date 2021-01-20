package com.example.pranavtask01;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    List<String> names;
    List<String> messages;
    List<String> profile;
    List<String> times;
    List<String> messageNum;
    Context context;


    public RecyclerAdapter(Context context,List<String> names, List<String> messages,List<String> profile,List<String> times,List<String> messageNum) {
        this.names = names;
        this.messages = messages;
        this.profile = profile;
        this.times = times;
        this.messageNum = messageNum;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_items,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView1.setText(names.get(position));//For Username
        holder.textView2.setText(messages.get(position));//For  UserMessage
        holder.textView3.setText(times.get(position));//For Message Timing
//      holder.textView4.setText(messageNum.get(position));//For No Of Messages
        if (messageNum.get(position).equals("0")){
            holder.textView4.setVisibility(View.GONE);
        }else{
             holder.textView4.setText(messageNum.get(position));
             holder.textView3.setTextColor(Color.parseColor("#39e600"));
        }

        Picasso.with(context)
                .load(profile.get(position))
                .resize(80,80)
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    ImageView imageView;
    TextView textView1, textView2,textView3,textView4;
    
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
            textView4 = itemView.findViewById(R.id.textView4);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(v -> {
                Toast.makeText(v.getContext(), "Archived "+ names.get(getAdapterPosition())+"'s message",Toast.LENGTH_SHORT).show();
                names.remove(getAdapterPosition());
                notifyItemRemoved(getAdapterPosition());
                return true;
            });
        }
        @Override
        public void onClick(View v) {
            String msg;
            if(Integer.parseInt(messageNum.get(getAdapterPosition()))>0)
                msg = messageNum.get(getAdapterPosition())+" Unread message from "+names.get(getAdapterPosition());
            else
              msg = "No message from "+names.get(getAdapterPosition());
        Toast.makeText(v.getContext(),msg,Toast.LENGTH_SHORT).show();
        }
    }
}
