package com.mygdx.first;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.Random;

public class FirstGame extends ApplicationAdapter {
	private ShapeRenderer ballShape;
	private ShapeRenderer paddleShape;
	private ShapeRenderer blockShape;
	private Ball ball;
	private Paddle paddle;
	private ArrayList<Block> blocks = new ArrayList<>();

	@Override
	public void create () {
		ballShape = new ShapeRenderer();
		paddleShape = new ShapeRenderer();
		blockShape = new ShapeRenderer();

		ball = new Ball(20, 200, 13, 5, -5);
		paddle = new Paddle(100, 10);

		int blockWidth = 62;
		int blockHeight = 20;
		for (int y = Gdx.graphics.getHeight() / 2; y < Gdx.graphics.getHeight(); y += blockHeight + 10) {
			for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
				blocks.add(new Block(x, y, blockWidth, blockHeight));
			}
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		ballShape.begin(ShapeRenderer.ShapeType.Filled);
		ball.update();
		ball.draw(ballShape);
		ballShape.end();


		paddleShape.begin(ShapeRenderer.ShapeType.Filled);
		paddle.update();
		paddle.draw(paddleShape);
		paddleShape.end();
		ball.checkPaddleCollision(paddle);

		blockShape.begin(ShapeRenderer.ShapeType.Filled);
		for (Block block : blocks) {
			block.draw(blockShape);
			ball.checkBlockCollision(block);
		}
		for (int i = 0; i < blocks.size(); i++) {
			Block b = blocks.get(i);
			if (b.isDestroyed()) {
				blocks.remove(b);
				i--;
			}
		}
		blockShape.end();
	}
}

