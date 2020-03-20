package com.nozimy.techpark_android_hw1;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;



public class ItemsFragment extends Fragment {

    private static final String COUNT_STATE_KEY = "count-state-key";
    private int mColumnCount = 3;

    private OnFragmentInteractionListener mListener;
    private ItemAdapter adapter;


    public ItemsFragment() {}


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mColumnCount = Integer.parseInt(getString(R.string.column_count));

        if (savedInstanceState != null) {
            DataHelper.initData(savedInstanceState.getInt(COUNT_STATE_KEY)-DataHelper.getItems().size());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_items, container, false);

        Context context = view.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));

        List<NumberItem> items = DataHelper.getItems();

        adapter = new ItemAdapter(items, mListener);
        recyclerView.setAdapter(adapter);

        mListener.setItemsFragmentEnabled();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
            mListener.setItemsFragmentEnabled();
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(int position);
        void setItemsFragmentEnabled();
    }

    public void setItems(List<NumberItem> data){
        adapter.setItems(data);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(COUNT_STATE_KEY, DataHelper.getItems().size());

        super.onSaveInstanceState(outState);
    }
}
