package com.paritosh.learning.mockito;

public class SomeBusinessImpl {

    private DataService service ;

    public void setService(DataService service) {
        this.service = service;
    }

    public int getLargest() throws Exception {
        int[] values = service.getSomeData();

        if ( values.length ==0 ){
            throw new Exception("No values to compare");
        }
        int largest = Integer.MIN_VALUE;

        for (int i: values){
            largest = Math.max(i,largest);
        }
        return largest;
    }
}
