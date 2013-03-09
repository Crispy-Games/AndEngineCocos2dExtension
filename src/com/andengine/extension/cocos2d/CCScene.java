package com.andengine.extension.cocos2d;

import org.andengine.entity.IEntity;
import org.andengine.entity.scene.ITouchArea;
import org.andengine.entity.scene.Scene;

public class CCScene extends Scene {

	public CCScene() {
		setTouchAreaBindingOnActionDownEnabled(true);
	}
	
	public void onEnter() {
		for (int c = 0; c < getChildCount(); c++) {
			internalOnEnter(getChildByIndex(c));
		}
	}
	
	public void onExit() {
		for (int c = 0; c < getChildCount(); c++) {
			internalOnExit(getChildByIndex(c));
		}
	}
	
	private void internalOnEnter(IEntity child) {
		if (child instanceof CCNode) {
			((CCNode) child).onEnter();
		}
		for (int c = 0; c < child.getChildCount(); c++) {
			internalOnEnter(child.getChildByIndex(c));
		}
	}
	
	private void internalOnExit(IEntity child) {
		if (child instanceof CCNode) {
			((CCNode) child).onExit();
		}
		for (int c = 0; c < child.getChildCount(); c++) {
			internalOnExit(child.getChildByIndex(c));
		}
	}
	
	public static CCScene sceneWithLayer(CCLayer layer) {
		CCScene scene = new CCScene();
		scene.attachChild(layer);
		return scene;
	}
}
