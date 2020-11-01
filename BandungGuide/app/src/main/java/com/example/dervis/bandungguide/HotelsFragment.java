package com.example.dervis.bandungguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dervis.bandungguide.Data.Hotel;

import java.util.List;


//this fragment shows a list of hotels in Bandung
public class HotelsFragment extends Fragment {


    public HotelsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attractions, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rV = view.findViewById(R.id.recycler_view);

        rV.setLayoutManager(new LinearLayoutManager(getContext()));

        rV.setAdapter(new HotelsAdapter(MainActivity.GetHotelsData(getContext())));
    }
}

class HotelsAdapter extends RecyclerView.Adapter<HotelsAdapter.ViewHolder> {

    private List<Hotel> hotels;

    public HotelsAdapter(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_attraction, parent, false);

        ImageView imageView = rootView.findViewById(R.id.image_view);
        TextView textView = rootView.findViewById(R.id.text_view_name);

        final ViewHolder viewHolder = new ViewHolder(rootView, imageView, textView);

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent.getContext(), HotelDetails.class);
                intent.putExtra(HotelDetails.HOTELS_LIST_INDEX_PARAM, viewHolder.getAdapterPosition());

                parent.getContext().startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(hotels.get(position).DrawableResId);
        holder.textView.setText(hotels.get(position).Name);
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;

        ViewHolder(View itemView, ImageView imageView, TextView textView) {
            super(itemView);
            this.imageView = imageView;
            this.textView = textView;
        }
    }
}
