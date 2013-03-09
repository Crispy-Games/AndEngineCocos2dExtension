package com.andengine.extension.cocos2d;

import org.andengine.entity.IEntity;
import org.andengine.util.modifier.BaseDurationModifier;
import org.andengine.util.modifier.IModifier;

public class CCDelayTime extends BaseDurationModifier<IEntity> {

	public CCDelayTime(float pDuration) {
		super(pDuration);
	}

	@Override
	protected void onManagedUpdate(float pSecondsElapsed, IEntity pItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onManagedInitialize(IEntity pItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IModifier<IEntity> deepCopy()
			throws org.andengine.util.modifier.IModifier.DeepCopyNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}


}
