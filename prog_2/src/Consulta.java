import entities.Song;
import exceptions.InformacionInvalida;
import uy.edu.um.prog2.adt.hash.MyHash;
import uy.edu.um.prog2.adt.hash.MyHashImpl;
import uy.edu.um.prog2.adt.heap.MyHeapImpl;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Consulta {
    MyHash<String, MyList<Song>> canciones;
    MyList<String> fechasUnicas;
    MyList<String> paisesUnicos;

    public Consulta() {
        MyList<Object> temp = ReadData.importData("universal_top_spotify_songs.csv");
        this.paisesUnicos = (MyList<String>) temp.get(2);
        this.canciones = (MyHashImpl<String, MyList<Song>>) temp.get(1);
        this.fechasUnicas = (MyList<String>) temp.get(0);
    }

    public void consultaUno(String pais, String fecha) throws InformacionInvalida {
        if(!(fechasUnicas.contains(fecha)) || !(paisesUnicos.contains(pais))){
            throw new InformacionInvalida();
        }
        MyList<Song> listaCancionesEnFecha = canciones.get(fecha);                //canciones de la fecha dada
        MyHash<Integer, Song> hashTemp = new MyHashImpl<>(10);        //hash auxiliar para guardar las canciones del top
        Song cancionTemp;
        int i = 0;
        int j = 0;

        while (i < 10 && j < listaCancionesEnFecha.size()){
            cancionTemp = listaCancionesEnFecha.get(j);
            if (cancionTemp.getCountry().equals(pais) && cancionTemp.getDaily_rank() < 11){
                hashTemp.put(cancionTemp.getDaily_rank(), cancionTemp);                       // guarda las canciones del top 10 en el hash por su ranking
                i++;
            }
            j++;
        }
        i = 0;
        System.out.println("Top 10 en " + pais + " el " + fecha + ":");
        while (i < 10) {
            cancionTemp = hashTemp.get(hashTemp.keys().get(i));
            if (cancionTemp.getArtists().size() > 1) {
                System.out.print(cancionTemp.getDaily_rank() + ". " + cancionTemp.getName() + ",de ");

                for (int k = 0; k < cancionTemp.getArtists().size(); k++) {
                    if (k == cancionTemp.getArtists().size()-1) {
                        System.out.println(cancionTemp.getArtists().get(k));
                    } else {
                        System.out.print(cancionTemp.getArtists().get(k) + ", ");
                    }
                }
            } else {
                System.out.println(cancionTemp.getDaily_rank() + ". " + cancionTemp.getName() + ",de " + cancionTemp.getArtists().get(0));
            }
            i++;
        }
    }

    public void consultaDos(String fecha) throws InformacionInvalida {
        if(!fechasUnicas.contains(fecha)){
            throw new InformacionInvalida();
        }
        MyList<Song> listaCancionesEnFecha = canciones.get(fecha);
        MyHash<String, Integer> aparicionesCancion = new MyHashImpl<>(50); //guarda las veces q cada cancion aparecio
        MyList<String> idCanciones = new MyLinkedListImpl<>(); //guarda los spotify id de las canciones
        MyHeapImpl<String, Integer> top5 = new MyHeapImpl<>(false);
        MyHash<String, String> idNombre = new MyHashImpl<>(50);
        Integer nroTemp;
        Song cancionActual;
        int i = 0;

        while (i < listaCancionesEnFecha.size() - 1) {
            cancionActual = listaCancionesEnFecha.get(i);
            if (cancionActual.getDaily_rank() < 51) {
                if (aparicionesCancion.contains(cancionActual.getSpotify_id())) {
                    if (!idCanciones.contains(cancionActual.getSpotify_id())) {
                        idNombre.put(cancionActual.getSpotify_id(), cancionActual.getName());
                        idCanciones.add(cancionActual.getSpotify_id());
                    }
                    nroTemp = aparicionesCancion.get(cancionActual.getSpotify_id());
                    aparicionesCancion.remove(cancionActual.getSpotify_id());
                    aparicionesCancion.put(cancionActual.getSpotify_id(), nroTemp + 1);
                } else {
                    if (!idCanciones.contains(cancionActual.getSpotify_id())) {
                        idNombre.put(cancionActual.getSpotify_id(), cancionActual.getName());
                        idCanciones.add(cancionActual.getSpotify_id());
                    }
                    aparicionesCancion.put(cancionActual.getSpotify_id(), 1);
                }
            }
            i++;
        }
        for (int j = 0; j < idCanciones.size(); j++) {
            top5.insert(idCanciones.get(j), aparicionesCancion.get(idCanciones.get(j)));
        }

        System.out.println("TOP 5 el " + fecha + ":");
        for (int k = 1; k < 6; k++) {
            System.out.println(k + ". " + idNombre.get(top5.get().getKey()) + ": " + top5.get().getValue() + " veces.");
            top5.delete();
        }
    }

    public void consultaTres(String fechaInicial, String fechaFinal) throws InformacionInvalida {
        LocalDate fechaInicio = LocalDate.parse(fechaInicial, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate fechaFin = LocalDate.parse(fechaFinal, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        if (fechaInicio.isAfter(fechaFin)) {
            throw new InformacionInvalida();
        }
        int diferenciaDias = 0;
        while (fechaInicio.plusDays(diferenciaDias).isBefore(fechaFin)) {
            diferenciaDias++;
        }

        Integer nroTemp;
        MyList<Song> listaCancionesEnFecha = new MyLinkedListImpl<>(); // lista auxiliar
        Song cancionActual;
        MyHash<String, Integer> artistasOcurrencias = new MyHashImpl<>(10); // guarda cantidad de apariciones por artista
        MyList<String> artistasSingulares = new MyLinkedListImpl<>(); //guarda el nombre de todos los artistas
        MyHeapImpl<String, Integer> top7 = new MyHeapImpl<>(false);

        for (int i = 0; i < diferenciaDias; i++) {
            LocalDate tempFecha = fechaInicio.plusDays(i);
            String tempFecha1 = tempFecha.toString();
            if (canciones.contains(tempFecha1)) {
                listaCancionesEnFecha = canciones.get(tempFecha1);
                for (int k = 0; k < listaCancionesEnFecha.size(); k++) {
                    cancionActual = listaCancionesEnFecha.get(k);
                    for (int j = 0; j < cancionActual.getArtists().size(); j++) {
                        if (!artistasSingulares.contains(cancionActual.getArtists().get(j))) {
                            artistasSingulares.add(cancionActual.getArtists().get(j));
                        }
                        if (artistasOcurrencias.contains(cancionActual.getArtists().get(j))) {
                            nroTemp = artistasOcurrencias.get(cancionActual.getArtists().get(j));
                            artistasOcurrencias.remove(cancionActual.getArtists().get(j));
                            artistasOcurrencias.put(cancionActual.getArtists().get(j), nroTemp + 1);
                        } else {
                            artistasOcurrencias.put(cancionActual.getArtists().get(j), 1);
                        }
                    }
                }
            }
        }
        for (int j = 0; j < artistasSingulares.size(); j++) {
            top7.insert(artistasSingulares.get(j), artistasOcurrencias.get(artistasSingulares.get(j)));
        }
        System.out.println("TOP 7 entre " + fechaInicial + " hasta " + fechaFinal + ":");
        for (int j = 1; j < 8; j++) {
            System.out.println(j + ". " + top7.get().getKey() + ": " + top7.get().getValue() + " veces.");
            top7.delete();
        }
    }

    public void consultaCuatro(String nombreArtista, String fecha) throws InformacionInvalida {
        if(!fechasUnicas.contains(fecha)){
            throw new InformacionInvalida();
        }
        int cantidad = 0;
        int i = 0;
        MyList<Song> listaCancionesEnFecha = canciones.get(fecha);
        boolean encontro = false;
        Song cancionActual;
        while (i < listaCancionesEnFecha.size()) {
            cancionActual = listaCancionesEnFecha.get(i);
            if (cancionActual.getDaily_rank() < 51 && cancionActual.getArtists().contains(nombreArtista)) {
                cantidad++;
            }
            i++;
        }
        System.out.println( nombreArtista + " aparece " + cantidad + " veces en el top 50 en el " + fecha);
    }

    public void consultaCinco(double tempo1, double tempo2, String fechaInicial, String fechaFinal) throws InformacionInvalida {
        LocalDate fechaInicio = LocalDate.parse(fechaInicial, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate fechaFin = LocalDate.parse(fechaFinal, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        if (fechaInicio.isAfter(fechaFin)) {
            throw new InformacionInvalida();
        }
        int diferenciaDias = 0;
        while (fechaInicio.plusDays(diferenciaDias).isBefore(fechaFin)) {
            diferenciaDias++;
        }

        int cantidad = 0;
        MyLinkedListImpl<String> cancionesCumplen = new MyLinkedListImpl<>();
        Song cancionActual;
        MyList<Song> listaCancionesEnFecha= new MyLinkedListImpl<>();

        for(int k = 0; k < diferenciaDias; k++) {
            int i = 0;
            LocalDate tempFecha = fechaInicio.plusDays(k);
            String tempFecha1 = tempFecha.toString();
            if (canciones.contains(tempFecha1)) {
                listaCancionesEnFecha = canciones.get(tempFecha1);
                while (i < listaCancionesEnFecha.size() - 1) {
                    cancionActual = listaCancionesEnFecha.get(i);
                    if (!cancionesCumplen.contains(cancionActual.getSpotify_id()) && cancionActual.getTempo() >= tempo1 && cancionActual.getTempo() <= tempo2) {
                        cancionesCumplen.add(cancionActual.getSpotify_id());
                        cantidad++;
                    }
                    i++;
                }
            }
        }
        System.out.println("Hay " + cantidad + " canciones entre el " + fechaInicial + " y el " + fechaFinal + " con ese rango de tempo.");
    }
}