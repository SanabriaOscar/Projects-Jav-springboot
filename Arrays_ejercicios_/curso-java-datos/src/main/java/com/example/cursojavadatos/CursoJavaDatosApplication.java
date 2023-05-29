package com.example.cursojavadatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursoJavaDatosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoJavaDatosApplication.class, args);
	findNumero(123445);
	}

	public static int findNumero(int numero){
	int  tamano=0;
	if (numero==0){
		tamano=1;
	}else{
		while (numero>=1 ||numero<=1){
			numero=numero/10;
			tamano++;
		}
		System.out.println("test "+tamano);
	}


		return numero;
	}

}
