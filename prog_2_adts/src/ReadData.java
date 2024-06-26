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
    public static MyLinkedListImpl<Object> importData(String filePath, int maxRecords) {
        MyLinkedListImpl<String> fechas = new MyLinkedListImpl<>();
        MyLinkedListImpl<Object> resultado = new MyLinkedListImpl<>();
        MyHash<String, MyLinkedListImpl<Song>> hashCanciones = new MyHashImpl<>(10);
        int i=0;
        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null && i < maxRecords) {
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
                double durationMs = parseDouble(row.get(10));
                String albumName = row.get(11).replaceAll("\"", "").trim();
                String albumReleaseDate = row.get(12).replaceAll("\"", "").trim();
                double danceability = parseDouble(row.get(13));
                double energy = parseDouble(row.get(14));
                int key = parseInt(row.get(15));
                double loudness = parseDouble(row.get(16));
                int mode = parseInt(row.get(17));
                double speechiness = parseDouble(row.get(18));
                double acousticness = parseDouble(row.get(19));
                double instrumentalness = parseDouble(row.get(20));
                double liveness = parseDouble(row.get(21));
                double valence = parseDouble(row.get(22));
                double tempo = parseDouble(row.get(23));
                int timeSignature = parseInt(row.get(24));

                Song cancion = new Song(spotifyId, name, artists, dailyRank, dailyMovement, weeklyMovement, country, snapshotDate, popularity, isExplicit, durationMs, albumName, albumReleaseDate, danceability, energy, key, loudness, mode, speechiness, acousticness, instrumentalness, liveness, valence, tempo, timeSignature);

                if(hashCanciones.get(snapshotDate) == null) {
                    MyLinkedListImpl<Song> canciones = new MyLinkedListImpl<Song>();
                    fechas.add(snapshotDate);
                    canciones.add(cancion);
                    hashCanciones.put(snapshotDate, canciones);
                } else {
                    hashCanciones.get(snapshotDate).add(cancion);
                }
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        resultado.add(hashCanciones);
        resultado.add(fechas);

        return resultado;
    }

    private static MyLinkedListImpl<String> parseArtists(String artistsString) {
        MyLinkedListImpl<String> artistList = new MyLinkedListImpl<>();
        String[] artists = artistsString.split(",");
        for (String artist : artists) {
            artistList.add(artist.trim());
        }
        return artistList;
    }

    private static int parseInt(String value) {
        return Integer.parseInt(value.replaceAll("\"", "").replaceAll(";", "").trim());
    }

    private static double parseDouble(String value) {
        return Double.parseDouble(value.replaceAll("\"", "").trim());
    }

}
