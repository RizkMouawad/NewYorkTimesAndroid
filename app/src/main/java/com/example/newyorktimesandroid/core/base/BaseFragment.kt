package com.example.newyorktimesandroid.core.base

import android.app.Activity
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment() {

    var mActivity: Activity?  = null

}