package com.bugsee.shared.listenscrollchanges;

import android.view.View;

/**
 * Created by denis.druzhinin, Bugsee Inc, <a href="https://www.bugsee.com">https://www.bugsee.com</a>
 */
public interface OnScrollChangeListenerCompat {
    void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY);
}