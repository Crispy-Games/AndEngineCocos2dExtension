package com.andengine.extension.cocos2d;

import java.util.LinkedList;

import org.andengine.engine.Engine;
import org.andengine.ui.activity.BaseActivity;
import org.andengine.ui.activity.BaseGameActivity;

import android.view.Display;

public class CCDirector {
	private static final CCDirector INSTANCE = new CCDirector();
	private CGSize winSize;
	
	private Engine mEngine;
	private BaseGameActivity mApp;
	private LinkedList<CCScene> queue;

	private CCDirector() {
		queue = new LinkedList<CCScene>();
	}

	public static CCDirector sharedInstance() {
		return INSTANCE;
	}
	
	public void setEngine(Engine e) {
		this.mEngine = e;
	}
	
	public void setApp(BaseGameActivity app) {
		this.mApp = app;
		winSize = new CGSize(480, 800);
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
	
	public void pushScene(CCScene scene) {
		CCScene running = runningScene();
		if (running == null) {
			throw new IllegalStateException("Why you trying to push scene into empty scene");
		}
		queue.addLast(scene);
		mEngine.setScene(scene);
		scene.onEnter();
	}
	
	public void popScene() {
		CCScene running = runningScene();
		if (running == null) {
			throw new IllegalStateException("Why you trying to pop scene from empty scene");
		}
		running.onExit();
		CCScene lastScene = queue.removeLast();
		mEngine.setScene(lastScene);
	}

	public CCScene runningScene() {
		return (CCScene) mEngine.getScene();
	}
	
	public CGSize getWinSize() {
		return winSize;
	}
}
