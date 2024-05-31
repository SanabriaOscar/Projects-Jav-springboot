package com.finnazen.springbootapirestbacked.music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class RedSocialAmistad2 {

        private Map<String, List<String>> conexiones;

        public RedSocialAmistad2() {
            conexiones = new HashMap<>();
        }

        public void agregarUsuario(String usuario) {
            conexiones.put(usuario, new ArrayList<>());
        }

        public void agregarConexion(String usuario1, String usuario2) {
            conexiones.get(usuario1).add(usuario2);
            conexiones.get(usuario2).add(usuario1);
        }

        public List<String> obtenerConexiones(String usuario) {
            return conexiones.get(usuario);
        }

        public static void main(String[] args) {
            RedSocialAmistad2 redSocial = new RedSocialAmistad2();

            // Agregar usuarios
            redSocial.agregarUsuario("Carlos");
            redSocial.agregarUsuario("Luisa");
            redSocial.agregarUsuario("Miguel");
            redSocial.agregarUsuario("Elena");

            // Establecer conexiones
            redSocial.agregarConexion("Carlos", "Luisa");
            redSocial.agregarConexion("Luisa", "Miguel");
            redSocial.agregarConexion("Luisa", "Elena");
            redSocial.agregarConexion("Miguel", "Elena");
            redSocial.agregarConexion("Miguel", "Carlos");

            // Obtener conexiones de un usuario
            String usuario = "Carlos";
            List<String> conexiones = redSocial.obtenerConexiones(usuario);

            System.out.println("Conexiones de " + usuario + ":");
            for (String conexion : conexiones) {
                System.out.println(conexion);
            }
        }
    }


