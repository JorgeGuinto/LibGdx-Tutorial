package com.jorgeguinto.inputs;

import com.badlogic.gdx.InputAdapter;
import com.jorgeguinto.VirtualController;

public class InputPlaneMouse extends InputAdapter {

    // == Fields ==
    private VirtualController controller;

    // == Constructor ==
    public InputPlaneMouse(VirtualController controller) {
        this.controller = controller;
    }

    // == Override Methods ==


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        controller.followMouse = true;
        controller.xObjective = screenX;
        return true;
    }
}
