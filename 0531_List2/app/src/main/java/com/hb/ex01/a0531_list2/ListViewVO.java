package com.hb.ex01.a0531_list2;

/**
 * Created by HB04-03 on 2017-05-31.
 */

// 리스트에 들어가는 변수들을 가지고 있는 클래스
public class ListViewVO {
    private int resId;
    private String itemName;

    public ListViewVO() {}
    public ListViewVO(int resId, String itemName) {
        this.resId = resId;
        this.itemName = itemName;
    }
    public int getResId() {
        return resId;
    }
    public void setResId(int resId) {
        this.resId = resId;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}