package com.aop.myBrickgame;


public class Position {
		private int x;
		private int y;

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		Position(int x, int y) {
			this.x = x;
			this.y = y;

		}

		public boolean equals(Position position) {
			int x = position.getX();
			int y = position.getY();
			return this.x == x && this.y == y;

		}

}
