package com.andengine.extension.cocos2d;

import java.io.IOException;
import java.util.HashMap;

import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;

public class SimpleAudioEngine {
	private static SimpleAudioEngine INSTANCE = null;

	public static SimpleAudioEngine sharedEngine() {
		if (INSTANCE == null) {
			INSTANCE = new SimpleAudioEngine();
		}
		return INSTANCE;
	}

	private HashMap<String, Sound> preloadedEffects;

	private SimpleAudioEngine() {
		preloadedEffects = new HashMap<String, Sound>();
	}

	public void preloadEffect(String sound) {
		try {
			Sound s = SoundFactory.createSoundFromAsset(CCDirector
					.sharedInstance().getEngine().getSoundManager(), CCDirector
					.sharedInstance().getApp(), sound);
			preloadedEffects.put(sound, s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void playEffect(String sound) {
		try {
			if (preloadedEffects.containsKey(sound)) {
				Sound s = preloadedEffects.get(sound);
				s.play();
			} else {
				Sound s = SoundFactory.createSoundFromAsset(CCDirector
						.sharedInstance().getEngine().getSoundManager(),
						CCDirector.sharedInstance().getApp(), sound);
				s.play();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
