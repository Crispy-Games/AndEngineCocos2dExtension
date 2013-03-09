package com.andengine.extension.cocos2d;

import org.andengine.entity.IEntity;
import org.andengine.util.modifier.BaseDurationModifier;
import org.andengine.util.modifier.IModifier;

public class CCMoveTo extends BaseDurationModifier<IEntity> {

	float dxPerSecond;
	float dyPerSecond;
	float tx;
	float ty;

	public CCMoveTo(float x, float y, float pDuration) {
		super(pDuration);
		this.tx = x;
		this.ty = y;
	}

	@Override
	protected void onManagedUpdate(float pSecondsElapsed, IEntity pItem) {
		pItem.setPosition(pItem.getX() + pSecondsElapsed * dxPerSecond,
				pItem.getY() + pSecondsElapsed * dyPerSecond);
	}

	@Override
	protected void onManagedInitialize(IEntity pItem) {
		dxPerSecond = (tx - pItem.getX()) / mDuration;
		dyPerSecond = (ty - pItem.getY()) / mDuration;
	}

	public IModifier<IEntity> deepCopy()
			throws org.andengine.util.modifier.IModifier.DeepCopyNotSupportedException {
		throw new DeepCopyNotSupportedException();
	}

}
