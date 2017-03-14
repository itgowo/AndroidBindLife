package com.example.demobindlife.ActivityLife;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.FragmentActivity;

/**
 * Created by lujianchao on 2016/10/26.
 */

public class QKManager {
    public static void bindLife (Object mContext, onQK_ILifeListener mListener) {
        if (mContext instanceof Activity) {
            QK_ListenerFragment listenerFragment = new QK_ListenerFragment ();
            listenerFragment.setLifeListener (mListener);
            FragmentManager manager = ((Activity) mContext).getFragmentManager ();
               manager.beginTransaction ().add (listenerFragment, QK_ListenerFragment.ListenerFragmentTag).commitAllowingStateLoss ();
        } else if (mContext instanceof FragmentActivity) {
            QK_ListenerFragmentV4 listenerFragment = new QK_ListenerFragmentV4 ();
            listenerFragment.setLifeListener (mListener);
            android.support.v4.app.FragmentManager manager = ((FragmentActivity) mContext).getSupportFragmentManager ();
            manager.beginTransaction ().add (listenerFragment, QK_ListenerFragmentV4.ListenerFragmentTag).commitAllowingStateLoss ();
        } else if (mContext instanceof Fragment) {
            QK_ListenerFragment listenerFragment = new QK_ListenerFragment ();
            listenerFragment.setLifeListener (mListener);
            FragmentManager manager = ((Fragment) mContext).getFragmentManager ();
            manager.beginTransaction ().add (listenerFragment, QK_ListenerFragment.ListenerFragmentTag).commitAllowingStateLoss ();
        } else if (mContext instanceof android.support.v4.app.Fragment) {
            QK_ListenerFragmentV4 listenerFragment = new QK_ListenerFragmentV4 ();
            listenerFragment.setLifeListener (mListener);
            android.support.v4.app.FragmentManager manager = ((android.support.v4.app.Fragment) mContext).getFragmentManager ();
            manager.beginTransaction ().add (listenerFragment, QK_ListenerFragmentV4.ListenerFragmentTag).commitAllowingStateLoss ();
        }
    }

    /**
     * 绑定系统默认Activity
     *
     * @param mContext
     * @param mListener
     */
    public static void bindLife (final Activity mContext, onQK_ILifeListener mListener) {
        //判断是不是原生Activity，如果不是。。。。怎么可能，严谨啊b(￣▽￣)d
        if (mContext instanceof Activity) {
            QK_ListenerFragment listenerFragment = new QK_ListenerFragment ();
            //设置监听
            listenerFragment.setLifeListener (mListener);
            FragmentManager manager = mContext.getFragmentManager ();
            //开启事务
            manager.beginTransaction ().add (listenerFragment, QK_ListenerFragment.ListenerFragmentTag).commitAllowingStateLoss ();
        }
    }

    /**
     * 绑定V4包下的FragmentActivity
     *
     * @param mContext
     * @param mListener
     */
    public static void bindLife (final FragmentActivity mContext, onQK_ILifeListener mListener) {
        if (mContext instanceof FragmentActivity) {
            QK_ListenerFragmentV4 listenerFragment = new QK_ListenerFragmentV4 ();
            listenerFragment.setLifeListener (mListener);
            android.support.v4.app.FragmentManager manager = mContext.getSupportFragmentManager ();
            manager.beginTransaction ().add (listenerFragment, QK_ListenerFragmentV4.ListenerFragmentTag).commitAllowingStateLoss ();
        }
    }

    /**
     * 绑定系统默认Fragment
     *
     * @param mContext
     * @param mListener
     */
    public static void bindLife (final Fragment mContext, onQK_ILifeListener mListener) {
        if (mContext instanceof Fragment) {
            QK_ListenerFragment listenerFragment = new QK_ListenerFragment ();
            listenerFragment.setLifeListener (mListener);
            FragmentManager manager = mContext.getFragmentManager ();
            manager.beginTransaction ().add (listenerFragment, QK_ListenerFragment.ListenerFragmentTag).commitAllowingStateLoss ();
        }
    }

    /**
     * 绑定V4包下的Fragment
     *
     * @param mContext
     * @param mListener
     */
    public static void bindLife (final android.support.v4.app.Fragment mContext, onQK_ILifeListener mListener) {
        if (mContext instanceof android.support.v4.app.Fragment) {
            QK_ListenerFragmentV4 listenerFragment = new QK_ListenerFragmentV4 ();
            listenerFragment.setLifeListener (mListener);
            android.support.v4.app.FragmentManager manager = mContext.getFragmentManager ();
            manager.beginTransaction ().add (listenerFragment, QK_ListenerFragmentV4.ListenerFragmentTag).commitAllowingStateLoss ();
        }
    }

}
