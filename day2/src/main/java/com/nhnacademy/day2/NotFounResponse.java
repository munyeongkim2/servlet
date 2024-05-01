package com.nhnacademy.day2;

public class NotFounResponse implements Response {
    @Override
    public void doResponse(Request request) {
        System.out.println("존재하지 않는 페이지!");
    }
}
