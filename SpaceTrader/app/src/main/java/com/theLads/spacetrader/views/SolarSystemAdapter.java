package com.theLads.spacetrader.views;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.theLads.spacetrader.R;
import com.theLads.spacetrader.entity.SolarSystem;
import com.theLads.spacetrader.viewmodels.TravelViewModel;

import java.util.ArrayList;
import java.util.List;

public class SolarSystemAdapter extends RecyclerView.Adapter<SolarSystemAdapter.SolarSystemViewHolder> {

    /** a copy of the list of solar system in the model */
    private List<SolarSystem> solarSystemList = new ArrayList<>();

    /** a listener for a touch event on the item */
    private OnSolarSystemClickListener listener;

    public void setCurrAct(Activity currAct) {
        this.currAct = currAct;
    }

    private Activity currAct;
    private TravelViewModel viewModel;

    @NonNull
    @Override
    public SolarSystemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        // hook up to the view for a single solar system in the system
        View solarSystemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.solar_system, parent, false);


        viewModel = ViewModelProviders.of((FragmentActivity) currAct).get(TravelViewModel.class);
        return new SolarSystemViewHolder(solarSystemView);
    }


    @Override
    public void onBindViewHolder(@NonNull SolarSystemViewHolder holder, int position) {

        //bind the solarSystem data for one solarSystem
        SolarSystem solarSystem = solarSystemList.get(position);

        Log.d("APP", "Binding: " + position + " " + solarSystemList.get(position));

        String solarSystemInfo = solarSystem.getName() + " Dist: " + viewModel.getDistanceTo(solarSystem);

        holder.solarSystemIndex.setText(solarSystemInfo);

    }

    @Override
    public int getItemCount() {
        return solarSystemList.size();
    }

    public void setSolarSystemList(List<SolarSystem> solarSystems) {
        solarSystemList = solarSystems;
        notifyDataSetChanged();
    }


    /**
     * This is a holder for the widgets associated with a single entry in the list of SolarSystems
     */
    class SolarSystemViewHolder extends RecyclerView.ViewHolder {
        private final TextView solarSystemIndex;

        public SolarSystemViewHolder(@NonNull View solarSystemView) {
            super(solarSystemView);
            solarSystemIndex = solarSystemView.findViewById(R.id.text_solar_system_id);

            solarSystemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onSolarSystemClicked(solarSystemList.get(position));
                    }
                }
            });

        }

        public void setText(String string) {
            solarSystemIndex.setText(string);
        }
    }

    public interface OnSolarSystemClickListener {
        void onSolarSystemClicked(SolarSystem solarSystem);
    }

    public void setOnSolarSystemClickListener(OnSolarSystemClickListener listener) {
        this.listener = listener;
    }
}
