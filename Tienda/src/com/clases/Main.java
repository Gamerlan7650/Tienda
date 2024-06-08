package com.clases;
import com.Frames.*;
import java.util.Scanner;
public class Main {
public static void main (String...args) {
	new Home().setVisible(true);
	Scanner sc=new Scanner(System.in);
	//Aimpl alm;
	//Producto p;
	
	//todo el codigo comentado funciona desde consola, pero el codigo para usarlo con interfaz grafica esta en los botones
	
	/*int j=0;
	int b;
	boolean v=true;
	while(v) {
		System.out.print("\n");
		System.out.println("INVENTARIO PRODUCTOS"+
	"\n 1.Agregar producto a inventario"+
	"\n 2.Eliminar producto de inventario"+
	"\n 3.Consultar datos de producto en inventario"+
	"\n 4.Imprimir inventario (productos sin descripcion)"
	+"\n 5.Salir de inventario");
		
		System.out.print("\n"+
	"Opción: ");
		int i=sc.nextInt();
		switch (i-1) {
		case 0:
		p=new Producto();
		p.setId_producto(j);
		System.out.println("Nombre del producto: ");
		String nm=sc.next();
		p.setNombre(nm);
		System.out.println("Descripcion del producto: ");
		String dc=sc.next();
		p.setDescripcion(dc);
		System.out.println("Precio del producto: ");
		double pr=sc.nextDouble();
		p.setPrecio(pr);
		System.out.println("Cantidad del producto para inventario (STOCK)");
		int stock=sc.nextInt();
		p.setStock(stock);
		alm.agregar(p);
		System.out.println("Producto de ID " +(j)+ " agregado");
		j++;
		break;
		case 1:
		System.out.print("ID del producto: ");
		b=sc.nextInt();
		alm.eliminar(b);
		break;
		case 2:
		System.out.print("ID del producto: ");
		b=sc.nextInt();
		alm.consultar(b);
		break;
		case 3:
		alm.Ilista();
		break;
		case 4:
			sc.close();
			System.exit(1);
		}	
		
	}
	*/
}
}

