package com.nhnacademy.day2;


public interface Filter {
    void doFilter(Request request, FilterChain filterChain);
}
