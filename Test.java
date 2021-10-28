package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Sistema;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sistema sist = new Sistema();
		
		System.out.println("1)");
		
		sist.agregarEmpleado("López", "Martín", 33333333, 3829);
		sist.agregarVisita("Martino", "Marcelo", 44444444, "Coop TIC");
		sist.agregarEmpleado("Rodríguez", "Lucía", 11111111, 3840);
		sist.agregarVisita("Molina", "Rocío", 22222222, "UNLa");		
		System.out.println(sist.getLstPersonas());
		
		System.out.println("2)");
		System.out.println(sist.traerPersona(1).toString());
		
		System.out.println("3-1)");
		try {
			sist.agregarSeguridad(LocalDate.of(2021, 8, 17), LocalTime.of(07, 50), true, sist.traerPersona(1));
		}catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		try {
			sist.agregarSeguridad(LocalDate.of(2021, 8, 17), LocalTime.of(8, 00), true, sist.traerPersona(2));
		}catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		try {
			sist.agregarSeguridad(LocalDate.of(2021, 8, 17), LocalTime.of(18, 10), false, sist.traerPersona(1));
		}catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		try {
			sist.agregarSeguridad(LocalDate.of(2021, 8, 17), LocalTime.of(18, 20), false, sist.traerPersona(2));
		}catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		try {
			sist.agregarSeguridad(LocalDate.of(2021, 8, 18), LocalTime.of(9, 00), true, sist.traerPersona(3));
		}catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		try {
			sist.agregarSeguridad(LocalDate.of(2021, 8, 18), LocalTime.of(9, 10), true, sist.traerPersona(4));
		}catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		try {
			sist.agregarSeguridad(LocalDate.of(2021, 8, 18), LocalTime.of(18, 10), false, sist.traerPersona(3));
		}catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		try {
			sist.agregarSeguridad(LocalDate.of(2021, 8, 18), LocalTime.of(18, 20), false, sist.traerPersona(4));
		}catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		System.out.println(sist.getLstSeguridad());
		
		
		System.out.println("3-2)");
		System.out.println(sist.traerSeguridad(LocalDate.of(2021, 8, 18), sist.traerPersona(4)));
		
		System.out.println("4)");
		try {
			sist.agregarSeguridad(LocalDate.of(2021, 8, 18), LocalTime.of(18, 25), false, sist.traerPersona(4));
		}catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		System.out.println("5)");
		System.out.println(sist.traerVisitas(LocalDate.of(2021, 8, 18)));
	}

}
