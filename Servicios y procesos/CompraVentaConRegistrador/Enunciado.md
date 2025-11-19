# Juego: "Compra y venta de artículos"
### Creación de hilos, sección crítica con lock, sockets

## Objetivo del juego:

Varios jugadores (procesos) compiten por comprar y vender artículos almacenados en un archivo compartido. Los artículos tienen un precio fijo (que no es tenido en cuenta) y los jugadores pueden comprar o vender estos artículos, modificando la cantidad disponible de cada uno en el archivo. Sin embargo, deben sincronizar su acceso al archivo para evitar que dos jugadores intenten modificar la cantidad del mismo artículo al mismo tiempo.

## Reglas del juego:

- El archivo compartido contiene una lista de artículos con su cantidad disponible y un precio fijo. Ejemplo: "Artículo 1:   5 unidades, precio 10.".
- Los jugadores (procesos) pueden comprar artículos (restando 1 unidad de la cantidad disponible) o vender artículos (añadiendo 1 unidad a la cantidad disponible), dependiendo de una acción aleatoria que decidan hacer.
- Los jugadores no pueden comprar más artículos de los que hay disponibles.
- El registrador es un proceso servidor que gestionará las peticiones de conexión de los procesos jugadores para permitir registrar en un archivo cada transacción (de compra o venta) que haga un jugador.


## Estructura del proyecto:

1. 'CompraVenta' es el proceso principal: Este proceso inicializa el archivo con varios artículos (cada uno con una cantidad y un precio) y lanza varios procesos concurrentes (jugadores) que intentan comprar y vender artículos. También lanza el servidor Registrador.
2. 'Jugador' (proceso concurrente que compra o vende artículos): Cada jugador toma una acción aleatoria (comprar o vender), actualiza el archivo en consecuencia, y comunica la transacción a un ManejadorRegistroJugador.
3. 'Registrador' es un proceso servidor que atenderá las peticiones de conexión de los procesos jugadores. Cada conexión nueva con un Jugador será atendida por 'ManejadorRegistroJugador' en una hebra nueva. 
4. 'ManejadorRegistroJugador' recibe y registra en un archivo las operaciones realizadas por los Jugadores.


## Entrega del proyecto:

- Completa los TODOs del código de partida adjunto.
- Realiza pruebas.
- Borra los archivos '.class' de la carpeta 'bin'.
- Comprime la carpeta que contiene todo tu proyecto en un único archivo ZIP y súbelo a la plataforma. 
