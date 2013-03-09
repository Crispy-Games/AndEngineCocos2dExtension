package com.andengine.extension.cocos2d;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.IEntityModifier;
import org.andengine.util.modifier.BaseDurationModifier;

public class CCHide extends BaseDurationModifier<IEntity> implements IEntityModifier {

	public CCHide() {
		super(0.5f);
	}

	@Override
	public IEntityModifier deepCopy()
			throws DeepCopyNotSupportedException {
		return new CCHide();
	}
	
	@Override
	protected void onModifierFinished(IEntity pItem) {
		super.onModifierFinished(pItem);
		pItem.setVisible(false);
	}

	@Override
	protected void onManagedUpdate(float pSecondsElapsed, IEntity pItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onManagedInitialize(IEntity pItem) {
		
	}
}
