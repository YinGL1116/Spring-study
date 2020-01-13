package com.envision.spring;

public class CDPlayer {

    public CDPlayer(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    private CompactDisc compactDisc;

    public void music() {
        compactDisc.play();
    }
}
