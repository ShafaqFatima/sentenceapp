package com.digipod.sentenceapp.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    private val _currentVowelCount = MutableLiveData(0)
    val currentVowelCount: LiveData<Int>
        get() = _currentVowelCount

    private val _currentWordCount = MutableLiveData(0)
    val currentWordCount: LiveData<Int>
        get() = _currentWordCount

    private val _currentCharCount = MutableLiveData(0)
    val currentCharCount: LiveData<Int>
        get() = _currentCharCount

    private val _currentSpaceCount = MutableLiveData(0)
    val currentSpaceCount: LiveData<Int>
        get() = _currentSpaceCount

    private val _currentSPCharCount = MutableLiveData(0)
    val currentSPCharCount: LiveData<Int>
        get() = _currentSPCharCount
    init {
        Log.d(" FirstFragment", "counterViewModel created!")
        reinitializeData()
    }
    fun counter(sentence: String) {
        for (element in sentence)
        {
            _currentCharCount.value = _currentCharCount.value!!.inc()
            when (element) {
                'a', 'e', 'i', 'o', 'u','A','E','I','O','U' -> {
                    _currentVowelCount.value = _currentVowelCount.value!!.inc()
                }
                ' ' -> {
                    _currentSpaceCount.value = _currentSpaceCount.value!!.inc()

                }
                in 'a'..'z', in 'A'..'Z' -> {

                }
                else -> {
                    _currentSPCharCount.value = _currentSPCharCount.value!!.inc()
                }
            }
            }

        _currentWordCount.value = _currentSpaceCount.value!!.inc()
    }

        override fun onCleared() {
            super.onCleared()
            Log.d("FirstFragment", "CounterViewModel destroyed!")
        }

        fun reinitializeData() {
            _currentVowelCount.value = 0
            _currentWordCount.value = 0
            _currentCharCount.value = 0
            _currentSpaceCount.value = 0
            _currentSPCharCount.value = 0


        }

    }

