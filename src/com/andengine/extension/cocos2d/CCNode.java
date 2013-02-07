package com.andengine.extension.cocos2d;

import org.andengine.entity.Entity;

public class CCNode extends Entity {
	
	public CCNode(float x, float y, float w, float h) {
		super(x, y, w, h);
	}
	
	public void onEnter() {}
	public void onExit() {}
	
	@Override
	public void onDetached() {
		super.onDetached();
		onExit();
	}
}
