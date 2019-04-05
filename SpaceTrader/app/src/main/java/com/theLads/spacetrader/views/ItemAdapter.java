package com.theLads.spacetrader.views;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import com.theLads.spacetrader.entity.enums.ItemType;
import com.theLads.spacetrader.R;


import java.util.ArrayList;
import java.util.List;

/**
 * used to display items
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    /** a copy of the list of items in the model */
    private final List<ItemType> itemList = new ArrayList<>();

    /** a listener for a touch event on the item */
    private OnItemClickListener listener;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        // hook up to the view for a single item in the system
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new ItemViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        //bind the item data for one item
        ItemType item = itemList.get(position);

        Log.d("APP", "Binding: " + position + " " + itemList.get(position));

        holder.itemIndex.setText(item.toString());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void setItemList(Iterable<Integer> quantities) {
        int i = 0;
        itemList.clear();
        for (Integer q : quantities) {
            if (q != 0) {
                itemList.add(ItemType.values()[i]);
            }
            i++;
        }
        notifyDataSetChanged();
    }


    /**
     * This is a holder for the widgets associated with a single entry in the list of items
     */
    class ItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView itemIndex;

        ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemIndex = itemView.findViewById(R.id.text_item_id);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if ((listener != null) && (position != RecyclerView.NO_POSITION)) {
                        listener.onItemClicked(itemList.get(position));
                    }
                }
            });

        }
    }

    /**
     * when an item is selected/clicked, this passes on the item that was selectd
     */
    public interface OnItemClickListener {
        void onItemClicked(ItemType item);
    }

    /**
     * Sets the listener for the ItemAdapter
     * @param listener  the listener to set this.listener to
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
