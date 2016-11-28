package app.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by james on 11/27/16.
 */
public class BoardPayload {

    // Character tokens
    @JsonProperty("Ms. Scarlet")
    public String msScarlet;

    @JsonProperty("Col. Mustard")
    public String colMustard;

    @JsonProperty("Mrs. White")
    public String mrsWhite;

    @JsonProperty("Mr. Green")
    public String mrGreen;

    @JsonProperty("Mrs. Peacock")
    public String mrsPeacock;

    @JsonProperty("Prof. Plum")
    public String profPlum;


    // Weapon tokens
    @JsonProperty("Candlestick")
    public String candlestick;

    @JsonProperty("Knife")
    public String knife;

    @JsonProperty("Pipe")
    public String pipe;

    @JsonProperty("Revolver")
    public String revolver;

    @JsonProperty("Rope")
    public String rope;

    @JsonProperty("Wrench")
    public String wrench;


    // Getters
    public String getMsScarlet() {
        return msScarlet;
    }

    public String getColMustard() {
        return colMustard;
    }

    public String getMrsWhite() {
        return mrsWhite;
    }

    public String getMrGreen() {
        return mrGreen;
    }

    public String getMrsPeacock() {
        return mrsPeacock;
    }

    public String getProfPlum() {
        return profPlum;
    }

    public String getCandlestick() {
        return candlestick;
    }

    public String getKnife() {
        return knife;
    }

    public String getPipe() {
        return pipe;
    }

    public String getRevolver() {
        return revolver;
    }

    public String getRope() {
        return rope;
    }

    public String getWrench() {
        return wrench;
    }


    // Setters
    public void setMsScarlet(String msScarlet) {
        this.msScarlet = msScarlet;
    }

    public void setColMustard(String colMustard) {
        this.colMustard = colMustard;
    }

    public void setMrsWhite(String mrsWhite) {
        this.mrsWhite = mrsWhite;
    }

    public void setMrGreen(String mrGreen) {
        this.mrGreen = mrGreen;
    }

    public void setMrsPeacock(String mrsPeacock) {
        this.mrsPeacock = mrsPeacock;
    }

    public void setProfPlum(String profPlum) {
        this.profPlum = profPlum;
    }

    public void setCandlestick(String candlestick) {
        this.candlestick = candlestick;
    }

    public void setKnife(String knife) {
        this.knife = knife;
    }

    public void setPipe(String pipe) {
        this.pipe = pipe;
    }

    public void setRevolver(String revolver) {
        this.revolver = revolver;
    }

    public void setRope(String rope) {
        this.rope = rope;
    }

    public void setWrench(String wrench) {
        this.wrench = wrench;
    }
}
