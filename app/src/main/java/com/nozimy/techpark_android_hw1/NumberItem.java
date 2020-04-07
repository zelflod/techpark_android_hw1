package com.nozimy.techpark_android_hw1;

public class NumberItem {
    final String text;
    final int color;

    NumberItem(String text, int color) {
        this.text = text;
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
}
