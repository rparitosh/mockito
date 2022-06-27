package com.paritosh.learning.mockito;

public class SomeBusinessImpl {

    private DataService service ;

    public void setService(DataService service) {
        this.service = service;
    }

    public int getLargest(){
        int[] values = service.getSomeData();
        int largest = Integer.MIN_VALUE;

        for (int i: values){
            largest = Math.max(i,largest);
        }
        return largest;
    }
}
