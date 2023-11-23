package com.finnazen.springbootapirestbacked.music;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class RedSocialAmistad {
    private Graph<String, DefaultEdge> grafo;

    public RedSocialAmistad() {
        grafo = new SimpleGraph<>(DefaultEdge.class);
    }

    public void agregarUsuario(String usuario) {
        grafo.addVertex(usuario);
    }

    public void agregarConexion(String usuario1, String usuario2) {
        grafo.addEdge(usuario1, usuario2);
    }

    public boolean sonAmigosDirectos(String usuario1, String usuario2) {
        return grafo.containsEdge(usuario1, usuario2);
    }

    public static void main(String[] args) {
        RedSocialAmistad redSocial = new RedSocialAmistad();

        // Agregar usuarios
        redSocial.agregarUsuario("Carlos");
        redSocial.agregarUsuario("Laura");
        redSocial.agregarUsuario("Roberto");
        redSocial.agregarUsuario("Isabel");

// Establecer conexiones
        redSocial.agregarConexion("Carlos", "Laura");
        redSocial.agregarConexion("Laura", "Roberto");
        redSocial.agregarConexion("Laura", "Isabel");
        redSocial.agregarConexion("Roberto", "Laura");

        String usuario1 = "Carlos";
        String usuario2 = "Laura";
        boolean sonAmigosDirectos = redSocial.sonAmigosDirectos(usuario1, usuario2);

        System.out.println(usuario1 + " y " + usuario2 + " son amigos directos: " + sonAmigosDirectos);
    }
}
