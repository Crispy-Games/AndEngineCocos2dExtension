package com.andengine.extension.cocos2d;

import java.io.IOException;

import org.andengine.entity.modifier.IEntityModifier;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.ui.activity.BaseGameActivity;

public class CCSprite extends Sprite {
	CCSprite(BaseGameActivity app, String file) throws IOException {
		super(0, 0, TextureRegionFactory.extractFromTexture(app
				.getTextureManager().getTexture(file, app.getAssets(), file,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA)),
		app.getVertexBufferObjectManager());
	}

	public CCSprite(String file) throws IOException {
		this(CCDirector.sharedInstance().getApp(), file);
	}
	
	public void runAction(IEntityModifier modifier) {
		registerEntityModifier(modifier);		
	}
}
