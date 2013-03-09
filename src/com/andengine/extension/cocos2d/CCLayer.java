package com.andengine.extension.cocos2d;

import org.andengine.engine.Engine;
import org.andengine.input.touch.TouchEvent;
import org.andengine.ui.activity.BaseGameActivity;

public abstract class CCLayer extends CCNode {

	private boolean isTouchEnabled;
	private boolean isAccelerometerEnabled;
	
	private boolean handlingTouch;
		
	public CCLayer() {
		super(0, 0, 480, 800);
		setAnchorCenter(0, 0);
		isTouchEnabled = false;
		isAccelerometerEnabled = false;
		handlingTouch = false;
	}
	
	public void setTouchEnabled(boolean isTouchEnabled) {
		this.isTouchEnabled = isTouchEnabled;
		
	}

	protected Engine getEngine() {
		return CCDirector.sharedInstance().getEngine();
	}

	protected BaseGameActivity getApp() {
		return CCDirector.sharedInstance().getApp();
	}

	@Override
	public void onEnter() {
		if (isTouchEnabled) {
			CCDirector.sharedInstance().runningScene().registerTouchArea(this);
		}
	}

	@Override
	public void onExit() {
		if (isTouchEnabled) {
			CCDirector.sharedInstance().runningScene().unregisterTouchArea(this);
		}
	}
	
	@Override
	public boolean onAreaTouched(TouchEvent event,
			float pTouchAreaLocalX, float pTouchAreaLocalY) {
		CGPoint p = new CGPoint(pTouchAreaLocalX, pTouchAreaLocalY);
		if (event.isActionDown()) { 
			handlingTouch = touchBegan(p);
			return handlingTouch;
		}
		if (!handlingTouch)
			return false;
		if (event.isActionMove()) {
			touchMoved(p);
		}
		if (event.isActionCancel()) {
			touchCancelled(p);
		}
		if (event.isActionUp()) {
			touchEnded(p);
		}
		return true;
	}

	public boolean touchBegan(CGPoint p) {
		return false;
	}
	
	public void touchMoved(CGPoint p) {
	}
	
	public void touchCancelled(CGPoint p) {
	}
	
	public void touchEnded(CGPoint p) {
	}
}
