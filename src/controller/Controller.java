package controller;

import javax.swing.Timer;
import controller.model.Model;
import controller.view.View;

public final class Controller 
{
    private final Model model;
    private final View view;

    public Controller()
    {
        this.model = new Model();
        this.view = new View(event -> {this.onEncryptButtonClicked();}, event -> {this.onDecryptButtonClicked();}, event -> {this.onBruteForceAttackButtonClicked();});
    }

    private final void onEncryptButtonClicked()
    {
        this.view.setOutput("Encrypting in progress...");
        final Timer timer = new Timer(0, event -> {this.view.setOutput(this.model.encrypt(this.view.getInput(), this.view.getKey()));});
        timer.setRepeats(false);
        timer.start();
    }

    private final void onDecryptButtonClicked()
    {
        this.view.setOutput("Decrypting in progress...");
        final Timer timer = new Timer(0, event -> {this.view.setOutput(this.model.decrypt(this.view.getInput(), this.view.getKey()));});
        timer.setRepeats(false);
        timer.start();
    }

    private final void onBruteForceAttackButtonClicked()
    {
        this.view.setOutput("Brute force attack in progress...");
        final Timer timer = new Timer(0, event -> {this.view.setOutput(this.model.bruteForceAttack(this.view.getInput(), this.view.getKeyLength()));});
        timer.setRepeats(false);
        timer.start();
    }
}
