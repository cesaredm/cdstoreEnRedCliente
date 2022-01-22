/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author CESAR DIAZ MARADIAGA
 */
public class Configuraciones extends Conexiondb{
	PreparedStatement pst;
	Statement st;
	Connection cn;
	ResultSet rs;
	String consulta;
	public static String ipServidor;
	
	public Configuraciones(){
		
	}

	public void getIpServidor(){
	this.cn = Conexion();
		this.consulta = "SELECT ipDireccion AS ip FROM ips WHERE tipoOrdenador = 'Servidor'";
		try {
			Statement st = this.cn.createStatement();
			this.rs = st.executeQuery(this.consulta);
			while (this.rs.next()) {
				this.ipServidor = this.rs.getString("ip");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.cn.close();
			} catch (SQLException ex) {
				Logger.getLogger(Configuraciones.class.getName()).log(Level.SEVERE, null, ex);
			}
		}	
	}
}
