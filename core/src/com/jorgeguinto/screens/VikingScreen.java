package com.jorgeguinto.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.jorgeguinto.characters.Plane;
import com.jorgeguinto.inputs.InputPlaneKeyboard;
import com.jorgeguinto.MyGdxGame;
import com.jorgeguinto.VirtualController;

public class VikingScreen extends Pantalla {

    // == Constants ==
    public static final int HEIGHT = 344;
    public static final int WIDTH = 849;

    // == Fields ==
    private Plane vik;
    private Texture viking;
    private TextureRegion vikingRegion;
    private TextureRegion[] vikingFrames;
    private Animation vikingAnimation;
    private float duration = 0;
    private VirtualController controller;
    private InputPlaneKeyboard input;

    // == Constructor ==
    public VikingScreen(MyGdxGame game) {
        super(game);
    }

    // == Override methods ==

    @Override
    public void show() {

        controller = new VirtualController();
        input = new InputPlaneKeyboard(controller);

        Gdx.input.setInputProcessor(input);

        viking = new Texture("viking.jpg");
        vikingRegion = new TextureRegion(viking, WIDTH, HEIGHT);
        TextureRegion[][] temp = vikingRegion.split(WIDTH/5, HEIGHT/2);
        vikingFrames = new TextureRegion[temp.length * temp[0].length];
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++){
                vikingFrames[index++] = temp[i][j];
            }
        }
        vikingAnimation = new Animation(0.2f, vikingFrames);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0.7f, 0.2f, 0.6f, 1);

        duration += delta;
        TextureRegion frame = (TextureRegion) vikingAnimation.getKeyFrame(duration, true);
        game.batch.begin();
            game.batch.draw(frame, 100, 100);
        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            game.setScreen(game.warrior);
        } else if (Gdx.input.isKeyPressed(Input.Keys.V)) {
            game.setScreen(game.viking);
        }
    }
}
