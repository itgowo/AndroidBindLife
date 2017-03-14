package com.example.demobindlife.ActivityLife;

/**
 * Created by lujianchao on 2016/10/27.
 */

public interface onQK_ILifeListener {
        public void onStart ();
        public void onDestroy ();
        public void onStop ();
        public void onCreat ();
        public void onPause ();
        public void onResume ();

        /**
         * 使用情况有限
         * @param isHidden
         */
        public void onFragmentHiddenChanged (boolean isHidden);
}
