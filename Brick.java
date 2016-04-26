package com.aop.myBrickgame;

public class Brick {

	private BrickGameApplication application;

	public Brick(BrickGameApplication brickGameApplication) {
		this.application = brickGameApplication;
		
	}

	void collide() {
		for (int i = 0; i < application.bricks.size(); i++) {
			if ((application.bricks.get(i).getX() == application.bollpos.getX())
					&& (application.bricks.get(i).getY() == application.bollpos.getY())) {
				application.bricks.remove(i);
			}
		}
	}
}
