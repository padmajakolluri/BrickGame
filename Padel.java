package com.aop.myBrickgame;

public class Padel {

	void padelmove(Direction direction,Position padelpos )

	{
		switch (direction) {
		case LEFT:
			int x = padelpos.getX() - 60;
			int y = padelpos.getY();
			padelpos.setX(x);
			padelpos.setY(y);
			break;
		case RIGHT:
			int a = padelpos.getX() + 60;
			int b = padelpos.getY();
			padelpos.setX(a);
			padelpos.setY(b);
			break;

		}

	}

}
