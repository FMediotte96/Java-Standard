package com.facu.javastandard.clase05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestCollections {

	public static void main(String[] args) {
		
		//Array o Vector de autos
		Auto[] autos = new Auto[4];
		autos[0] = new Auto("Fiat", "Idea", "Rojo");
		autos[1] = new Auto("Ford", "Focus", "Verde");
		autos[2] = new Auto("VW", "Gol", "Azul");
		autos[3] = new Auto("Peugeot", "207", "Negro");

		//Recorrido por indice
		for(int a = 0; a < autos.length; a++) {
			System.out.println(autos[a]);
		}
		
		//Recorrido por iteradores
		for(Auto auto : autos) {
			System.out.println(auto);
		}
		
		//Interface List
		//Implementación ArrayList y LinkedList
		List<Object> lista1 = new ArrayList<Object>(10);
		lista1.add(new Auto("Renault","Kangoo","Bordo"));
        lista1.add(new Auto("VW","Suran","Rojo"));
        lista1.add(new Auto("Chevrolet","Prisma","Blanco"));
        lista1.add(new Auto("Fiat","Palio","Gris"));
        lista1.add("Hola");
        lista1.add(26);
        
        System.out.println("--------------INDICE---------------------");
        //Recorrido por indice
        for(int b=0; b < lista1.size(); b++) { 
        	System.out.println(lista1.get(b));
        }

        System.out.println("--------------ITERADORES---------------------");
        //Recorrido por iteradores
        for(Object obj: lista1) {
        	System.out.println(obj);
        }

        System.out.println("----------------SOLO AUTOS-------------------");
        //Solo imprimimos los elementos del tipo Auto
        for(Object obj: lista1) { 
        	if(obj instanceof Auto) {
        		System.out.println(obj);
        	}
        }

        System.out.println("----------------JAVA 8-------------------");
        //Recorrido por JAVA 8
        lista1.forEach(item->{
        	System.out.println(item);
        });
        
        System.out.println("-----------------------");
        lista1.forEach(System.out::println);
        
        System.out.println("----------J8 SOLO AUTOS-------------");
        lista1.forEach(item->{
        	if(item instanceof Auto) 
        		System.out.println(item);
        });
        
        //Copiamos los autos del array autos a lista1
        System.out.println("---------autos del array autos a lista1-------------");
        for(Auto auto: autos) {
        	lista1.add(auto);
        }
        lista1.forEach(System.out::println);
        
        //Lista tipada uso de generics
        List<Auto> lista2 = new ArrayList<Auto>();
        lista2.add(new Auto("Ford", "Ecosport", "Negro"));
        lista2.add(new Auto("VW", "Vento", "Azul"));
        lista2.add(new Auto("Citroen", "C4", "Bordo"));
        lista2.add(new Auto("Honda", "Civic", "Blanco"));
        
        System.out.println("-----------Lista tipada uso de generics--------------");
        lista2.forEach(System.out::println);
        
        Auto auto1 = (Auto) lista1.get(0);
        Auto auto2 = lista2.get(0);
        System.out.println("----------------------------");
        System.out.println(auto1);
        System.out.println(auto2);
        System.out.println("----------------------------");

        //Copiar los Autos de lista1 a lista2
        lista1.forEach(item->{
        	if(item instanceof Auto) {
        		lista2.add((Auto)item);
        	}
        });
        
        System.out.println("-----------------Lista 1 y lista2--------------");
        lista2.forEach(System.out::println);
        System.out.println("\nCantidad de autos: " + lista2.size());
        
        List<Auto> lista3 = new ArrayList<>();
        
        //Copiar todos los autos de lista2 a lista 3
        lista3.addAll(lista2);
        System.out.println("----------------Lista3--------------------");
        lista3.forEach(System.out::println);
        
        //Interfaz set no permite duplicados
        System.out.println("----------------INTERFAZ SET----------------");
        Set<String> set;
        
        System.out.println("------------HashSet-------------");
        //Implementacion HashSet: es el más veloz
        set = new HashSet<>(); //No garantiza ningun orden, lo hace lo más rápido que pueda
        set.add("Hola");
        set.add("Mundo");
        set.add("Hola");
        set.add("Mundo");
        set.add("chau");
        set.forEach(System.out::println);
        
        System.out.println("------------TreeSet-------------");
        //Implementación TreeSet ordena de menor a mayor
        set = new TreeSet<>();
        set.add("Hola");
        set.add("Mundo");
        set.add("Hola");
        set.add("Mundo");
        set.add("Chau");
        set.forEach(System.out::println);
        
        System.out.println("------------LinkedHashSet-------------");
        //Implementación LinkedHashSet Ordena por orden de Ingreso
        set = new LinkedHashSet<>();
        set.add("Hola");
        set.add("Mundo");
        set.add("Hola");
        set.add("Mundo");
        set.add("chau");
        set.forEach(System.out::println);
        
        //Ejemplo de List
        System.out.println("----------List y Set-------------");
        List<String> lista4 = new LinkedList<String>();
        lista4.add("Hola");
        lista4.add("Mundo");
        lista4.add("Hola");
        lista4.add("Mundo");
        lista4.add("Chau");
        lista4.forEach(System.out::println);

        System.out.println("------------HashSet Autos--------------");
        Set<Auto> setAutos = new HashSet<>();
        setAutos.addAll(lista2);
        setAutos.add(new Auto("Citroen", "C4", "Bordo"));
        setAutos.add(new Auto("Peugeot", "207", "Negro"));
        setAutos.forEach(System.out::println);
        
        System.out.println("-----------------------");
        setAutos.forEach(item-> {
        	System.out.println(item+"\t"+ item.hashCode());
        });
        
        System.out.println("-------------PILA (Stack)--------------");
        Stack<Auto> pila = new Stack<>();
        System.out.println("-----------APILAR----------");
        pila.push(new Auto("Fiat", "Siena", "Verde"));
        pila.push(new Auto("Ford", "Ka", "Negro"));
        pila.addAll(lista3);
        pila.forEach(System.out::println);
        System.out.println("\nCantidad: " + pila.size());
        
        System.out.println("----------DESAPILAR---------");
        while(!pila.isEmpty()) {
        	System.out.println(pila.pop()); //Me devuelve el ultimo elemento
        }
        System.out.println("Cantidad: " + pila.size());

        
        System.out.println("-------------COLA (Queue)--------------");
        //Interface Queue Colas
        Queue<Auto> cola = new LinkedList<>();
        System.out.println("------------ACOLAR-----------");
        cola.offer(new Auto("Honda", "Fit", "Gris"));
        cola.offer(new Auto("Hyundai", "I10", "Blanco"));
        cola.addAll(lista2);
        cola.forEach(System.out::println);
        System.out.println("\nCantidad: " + cola.size());
        System.out.println("---------DESACOLAR-----------");
        while(!cola.isEmpty()) {
        	System.out.println(cola.poll()); //Desacola y me lo retorna
        }
        System.out.println("Cantidad: " + cola.size());
        
        System.out.println("-----------------MAP---------------");
        Map<String, String> mapaDiasEsp;
        
        System.out.println("-----------HashMap----------");
        //Implementación HashMap
        mapaDiasEsp = new HashMap<String, String>(); //no garantiza ningun orden, lo hace lo más rápido que pueda
        mapaDiasEsp.put("Monday", "Lunes");
        mapaDiasEsp.put("Tuesday", "Martes");
        mapaDiasEsp.put("Wednesday", "Miércoles");
        mapaDiasEsp.put("Thrusday", "Jueves");
        mapaDiasEsp.put("Friday", "Viernes");
        mapaDiasEsp.forEach((k,v) -> System.out.println(k+" " + v));
        System.out.println("------------------------------");
        
        System.out.println("-----------HashMap----------");
        //Implementación TreeMap
        mapaDiasEsp = new TreeMap<String, String>(); //Ordena alfabeticamente de menor a mayor
        mapaDiasEsp.put("Monday", "Lunes");
        mapaDiasEsp.put("Tuesday", "Martes");
        mapaDiasEsp.put("Wednesday", "Miércoles");
        mapaDiasEsp.put("Thrusday", "Jueves");
        mapaDiasEsp.put("Friday", "Viernes");
        mapaDiasEsp.forEach((k,v) -> System.out.println(k+" " + v));
        System.out.println("------------------------------");
        
        System.out.println("-----------LinkedHashMap----------");
        //Implementación LinkedHashMap
        mapaDiasEsp = new LinkedHashMap<String, String>(); //Ordena por orden de ingreso
        mapaDiasEsp.put("Monday", "Lunes");
        mapaDiasEsp.put("Tuesday", "Martes");
        mapaDiasEsp.put("Wednesday", "Miércoles");
        mapaDiasEsp.put("Thrusday", "Jueves");
        mapaDiasEsp.put("Friday", "Viernes");
        mapaDiasEsp.forEach((k,v) -> System.out.println(k+" " + v));
        
        System.out.println("------------DIAS EN PORTUGUES-------------");
        //mapa dias en portugues
        Map<String,String> mapaDiasPor;
        mapaDiasPor = new LinkedHashMap<String, String>();
        mapaDiasPor.put("monday","Segunda-feira");
        mapaDiasPor.put("tuesday","Terça-feira");
        mapaDiasPor.put("wednesday","Quarta-feira");
        mapaDiasPor.put("thursday","Quinta-feira");
        mapaDiasPor.put("friday","Sexta-feira");  
        mapaDiasPor.forEach((k,v) -> System.out.println(k+" " + v));
        
        System.out.println("---------------------------");
        //Ejemplo de uso en un proyecto multicultura
        Map<String,String> mapaDias = mapaDiasPor;
        System.out.println(mapaDias.get("monday"));
        System.out.println(mapaDias.get("friday"));
        
	}
	
}
