/*

Classe non fonctionnelle, à revoir

package com.example.echecsae.game;
public class Chrono {

    private int sec;
    private int min;
    private boolean estBlanc;

    public Chrono(){

    }

    public Chrono(int min, int sec, boolean estBlanc){

        this.sec = sec;
        this.min = min;
        this.estBlanc = estBlanc;

    }

    @Override
    public void run(){
        while (s>=0 && m >=0){
            try {
                this.sleep(1000);
                if(this.estBlanc){
                    fen.updateChronoB(min, sec);
                }
                else{
                    fen.updateChronoN(min, sec);
                }
                if(sec <= 0){
                    min--;
                    sec = 60;
                }
                sec--;
            }}

        public int getSeconde(){
            return sec;
        }

        public int getMinute(){
            return min;
        }

        public void setSeconde(int secondes){
            this.s = secondes;
        }

        public void setMinute(int minutes){
            this.m = minutes;
        }
    }
}
*/