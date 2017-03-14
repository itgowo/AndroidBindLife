package com.example.demobindlife.ActivityLife;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by lujianchao on 2016/10/27.
 */

public class QK_ListenerFragmentV4 extends android.support.v4.app.Fragment {
    private onQK_ILifeListener mlistener; public static final String ListenerFragmentTag = "ListenerFragment";

    public QK_ListenerFragmentV4 () {

    }

    public void setLifeListener (onQK_ILifeListener mlistener) {
        this.mlistener = mlistener;
    }

    @Override
    public void onCreate (@Nullable final Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        if (mlistener != null) {
            mlistener.onCreat ();
        }
    }

    @Override
    public void onResume () {
        super.onResume ();
        if (mlistener != null) {
            mlistener.onResume ();
        }
    }

    @Override
    public void onPause () {
        if (mlistener != null) {
            mlistener.onPause ();
        }
        super.onPause ();
    }

    @Override
    public void onStart () {
        super.onStart ();
        if (mlistener != null) {
            mlistener.onStart ();
        }
    }

    @Override
    public void onStop () {
        if (mlistener != null) {
            mlistener.onStop ();
        }
        super.onStop ();
    }

    @Override
    public void onHiddenChanged (final boolean hidden) {
        super.onHiddenChanged (hidden);
        if (mlistener != null) {
            mlistener.onFragmentHiddenChanged (hidden);
        }
    }

    @Override
    public void onDestroy () {
        if (mlistener != null) {
            mlistener.onDestroy ();
        }
        super.onDestroy ();
    }

}
