package com.prueba.demo.Chat;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server  {
	public static void main(String[] args) {
		MarcoServidor mimarco=new MarcoServidor();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}	
}

class MarcoServidor extends JFrame implements Runnable{
	private static final int PORT = 59420;
	
	public MarcoServidor(){
		String presentacion = "Proyecto Java [GRUPO B01] SUBGRUPO 28 \n\n"
				+ "Persistencia y Datos Transaccionales\n\n"
				+ "Docente: Roa Diego\n\n"
				+ "Estudiantes: Juan Guillermo Tafur R.\n"
				+ "             Jorge David Calderon T.\n"
				+ "             Angie Tatiana Murillo M.\n\n\n"
				+ "El presente programa permite realizar la \ncomunicacion bidireccional entre Cliente \ny servidor, Escenario 3\n"
				+ "\n"
				+ "Servidor iniciado y constestando Ok\n\n";
		setBounds(100,100,280,450);
		JPanel milamina= new JPanel();
		milamina.setLayout(new BorderLayout());
		
		JTextArea presentacionArea = new JTextArea(presentacion);
        presentacionArea.setEditable(false);
        presentacionArea.setBackground(null);  	// Para hacer que el fondo sea transparente
        presentacionArea.setBorder(null);  		// Para quitar el borde
        
		areatexto=new JTextArea();
		milamina.add(new JScrollPane(presentacionArea), BorderLayout.NORTH);
        milamina.add(new JScrollPane(areatexto), BorderLayout.CENTER);
        
		add(milamina);
		setVisible(true);
		Thread miHilo = new Thread(this);
		miHilo.start();
	}
	
	@Override
	public void run() {
		System.out.println("Servidor a la escucha");
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			System.out.println("Server inicializado por el puerto "+PORT+" Chat a la espera de nuevos Usuarios!!");
			while(true) {  	
				Socket clientSocket = serverSocket.accept();            
				DataInputStream flujoEntrada = new DataInputStream(clientSocket.getInputStream());      
				String mensajeEntrada = flujoEntrada.readUTF();
				areatexto.append("\n"+ mensajeEntrada);            
				clientSocket.close();            
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private	JTextArea areatexto;
}
