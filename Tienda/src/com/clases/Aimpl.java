package com.clases;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.Frames.*;
/*interface almacenamiento{
	public void agregar(Producto p);
	public void eliminar(int i);
	public void consultar(int i);
	public void Ilista();
	}
	abstract class AbstractImpl implements almacenamiento{
		@Override
		public void agregar(Producto p) {
			// TODO Auto-generated method stub
		}
		@Override
		public void eliminar(int i) {
			// TODO Auto-generated method stub	
		}
		@Override
		public void consultar(int i) {
			// TODO Auto-generated method stub
		}
		@Override
		public void Ilista() {
			// TODO Auto-generated method stub
		}
	}
	*/
	public class Aimpl /*extends AbstractImpl*/{
		//private List<Producto> listaP;
		//public Aimpl() {
			private List<Producto>listaP=new ArrayList<>();
		//}
		//@Override
		public void agregar(Producto p) {
			listaP.add(p);
			JOptionPane.showMessageDialog(null, "Producto agregado sistema");
		}
		//@Override
		public void eliminar(int i) {
			boolean m=false;
			for (Producto k:listaP) {
				if(i==k.getId_producto()){
					listaP.remove(k);
					JOptionPane.showMessageDialog(null, "Elemento eliminado del sistema");	
					m=true;
					break;
				}
			}
			if(m==false) {
				JOptionPane.showMessageDialog(null, "El elemento no existe en el sistema");	
			}
		}
		//@Override
		public Producto consultar(int i) {
			boolean m=false;
			for (Producto k:listaP) {
				if(i==k.getId_producto()) {	
					/*JOptionPane.showMessageDialog(null,"Id_producto: "+k.getId_producto()
					+"\nNombre: "+k.getNombre()
					+"\nDescripcion: "+k.getDescripcion()
					+"\nPrecio: "+k.getPrecio()
					+"\nStock: "+k.getStock());*/
					m=true;
					return k;
				}
			}
			if(m==false) {
				JOptionPane.showMessageDialog(null, "El elemento no existe en el sistema");	
				
			}return null;
		}
		public Producto consultarN(String n) {
			String nmin=n.toLowerCase();
			boolean m=false;
			for (Producto k:listaP) {
				String kmin=k.getNombre().toLowerCase();
				if(nmin.equals(kmin)) {	
					/*JOptionPane.showMessageDialog(null,"Id_producto: "+k.getId_producto()
					+"\nNombre: "+k.getNombre()
					+"\nDescripcion: "+k.getDescripcion()
					+"\nPrecio: "+k.getPrecio()
					+"\nStock: "+k.getStock());*/
					m=true;
					return k;
				}
			}
			if(m==false) {
				JOptionPane.showMessageDialog(null, "El elemento no existe en el sistema");	
				
			}return null;
		}
		//@Override
		public String Ilista() {
			String lista="";
			for (Producto k:listaP) {
				lista=lista+"Producto ["+listaP.indexOf(k)+"]"+"\n"+" | "+k.getId_producto()+" | "+k.getNombre()+" | "+k.getPrecio()+" | "+k.getStock()+" | "+"\n";	
			}
			//JOptionPane.showMessageDialog(null,lista);
			return lista;
		}
		
	}


