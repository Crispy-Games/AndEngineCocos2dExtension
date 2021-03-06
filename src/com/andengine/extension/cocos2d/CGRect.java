package com.andengine.extension.cocos2d;

public class CGRect {
	public static final CGRect ZERO = new CGRect(0, 0, 0, 0);
	
	public final CGPoint origin;
	public final CGSize size;
	
	public CGRect(float x, float y, float w, float h) {
		origin = new CGPoint(x, y);
		size = new CGSize(w, h);
	}

	public boolean containsPoint(float x, float y) {
		float xx = x - origin.x;
		float yy = y - origin.y;
		return ((xx >= 0) && (xx <= size.width))
				&& ((yy >= 0) && (yy <= size.height));
	}
	
	public float getMidX() {
		return origin.x + size.width/2;
	}
	
	public float getMinX() {
		return origin.x;
	}
	
	public float getMinY() {
		return origin.y;
	}
	
	public float getMaxX() {
		return origin.x + size.width;
	}
	
	public float getMaxY() {
		return origin.y + size.height;
	}
	
	public float getMidY() {
		return origin.y + size.height/2;
	}
}
