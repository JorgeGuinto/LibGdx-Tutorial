package com.jorgeguinto.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.jorgeguinto.MyGdxGame;

public class WarriorScreen extends Pantalla {

    // == Constants ==
    public static final int HEIGHT = 168;
    public static final int WIDTH = 919;

    // == Fields ==
    private Texture warrior;
    private TextureRegion warriorRegion;
    private TextureRegion[] warriorFrames;
    private Animation warriorAnimation;
    private float duration = 0;



    // == Constructor ==
    public WarriorScreen(MyGdxGame game) {
        super(game);
    }

    // == Override methods ==


    @Override
    public void show() {

        warrior = new Texture("warrior.png");
        warriorRegion = new TextureRegion(warrior, WIDTH, HEIGHT);
        TextureRegion[][] temp = warriorRegion.split(WIDTH/5, HEIGHT/1);
        warriorFrames = new TextureRegion[temp.length * temp[0].length];
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++){
                warriorFrames[index++] = temp[i][j];
            }
        }

        warriorAnimation = new Animation(0.2f, warriorFrames);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0.7f, 0.2f, 0.6f, 1);

        duration += delta;
        TextureRegion frame = (TextureRegion) warriorAnimation.getKeyFrame(duration, true);
        game.batch.begin();
            game.batch.draw(frame, 100, 100);
        game.batch.end();
    }
}
