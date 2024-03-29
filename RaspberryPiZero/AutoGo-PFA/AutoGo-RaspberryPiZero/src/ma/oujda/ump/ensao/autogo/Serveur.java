package ma.oujda.ump.ensao.autogo;

import java.io.*;
import java.net.*;

public class Serveur {

	private ServerSocket socketserver = null;
	private boolean isRunning = true;

	public Serveur() {
		try {
			socketserver = new ServerSocket(8988);
			System.out.println("Le serveur est � l'�coute du port " + socketserver.getLocalPort());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	On lance notre serveur dans un thread � part vu qu'il est dans une boucle infinie
	public void open() {
		
		Thread t = new Thread(new Runnable() 
		{
			public void run() 
			{
				while (isRunning == true) 
				{
					try 
					{
//						On attend une connexion d'un client ( Application Mobile )
						Socket client = socketserver.accept();

//						Une fois re�ue, on la traite dans un thread s�par�
						System.out.println("Connexion cliente re�ue.");
						Thread t = new Thread(new Traitement(client));
						t.start();

					} 
					catch (IOException e) {e.printStackTrace();}
				}
				try 
				{
					socketserver.close();
				}
				catch (IOException e) 
				{
					e.printStackTrace();
					socketserver = null;
				}
			}
		});
		t.start();
	}

	public void close() 
	{
		isRunning = false;
	}
}
