package com.hb.ex01.a0607_planner;

/**
 * Created by HB04-03 on 2017-06-07.
 */

public class VO {
    int p_idx;
    String date,content;

    public VO() {}
    public VO(int p_idx, String date, String content) {
        this.p_idx = p_idx;
        this.date = date;
        this.content = content;
    }
    public int getP_idx() {
        return p_idx;
    }
    public void setP_idx(int p_idx) {
        this.p_idx = p_idx;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
