package entities;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;

public class Song {
    private String spotifyId;
    private String name;
    private MyList<String> artists;
    private int dailyRank;
    private int dailyMovement;
    private int weeklyMovement;
    private String country;
    private String snapshotDate;
    private int popularity;
    private boolean isExplicit;
    private String durationMs;
    private String albumName;
    private String albumReleaseDate;
    private String danceability;
    private String energy;
    private int key;
    private String loudness;
    private int mode;
    private String speechiness;
    private String acousticness;
    private String instrumentalness;
    private String liveness;
    private String valence;
    private double tempo;
    private int timeSignature;

    public Song(String spotifyId, String name, MyList<String> artists, int dailyRank, int dailyMovement, int weeklyMovement, String country, String snapshotDate, int popularity, boolean isExplicit, String durationMs, String albumName, String albumReleaseDate, String danceability, String energy, int key, String loudness, int mode, String speechiness, String acousticness, String instrumentalness, String liveness, String valence, double tempo, int timeSignature) {
        this.spotifyId = spotifyId;
        this.name = name;
        this.artists = artists;
        this.dailyRank = dailyRank;
        this.dailyMovement = dailyMovement;
        this.weeklyMovement = weeklyMovement;
        this.country = country;
        this.snapshotDate = snapshotDate;
        this.popularity = popularity;
        this.isExplicit = isExplicit;
        this.durationMs = durationMs;
        this.albumName = albumName;
        this.albumReleaseDate = albumReleaseDate;
        this.danceability = danceability;
        this.energy = energy;
        this.key = key;
        this.loudness = loudness;
        this.mode = mode;
        this.speechiness = speechiness;
        this.acousticness = acousticness;
        this.instrumentalness = instrumentalness;
        this.liveness = liveness;
        this.valence = valence;
        this.tempo = tempo;
        this.timeSignature = timeSignature;
    }

    public String getSpotify_id() {
        return spotifyId;
    }

    public String getName() {
        return name;
    }

    public MyList<String> getArtists() {
        return artists;
    }

    public int getDaily_rank() {
        return dailyRank;
    }

    public String getCountry() {
        return country;
    }

    public double getTempo() {
        return tempo;
    }
}
