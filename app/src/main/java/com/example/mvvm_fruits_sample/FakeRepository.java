package com.example.mvvm_fruits_sample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Random;

public class FakeRepository {

    //Repositories should get required data from database or external server.

    private static FakeRepository fakeRepository;
    private ArrayList<String> fruitList;

    private MutableLiveData<String> topFruit;
    private MutableLiveData<String> bottomFruit;

    public static FakeRepository getInstance(){
        if(fakeRepository == null){
            fakeRepository = new FakeRepository();
        }
        return fakeRepository;
    }

    private FakeRepository() {
        topFruit = new MutableLiveData<>();
        bottomFruit = new MutableLiveData<>();

        topFruit.setValue("Apple");
        bottomFruit.setValue("Apple");

        fruitList = new ArrayList<>();
        fruitList.add("Orange");
        fruitList.add("Apple");
        fruitList.add("Mango");
        fruitList.add("Pineapple");
        fruitList.add("Peach");
        fruitList.add("Strawberry");
    }

    //return LiveData, since only Repo should change data
    public MutableLiveData<String> getTopFruit() {
        return topFruit;
    }

    public MutableLiveData<String> getBottomFruit(){
        return bottomFruit;
    }


    public void randomizeTopFruit(){
        Random random = new Random();
        String name = fruitList.get(random.nextInt(fruitList.size()));
        topFruit.setValue(name);
    }

    public void randomizeBottomFruit(){
        Random random = new Random();
        String name = fruitList.get(random.nextInt(fruitList.size()));
        bottomFruit.setValue(name);
    }


}
