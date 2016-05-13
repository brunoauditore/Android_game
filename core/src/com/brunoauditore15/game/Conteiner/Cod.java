package com.brunoauditore15.game.Conteiner;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.brunoauditore15.game.MyGdxGame;

import java.util.Random;


public class Cod {

    public Constanta constanta = new Constanta();
    //Files
    private Random ran;
    public boolean StartEnd = false;
    public boolean lvlTrue;
    private boolean ist;
    public int k = 12 , z1 = 0 , lvlD, menuButton_Width , menuButton_Height;
    public int[] mas = new int[k] , kvadratInt = new int[12] , menuButtonCoordenata_x = new int[2],
            menuButtonCoordenata_y = new int [2] , zirkaM = new int[12];
    private int[] masKopy = new int[k];
    public TextureRegion textureNull , fon , fonMenu , pauseTexture,playTexture,zirkaFullTexture,zirkaNullTexture;

    // }

    // для рандома

    public TextureRegion[] fonGame = new TextureRegion[12],mal = new TextureRegion[6],  kvadrat = new TextureRegion[12] , lvlTexture = new TextureRegion[12];
    public Texture texture , fonGameRegion;

    // / Files


    // Cod;
    public MyGdxGame game;
    public int  zminaButton =0;
    public int[] gameKnopka = new int[2];
    public int kolNullButton = 0;
    public int hid;
    public int thisLvl;
    private com.badlogic.gdx.Preferences lvl;
    public int returnMenuButton;
    public int kvCoordenata_x[] = new int[12] ,kvCoordenata_y[] = new int[12] , kvWidth , kvHeight;
    public int returnGameStan = -1;





    // Files
    public void FilesCreate() {;
        constanta.create();
        gameKnopka[1]= -1;
        texture = new Texture(Gdx.files.internal("texture.png"));

        textureNull = new TextureRegion(texture, 0, 0, 300, 300);
        textureNull.flip(false, true);

        // Lvl Texture
            for(int i = 0; i < 12; i++) {
        lvlTexture[i] = new TextureRegion(texture, constanta.lvlTexture_x[i], constanta.lvlTexture_y[i], constanta.lvlTexture_width, constanta.lvlTexture_height);
        lvlTexture[i].flip(false, false);}


                 // Pause , Play , ZirkaFull , ZirkaNull - TextureRegion
                    pauseTexture = new TextureRegion(texture, 2760, 1500, 44, 60);
                    pauseTexture.flip(false, false);

                    playTexture = new TextureRegion(texture, 2804, 1500, 44, 60);
                    playTexture.flip(false, false);

                    zirkaFullTexture = new TextureRegion(texture, 2760, 1560, 58, 58);
                    zirkaFullTexture.flip(false, false);

                    zirkaNullTexture = new TextureRegion(texture, 2818, 1560, 58, 58);
                    zirkaNullTexture.flip(false, false);
                // /pause , Play , ZirkaFull , zirkaNull - TextureRegion


        ran = new Random();


        fon = new TextureRegion(texture , 0,0,1080,1920);
        fon.flip(false,false);

        fonGameRegion = new Texture(Gdx.files.internal("fonGameRegion.png"));
        int j = 0;
        for(int i = 0; i < 12 ;i++) {
            j = 1080 * i;
            fonGame[i] = new TextureRegion(fonGameRegion, j, 0 , 1080 , 1920);
            fonGame[i].flip(false, false);
            if(j == 5) {
                j = 0;
            }
        }

        fonMenu  = new TextureRegion(texture , 1080,0,1080,1920);
        fonMenu.flip(false,false);


        for (int i = 0; i < 6; i++) {
            mal[i] = new TextureRegion(texture, constanta.TextureRegion_x[i], constanta.TextureRegion_y[i], constanta.TextureRegion_width, constanta.TextureRegion_height);
            mal[i].flip(false, true);
        }
    }

    public void Start() {
        Restart();
        Ran();
        switch (thisLvl) {
            case 0: hid = 30;
                break;
            case 1: hid = 28;
                break;
            case 2: hid = 26;
                break;
            case 3: hid = 24;
                break;
            case 4: hid = 22;
                break;
            case 5: hid = 20;
                break;
            case 6: hid = 18;
                break;
            case 7: hid = 16;
                break;
            case 8: hid = 14;
                break;
            case 9: hid = 12;
                break;
            case 10: hid = 11;
                break;
            case 11: hid = 10;
                break;

        }




    }

    public void Ran() {
        for(int i = 0; i < k;i++) {
            mas[i] = ran.nextInt(k);
            ist = true;
            while(ist) {
                ist = false;
                for(int j=0;j<i;j++) {
                    if(mas[i] == masKopy[j]) {
                        mas[i] = ran.nextInt(k);
                        ist = true;
                    }}}
            masKopy[i] = mas[i];
        }
        // }
        // Розбиваю на пари (Масив з 12 цифр - тому , що 12 квадратів , але картинок має бути лише 6 )
        z1 = 0;
        for(int i=0;i< k/2;i++) {
            kvadrat[mas[z1]] = mal[i];
            kvadratInt[mas[z1]] = i;
            System.out.println("mas" +mas[z1]);
            z1++;
            kvadrat[mas[z1]] = mal[i];
            kvadratInt[mas[z1]] = i;
            System.out.println("mas" + mas[z1]);
            z1++;
        }
        StartEnd = true;
    }

    // Cod

    public void Create(){

        // hid = ...  (хочу зробити на різних рівнях різну кількість ходів)

        menuButton_Width = 310;
        menuButton_Height = 139;

        menuButtonCoordenata_x[0] = 24;
        menuButtonCoordenata_y[0] = 194;


        menuButtonCoordenata_x[1] = 24;
        menuButtonCoordenata_y[1] = 386;

        kvWidth = 300;
        kvHeight = 300;

        KvCoordenate();

        lvl = Gdx.app.getPreferences("Lvl");

        if (!lvl.contains("highScore")) {
            lvl.putInteger("highScore", 1);
        }

        if (!lvl.contains("zirka0")) {
            lvl.putInteger("zirka0", 0);
        }

        if (!lvl.contains("zirka1")) {
            lvl.putInteger("zirka1", 0);
        }

        if (!lvl.contains("zirka2")) {
            lvl.putInteger("zirka2", 0);
        }

        if (!lvl.contains("zirka3")) {
            lvl.putInteger("zirka3", 0);
        }

        if (!lvl.contains("zirka4")) {
            lvl.putInteger("zirka4", 0);
        }

        if (!lvl.contains("zirka5")) {
            lvl.putInteger("zirka5", 0);
        }

        if (!lvl.contains("zirka6")) {
            lvl.putInteger("zirka6", 0);
        }

        if(!lvl.contains("zirka7")) {
            lvl.putInteger("zirka7", 0);
        }

        if (!lvl.contains("zirka8")) {
            lvl.putInteger("zirka8", 0);
        }

        if (!lvl.contains("zirka9")) {
            lvl.putInteger("zirka9", 0);
        }
        if (!lvl.contains("zirka10")) {
            lvl.putInteger("zirka10", 0);
        }
        if (!lvl.contains("zirka11")) {
            lvl.putInteger("zirka11", 0);
        }

        lvlD =  lvl.getInteger("highScore");

        zirkaM[0] =  lvl.getInteger("zirka0");
        zirkaM[1] =  lvl.getInteger("zirka1");
        zirkaM[2] =  lvl.getInteger("zirka2");
        zirkaM[3] =  lvl.getInteger("zirka3");
        zirkaM[4] =  lvl.getInteger("zirka4");
        zirkaM[5] =  lvl.getInteger("zirka5");
        zirkaM[6] =  lvl.getInteger("zirka6");
        zirkaM[7] =  lvl.getInteger("zirka7");
        zirkaM[8] =  lvl.getInteger("zirka8");
        zirkaM[9] =  lvl.getInteger("zirka9");
        zirkaM[10] =  lvl.getInteger("zirka10");
        zirkaM[11] =  lvl.getInteger("zirka11");


    }

    public void KvCoordenate() {
        kvCoordenata_x[0] = (50 - 25)* 5 /2 ;
        kvCoordenata_y[0] =  10*5/2;

        kvCoordenata_x[1] = (180-25)*5/2;
        kvCoordenata_y[1] =  10*5/2;

        kvCoordenata_x[2] = (310-25)*5/2;
        kvCoordenata_y[2] =  10*5/2;

        kvCoordenata_x[3] = (50-25)*5/2;
        kvCoordenata_y[3] =  140*5/2;

        kvCoordenata_x[4] = (180-25)*5/2;
        kvCoordenata_y[4] =  140*5/2;

        kvCoordenata_x[5] = (310-25)*5/2;
        kvCoordenata_y[5] =  140*5/2;

        kvCoordenata_x[6] = (50-25)*5/2;
        kvCoordenata_y[6] =  270*5/2;

        kvCoordenata_x[7] = (180-25)*5/2;
        kvCoordenata_y[7] =  270*5/2;

        kvCoordenata_x[8] = (310-25)*5/2;
        kvCoordenata_y[8] =  270*5/2;

        kvCoordenata_x[9] = (50-25)*5/2;
        kvCoordenata_y[9] =  400*5/2;

        kvCoordenata_x[10] = (180-25)*5/2;
        kvCoordenata_y[10] =  400*5/2;

        kvCoordenata_x[11] = (310-25)*5/2;
        kvCoordenata_y[11] =  400*5/2;
    }

    public void ClickGame(int x,int y) {
        for(int i=0;i<12;i++) {
            if(x > kvCoordenata_x[i] && x < (kvCoordenata_x[i] + kvWidth )) {
                if(y > kvCoordenata_y[i] && y < (kvCoordenata_y[i] + kvHeight)) {

                    gameKnopka[zminaButton] = i;
                    if(gameKnopka[0] != gameKnopka[1]) {
                        if(zminaButton == 0) { zminaButton = 1;}
                        else {
                            zminaButton = 0;
                            hid--;
                            GameLogic();
                        }}}
            }}
    }
    public void ClickMenu(int x,int y) {
        // MenuScreen
        for(int i=0;i < 2;i++) {
            if(x > menuButtonCoordenata_x[i] && ( x < (menuButtonCoordenata_x[i] + menuButton_Width ))) {
                if (y > menuButtonCoordenata_y[i] && (y < (menuButtonCoordenata_y[i] + menuButton_Height))) {
                    returnMenuButton = i;
                }
            }}}
    public void ClickLvl(int x,int y) {
        lvlTrue = false;
        for (int i = 0; i < 12l; i++) {
            if ((x > constanta.lvlCoordenata_x[i]) && x < (constanta.lvlCoordenata_x[i] + 300)) {
                if (y > constanta.lvlCoordenata_y[i] && y < (constanta.lvlCoordenata_y[i] + 300)) {
                    thisLvl = i;
                }
            }
        }
        // провірка чи рівень який ми вибрали - відкритий
        if (thisLvl <= lvlD) {
            lvlTrue = true;
        }

    }

    public void Restart() {
        hid = 0;
        kolNullButton = 0;
        KvCoordenate();
        returnGameStan = -1;

    }

    public void GameLogic() {
        if (kvadratInt[gameKnopka[0]] == kvadratInt[gameKnopka[1]]) {
            // тіп tru )
            // шото робим ,
            //1 - видаляєм текстуру квадрата (а точніше міняєм її на текстуру ідентичного кольору з фоном)
            kvadrat[gameKnopka[0]] = textureNull;
            kvadrat[gameKnopka[1]] = textureNull;
            kvCoordenata_x[gameKnopka[0]] = -300;
            kvCoordenata_y[gameKnopka[0]] = -300;
            kvCoordenata_x[gameKnopka[1]] = -300;
            kvCoordenata_y[gameKnopka[1]] = -300;
            kolNullButton++;

        } else {
            // тіп false
            // тоже шото робим
            // тут можна зробити провірку чи нажимались пауза , звук оф/он
        }
                // якщо kolNullButton = 11 (тобто всі кнопки відкрили) то мипройшли рівень , (11 - тому , що від 0 ряхуєм)
                if (kolNullButton > 5) {
                    if(thisLvl == lvlD) {
                    lvlD++;}
                    switch (thisLvl) {
                        case 0:
                            if(hid == 0) { zirkaM[thisLvl] = 1;}
                            if(hid > 0 && hid <= 11 ) { zirkaM[thisLvl] = 2;}
                            if(hid > 11) { zirkaM[thisLvl] = 3;}
                            break;
                        case 1:
                            if(hid == 0) { zirkaM[thisLvl] = 1;}
                            if(hid > 0 && hid <= 10 ) { zirkaM[thisLvl] = 2;}
                            if(hid > 10) { zirkaM[thisLvl] = 3;}
                            break;
                        case 2:
                            if(hid == 0) { zirkaM[thisLvl] = 1;}
                            if(hid > 0 && hid <= 9 ) { zirkaM[thisLvl] = 2;}
                            if(hid > 9) { zirkaM[thisLvl] = 3;}
                            break;
                        case 3:
                            if(hid == 0) { zirkaM[thisLvl] = 1;}
                            if(hid > 0 && hid <= 8 ) { zirkaM[thisLvl] = 2;}
                            if(hid > 8) { zirkaM[thisLvl] = 3;}
                            break;
                        case 4:
                            if(hid == 0) { zirkaM[thisLvl] = 1;}
                            if(hid > 0 && hid <= 7 ) { zirkaM[thisLvl] = 2;}
                            if(hid > 7) { zirkaM[thisLvl] = 3;}
                            break;
                        case 5:
                            if(hid == 0) { zirkaM[thisLvl] = 1;}
                            if(hid > 0 && hid <= 6 ) { zirkaM[thisLvl] = 2;}
                            if(hid > 6) { zirkaM[thisLvl] = 3;}
                            break;
                        case 6:
                            if(hid == 0) { zirkaM[thisLvl] = 1;}
                            if(hid > 0 && hid <= 5 ) { zirkaM[thisLvl] = 2;}
                            if(hid > 5) { zirkaM[thisLvl] = 3;}
                            break;
                        case 7:
                            if(hid == 0) { zirkaM[thisLvl] = 1;}
                            if(hid > 0 && hid <= 4 ) { zirkaM[thisLvl] = 2;}
                            if(hid > 4) { zirkaM[thisLvl] = 3;}
                            break;
                        case 8:
                            if(hid == 0) { zirkaM[thisLvl] = 1;}
                            if(hid > 0 && hid <= 3 ) { zirkaM[thisLvl] = 2;}
                            if(hid > 3) { zirkaM[thisLvl] = 3;}
                            break;
                        case 9:
                            if(hid == 0) { zirkaM[thisLvl] = 1;}
                            if(hid > 0 && hid <= 2 ) { zirkaM[thisLvl] = 2;}
                            if(hid > 2) { zirkaM[thisLvl] = 3;}
                            break;
                        case 10:
                            if(hid == 0) { zirkaM[thisLvl] = 1;}
                            if(hid > 0 && hid <= 2 ) { zirkaM[thisLvl] = 2;}
                            if(hid > 2) { zirkaM[thisLvl] = 3;}
                            break;
                        case 11:
                            if(hid == 0) { zirkaM[thisLvl] = 1;}
                            if(hid > 0 && hid <= 2 ) { zirkaM[thisLvl] = 2;}
                            if(hid > 2) { zirkaM[thisLvl] = 3;}
                            break;
                    }
                    Save();
                    returnGameStan = 0;
                }  else {
                if (hid < 0) {
                    returnGameStan = 1;
                }}
    }

    public void Save(){


        if(lvlD > lvl.getInteger("highScore")) {
        lvl.putInteger("highScore", lvlD);
        lvl.flush();

        }

        if(zirkaM[thisLvl] > lvl.getInteger("zirka"+thisLvl)) {
        lvl.putInteger("zirka"+thisLvl, zirkaM[thisLvl]);
        lvl.flush();}

    }

    public void DeleteP() {

            lvl.putInteger("highScore", 1);
            lvl.flush();

                for(int i = 0;i < 12;i++) {
            lvl.putInteger("zirka"+i, 0);
            lvl.flush();}}


}
