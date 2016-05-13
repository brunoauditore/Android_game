package com.brunoauditore15.game;

import com.badlogic.gdx.Game;
import com.brunoauditore15.game.Conteiner.Cod;
import com.brunoauditore15.game.Screen.LvlScreen;
import com.brunoauditore15.game.Screen.MenuScreen;


public class MyGdxGame extends Game {


	public Cod cod;


	@Override
	public void create () {

		System.out.println("MyGdxGame");
		cod = new Cod();
		cod.FilesCreate();
		cod.Create();

		this.setScreen(new MenuScreen(this));
	}


	@Override
	public void render () {
		super.render();
	}
}
