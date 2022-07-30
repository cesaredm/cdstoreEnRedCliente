/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Configuraciones;
import vista.IMenu;

/**
 *
 * @author CESAR DIAZ MARADIAGA
 */
public class CtrlConfiguraciones implements ActionListener {

	IMenu menu = null;
	Configuraciones config = null;

	public CtrlConfiguraciones(IMenu menu, Configuraciones info) {
		this.menu = menu;
		this.config = info;
		menu.btnActualizarInfoFactura.addActionListener(this);
		this.config.getImpresora();
		this.config.getIpServidor();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
