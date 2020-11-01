package com.example.dervis.bandungguide;


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

import com.example.dervis.bandungguide.Data.Park;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ParksFragment extends Fragment {

    public ParksFragment() {
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

        rV.setAdapter(new ParksAdapter(MainActivity.GetListOfParks(getContext())));
    }


}


class ParksAdapter extends RecyclerView.Adapter<ParksAdapter.ViewHolder> {

    private List<Park> parks;

    public ParksAdapter(List<Park> parks) {
        this.parks = parks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_attraction, parent, false);

        ImageView imageView = rootView.findViewById(R.id.image_view);
        TextView textView = rootView.findViewById(R.id.text_view_name);

        return new ViewHolder(rootView, imageView, textView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(parks.get(position).DrawableResId);
        holder.textView.setText(parks.get(position).Name);
    }

    @Override
    public int getItemCount() {
        return parks.size();
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