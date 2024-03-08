package com.nhnacademy;

public class Vector {
    //dx dy 변수
    //dx dy 받아서 벡터 오브젝트 생성
    //dxdy를 위한 겟터세터
    //dxdy 방향 바꾼다
    //추가 + - 연산 (이것은 나중에)

    int dx = 0;
    int dy = 0;
    int angle = 0 ;
    int Magnitude = 0;


    public Vector(){
        this.dx = 0;
        this.dy = 0;

    }
    public Vector(int dx, int dy){
        this.dx = dx;
        this.dy = dy;

    }
    public Vector(int dx, int dy,int angle, int Magnitude){
        this.dx = dx;
        this.dy = dy;
        this.angle = angle;
        this.Magnitude = Magnitude;
    }

    public int getMagnitude() {
        return Magnitude;
    }



    // public void setMagnitude(int magnitude) {
    //     Magnitude = magnitude;
    // }

    // public int getAngle() {
    //     return angle;
    // }
    // public void setAngle(int angle) {
    //     this.angle = angle;
    // }

    public int getDX() {
        return dx;
    }
    public void setDX(int dx) {
        this.dx = dx;
    }
    public int getDY() {
        return dy;
    }
    public void setDY(int dy) {
        this.dy = dy;
    }
    public void set(int dx ,int dy) {
        setDX(dx);
        setDY(dy);
    }
    public void turnDX(){
        setDX(-getDX());
    }
    public void turnDY(){
        setDY(-getDY());
    }

    public void add(Vector other){
        set(getDX() + other.getDX(), getDY() + other.getDY());

    }

    public void sub(Vector other){
        set(getDX() - other.getDX(), getDY() - other.getDY());
    }

}
