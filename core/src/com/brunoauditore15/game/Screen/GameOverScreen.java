package com.brunoauditore15.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.brunoauditore15.game.MyGdxGame;

/**
 * Created by bruno on 02.05.16.
 */
public class GameOverScreen implements Screen {

    final MyGdxGame game;
    public GameOverScreen(final MyGdxGame gam) {
        this.game = gam;
        System.out.println("GameOver");

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // виводим пов. шо ми програли


    }

    @Override
    public void resize(int width, int height) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
