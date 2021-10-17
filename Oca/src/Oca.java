// Importamos Arrays para utilizar Arrays.sort() que ordena numeros enteros
import java.util.Arrays;

// Importamos Random para generar numeros aleatorios (dado())
import java.util.Random;
import java.util.Scanner;

// MENSAJE PARA JOSE MANUEL, EN LOS PAUSE PUEDES UTILIZAR CUALQUIER CARACTER MENOS (ª, ENTER DIRECTAMENTE) \\
//
// UN SALUDO :D

// ANGEL SOUSA NAVARRO \\

public class Oca {
	private static Scanner sc = new Scanner(System.in);
	// TAMAÑO DEL TABLERO (constante que guarda el tamaño del tablero)
	private static int TAMANO_TABLERO=8*8;
	
	// CASILLAS DE LA OCA (array que guarda las casillas de oca)
	private static int[] CASILLAS_OCA= new int[TAMANO_TABLERO];
	
	// POSICION INICIAL DE JUGADORES
	private static String jugadores[] = { "Azul", "Verde", "Rojo", "Naranja" };
	
	// POSICION FINAL (con caracteres)
	private static String ordenDefinitivo[] = new String[jugadores.length];;

	// CASILLAS DE JUGADORES
	private static int casillaAzul=1;
	private static int casillaVerde=1;
	private static int casillaRojo=1;
	private static int casillaNaranja=1;
	
	// POSICIONES DE LOS JUGADORES (decidirLugar)
	private static int posicionJugadores[] = {0,1,2,3};
	private static int posicionJugadoresProvisional[] = new int[posicionJugadores.length];
	private static int guardadoPosicion[] = new int[posicionJugadores.length];
	
	// POSICION FINAL(con enteros)
	private static int posicionJugadoresDefinitiva[]=new int[posicionJugadores.length];

	public static void main(String[] args) {
		boolean partidaFinalizada=false; //--> llevamos el control para finalizar la partida en el caso de que algun jugador gane
		
		// Primero decidimos cual es el orden de los jugadores
		decidirLugar();
		
		pausar();
		
		// Definimos las casillas de OCA
		definirCasillasOca();
		
		// BASE DEL JUEGO
		// mientras ningun jugador haya ganado el bucle continuará
		while (!partidaFinalizada) {
			
			// lo primero es un bucle que la longitud de los jugadores y con el orden correcto
			// para cada uno de los turnos
			for (int i=0;i<ordenDefinitivo.length && !partidaFinalizada;i++) {
				switch(ordenDefinitivo[i]) {
					
					// TURNO DEL JUGADOR AZUL
				
				// ATENTAMENTE: SOLO HE COMENTADO EL JUGADOR AZUL YA QUE EL RESTO DE JUGADORES TIENEN EL MISMO CÓDIGO \\
				
				
					case "Azul": 
						System.out.println();
						System.out.println("----------------------");
						System.out.println("Turno del jugador Azul");
						System.out.println("----------------------");
						pausar();
						System.out.println("Casilla actual: "+casillaAzul); //--> indicamos al jugador la casilla en la que se encuentra
						System.out.println();
						int tiradaAzul = dado(); // hacemos la tirada
						System.out.println("Has sacado un: "+tiradaAzul);//--> le indicamos la tirada	
						System.out.println();
						pausar();
						casillaAzul=casillaAzul+tiradaAzul;//--> le sumamos la tirara al numero de casillas 
						calavera(); //--> en el caso de que la casilla despues de la tirada sea la calabera, el jugador volvera a la casilla inicial
						
						// en el caso de que la casilla actual sea una casilla de la oca entonces -->
						while (determinarMultiplo(casillaAzul)) {
							System.out.println("Le ha tocado la OCA!");//--> le indicamos al jugador que le ha tocado en una casilla oca
							casillaAzul=siguienteCasillaOca(casillaAzul);//--> luego igualamos la casilla a la siguente casilla oca
							System.out.println("Ha avanzado a la casilla: "+casillaAzul); //--> le indicamos hasta donde ha avanzado
							pausar();
							System.out.println();
							System.out.println("OCA, OCA y tiro por que me toca!");
							tiradaAzul = dado();//--> hacemos una nueva tirada ya que le toco en una casilla oca
							System.out.println("Has sacado un: "+tiradaAzul);
							pausar();
							System.out.println();
							casillaAzul=casillaAzul+tiradaAzul;//--> sumamos la tirada a la casilla
							calavera(); //--> miramos nuevamente que en su nueva tirada no le haya tocado en la casilla calabera
							System.out.println("Ha avanzado a la casilla: "+casillaAzul);
							pausar();
							System.out.println();
							
							// en el caso de que en la nueva tirada no le haya tocado una casilla oca, salimos del bucle
							if(!determinarMultiplo(casillaAzul)) {
								break;
							}
						}
						
						// en el caso de que la casilla sea mayor o igual a las casillas del tablero,
						// concederiamos la victoria a dicho jugador y terminariamos la partida
						if (casillaAzul>=TAMANO_TABLERO) {
							partidaFinalizada=true;
							System.out.print("VICTORIA, HAS GANADO!!");
							break;
						}
						
						// le indicamos al jugador en la casilla que se ha quedado
						System.out.println("El jugador se queda en la casilla: "+casillaAzul);
						System.out.println("------------------------------------");
						
						pausar();
						break;
						
						// TURNO DEL JUGADOR VERDE
					case "Verde":
						System.out.println();
						System.out.println("-----------------------");
						System.out.println("Turno del jugador Verde");
						System.out.println("-----------------------");
						pausar();
						int tiradaVerde = dado();
						System.out.println("Casilla actual: "+casillaVerde);
						System.out.println();
						System.out.println("Has sacado un: "+tiradaVerde);	
						System.out.println();
						pausar();
						casillaVerde=casillaVerde+tiradaVerde;
						calavera();
						while (determinarMultiplo(casillaVerde)) {
							System.out.println("Le ha tocado la OCA!");
							casillaVerde=siguienteCasillaOca(casillaVerde);
							System.out.println("Ha avanzado a la casilla: "+casillaVerde);
							pausar();
							System.out.println();
							System.out.println("OCA, OCA y tiro por que me toca!");
							tiradaVerde = dado();
							System.out.println("Has sacado un: "+tiradaVerde);	
							pausar();
							System.out.println();
							casillaVerde=casillaVerde+tiradaVerde;
							calavera();
							System.out.println("Ha avanzado a la casilla: "+casillaVerde);
							pausar();
							System.out.println();
							if(!determinarMultiplo(casillaVerde)) {
								break;
							}
						}
						if (casillaVerde>=TAMANO_TABLERO) {
							partidaFinalizada=true;
							System.out.print("VICTORIA, HAS GANADO!!");
							break;
						}
						
							
						System.out.println("El jugador se queda en la casilla: "+casillaVerde);
						System.out.println("------------------------------------");
						pausar();
						break;
						
						// TURNO DEL JUGADOR ROJO
					case "Rojo":
						System.out.println();
						System.out.println("----------------------");
						System.out.println("Turno del jugador Rojo");	
						System.out.println("----------------------");
						pausar();
						int tiradaRojo = dado();
						System.out.println("Casilla actual: "+casillaRojo);
						System.out.println();
						System.out.println("Has sacado un: "+tiradaRojo);	
						System.out.println();
						pausar();
						casillaRojo=casillaRojo+tiradaRojo;
						calavera();
						while (determinarMultiplo(casillaRojo)) {
							System.out.println("Le ha tocado la OCA!");
							casillaRojo=siguienteCasillaOca(casillaRojo);
							System.out.println("Ha avanzado a la casilla: "+casillaRojo);
							pausar();
							System.out.println();
							System.out.println("OCA, OCA y tiro por que me toca!");
							tiradaRojo = dado();
							System.out.println("Has sacado un: "+tiradaRojo);	
							pausar();
							System.out.println();
							casillaRojo=casillaRojo+tiradaRojo;
							calavera();
							System.out.println("Ha avanzado a la casilla: "+casillaRojo);
							pausar();
							System.out.println();
							if(!determinarMultiplo(casillaRojo)) {
								break;
							}
						}
						if (casillaRojo>=TAMANO_TABLERO) {
							partidaFinalizada=true;
							System.out.print("VICTORIA, HAS GANADO!!");
							break;
						}
						System.out.println("El jugador se queda en la casilla: "+casillaRojo);
						System.out.println("------------------------------------");
						pausar();
						break;
						
					// TURNO DEL JUGADOR NARANJA
					case "Naranja":	
						System.out.println();
						System.out.println("-------------------------");
						System.out.println("Turno del jugador Naranja");
						System.out.println("-------------------------");
						pausar();
						int tiradaNaranja = dado();
						System.out.println("Casilla actual: "+casillaNaranja);
						System.out.println();
						System.out.println("Has sacado un: "+tiradaNaranja);	
						System.out.println();
						pausar();
						casillaNaranja=casillaNaranja+tiradaNaranja;
						calavera();
						while (determinarMultiplo(casillaNaranja)) {
							System.out.println("Le ha tocado la OCA!");
							casillaNaranja=siguienteCasillaOca(casillaNaranja);
							System.out.println("Ha avanzado a la casilla: "+casillaNaranja);
							pausar();
							System.out.println();
							System.out.println("OCA, OCA y tiro por que me toca!");
							tiradaNaranja = dado();
							System.out.println("Has sacado un: "+tiradaNaranja);
							pausar();
							System.out.println();
							casillaNaranja=casillaNaranja+tiradaNaranja;
							calavera();
							System.out.println("Ha avanzado a la casilla: "+casillaNaranja);
							pausar();
							System.out.println();
							if(!determinarMultiplo(casillaNaranja)) {
								break;
							}
						}
						if (casillaNaranja>=TAMANO_TABLERO) {
							partidaFinalizada=true;
							System.out.print("VICTORIA, HAS GANADO!!");
							break;
						}
						System.out.println("El jugador se queda en la casilla: "+casillaNaranja);
						System.out.println("------------------------------------");
						pausar();
						break;
					}
				
				}
		}
		sc.close();
	}

		// M E T O D O S //
	
	
	// En este metodo vamos a ordenar el array jugadores
	// cambiando el orden en funcion del numero que saque cada jugador
	// así guardaremos el orden de tirada 
	public static void decidirLugar() {

		// Declaramos las arrays
		int tiradas[] = new int[jugadores.length]; //--> se guarda la primera tirada
		int jugadoresNuevaTirada[] = new int[jugadores.length]; //--> guarda los jugadores que debera repetir la tirada 
		int arrayOrden[] = new int[jugadores.length]; //--> guarda lo mismo que tirada pero ordenada
		boolean validador;
		

		System.out.println("--------------");
		System.out.println("PRIMERA TIRADA");
		System.out.println("--------------");

		// llamamos al metodo tirada, el cual nos genera 1 numero aleatorio
		// entre el 1 y el 6 (incluyendolos)
		tirada(tiradas);

		// Mostramos la tirada
		mostrarTirada(tiradas);
		
		// llamamos al metodo elementosRepetidos el cual devuelve un boolean, y lo guardamos en nuestra variable
		// lo que hacemos es mirar si hay elementos repetidos que lo compararemos a continuacion
		validador = elementosRepetidos(tiradas);
		
		// llamamos al metodo repetido el cual nos dice los la posicion jugadores que tienen 
		// que repetir la tirada y lo guardamos en nuestra array
		jugadoresNuevaTirada = repetido(tiradas);
		
		// guardamos la tirada ordenada en arrayOrden
		guardarTirada(tiradas, arrayOrden);
		
		// ordenamos las posiciones y la añadimos a el array posicionJugadoresProvisional 
		ordenarPosiciones(tiradas, arrayOrden);
		
		// Tenemos que guardar la primera tirada
		guardadoPosicion=posicionJugadoresProvisional;

		// En el caso de que no haya ninguno repetido lo guardamos en el orden correcto;
		if (validador == false) {
			System.out.println();
			System.out.println("----------------------");
			System.out.println("POSICIONES DEFINITIVAS");
			System.out.println("----------------------");
			
			// guardamos los jugadores ya con sus nombre y lo mostramos
			ordenDefinitivo = devolverPosiciones(posicionJugadoresProvisional);
			mostrar(ordenDefinitivo);
		} 
		// en el otro caso tenemos que hacer la tirada solo para los jugadores que
		// hayan repetido de numero
		else {			
			int tiradaRepetida[] = new int[jugadoresNuevaTirada.length]; //--> contendrá la nueva tirada
			int ordenRepetida[] = new int[jugadoresNuevaTirada.length]; //--> contendrá la nueva tirada ordenada
			int jugadoresRepetida[] = new int[jugadoresNuevaTirada.length]; //--> contendrá los jugadores de que repitieron numero de la primera tirada
			int[] jugadoresSobreescribir; 
			jugadoresRepetida = jugadoresNuevaTirada; //--> Igualamos los jugadores de la primera tirada para guardarlos en otra array
		
			// mientras haya valores repetidos seguiremos en el bucle
			// en caso contrario saldremos
			while (validador == true) {

				System.out.println();
				System.out.println("---------------");
				System.out.println("TIRADA REPETIDA");
				System.out.println("---------------");
				
				// Hacemos la nueva tirada
				tirada(tiradaRepetida);
				// Mostramos la tirada repetida
				for (int i = 0; i < jugadoresNuevaTirada.length; i++) {
					System.out.print("Tirada del jugador: " + jugadores[jugadoresRepetida[i]]);
					System.out.println(" = " + tiradaRepetida[i]);
				}
				// Se valida si hay repetidos despues de la tirada
				validador = elementosRepetidos(tiradaRepetida);
				
				// se buscan los nuevos jugadores que han repetido (En el caso que los haya)
				jugadoresNuevaTirada = repetido(tiradaRepetida);
			}
			
			// cuando ya no haya mas numeros repetidos tendremos que guardar las posiciones finales
			if (validador == false) {
				guardarTirada(tiradaRepetida,ordenRepetida); //--> ordenamos la nueva tirada
				
				System.out.println();
				System.out.println("--------------------------------");
				System.out.println("RESOLUCIÓN DE LA TIRADA REPETIDA");
				System.out.println("--------------------------------");
				ordenarPosiciones(tiradaRepetida, ordenRepetida); //--> ordenamos la nueva tirada y lo añadimos a posicionJugadoresProvisional
				
				// primer bucle para mostrar los jugadores en el orden correcto
				for (int i = 0; i < posicionJugadoresProvisional.length; i++) {
					System.out.print(i + 1 + ") ");
					System.out.println(jugadores[jugadoresRepetida[posicionJugadoresProvisional[i]]]);
				}
				
				jugadoresSobreescribir=new int[posicionJugadoresProvisional.length]; //--> le añadimos la misma longitud que jugadores haya
				// segundo bucle para añadir dichos jugadores a nuestro array jugadoresSobreescribir
				for (int i = 0; i < posicionJugadoresProvisional.length; i++) {
					jugadoresSobreescribir[i]=jugadoresRepetida[posicionJugadoresProvisional[i]];
				}		
				
				pausar();
				
				System.out.println("----------------------");
				System.out.println("POSICIONES DEFINITIVAS");
				System.out.println("----------------------");
				
				// sobrescribimos los jugadores en el orden correcto segun su ultima tirada
				sobrescribir(jugadoresSobreescribir);
				
				// llamamos al metodo que nos cambia las posiciones por el nombre de los jugadores
				ordenDefinitivo = devolverPosiciones(posicionJugadoresDefinitiva);
				
				// mostramos el resulado
				mostrar(ordenDefinitivo);
			}
		}
	}

	// Metodo que genera un numero aleatorio entre el 1 y 6, incluyendo a ambos
	public static int dado() {
		Random r = new Random(); // --> creamos una variable de tipo RANDOM
		int num = r.nextInt(6) + 1; // --> luego generamos un numero del 1-6 incluyendolos y lo retornamos
		return num;
	}

	// Buscar los numeros repetidos y devolver los jugadores que tienen que repetir
	// la tirada
	public static int[] repetido(int array[]) {
		int posi[] = new int[array.length];
		int cont = 0; // --> inicializamos el contador para saber cuantos valores hay
		
		// bucle para asignar todos los valores de el array en -1
		for (int i = 0; i < posi.length; i++) {
			posi[i] = -1;
		}

		// dos bucles para la compracion de la misma array
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) { // --> j = i+1 para que no se compare a si mismo
				if (array[i] == array[j]) {
					if (!contieneElemento(posi, i)) { // --> en el caso que no contenga el elemento lo añade
						posi[cont++] = i;
					}
					if (!contieneElemento(posi, j)) { // --> en el caso que no contenga el elemento lo añade
						posi[cont++] = j;
					}
				}
			}
		}
		
		// creamos un nuevo array de longitud contador para que tenga la longitud exacta a los valores
		int ultArray[] = new int[cont];

		// Luego le introducimos los valores
		for (int i = 0; i < cont; i++) {
			ultArray[i] = posi[i];
		}
		return ultArray;
	}

	// metodo que devuelve true si hay elementos repetidos en la misma array
	public static boolean elementosRepetidos(int array[]) {
		boolean validador = false;

		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) { // --> J la iniciamos en i + 1 para que siempre mire el próximo valor
				if (array[i] == array[j]) { //--> en el caso de que haya otro valor igual 
					validador = true; // --> devolverá true
					break;
				}
			}
		}
		return validador;
	}

	// Metodo que devuelve un booleano en el caso que contenga el valor indicado
	// dentro del array introducido
	public static boolean contieneElemento(int[] array, int elemento) {
		boolean encontrado = false;

		for (int i = 0; i < array.length && !encontrado; i++) {
			if (array[i] == elemento) {
				encontrado = true;
			}
		}
		return encontrado;
	}

	// metodo que hace una tirada de x jugadores
	public static void tirada(int array[]) {
		for (int i = 0; i < array.length; i++) {
			array[i] = dado();
		}
	}
	
	// Imprime la tirada introducida
	public static void mostrarTirada(int array[]) {
		for (int i = 0; i < jugadores.length; i++) {
			System.out.print("Tirada " + jugadores[i]);
			System.out.println(" = " + array[i]);
		}
	}

	// Metodo que te guarda las tiradas ya ordenadas.
	public static void guardarTirada(int array[], int array2[]) {
		for (int i = 0; i < array.length; i++) {
			array2[i] = array[i];
		}
		Arrays.sort(array2);
	}

	// Metodo en el cual se introducen un array sin ordenar, un array ordenado y la posicion
	// de los jugadores, y su funcion es ordenar adecuadamente las posiciones introducidas.
	// no devuelve nada ya que modifica las arrays introducidas
	public static void ordenarPosiciones(int cruda[], int ordenada[]) {
		int arrayAux[] = new int[cruda.length]; //--> creamos un array auxiliar donde iran las posiciones
		int contador = 0; 
		int[] crudaLocal=cruda; //--> creamos un array local la cual contendrá cruda, la razon es para no modificar cruda directamente
		int cont = 0; //--> contador para que los valores se vayan introduciendo en orden
		
		for (int i = 0; i < ordenada.length; i++) {
			contador = 0;
			for (int x = 0; x < cruda.length; x++) {				
				if (crudaLocal[x] == ordenada[i]) {
					arrayAux[cont++] = contador;
					crudaLocal[x]=-1; //--> igualamos 
					break;
				}
				contador++; //--> llevamos la cuenta de las iteraciones que hace el bucle hasta el valor
			}
		}
		posicionJugadoresProvisional=new int[arrayAux.length];
		
		cont=0;
			for (int i = posicionJugadoresProvisional.length - 1;i >= 0; i--) {
				posicionJugadoresProvisional[cont++] = posicionJugadores[arrayAux[i]];
			}
	}

	// Imprime el resultado de las tiradas
	public static void mostrar(String newArray[]) {
		for (int i = 0; i < newArray.length; i++) {
			System.out.print(i + 1 + ") ");
			System.out.println(newArray[i]);
		}
	}
	
	// Metodo que devuelve los nombres de los jugadores introducidos
	public static String[] devolverPosiciones(int[] array) {
		String[] arrayAux = new String[array.length];
		
		// Bucle para recorrer todo el array
		for (int i=0;i<array.length;i++) {
			switch(array[i]) {
				
			case 0:
				arrayAux[i]="Azul";
				break;
				
			case 1:
				arrayAux[i]="Verde";
				break;
				
			case 2:
				arrayAux[i]="Rojo";
				break;
			
			case 3:
				arrayAux[i]="Naranja";
				break;
			}
		}
		return arrayAux;
	}
	
	// Metodo que introduciendo los jugadores que tienen que repetir la tirada
	// te ordene en el orden correcto las posiciones finales
	public static void sobrescribir(int[] jugadoresOrdenada) {
		// Declaramos un contador para ir recorriendo el array jugadoresOrdenada del primer valor
		// al ultimo, teniendo en cuenta que las posiciones de dicho array estan ya ordenadas
		int cont=0;

		// Hay que hacer dos bucles FOR anidados ya que queremos comparar dos array
		for (int i=0;i<guardadoPosicion.length;i++) {
			for (int x=0;x<jugadoresOrdenada.length;x++) {
				
				// En el caso de que el numero guardadoPosicion[i] sea igual a jugadoresOrdenada[x]
				// entramos al if
				if (guardadoPosicion[i]==jugadoresOrdenada[x]) {
					
					// En el caso de que la posicion de alguno de los jugadores sea cont entonces 
					// añadimos la posicion del array jugadoresOrdenana a nuestra nueva array
					// en caso contrario, la añadiremos igualmente ya que al ser la misma poscion
					// no influye en el resultado
					if (x==cont) {
						posicionJugadoresDefinitiva[i]=jugadoresOrdenada[cont++];
						break;
					}
					else {
						posicionJugadoresDefinitiva[i]=jugadoresOrdenada[cont++];
						break;
					}
				}
				else {
					posicionJugadoresDefinitiva[i]=guardadoPosicion[i];

				}
			}
		}
	}
	
	// Metodo para definir las casillas de la oca
	public static void definirCasillasOca() {
		// Establecemos un contador para ir añadiendo valores en orden
		int contador=0;
		
		// buscamos los valores multiplos de 4 y los guardamos en la array auxiliar
		for (int i=4;i<=TAMANO_TABLERO;i++) {
			// si el resto es 0 significa que es multiplo de 4
			if (i%4==0) {
				CASILLAS_OCA[contador++]=i;
			}
		}
	}
	
	// metodo el cual se le introduce la casilla y devuelve si dicha casilla es una casilla de oca
	// en caso afirmativo devuelve true
	public static boolean determinarMultiplo(int casilla) {
		boolean validador=false;
		int i=0;
		
		while (!validador && i<CASILLAS_OCA.length) { // --> mientras validador sea falso y no supere la longitud de las casillas de oca, seguira el bucle
			if (casilla==CASILLAS_OCA[i++]) { // --> comparamos la casilla con las casilla de oca
				validador=true; // --> lo convertimos a true en caso afirmativo
			}
		}
		return validador; // --> devolvemos el booleano
	}
	
	// metodo que lee la casilla actual y devuelve la siguente casilla de oca
	public static int siguienteCasillaOca(int casilla) {
		int valor=0;

		for(int i=0;i<CASILLAS_OCA.length;i++) {
			if (casilla==CASILLAS_OCA[i]) { //--> comparacion de la casilla con las casillas de la oca
				valor=CASILLAS_OCA[i+1];//--> en caso afirmativo guardamos la siguiente casilla de oca
			}
		}
		return valor;//---> devolvemos la casilla de oca en cuestion
	}
	
	// metodo el cual acepta cualquier caracter menos ª y caracteres especificos
	public static void pausar() {
		
		System.out.println();
		//System.out.print("Pulse el espacio y seguidamente el enter para continuar.. ");
		char valor = sc.nextLine().charAt(0);
		if (valor!='ª') {
		}
	}
	
	// metodo el cual iguala la casilla del jugador a 1 en el caso de que dicha 
	// casilla llegue a la antepenultima casilla
	public static void calavera() {
		if (casillaAzul==TAMANO_TABLERO-3) {
			casillaAzul=1;
			System.out.println("Ooh, has caido en la casilla calavera, vuelves a la casilla 1");
		}
		else if (casillaVerde==TAMANO_TABLERO-3) {
			casillaVerde=1;
			System.out.println("Ooh, has caido en la casilla calavera, vuelves a la casilla 1");
		}
		else if (casillaRojo==TAMANO_TABLERO-3) {
			casillaRojo=1;
			System.out.println("Ooh, has caido en la casilla calavera, vuelves a la casilla 1");
		}
		else if (casillaNaranja==TAMANO_TABLERO-3) {
			casillaNaranja=1;
			System.out.println("Ooh, has caido en la casilla calavera, vuelves a la casilla 1");
		}
	}
}
