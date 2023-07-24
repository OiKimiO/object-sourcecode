package com.study.object.chapter04.movie;

public class AnyClass {
    // 결합도가 높음
    public void anyMethod(Rectangle rectangle, int multiple){
        rectangle.setRight(rectangle.getRight() * multiple);
        rectangle.setBottom(rectangle.getBottom() * multiple);
    }
}
