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


public class GameScreen implements Screen{

    private OrthographicCamera camera;
    public int x1 , y1;
    private Viewport viewport;
    private SpriteBatch batch;
    final MyGdxGame game;

    public GameScreen(final MyGdxGame gam) {
        this.game = gam;

        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        viewport = new ExtendViewport(1080,1920 , camera);
        viewport.apply();

        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown (int x , int y , int pointer , int button) {

                Vector3 worldCoordinates = camera.unproject(new Vector3(x,y,0));
                x1 = (int) worldCoordinates.x;
                y1 = (int) worldCoordinates.y;
                game.cod.ClickGame(x1,y1);

                    switch (game.cod.returnGameStan) {
                        case 0:
                            game.setScreen(new LvlScreen(game));
                            break;
                        case 1:
                            game.setScreen(new GameOverScreen(game));
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

        Gdx.gl.glClearColor(1f, 3f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.setProjectionMatrix(camera.combined);

        batch.draw(game.cod.fon , 0 ,0);
        batch.draw(game.cod.kvadrat[0] , game.cod.kvCoordenata_x[0], game.cod.kvCoordenata_y[0]);
        batch.draw(game.cod.kvadrat[1] , game.cod.kvCoordenata_x[1], game.cod.kvCoordenata_y[1]);
        batch.draw(game.cod.kvadrat[2] , game.cod.kvCoordenata_x[2], game.cod.kvCoordenata_y[2]);
        batch.draw(game.cod.kvadrat[3] , game.cod.kvCoordenata_x[3], game.cod.kvCoordenata_y[3]);
        batch.draw(game.cod.kvadrat[4] , game.cod.kvCoordenata_x[4], game.cod.kvCoordenata_y[4]);
        batch.draw(game.cod.kvadrat[5] , game.cod.kvCoordenata_x[5], game.cod.kvCoordenata_y[5]);
        batch.draw(game.cod.kvadrat[6] , game.cod.kvCoordenata_x[6], game.cod.kvCoordenata_y[6]);
        batch.draw(game.cod.kvadrat[7] , game.cod.kvCoordenata_x[7], game.cod.kvCoordenata_y[7]);
        batch.draw(game.cod.kvadrat[8] , game.cod.kvCoordenata_x[8], game.cod.kvCoordenata_y[8]);
        batch.draw(game.cod.kvadrat[9] , game.cod.kvCoordenata_x[9], game.cod.kvCoordenata_y[9]);
        batch.draw(game.cod.kvadrat[10] , game.cod.kvCoordenata_x[10], game.cod.kvCoordenata_y[10]);
        batch.draw(game.cod.kvadrat[11] , game.cod.kvCoordenata_x[11], game.cod.kvCoordenata_y[11]);

        batch.draw(game.cod.pauseTexture, 980,1800);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
    }

    @Override
    public void pause() {
        game.cod.Save();
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
