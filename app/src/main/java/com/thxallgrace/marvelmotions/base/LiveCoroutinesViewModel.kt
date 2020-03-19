package com.thxallgrace.marvelmotions.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers

/**
 * 코루틴
 *
 * 비동기적으로 실행되는 코드를 간소화 시키기 위해 Android에서 사용할 수 있는 동시 실행 설계 패턴
 * 코투린을 통해 기본 스레드를 차단하여 앱이 정지될 장기 실행 작업을 관리할 수 있다.
 * 코루탄을 통해 기본 스레드에서 네트워크 또는 디스크 작업을 안전하게 호출하는 기능을 제공할 수 있다.
 */


abstract class LiveCoroutinesViewModel : ViewModel(){

    //crossinline : 람다 파라미터를 이 수정자를 통해서 표시해야함
    //suspend : 모든 로컬 변수를 저장하여 현재 코루틴 실행을 정지
    protected inline fun <T> launchOnViewModelScope(crossinline block: suspend () -> LiveData<T>): LiveData<T> {

        // CoroutineContext : 코루틴을 어떻게 처리 할것인지에 대한 여러가지 정보의 집합
        // Dispatchers.IO : 네트워크, 디스크 사용 할때 사용함. 파일 읽고, 쓰고, 소켓을 읽고, 쓰고 작업을 멈추는것에 최적화되어 있음.

        return liveData(viewModelScope.coroutineContext + Dispatchers.IO){

            // emitSource() : 새 값을 내보내려고 할 때 이 함수 호출
            emitSource(block())
        }
    }
}