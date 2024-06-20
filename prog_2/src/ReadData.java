import entities.Song;
import uy.edu.um.prog2.adt.hash.MyHash;
import uy.edu.um.prog2.adt.hash.MyHashImpl;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadData {
    public static MyList<Object> importData(String filePath){
        MyList<String> fechasUnicas = new MyLinkedListImpl<>();
        MyHash<String, MyList<Song>> canciones = new MyHashImpl<>(30);
        MyList<String> paisesUnicos = new MyLinkedListImpl<>();
        int i=0;
        MyList<Object> records = new MyLinkedListImpl<>();
        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null && i < 748805) {
                String[] values = line.split("\",\"");
                List<String> row = new ArrayList<>();
                for (String value : values) {
                    row.add(value);
                }
                
                String spotifyId = row.get(0);
                String name = row.get(1);
                MyList<String> artists = parseArtists(row.get(2));
                int dailyRank = parseInt(row.get(3));
                int dailyMovement = parseInt(row.get(4));
                int weeklyMovement = parseInt(row.get(5));
                String country = row.get(6).replaceAll("\"", "").trim();
                String snapshotDate = row.get(7).replaceAll("\"", "").trim();
                int popularity = parseInt(row.get(8));
                boolean isExplicit = Boolean.parseBoolean(row.get(9));
                String durationMs = row.get(10);
                String albumName = row.get(11).replaceAll("\"", "").trim();
                String albumReleaseDate = row.get(12).replaceAll("\"", "").trim();
                String danceability = row.get(13);
                String energy = row.get(14);
                int key = parseInt(row.get(15));
                String loudness = row.get(16);
                int mode = parseInt(row.get(17));
                String speechiness = row.get(18);
                String acousticness = row.get(19);
                String instrumentalness = row.get(20);
                String liveness = row.get(21);
                String valence = row.get(22);
                double tempo = parseDouble(row.get(23));
                int timeSignature = parseInt(row.get(24));

                Song cancion = new Song(spotifyId, name, artists, dailyRank, dailyMovement, weeklyMovement, country, snapshotDate, popularity, isExplicit, durationMs, albumName, albumReleaseDate, danceability, energy, key, loudness, mode, speechiness, acousticness, instrumentalness, liveness, valence, tempo, timeSignature);

                if (!paisesUnicos.contains(country)){
                    paisesUnicos.add(country);
                }
                if(!canciones.contains(snapshotDate)){
                    MyList<Song> cancionesEnFecha = new MyLinkedListImpl<>();
                    fechasUnicas.add(snapshotDate);
                    cancionesEnFecha.add(cancion);
                    canciones.put(snapshotDate, cancionesEnFecha);
                } else{
                    canciones.get(snapshotDate).add(cancion);
                }
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        records.add(fechasUnicas);
        records.add(canciones);
        records.add(paisesUnicos);

        return records;
    }

    private static MyLinkedListImpl<String> parseArtists(String artistsString){
        MyLinkedListImpl<String> artistList = new MyLinkedListImpl<>();
        String[] artists = artistsString.split(",");
        for (String artist : artists) {
            artistList.add(artist.trim());
        }
        return artistList;
    }

    private static int parseInt(String value){
        return Integer.parseInt(value.replaceAll("\"", "").replaceAll(";", "").trim());
    }

    private static double parseDouble(String value){
        return Double.parseDouble(value.replaceAll("\"", "").trim());
    }

}
