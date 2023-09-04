package com.example.demo.socket;

import java.io.*;
import java.net.*;

public class Servidor {
  private static final int PORT = 13;

  public static void main(String[] args) {
    ServerSocket serverSocket = null;

    try {
      serverSocket = new ServerSocket(PORT);

      while (true) {
        System.out.println("Servidor esperando conexión");
        Socket socketCliente = serverSocket.accept();

        System.out.println("Cliente conectado");

        File imagen = new File(
            "E:\\Rodolfo\\Cibertec\\Ciclo VI\\Desarrollo de Aplicaciones Web II\\WS_DAWII_2023_2\\server\\caballero.jfif");

        FileInputStream entrada = new FileInputStream(imagen);
        DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());

        int bytes = 0;
        while ((bytes = entrada.read()) != -1) {
          salida.write(bytes);
        }

        entrada.close();
        salida.close();
        socketCliente.close();
        System.out.println("Cliente desconectado");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
