#Android 轻松实现生命周期绑定

#####不知道大家用没用过Glide这个加载图片的第三方库，非常好用，Glide就实现了绑定Activity和Fragment生命周期的方法，本期文章讲的就是看了Glide源码后总结的精华内容。

QQ:1264957104

Web:http://lujianchao.com 

GitHub：https://github.com/hnsugar 

CSDN:http://blog.csdn.net/hnsugar

###1.首先大家会问，为什么要绑定生命周期？

####我举几个例子：
Glide绑定ImageView，当Activity或者fragment销毁了，上面的Imageview所使用的图像资源就可以释放了，可以说是“手动”释放了，虽然是回调的方式实现的。

  还有就是，网络请求，我们在一个页面发送了网络请求，但是又很快关闭了，那请求结果可能就不需要处理了，（之后我会发一篇自己写一个用反射实现缓存的框架，只有不到300行代码）有一些网络请求框架是支持请求取消的，可以cancel掉，这样就用到了这个绑定，当然了，也可以在返回结果后在判断是否处理结果，但是。。。。activity不是立即销毁的，还得判断显隐状态，麻烦啊。使用绑定生命周期方法还可以和网络请求框架组合使用写一个框架，实现自动取消网络请求，是不是更高大尚呢？

总结一下：绑定生命周期是一个优化软件性能的途径之一，让系统少处理一些没意义的事情，具体怎么用还需要开发人员动动脑筋。

###2.原理
原理很简单，大家知道fragment在activity上的生命周期是跟随activity变化的，所以，我们在需要绑定的activity上加入一个看不见的fragment就可以了，是不是很简单 (＾－＾)V。

###3.开始写代码
####1.创建一个接口，监听回调用
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
####2.创建两个Fragment（一模一样，其中一个是继承V4包的）

	public class QK_ListenerFragment extends Fragment {
	    private onQK_ILifeListener mlistener;
	    public static final String ListenerFragmentTag = "ListenerFragment";

	    public QK_ListenerFragment () {
	
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
	    public void onHiddenChanged (final boolean hidden) {
	        super.onHiddenChanged (hidden);
	        if (mlistener != null) {
	            mlistener.onFragmentHiddenChanged (hidden);
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
	    public void onDestroy () {
	        if (mlistener != null) {
	            mlistener.onDestroy ();
	        }
	        super.onDestroy ();
	    }
	
	}

另一个android.support.v4.app.Fragment

	public class QK_ListenerFragmentV4 extends android.support.v4.app.Fragment {
	    //和上面的一模一样。。。。d=====(￣▽￣*)b
	}


####3.绑定生命周期，以Activity为例
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
好了，直接调用就行了，
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
####4.FragmentActivity方式
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
####5.默认Fragment绑定,使用的是FragmentManager ，记住
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
####6.绑定V4包下的Fragment ,  android.support.v4.app.Fragment
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

####7.综合一下，用一个方法

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
####8.其他问题
现在这个是简单的实现绑定，如果一个页面绑定好多次是不是就造成了浪费呢，答案是肯定的，如果一个Activity或者fragment只保留一个添加的fragment，需要做判断还要处理一堆问题，留给大家了，目前我的解决方案是利用tag，静态集合和findFragmentByTag等。。。来保证一个Activity或者fragment只插入一个我们的fragment,监听是放在一个集合里，每次触发就遍历一次执行回调，好了，思路就是这样了，大家自己拓展思路吧。(o゜▽゜)o☆[BINGO!]



####9.小尾巴
个人在倒腾自己的网站：http://lujianchao.com        风格或者数据什么的偶尔出问题，那是我在调试。。。。
GitHub：https://github.com/hnsugar    
CSDN:http://blog.csdn.net/hnsugar
项目地址：我自己的Git服务器  http://lujianchao.com:8081/gitblit/summary/AndroidTips!DemoBindLife.git
