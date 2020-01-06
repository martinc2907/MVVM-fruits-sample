package com.example.mvvm_fruits_sample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.Bindable;

public class MainViewModel extends ViewModel {

    private LiveData<String> fruitTop;
    private MutableLiveData<String> fruitBottom;

    public MainViewModel() {
        fruitTop = FakeRepository.getInstance().getTopFruit();
        fruitBottom = FakeRepository.getInstance().getBottomFruit();
    }

    public void randomizeTopFruit(){
        FakeRepository.getInstance().randomizeTopFruit();
    }

    public void randomizeBottomFruit(){
        FakeRepository.getInstance().randomizeBottomFruit();
    }

    public LiveData<String> getFruitTop() {
        return fruitTop;
    }

    public MutableLiveData<String> getFruitBottom() {
        return fruitBottom;
    }
}
