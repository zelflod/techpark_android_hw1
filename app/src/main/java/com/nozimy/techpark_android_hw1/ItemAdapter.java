package com.nozimy.techpark_android_hw1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{
    private List<NumberItem> items;
    private final ItemsFragment.OnFragmentInteractionListener mClickHandler;

    public ItemAdapter(List<NumberItem> items, ItemsFragment.OnFragmentInteractionListener mClickHandler) {
        this.items = items;
        this.mClickHandler = mClickHandler;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mContent.setText(getItem(position).getText());
        holder.mContent.setTextColor(getItem(position).getColor());
    }

    @Override
    public int getItemCount() {
        if (null == items) return 0;
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView mContent;

        public ViewHolder(View itemView) {
            super(itemView);
            mContent = itemView.findViewById(R.id.list_item_text);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
//            NumberItem item = items.get(adapterPosition);
            mClickHandler.onFragmentInteraction(adapterPosition);
        }
    }

    private NumberItem getItem (int position) {
        Object im = items.get(position);
        return ((NumberItem) im);
    }

    void setItems(List<NumberItem> itemsData) {
        items = itemsData;
        // обновляем отображаемый список
        notifyDataSetChanged();
    }
}
