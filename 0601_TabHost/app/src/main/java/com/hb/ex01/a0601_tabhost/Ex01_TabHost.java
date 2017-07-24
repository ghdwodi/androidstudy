package com.hb.ex01.a0601_tabhost;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TabHost;

/**
 * Created by HB04-03 on 2017-06-01.
 */

public class Ex01_TabHost extends TabActivity{
    TabHost tabHost;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01_tabhost);

        tabHost = getTabHost();

        TabHost.TabSpec tabSpecSong = tabHost.newTabSpec("Song").setIndicator("음악별");
        tabSpecSong.setContent(R.id.tabSong);
        tabHost.addTab(tabSpecSong);
        TabHost.TabSpec tabSpecArtist = tabHost.newTabSpec("Artist").setIndicator("가수별");
        tabSpecArtist.setContent(R.id.tabArtist);
        tabHost.addTab(tabSpecArtist);
        TabHost.TabSpec tabSpecAlbum = tabHost.newTabSpec("Album").setIndicator("앨범별");
        tabSpecAlbum.setContent(R.id.tabAlbum);
        tabHost.addTab(tabSpecAlbum);
        TabHost.TabSpec tabSpecOther = tabHost.newTabSpec("Other").setIndicator("기타");
        tabSpecOther.setContent(R.id.tabOther);
        tabHost.addTab(tabSpecOther);

    }
}
