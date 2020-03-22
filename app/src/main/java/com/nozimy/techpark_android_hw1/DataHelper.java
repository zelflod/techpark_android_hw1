package com.nozimy.techpark_android_hw1;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {
    private List<NumberItem> items = new ArrayList<NumberItem>();

    private static DataHelper single_instance;

    private DataHelper(){

    }

    public static DataHelper getInstance(){
        if (single_instance == null) {
            single_instance = new DataHelper();
        }

        return single_instance;
    }

    public int createItem() {
        int tmpCount = items.size() + 1;
        int color = tmpCount % 2 == 0 ? Color.RED : Color.BLUE;
        items.add(new NumberItem(String.valueOf(tmpCount), color));
        return items.size();
    }

    public void initData(int count){
        for (int i = 0; i < count; ++i) {
            createItem();
        }
    }

    public List<NumberItem> getItems(){
        return items;
    }
}
