package com.bugsee.shared.listenscrollchanges;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

/**
 * Created by denis.druzhinin, Bugsee Inc, <a href="https://www.bugsee.com">https://www.bugsee.com</a>
 */
@RequiresApi(api = Build.VERSION_CODES.M)
public class OnScrollChangeListenerAdapter implements View.OnScrollChangeListener {
    private final OnScrollChangeListenerCompat mOnScrollChangeListener;

    public OnScrollChangeListenerAdapter(OnScrollChangeListenerCompat onScrollChangeListener) {
        mOnScrollChangeListener = onScrollChangeListener;
    }

    @Override
    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        mOnScrollChangeListener.onScrollChange(v, scrollX, scrollY, oldScrollX, oldScrollY);
    }
}
