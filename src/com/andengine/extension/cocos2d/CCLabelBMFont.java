package com.andengine.extension.cocos2d;

import org.andengine.engine.Engine;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.BitmapFont;
import org.andengine.opengl.font.IFont;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.BaseGameActivity;

public class CCLabelBMFont extends Text {

	public CCLabelBMFont(float pX, float pY, IFont pFont, CharSequence pText,
			VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pX, pY, pFont, pText, pVertexBufferObjectManager);
	}

	public static CCLabelBMFont create(String fontFile, String text) {
		BaseGameActivity app = CCDirector.sharedInstance().getApp();
		Engine engine = CCDirector.sharedInstance().getEngine();
		BitmapFont font = new BitmapFont(app.getTextureManager(), app.getAssets(), fontFile);
		font.load();
		return new CCLabelBMFont(0, 0, font, text,
				engine.getVertexBufferObjectManager());
	}

}
