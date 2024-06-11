package com.prueba.demo.Chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;

public class Client {
    private static String nickname;
    public static void main(String[] args) {
    	Scanner lectura = new Scanner (System.in);
    	System.out.println("Bienvenido al chat, por favor ingrese su usuario");
    	nickname = lectura.next();
    	System.out.println("Su nickname es = "+nickname+"\nConnecting to the chat server..." );
		MarcoCliente mimarco=new MarcoCliente(nickname);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }  
}

class MarcoCliente extends JFrame{
	public MarcoCliente(String nickname){
		setBounds(0,0,280,150);	
		LaminaMarcoCliente milamina=new LaminaMarcoCliente(nickname);
		add(milamina);
		setVisible(true);
	}	
}

class LaminaMarcoCliente extends JPanel{
	public LaminaMarcoCliente(String nickname){
		JLabel texto=new JLabel("Bienvenido " +nickname);
		add(texto);
		campo1=new JTextField(20);
		add(campo1);		
		miboton=new JButton("Enviar");
		EnviarMsm EnviarMsm = new EnviarMsm(nickname);
		miboton.addActionListener(EnviarMsm);
		add(miboton);	
	}
	
	//Metodo que esta a la escucha del boton enviar
    class EnviarMsm implements ActionListener{
    	String nickname;
    	boolean isActiveChat = true;
    	
    	EnviarMsm(String nickname){
    		this.nickname= nickname;
    	}

    	@Override
    	public void actionPerformed(ActionEvent e) {
    		if (!isActiveChat) {
                return;
            }
    		
    		String SERVER_ADDRESS = "192.168.0.29";
    	    int SERVER_PORT = 59420;
    	    String salir = "chao";
    	    
    	    	try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
    			      				
    				//System.out.println("Connected to the server");                    
    				DataOutputStream flujo_Salida = new DataOutputStream(socket.getOutputStream());
    				if(isActiveChat && !campo1.getText().equalsIgnoreCase(salir)) {    					
    					flujo_Salida.writeUTF("User:"+nickname+ "= " + campo1.getText());
    					campo1.setText("");
    					//flujo_Salida.close();
    				}else {
    					flujo_Salida.writeUTF("User:"+nickname+ "= El Usuario se desconecto");
    					campo1.setText("Te haz desconectado");
    					//flujo_Salida.close();
    					isActiveChat = false;
    					campo1.setEditable(false); // Desactivar campo de texto
	                    miboton.setEnabled(false); // Desactivar bot�n
    				}
    
    				flujo_Salida.close();
	            } catch (IOException e2) {
	                System.out.println("Client error: " + e2.getMessage());
	            }
    	}
    }
	private JTextField campo1;
	private JButton miboton;
}
    

