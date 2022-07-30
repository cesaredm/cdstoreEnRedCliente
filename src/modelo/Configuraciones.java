/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author CESAR DIAZ MARADIAGA
 */
public class Configuraciones extends Conexiondb{
	/* ------------- DATOS PARA LA CONFIGUIRACION DE DATOS DE FACTURA -------------*/
	private String nombre, direccion, rfc, rangoInicio, rangoFinal, telefono, anotaciones;
	PreparedStatement pst;
	Statement st;
	Connection cn;
	ResultSet rs;
	String consulta;
	private final int id = 1;
	public static String ipServidor,impresora;
	
	public Configuraciones(){
			
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getRangoInicio() {
		return rangoInicio;
	}

	public void setRangoInicio(String rangoInicio) {
		this.rangoInicio = rangoInicio;
	}

	public String getRangoFinal() {
		return rangoFinal;
	}

	public void setRangoFinal(String rangoFinal) {
		this.rangoFinal = rangoFinal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getAnotaciones() {
		return anotaciones;
	}

	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
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

	/* OBTENER LA IMPRESORA ESTABLECIDA */
	public void getImpresora() {
		this.cn = Conexion();
		this.consulta = "SELECT impresora FROM impresoras WHERE id = ?";
		try {
			this.pst = this.cn.prepareStatement(this.consulta);
			this.pst.setInt(1, this.id);
			this.rs = this.pst.executeQuery();
			while (this.rs.next()) {
				this.impresora = this.rs.getString("impresora");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e + "en el metodo Impresora en el modelo Configuraciones");
			e.printStackTrace();
		} finally {
			try {
				this.cn.close();
			} catch (SQLException ex) {
				Logger.getLogger(Configuraciones.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	/* OBTENER DATOS DE FACTURA */
	public void obtenerInfoFactura() {
		this.cn = Conexion();
		this.consulta = "SELECT * FROM infoFactura";
		try {
			this.pst = this.cn.prepareStatement(this.consulta);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				this.nombre = rs.getString("nombre");
				this.telefono = rs.getString("telefono");
				this.direccion = rs.getString("direccion");
				this.rfc = rs.getString("RFC");
				this.rangoInicio = rs.getString("inicioRango");
				this.rangoFinal = rs.getString("finalRango");
				this.anotaciones = rs.getString("anotaciones");
			}
			this.cn.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
}
