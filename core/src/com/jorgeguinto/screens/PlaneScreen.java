package com.jorgeguinto.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.jorgeguinto.MyGdxGame;
import com.jorgeguinto.VirtualController;
import com.jorgeguinto.characters.Plane;
import com.jorgeguinto.inputs.InputPlaneKeyboard;
import com.jorgeguinto.inputs.InputPlaneMouse;

public class PlaneScreen extends Pantalla{

    // == Fields ==
    private Plane plane;
    private VirtualController controller;
    private InputProcessor keyboard, mouse;
    private InputMultiplexer multiplexer;

    // == Constructor ==
    public PlaneScreen(MyGdxGame game) {
        super(game);
    }

    // == Override Methods ==


    @Override
    public void show() {
        plane = new Plane();
        plane.setPosition(100, 100);

        controller = new VirtualController();
        keyboard = new InputPlaneKeyboard(controller);
        mouse = new InputPlaneMouse(controller);

        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(mouse);
        multiplexer.addProcessor(keyboard);

        Gdx.input.setInputProcessor(multiplexer);

//        Esto es por si se usa de manera individual el teclado o el ratón
//        Gdx.input.setInputProcessor(keyboard);
//        Gdx.input.setInputProcessor(mouse);
    }

    @Override
    public void render(float delta) {
        renderGame();
    }

    private void renderGame() {
//        Restart the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        Background color
        Gdx.gl.glClearColor(0.5294f, 0.8078f, 0.9804f, 1);
//        Render game
        game.batch.begin();
        plane.draw(game.batch);
        game.batch.end();

        if (controller.followMouse) {
            float difference = controller.xObjective - plane.getX();
            if (difference > 0) {
                 plane.accelerate();
            } else {
                 plane.reverse();
            }
            controller.followMouse = (Math.abs(difference) > 10f);
        } else if (controller.moveRight) {
            plane.accelerate();
        } else if (controller.moveLeft) {
            plane.reverse();
        } else {
            plane.stop();
        }

        plane.update();
    }
}
