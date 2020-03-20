package com.nozimy.techpark_android_hw1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ItemDetailsFragment extends Fragment {
    private static final String ARG_POSITION = "mPosition";

    private int mPosition;

    public ItemDetailsFragment() {}

    public static ItemDetailsFragment newInstance(int pos) {
        ItemDetailsFragment fragment = new ItemDetailsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, pos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(ARG_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_details, container, false);

        TextView detailText = view.findViewById(R.id.detail_text);
        detailText.setText(DataHelper.getItems().get(mPosition).getText());
        detailText.setTextColor(DataHelper.getItems().get(mPosition).getColor());

        return view;
    }
}
