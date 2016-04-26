package com.aop.myBrickgame;

public class Boll {
	public double angle = 45;
	int radious = 10;
	private BrickGameApplication gameapp;
	private int x;
	private int y;

	Boll(BrickGameApplication gameapp) {
		this.gameapp = gameapp;
	}

	void move() {
		System.out.print("in move ");
		changeAngle();
			calculateDestinationPosition();
			
	}

	public void calculateDestinationPosition() {
		
		x = gameapp.bollpos.getX();
		y = gameapp.bollpos.getY();
		if(x>=0&&y>=0)
		{
		x = (int) (x + (radious * Math.cos(angle)));
		y = (int) (y + (radious * Math.sin(angle)));
		
		System.out.print(" in dest pos");
		System.out.print("angle"+angle);
		System.out.print("x="+x);
		System.out.print("y="+y);
		gameapp.createBoll(x, y);
	}
		
	}
	

	public void changeAngle() {
		System.out.print("in change angle");
		if (isTouchLeftWall()|| isTouchRightWall()) 
	{
			this.angle = this. angle+180;
			System.out.println("hellow");
		}
		if (isTouchAtup() || isTouchpadel() || isTouchbricks())
		
		{
			this.angle = this. angle+180;
			System.out.println(angle);
		}

	
	}
	public boolean isTouchbricks() {
		for (int i = 0; i < gameapp.bricks.size(); i++)
			if ((gameapp.bricks.get(i).getX() == gameapp.bollpos.getX())
					&& (gameapp.bricks.get(i).getY() == gameapp.bricks.get(i).getY())) {
				return true;
			}
		return false;
	}

	public boolean isTouchpadel() {
		if (gameapp.boll.x == gameapp.padelpos.getX()) {
			return true;
		}
		return false;
	}

	public boolean isTouchAtup() {
		if (gameapp.getM()>=0&&gameapp.getN()==0)
			return true;
		else
			return false;
	}

	public boolean isTouchRightWall() {
		if (gameapp.getM() == 600&&gameapp.getN()>=0) {
			return true;
		} else
			return false;
	}

	public boolean isTouchLeftWall()
	{System.out.println(gameapp.getN());
		if (gameapp.getN() == 600&&gameapp.getM()>=0)
			return true;
		else
			return false;
	}

}
