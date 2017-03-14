package com.example.demobindlife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.demobindlife.ActivityLife.QKManager;
import com.example.demobindlife.ActivityLife.onQK_ILifeListener;
import com.example.demobindlife.ActivityLife.onQK_LifeListener;


public class DemoBindLifeActivityV4 extends FragmentActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_demo_bind_life);
        final TextView mTextView = (TextView) findViewById (R.id.tv);
        mTextView.setMovementMethod (ScrollingMovementMethod.getInstance ());
        QKManager.bindLife (this, new onQK_LifeListener () {
            @Override
            public void onStart () {
                mTextView.append ("\r\n"+"DemoBindLifeActivityV4.onStart");
            }

            @Override
            public void onDestroy () {
                mTextView.append ("\r\n"+"DemoBindLifeActivityV4.onDestroy");
            }

            @Override
            public void onStop () {
                mTextView.append ("\r\n"+"DemoBindLifeActivityV4.onStop");
            }

            @Override
            public void onCreat () {
                mTextView.append ("\r\n"+"DemoBindLifeActivityV4.onCreat");
            }

            @Override
            public void onPause () {
                mTextView.append ("\r\n"+"DemoBindLifeActivityV4.onPause");
            }

            @Override
            public void onResume () {
                mTextView.append ("\r\n"+"DemoBindLifeActivityV4.onResume");
            }

            @Override
            public void onFragmentHiddenChanged (final boolean isHidden) {
                mTextView.append ("\r\n"+"DemoBindLifeActivityV4.onFragmentHiddenChanged");
            }
        });


        getSupportFragmentManager ().beginTransaction ().add (R.id.fragment,new fragmentV4 (), "fragment").commitAllowingStateLoss ();
    }

    public static class fragmentV4 extends android.support.v4.app.Fragment {
        @Nullable
        @Override
        public View onCreateView (final LayoutInflater inflater, @Nullable final ViewGroup container, final Bundle savedInstanceState) {
            View mView = inflater.inflate (R.layout.activity_demo_bind_life_fragment, null);
            final TextView mTextView = (TextView) mView.findViewById (R.id.tv);
            mTextView.setMovementMethod (ScrollingMovementMethod.getInstance ());
            QKManager.bindLife (this, new onQK_ILifeListener () {
                @Override
                public void onStart () {
                    mTextView.append ("\r\n" + "fragmentV4.onStart");
                }

                @Override
                public void onDestroy () {
                    mTextView.append ("\r\n" + "fragmentV4.onDestroy");

                }

                @Override
                public void onStop () {
                    mTextView.append ("\r\n" + "fragmentV4.onStop");

                }

                @Override
                public void onCreat () {
                    mTextView.append ("\r\n" + "fragmentV4.onCreat");

                }

                @Override
                public void onPause () {
                    mTextView.append ("\r\n" + "fragmentV4.onPause");
                }

                @Override
                public void onResume () {
                    mTextView.append ("\r\n" + "fragmentV4.onResume");
                }

                @Override
                public void onFragmentHiddenChanged (final boolean isHidden) {
                    mTextView.append ("\r\n" + "fragmentV4.onFragmentHiddenChanged");
                }
            });
            return mView;
        }
    }
}
