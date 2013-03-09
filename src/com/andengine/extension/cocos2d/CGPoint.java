package com.andengine.extension.cocos2d;

public class CGPoint {
	public static final CGPoint ZERO = new CGPoint(0, 0);
	public final float x;
	public final float y;

	public CGPoint(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public static float distance(CGPoint p1, CGPoint p2) {
		return (float) Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y)
				* (p2.y - p1.y));
	}
}
