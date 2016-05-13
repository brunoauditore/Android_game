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

/**
 * Created by bruno on 02.05.16.
 */
public class LvlScreen implements Screen{

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Viewport viewport;
    public int x1,y1;

    final MyGdxGame game;
    public LvlScreen(final MyGdxGame gam) {
        this.game = gam;

        game.cod.Start();
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
                game.cod.ClickLvl(x1,y1);
                if(game.cod.lvlTrue) {
                    game.cod.lvlTrue = false;
                    game.cod.Start();
                    game.setScreen(new GameScreen(game));}

                return true;
            } });
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        camera.update();
        Gdx.gl.glClearColor(0f, 0f, 0f, 7f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


         batch.begin();
        batch.setProjectionMatrix(camera.combined);
        batch.setColor(1,1,1,1f);
        batch.draw(game.cod.fon , 0,0);
        batch.draw(game.cod.pauseTexture, 980,1800);


        batch.draw(game.cod.lvlTexture[0] , 20 , 20);
        switch(game.cod.zirkaM[0]) {
            case 0:
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[0]+30 , game.cod.constanta.lvlCoordenata_y[0]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[0]+120, game.cod.constanta.lvlCoordenata_y[0]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[0]+210 , game.cod.constanta.lvlCoordenata_y[0]-60);
                break;
            case 1:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[0]+30 , game.cod.constanta.lvlCoordenata_y[0]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[0]+120, game.cod.constanta.lvlCoordenata_y[0]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[0]+210 , game.cod.constanta.lvlCoordenata_y[0]-60);
            break;
            case 2:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[0]+30 , game.cod.constanta.lvlCoordenata_y[0]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[0]+120, game.cod.constanta.lvlCoordenata_y[0]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[0]+210 , game.cod.constanta.lvlCoordenata_y[0]-60);
            break;
            case 3:
            batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[0]+30 , game.cod.constanta.lvlCoordenata_y[0]-60);
            batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[0]+120, game.cod.constanta.lvlCoordenata_y[0]-60);
            batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[0]+210 , game.cod.constanta.lvlCoordenata_y[0]-60);
        }
                        if(game.cod.lvlD == 1){ batch.setColor(1,0,1,.1f);}
                batch.draw(game.cod.lvlTexture[1] , game.cod.constanta.lvlCoordenata_x[1] , game.cod.constanta.lvlCoordenata_y[1]);
        switch(game.cod.zirkaM[1]) {
            case 0:
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[1]+30 , game.cod.constanta.lvlCoordenata_y[1]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[1]+120, game.cod.constanta.lvlCoordenata_y[1]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[1]+210 , game.cod.constanta.lvlCoordenata_y[1]-60);
                break;
            case 1:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[1]+30 , game.cod.constanta.lvlCoordenata_y[1]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[1]+120, game.cod.constanta.lvlCoordenata_y[1]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[1]+210 , game.cod.constanta.lvlCoordenata_y[1]-60);
                break;
            case 2:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[1]+30 , game.cod.constanta.lvlCoordenata_y[1]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[1]+120, game.cod.constanta.lvlCoordenata_y[1]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[1]+210 , game.cod.constanta.lvlCoordenata_y[1]-60);
                break;
            case 3:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[1]+30 , game.cod.constanta.lvlCoordenata_y[1]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[1]+120, game.cod.constanta.lvlCoordenata_y[1]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[1]+210 , game.cod.constanta.lvlCoordenata_y[1]-60);
        }
                        if(game.cod.lvlD == 2){ batch.setColor(1,0,1,.1f);}
                batch.draw(game.cod.lvlTexture[2] , game.cod.constanta.lvlCoordenata_x[2] , game.cod.constanta.lvlCoordenata_y[2]);
        switch(game.cod.zirkaM[2]) {
            case 0:
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[2]+30 , game.cod.constanta.lvlCoordenata_y[2]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[2]+120, game.cod.constanta.lvlCoordenata_y[2]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[2]+210 , game.cod.constanta.lvlCoordenata_y[2]-60);
                break;
            case 1:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[2]+30 , game.cod.constanta.lvlCoordenata_y[2]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[2]+120, game.cod.constanta.lvlCoordenata_y[2]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[2]+210 , game.cod.constanta.lvlCoordenata_y[2]-60);
                break;
            case 2:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[2]+30 , game.cod.constanta.lvlCoordenata_y[2]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[2]+120, game.cod.constanta.lvlCoordenata_y[2]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[2]+210 , game.cod.constanta.lvlCoordenata_y[2]-60);
                break;
            case 3:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[2]+30 , game.cod.constanta.lvlCoordenata_y[2]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[2]+120, game.cod.constanta.lvlCoordenata_y[2]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[2]+210 , game.cod.constanta.lvlCoordenata_y[2]-60);
        }
                        if(game.cod.lvlD == 3){ batch.setColor(1,0,1,.1f);}
                batch.draw(game.cod.lvlTexture[3] , game.cod.constanta.lvlCoordenata_x[3] , game.cod.constanta.lvlCoordenata_y[3]);
        switch(game.cod.zirkaM[3]) {
            case 0:
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[3]+30 , game.cod.constanta.lvlCoordenata_y[3]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[3]+120, game.cod.constanta.lvlCoordenata_y[3]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[3]+210 , game.cod.constanta.lvlCoordenata_y[3]-60);
                break;
            case 1:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[3]+30 , game.cod.constanta.lvlCoordenata_y[3]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[3]+120, game.cod.constanta.lvlCoordenata_y[3]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[3]+210 , game.cod.constanta.lvlCoordenata_y[3]-60);
                break;
            case 2:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[3]+30 , game.cod.constanta.lvlCoordenata_y[3]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[3]+120, game.cod.constanta.lvlCoordenata_y[3]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[3]+210 , game.cod.constanta.lvlCoordenata_y[3]-60);
                break;
            case 3:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[3]+30 , game.cod.constanta.lvlCoordenata_y[3]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[3]+120, game.cod.constanta.lvlCoordenata_y[3]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[3]+210 , game.cod.constanta.lvlCoordenata_y[3]-60);
        }
                        if(game.cod.lvlD == 4){ batch.setColor(1,0,1,.1f);}
                batch.draw(game.cod.lvlTexture[4] , game.cod.constanta.lvlCoordenata_x[4] , game.cod.constanta.lvlCoordenata_y[4]);
        switch(game.cod.zirkaM[4]) {
            case 0:
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[4]+30 , game.cod.constanta.lvlCoordenata_y[4]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[4]+120, game.cod.constanta.lvlCoordenata_y[4]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[4]+210 , game.cod.constanta.lvlCoordenata_y[4]-60);
                break;
            case 1:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[4]+30 , game.cod.constanta.lvlCoordenata_y[4]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[4]+120, game.cod.constanta.lvlCoordenata_y[4]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[4]+210 , game.cod.constanta.lvlCoordenata_y[4]-60);
                break;
            case 2:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[4]+30 , game.cod.constanta.lvlCoordenata_y[4]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[4]+120, game.cod.constanta.lvlCoordenata_y[4]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[4]+210 , game.cod.constanta.lvlCoordenata_y[4]-60);
                break;
            case 3:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[4]+30 , game.cod.constanta.lvlCoordenata_y[4]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[4]+120, game.cod.constanta.lvlCoordenata_y[4]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[4]+210 , game.cod.constanta.lvlCoordenata_y[4]-60);
        }
                        if(game.cod.lvlD == 5){ batch.setColor(1,0,1,.1f);}
                batch.draw(game.cod.lvlTexture[5] , game.cod.constanta.lvlCoordenata_x[5] , game.cod.constanta.lvlCoordenata_y[5]);
        switch(game.cod.zirkaM[5]) {
            case 0:
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[5]+30 , game.cod.constanta.lvlCoordenata_y[5]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[5]+120, game.cod.constanta.lvlCoordenata_y[5]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[5]+210 , game.cod.constanta.lvlCoordenata_y[5]-60);
                break;
            case 1:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[5]+30 , game.cod.constanta.lvlCoordenata_y[5]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[5]+120, game.cod.constanta.lvlCoordenata_y[5]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[5]+210 , game.cod.constanta.lvlCoordenata_y[5]-60);
                break;
            case 2:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[5]+30 , game.cod.constanta.lvlCoordenata_y[5]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[5]+120, game.cod.constanta.lvlCoordenata_y[5]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[5]+210 , game.cod.constanta.lvlCoordenata_y[5]-60);
                break;
            case 3:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[5]+30 , game.cod.constanta.lvlCoordenata_y[5]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[5]+120, game.cod.constanta.lvlCoordenata_y[5]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[5]+210 , game.cod.constanta.lvlCoordenata_y[5]-60);
        }
                        if(game.cod.lvlD == 6){ batch.setColor(1,0,1,.1f);}
                batch.draw(game.cod.lvlTexture[6] , game.cod.constanta.lvlCoordenata_x[6] , game.cod.constanta.lvlCoordenata_y[6]);
        switch(game.cod.zirkaM[6]) {
            case 0:
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[6]+30 , game.cod.constanta.lvlCoordenata_y[6]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[6]+120, game.cod.constanta.lvlCoordenata_y[6]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[6]+210 , game.cod.constanta.lvlCoordenata_y[6]-60);
                break;
            case 1:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[6]+30 , game.cod.constanta.lvlCoordenata_y[6]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[6]+120, game.cod.constanta.lvlCoordenata_y[6]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[6]+210 , game.cod.constanta.lvlCoordenata_y[6]-60);
                break;
            case 2:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[6]+30 , game.cod.constanta.lvlCoordenata_y[6]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[6]+120, game.cod.constanta.lvlCoordenata_y[6]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[6]+210 , game.cod.constanta.lvlCoordenata_y[6]-60);
                break;
            case 3:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[6]+30 , game.cod.constanta.lvlCoordenata_y[6]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[6]+120, game.cod.constanta.lvlCoordenata_y[6]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[6]+210 , game.cod.constanta.lvlCoordenata_y[6]-60);
        }
                        if(game.cod.lvlD == 7){ batch.setColor(1,0,1,.1f);}
                batch.draw(game.cod.lvlTexture[7] , game.cod.constanta.lvlCoordenata_x[7] , game.cod.constanta.lvlCoordenata_y[7]);
        switch(game.cod.zirkaM[7]) {
            case 0:
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[7]+30 , game.cod.constanta.lvlCoordenata_y[7]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[7]+120, game.cod.constanta.lvlCoordenata_y[7]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[7]+210 , game.cod.constanta.lvlCoordenata_y[7]-60);
                break;
            case 1:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[7]+30 , game.cod.constanta.lvlCoordenata_y[7]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[7]+120, game.cod.constanta.lvlCoordenata_y[7]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[7]+210 , game.cod.constanta.lvlCoordenata_y[7]-60);
                break;
            case 2:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[7]+30 , game.cod.constanta.lvlCoordenata_y[7]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[7]+120, game.cod.constanta.lvlCoordenata_y[7]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[7]+210 , game.cod.constanta.lvlCoordenata_y[7]-60);
                break;
            case 3:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[7]+30 , game.cod.constanta.lvlCoordenata_y[7]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[7]+120, game.cod.constanta.lvlCoordenata_y[7]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[7]+210 , game.cod.constanta.lvlCoordenata_y[7]-60);
        }
                        if(game.cod.lvlD == 8){ batch.setColor(1,0,1,.1f);}
                batch.draw(game.cod.lvlTexture[8] , game.cod.constanta.lvlCoordenata_x[8] , game.cod.constanta.lvlCoordenata_y[8]);
        switch(game.cod.zirkaM[8]) {
            case 0:
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[8]+30 , game.cod.constanta.lvlCoordenata_y[8]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[8]+120, game.cod.constanta.lvlCoordenata_y[8]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[8]+210 , game.cod.constanta.lvlCoordenata_y[8]-60);
                break;
            case 1:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[8]+30 , game.cod.constanta.lvlCoordenata_y[8]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[8]+120, game.cod.constanta.lvlCoordenata_y[8]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[8]+210 , game.cod.constanta.lvlCoordenata_y[8]-60);
                break;
            case 2:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[8]+30 , game.cod.constanta.lvlCoordenata_y[8]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[8]+120, game.cod.constanta.lvlCoordenata_y[8]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[8]+210 , game.cod.constanta.lvlCoordenata_y[8]-60);
                break;
            case 3:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[8]+30 , game.cod.constanta.lvlCoordenata_y[8]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[8]+120, game.cod.constanta.lvlCoordenata_y[8]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[8]+210 , game.cod.constanta.lvlCoordenata_y[8]-60);
        }
                        if(game.cod.lvlD == 9){ batch.setColor(1,0,1,.1f);}
                batch.draw(game.cod.lvlTexture[9] , game.cod.constanta.lvlCoordenata_x[9] , game.cod.constanta.lvlCoordenata_y[9]);
        switch(game.cod.zirkaM[9]) {
            case 0:
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[9]+30 , game.cod.constanta.lvlCoordenata_y[9]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[9]+120, game.cod.constanta.lvlCoordenata_y[9]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[9]+210 , game.cod.constanta.lvlCoordenata_y[9]-60);
                break;
            case 1:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[9]+30 , game.cod.constanta.lvlCoordenata_y[9]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[9]+120, game.cod.constanta.lvlCoordenata_y[9]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[9]+210 , game.cod.constanta.lvlCoordenata_y[9]-60);
                break;
            case 2:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[9]+30 , game.cod.constanta.lvlCoordenata_y[9]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[9]+120, game.cod.constanta.lvlCoordenata_y[9]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[9]+210 , game.cod.constanta.lvlCoordenata_y[9]-60);
                break;
            case 3:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[9]+30 , game.cod.constanta.lvlCoordenata_y[9]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[9]+120, game.cod.constanta.lvlCoordenata_y[9]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[9]+210 , game.cod.constanta.lvlCoordenata_y[9]-60);
        }
                        if(game.cod.lvlD == 10){ batch.setColor(1,0,1,.1f);}
                batch.draw(game.cod.lvlTexture[10] , game.cod.constanta.lvlCoordenata_x[10] , game.cod.constanta.lvlCoordenata_y[10]);
        switch(game.cod.zirkaM[10]) {
            case 0:
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[10]+30 , game.cod.constanta.lvlCoordenata_y[10]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[10]+120, game.cod.constanta.lvlCoordenata_y[10]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[10]+210 , game.cod.constanta.lvlCoordenata_y[10]-60);
                break;
            case 1:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[10]+30 , game.cod.constanta.lvlCoordenata_y[10]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[10]+120, game.cod.constanta.lvlCoordenata_y[10]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[10]+210 , game.cod.constanta.lvlCoordenata_y[10]-60);
                break;
            case 2:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[10]+30 , game.cod.constanta.lvlCoordenata_y[10]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[10]+120, game.cod.constanta.lvlCoordenata_y[10]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[10]+210 , game.cod.constanta.lvlCoordenata_y[10]-60);
                break;
            case 3:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[10]+30 , game.cod.constanta.lvlCoordenata_y[10]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[10]+120, game.cod.constanta.lvlCoordenata_y[10]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[10]+210 , game.cod.constanta.lvlCoordenata_y[10]-60);
        }
                        if(game.cod.lvlD == 11){ batch.setColor(1,0,1,.1f);}
                batch.draw(game.cod.lvlTexture[11] , game.cod.constanta.lvlCoordenata_x[11] , game.cod.constanta.lvlCoordenata_y[11]);
        switch(game.cod.zirkaM[11]) {
            case 0:
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[11]+30 , game.cod.constanta.lvlCoordenata_y[11]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[11]+120, game.cod.constanta.lvlCoordenata_y[11]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[11]+210 , game.cod.constanta.lvlCoordenata_y[11]-60);
                break;
            case 1:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[11]+30 , game.cod.constanta.lvlCoordenata_y[11]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[11]+120, game.cod.constanta.lvlCoordenata_y[11]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[11]+210 , game.cod.constanta.lvlCoordenata_y[11]-60);
                break;
            case 2:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[11]+30 , game.cod.constanta.lvlCoordenata_y[11]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[11]+120, game.cod.constanta.lvlCoordenata_y[11]-60);
                batch.draw(game.cod.zirkaNullTexture , game.cod.constanta.lvlCoordenata_x[11]+210 , game.cod.constanta.lvlCoordenata_y[11]-60);
                break;
            case 3:
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[11]+30 , game.cod.constanta.lvlCoordenata_y[11]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[11]+120, game.cod.constanta.lvlCoordenata_y[11]-60);
                batch.draw(game.cod.zirkaFullTexture , game.cod.constanta.lvlCoordenata_x[11]+210 , game.cod.constanta.lvlCoordenata_y[11]-60);
        }



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
