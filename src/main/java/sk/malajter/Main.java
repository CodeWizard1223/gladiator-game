package sk.malajter;

import sk.malajter.service.GameManager;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        final GameManager gameManager = new GameManager();
        gameManager.startGame();


    }
}
