package com.nozimy.techpark_android_hw1;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {
    private List<NumberItem> items = new ArrayList<NumberItem>();

    private static DataHelper sInstance;

    private DataHelper(){

    }

    public static DataHelper getInstance(){
        if (sInstance == null) {
            sInstance = new DataHelper();
        }

        return sInstance;
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
