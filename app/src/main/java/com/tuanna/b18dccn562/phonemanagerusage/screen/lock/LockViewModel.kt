package com.tuanna.b18dccn562.phonemanagerusage.screen.lock

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tuanna.b18dccn562.phonemanagerusage.base.BaseViewModel
import com.tuanna.b18dccn562.phonemanagerusage.utils.PatternUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LockViewModel @Inject constructor(
    application: Application,
    private val patternUtil: PatternUtil
) : BaseViewModel(application) {

    private var isInitForUnlockApp = MutableLiveData<Boolean>()
    private var unlocked = MutableLiveData(false)
    private var lockStatus = MutableLiveData<LockPatternStatus>()
    private var patternToSaved: List<Int> = mutableListOf()

    fun setIsUnlockApp(isInitForUnlock: Boolean) {
        isInitForUnlockApp.value = isInitForUnlock
    }

    fun setLockStatus(status: LockPatternStatus) {
        lockStatus.value = status
    }

    fun checkPattern(pattern: List<Int>) {
        if (isInitForUnlockApp.value == true) {
            if (patternUtil.checkPattern(pattern)) {
                unlocked.value = true
            } else {
                lockStatus.value = LockPatternStatus.WRONG_PATTERN
            }
        } else {
            if (patternToSaved.isEmpty()) {
                if (pattern.size >= 3) {
                    patternToSaved = patternToSaved.plus(pattern)
                    setLockStatus(LockPatternStatus.REDRAW_PATTERN)
                } else {
                    setLockStatus(LockPatternStatus.TOO_SHORT)
                }
            } else {
                if (patternToSaved == pattern) {
                    patternUtil.savePattern(pattern)
                    unlocked.value = true
                } else {
                    setLockStatus(LockPatternStatus.WRONG_PATTERN)
                }
            }
        }
    }


    fun getLockStatus(): LiveData<Boolean> = unlocked
    fun getCreateLockStatus(): LiveData<LockPatternStatus> = lockStatus

}