# 벽돌깨임 게임

## 요구사항
Ball

    모든 물체에 반사된다. 

    한개 이상도 가능하다.

    즉, 동시에 두개 이상의 ball 사용도 가능하며, ball간 충돌시에도 튕긴다.

    게임당 1개 이상의 볼이 주어질 수 있다.

    동시 사용과는 다르다

Brick

    단색 또는 복수의 색 사용이 가능하다.

    종류에 따라 점수를 달리 줄 수 있다.

    종류에 따라 강도를 정할 수 있다.

    1번에 깨지는 벽돌, 3번에 깨지는 벽돌이 존재할 수 있다.

    깨지지 않는 벽돌이 존재할 수 있다.

Control Bar

    깨지지 않는다.

    ball을 튕길때 마다 크기가 변경될 수 있다.

    위치에 따라 반사 각도가 달라 질 수 있다.

점수판

    시작시 인원을 지정하고, 점수판은 해당 인원만큼 생성될 수 있다.


- interface bounded, paintable, moveable, regionable
- class ball, box (상속 brick, ControlBar 생성) 
- class playground (ex. world)

