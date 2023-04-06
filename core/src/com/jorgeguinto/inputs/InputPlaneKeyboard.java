package com.jorgeguinto.inputs;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input;
import com.jorgeguinto.VirtualController;

public class InputPlaneKeyboard extends InputAdapter {

    // == Fields ==
    private VirtualController controller;

    // == Constructor ==
    public InputPlaneKeyboard(VirtualController controller) {
        this.controller = controller;
    }

    // == Override Methods ==
    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
            case Input.Keys.A:
                if (!controller.moveRight){
                    controller.moveLeft = true;
                }
                return true;
            case Input.Keys.RIGHT:
            case Input.Keys.D:
                if (!controller.moveLeft) {
                    controller.moveRight = true;
                }
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
            case Input.Keys.A:
                controller.moveLeft = false;
                return true;
            case Input.Keys.RIGHT:
            case Input.Keys.D:
                controller.moveRight = false;
                return true;
            default:
                return false;
        }
    }
}
