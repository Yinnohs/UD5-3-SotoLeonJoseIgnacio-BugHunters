package com.digitalcastaway.biblioteca;

import java.util.ArrayList;

public class Persona extends Usuario {
    private final String  nombre;
    private ArrayList<String> librosPrestados;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.librosPrestados = new ArrayList<>();
    }

    @Override
    public void obtenerLibro(int posicion, Biblioteca biblioteca) {
        String titulo = biblioteca.prestarLibro(posicion);
        librosPrestados.add(titulo);
    }

    @Override
    public String obtenerLibroAleatorio(Biblioteca biblioteca) {
        String titulo = biblioteca.prestarLibroAleatorio();
        librosPrestados.add(titulo);
        return titulo;
    }

    @Override
    public void devolverLibro(String titulo, Biblioteca biblioteca) {
        biblioteca.devolverLibro(titulo);

        int posicion = librosPrestados.indexOf(titulo);

        biblioteca.devolverLibro(librosPrestados.remove(posicion));
    }

    public String obtenerTituloLibro(int posicion) {
        return librosPrestados.get(posicion);
    }

    public Integer borrowedBooksSize(){
        return this.librosPrestados.size();
    }
    @Override
    public String toString() {
        String output =  "Nombre='" + nombre + '\'' +
                " tiene los siguientes libros de la biblioteca: \n";

        int contador = 1;
        for ( String titulo: librosPrestados) {
            output += contador + " --> " + titulo + "\n";
            contador ++;
        }
        return output;
    }
}
