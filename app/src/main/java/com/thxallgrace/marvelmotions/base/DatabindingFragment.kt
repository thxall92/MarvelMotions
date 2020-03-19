package com.thxallgrace.marvelmotions.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class DatabindingFragment : Fragment(){

    // DataBindingUtil 클래스에 레이아웃을 정의해 Fragment 를 바인딩하는 함수
    protected inline fun <reified T : ViewDataBinding> binding(
            inflater: LayoutInflater,
            @LayoutRes resId: Int,
            container: ViewGroup?
    ): T = DataBindingUtil.inflate(inflater, resId, container, false)
}