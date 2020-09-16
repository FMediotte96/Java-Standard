package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainAdvanced {
	
	public static void main(String[] args) {
		
		//REDUCTION
		
		/* Ejemplo 1:
		 * 1. Generamos una lista myList
		 * 2. Convierto la lista en Stream. Le aplico un filtro por el cual el stream "s" comience con la letra "c".
		 * 3. Se mapea esa información y se convierte a Mayuscula
		 * 4. Finalmente se muestra por consola a traves de un forEach()
		 */
		System.out.println("------------Ejemplo 1 --------------");
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		
		myList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase)
			.sorted().forEach(System.out::println);
		
		//Ejemplo 2:
		//En el rango de -2 y 4 excluyente mostramos los nros por consola
		System.out.println("------------Ejemplo 2 --------------");
		IntStream.range(-2, 4).forEach(System.out::println);
		
		
		/* Ejemplo 3:
		 * Toma una lista de tres valores, retorna un stream de esa lista. 
		 * Encuentra el primer valor y si esta presente lo muestra por consola
		 */
		System.out.println("------------Ejemplo 3 --------------");
		Arrays.asList("a1","a2","a3").stream().findFirst().ifPresent(System.out::println);
		
		/* Ejemplo 4
		 * Conversión de dobles a enteros
		 */
		System.out.println("------------Ejemplo 4 --------------");
		Stream.of(1.0, 2.0, 3.0).mapToInt(Double::intValue).mapToObj(i -> "a" + i).forEach(System.out::println);
		
		/* Ejemplo 5
		 * Stream de enteros cuyos elementos son el num de caracteres de los paises
		 * La lista de países es devuelta como Stream (conteniendo Strings).
		 * Convierte a enteros los length de los String de los nombres de los países
		 */
		System.out.println("------------Ejemplo 5 --------------");
		List<String> paises = Arrays.asList("Colombia", "Mexico", "Guatemala");
		IntStream valor = paises.stream().mapToInt(String::length);
		valor.forEach(System.out::println);
		
		/* Ejemplo 6
		 */
		System.out.println("------------Ejemplo 6 --------------");
		Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> {
			System.out.println("filter: " + s);
			return true;
		}).forEach(s -> System.out.println("forEach: " + s));
		
		/* Ejemplo 7
		 * Filtrar los elementos que empiecen con a
		 */
		System.out.println("------------Ejemplo 7 --------------");
		Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> s.startsWith("a"));
		stream.forEach(System.out::println);
		
	}

}
