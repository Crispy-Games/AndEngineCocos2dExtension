package com.andengine.extension.cocos2d;

import org.andengine.entity.IEntity;
import org.andengine.util.call.Callable;
import org.andengine.util.modifier.BaseModifier;
import org.andengine.util.modifier.IModifier;

public class CCCallFuncN extends BaseModifier<IEntity> {

	Callable<Void> f;
	
	public CCCallFuncN(Callable<Void> f) {
		super();
		this.f = f;
	}
	
	@Override
	public void reset() {
		
	}

	@Override
	public float getSecondsElapsed() {
		return 0;
	}

	@Override
	public float getDuration() {
		return 0;
	}

	@Override
	public float onUpdate(float pSecondsElapsed, IEntity pItem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IModifier<IEntity> deepCopy()
			throws org.andengine.util.modifier.IModifier.DeepCopyNotSupportedException {
		return null;
	}

	@Override
	protected void onModifierFinished(IEntity pItem) {
		super.onModifierFinished(pItem);
		try {
			f.call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
