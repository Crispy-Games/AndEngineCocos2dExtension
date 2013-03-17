package com.andengine.extension.cocos2d;

import org.andengine.engine.Engine;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.font.IFont;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.BaseGameActivity;

import android.graphics.Typeface;

public class CCLabelTTF extends Text {

	public CCLabelTTF(float pX, float pY, IFont pFont, CharSequence pText,
			VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pX, pY, pFont, pText, 100, pVertexBufferObjectManager);
	}

	public static CCLabelTTF create(String text, float fontSize, int color) {
		BaseGameActivity app = CCDirector.sharedInstance().getApp();
		Engine engine = CCDirector.sharedInstance().getEngine();
		IFont font = app.getFontManager().getMappedFont(
				"font_" + fontSize + "_" + color);
		if (font == null) {
			font = FontFactory.create(app.getFontManager(), app.getTextureManager(),
					256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA,
					Typeface.create(Typeface.DEFAULT, Typeface.NORMAL),
					fontSize, true, color);
			font.load();
			app.getFontManager().addMappedFont(
					"font_" + fontSize + "_" + color, font);
		}
		return new CCLabelTTF(0, 0, font, text,
				engine.getVertexBufferObjectManager());
	}

}
