package com.example.demobindlife;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.demobindlife.ActivityLife.QKManager;
import com.example.demobindlife.ActivityLife.onQK_ILifeListener;
import com.example.demobindlife.ActivityLife.onQK_LifeListener;


public class DemoBindLifeActivity extends Activity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_demo_bind_life);
        final TextView mTextView = (TextView) findViewById (R.id.tv);
        mTextView.setMovementMethod (ScrollingMovementMethod.getInstance ());

        QKManager.bindLife (this, new onQK_LifeListener () {

            @Override
            public void onStart () {

                mTextView.append ("\r\n" + "DemoBindLifeActivity.onStart");
            }

            @Override
            public void onDestroy () {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onDestroy");
            }

            @Override
            public void onStop () {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onStop");
            }

            @Override
            public void onCreat () {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onCreat");
            }

            @Override
            public void onPause () {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onPause");
            }

            @Override
            public void onResume () {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onResume");
            }

            @Override
            public void onFragmentHiddenChanged (final boolean isHidden) {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onFragmentHiddenChanged");
            }
        });
        QKManager.bindLife (this, new onQK_LifeListener () {

            @Override
            public void onStart () {

                mTextView.append ("\r\n" + "DemoBindLifeActivity.onStart");
            }

            @Override
            public void onDestroy () {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onDestroy");
            }

            @Override
            public void onStop () {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onStop");
            }

            @Override
            public void onCreat () {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onCreat");
            }

            @Override
            public void onPause () {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onPause");
            }

            @Override
            public void onResume () {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onResume");
            }

            @Override
            public void onFragmentHiddenChanged (final boolean isHidden) {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onFragmentHiddenChanged");
            }
        });
        QKManager.bindLife (this, new onQK_LifeListener () {

            @Override
            public void onStart () {

                mTextView.append ("\r\n" + "DemoBindLifeActivity.onStart");
            }

            @Override
            public void onDestroy () {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onDestroy");
            }

            @Override
            public void onStop () {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onStop");
            }

            @Override
            public void onCreat () {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onCreat");
            }

            @Override
            public void onPause () {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onPause");
            }

            @Override
            public void onResume () {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onResume");
            }

            @Override
            public void onFragmentHiddenChanged (final boolean isHidden) {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onFragmentHiddenChanged");
            }
        });
        QKManager.bindLife (this, new onQK_LifeListener () {

            @Override
            public void onStart () {

                mTextView.append ("\r\n" + "DemoBindLifeActivity.onStart");
            }

            @Override
            public void onDestroy () {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onDestroy");
            }

            @Override
            public void onStop () {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onStop");
            }

            @Override
            public void onCreat () {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onCreat");
            }

            @Override
            public void onPause () {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onPause");
            }

            @Override
            public void onResume () {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onResume");
            }

            @Override
            public void onFragmentHiddenChanged (final boolean isHidden) {
                mTextView.append ("\r\n" + "DemoBindLifeActivity.onFragmentHiddenChanged");
            }
        });

        getFragmentManager ().beginTransaction ().add (R.id.fragment,new fragment (), "fragment").commitAllowingStateLoss ();
    }

    public static class fragment extends Fragment {
        @Nullable
        @Override
        public View onCreateView (final LayoutInflater inflater, @Nullable final ViewGroup container, final Bundle savedInstanceState) {
            View mView = inflater.inflate (R.layout.activity_demo_bind_life_fragment, null);
            final TextView mTextView = (TextView) mView.findViewById (R.id.tv);
            mTextView.setMovementMethod (ScrollingMovementMethod.getInstance ());
            QKManager.bindLife (this, new onQK_ILifeListener () {
                @Override
                public void onStart () {
                    mTextView.append ("\r\n" + "fragment.onStart");
                }

                @Override
                public void onDestroy () {
                    mTextView.append ("\r\n" + "fragment.onDestroy");

                }

                @Override
                public void onStop () {
                    mTextView.append ("\r\n" + "fragment.onStop");

                }

                @Override
                public void onCreat () {
                    mTextView.append ("\r\n" + "fragment.onCreat");

                }

                @Override
                public void onPause () {
                    mTextView.append ("\r\n" + "fragment.onPause");
                }

                @Override
                public void onResume () {
                    mTextView.append ("\r\n" + "fragment.onResume");
                }

                @Override
                public void onFragmentHiddenChanged (final boolean isHidden) {
                    mTextView.append ("\r\n" + "fragment.onFragmentHiddenChanged");
                }
            });
            return mView;
        }
    }
}
