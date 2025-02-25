package GameReader;


public class Pokemon {
    private String pokemon;
    private String nickname;
    private int kills;
    private Pokemon statusedBy;
    private Pokemon bindedBy;
    private Pokemon cursedBy;
    private Pokemon seededBy;
    private Pokemon nightmaredBy;
    private Pokemon confusedBy;
    private Pokemon lastDmgBy;
    private Pokemon perishedBy;
    private Pokemon saltCuredBy;
    private boolean dead = false;


    public Pokemon (String poke) {
        pokemon = poke;
    }


    public String DeadToString() {
        return dead ? "d" : "a";
    }

    @Override
    public String toString() {
        return pokemon + "{" +
                nickname +
                "}, " + DeadToString();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Pokemon getSeededBy() {
        return seededBy;
    }

    public void setSeededBy(Pokemon seededBy) {
        this.seededBy = seededBy;
    }

    public Pokemon getNightmaredBy() {
        return nightmaredBy;
    }

    public void setNightmaredBy(Pokemon nightmaredBy) {
        this.nightmaredBy = nightmaredBy;
    }

    public Pokemon getConfusedBy() {
        return confusedBy;
    }

    public void setConfusedBy(Pokemon confusedBy) {
        this.confusedBy = confusedBy;
    }

    public Pokemon getCursedBy() {
        return cursedBy;
    }

    public void setCursedBy(Pokemon cursedBy) {
        this.cursedBy = cursedBy;
    }

    public Pokemon getBindedBy() {
        return bindedBy;
    }

    public void setBindedBy(Pokemon bindedBy) {
        this.bindedBy = bindedBy;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public String getPokemon() {
        return pokemon;
    }

    public void setPokemon(String pokemon) {
        this.pokemon = pokemon;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public Pokemon getStatusedBy() {
        return statusedBy;
    }

    public void setStatusedBy(Pokemon statusedBy) {
        this.statusedBy = statusedBy;
    }

    public Pokemon getLastDmgBy() {
        return lastDmgBy;
    }

    public void setLastDmgBy(Pokemon lastDmgBy) {
        this.lastDmgBy = lastDmgBy;
    }

    public void killsPlus1() {
        this.kills++;
    }

    public Pokemon getPerishedBy() {
        return perishedBy;
    }

    public void setPerishedBy(Pokemon perishedBy) {
        this.perishedBy = perishedBy;
    }

    public Pokemon getSaltCuredBy() {
        return saltCuredBy;
    }

    public void setSaltCuredBy(Pokemon saltCuredBy) {
        this.saltCuredBy = saltCuredBy;
    }


}
