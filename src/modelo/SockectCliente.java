/* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CESAR DIAZ MARADIAGA
 */
public class SockectCliente {

	final int PORT = 20000;
	Socket cliente;
	ObjectOutputStream output;

	public SockectCliente() {

	}

	public void socketInit(Object objeto) {
		try {

			this.cliente = new Socket(Configuraciones.ipServidor, PORT);
			this.output = new ObjectOutputStream(this.cliente.getOutputStream());
			this.output.writeObject(objeto);

			this.cliente.close();
			this.output.close();
		} catch (IOException ex) {
			Logger.getLogger(SockectCliente.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
