package com.jorgeguinto;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jorgeguinto.screens.Pantalla;
import com.jorgeguinto.screens.WarriorScreen;

public class MyGdxGame extends Game {

	public SpriteBatch batch;
	public Pantalla warrior;

	@Override
	public void create () {

		batch = new SpriteBatch();
		warrior = new WarriorScreen(this);
		setScreen(warrior);

	}
	@Override
	public void dispose () {
		batch.dispose();
	}
}
