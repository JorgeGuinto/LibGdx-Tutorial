package com.jorgeguinto.screens;

import com.badlogic.gdx.Screen;
import com.jorgeguinto.MyGdxGame;

public abstract class Pantalla implements Screen {

    protected MyGdxGame game;

    public Pantalla(MyGdxGame game) {
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
