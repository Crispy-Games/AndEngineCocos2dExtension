package com.andengine.extension.cocos2d;

import org.andengine.engine.Engine;
import org.andengine.ui.activity.BaseActivity;
import org.andengine.ui.activity.BaseGameActivity;

import android.view.Display;

public class CCDirector {
	private static final CCDirector INSTANCE = new CCDirector();
	private CGSize winSize;
	
	private Engine mEngine;
	private BaseGameActivity mApp;

	private CCDirector() {
	}

	public static CCDirector sharedInstance() {
		return INSTANCE;
	}
	
	public void setEngine(Engine e) {
		this.mEngine = e;
	}
	
	public void setApp(BaseGameActivity app) {
		this.mApp = app;
		Display d = app.getWindowManager().getDefaultDisplay();
		winSize = new CGSize(d.getWidth(), d.getHeight());
	}
	
	public Engine getEngine() {
		return mEngine;
	}
	
	public BaseGameActivity getApp() {
		return mApp;
	}

	public void runScene(CCScene scene) {
		CCScene running = runningScene();
		if (running != null)
			running.onExit();
		mEngine.setScene(scene);
		scene.onEnter();
	}

	public CCScene runningScene() {
		return (CCScene) mEngine.getScene();
	}
	
	public CGSize getWinSize() {
		return winSize;
	}
}
