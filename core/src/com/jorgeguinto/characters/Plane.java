package com.jorgeguinto.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Plane extends Sprite {

    // == Fields ==
    public float speed = 0; // Velocidad
    public float velocity = 0; // aceleración

    public Plane() {
        super(new Texture("plane.png"));
    }

    public void update() {
        float position = getX();
        float time = Gdx.graphics.getDeltaTime();

        speed += velocity * time;
        position += speed * time + 0.5 * velocity * (time * time);
        setX(position);
    }

    public void accelerate() {
        if (velocity <= 240f) {
            velocity += 60f;
        }
    }

    public void reverse() {
        if (velocity >= -240f) {
            velocity -= 40f;
        }
    }

    public void stop() {
        velocity = 0;
        if (Math.abs(speed) > 0.5f){
            speed *= 0.95f;
        } else {
            speed = 0;
        }
    }
}