package com.example.demo.socket;

import java.io.*;
import java.net.Socket;

public class Cliente {
  private static final int PORT = 13;
  private static final String HOST = "localhost";

  public static void main(String[] args) {
    Socket socket = null;

    try {
      socket = new Socket(HOST, PORT);

      System.out.println("Conectado al servidor");

      File imagenDestino = new File(
          "E:\\Rodolfo\\Cibertec\\Ciclo VI\\Desarrollo de Aplicaciones Web II\\WS_DAWII_2023_2\\cliente\\caballero-2.jfif");

      FileOutputStream salida = new FileOutputStream(imagenDestino);
      DataInputStream entrada = new DataInputStream(socket.getInputStream());

      int bytesLeidos = 0;
      while ((bytesLeidos = entrada.read()) != -1) {
        salida.write(bytesLeidos);
      }

      salida.close();
      entrada.close();
      socket.close();
      System.out.println("Desconectado del servidor");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
