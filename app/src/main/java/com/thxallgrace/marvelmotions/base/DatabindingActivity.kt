package com.thxallgrace.marvelmotions.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class DatabindingActivity : AppCompatActivity() {

    /**
     * reified로 타입 매개변수 T를 지정하면
     * 런타임에서도 접근 가능
     * c: Class<T>와 같은 매개변수를 넘겨주지 않아도 됨
     *
     * 하지만 reifeid 자료형은 인라인 함수에서만 사용할수 있습니다.
     */

    // DataBindingUtil 클래스에 레이아웃을 정의해 액티비티를 바인딩하는 함수
    protected inline fun <reified T : ViewDataBinding> binding(
            @LayoutRes resId: Int
    ): Lazy<T> = lazy { DataBindingUtil.setContentView<T>(this, resId) }

}