package com.example.demo;

public class RecyclerItem {
    public static final int ITEM_HEADER = 1;
    public static final int ITEM_POSTER = 2;
    public static final int ITEM_DESC = 3;

    private int type;

    public RecyclerItem(int type) {
        this.type = type;
    }
    public int getItemType() {
        return type;
    }
}
