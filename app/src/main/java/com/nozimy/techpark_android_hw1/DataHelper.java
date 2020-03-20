package com.nozimy.techpark_android_hw1;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {
    public static List<NumberItem> items = new ArrayList<NumberItem>();

    public static int createItem() {
        int tmpCount = items.size() + 1;
        int color = tmpCount % 2 == 0 ? Color.RED : Color.BLUE;
        items.add(new NumberItem(String.valueOf(tmpCount), color));
        return items.size();
    }

    public static void initData(int count){
        for (int i = 0; i < count; ++i) {
            DataHelper.createItem();
        }
    }

    public static List<NumberItem> getItems(){
        return items;
    }
}
