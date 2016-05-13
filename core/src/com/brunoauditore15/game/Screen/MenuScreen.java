package com.brunoauditore15.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.brunoauditore15.game.MyGdxGame;

public class MenuScreen implements Screen {

    final MyGdxGame game;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Viewport viewport;
    public int x1 , y1;
    public MenuScreen(final MyGdxGame gam) {
        this.game = gam;
        System.out.println("MneuScreen");

        camera = new OrthographicCamera();
        viewport = new ExtendViewport(1080, 1920, camera);
        viewport.apply();

        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);

        batch = new SpriteBatch();

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown (int x , int y , int pointer , int button) {

                Vector3 worldCoordinates = camera.unproject(new Vector3(x,y,0));
                x1 = (int) worldCoordinates.x;
                y1 = (int) worldCoordinates.y;
                game.cod.ClickMenu(x1,y1);

                switch (game.cod.returnMenuButton) {
                    case 0:
                        game.setScreen(new LvlScreen(game));
                        break;
                    case 1:
                        dispose();
                        // exit;
                        break;

                }
                return true;
            } });}

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        camera.update();
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.setProjectionMatrix(camera.combined);
        batch.draw(game.cod.fonMenu , 0,0);
        batch.end();


    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
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
