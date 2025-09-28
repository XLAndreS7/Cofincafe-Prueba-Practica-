Cofincafe – Prueba Practica 

El objetivo fue implementar operaciones sobre una lista de clientes de una microfinanciera.
Cada cliente tiene: id, nombre y balance.

Se hicieron:

1.Método para obtener clientes con balance negativo.

2.Método para obtener el Top 3 de clientes con mayor balance.

3.Conversión de las listas a JSON usando Jackson.

4.Pruebas unitarias con JUnit 5 para validar los resultados.

Solucion de la Prueba Practica:
Lista de Negativos:
[ {
  "id" : 2,
  "nombre" : "Adriana Falla",
  "balance" : -200.00
}, {
  "id" : 5,
  "nombre" : "Alejandra Sarmiento",
  "balance" : -10.50
} ]

Lista del Top 3:
[ {
  "id" : 3,
  "nombre" : "Luisa Nieto",
  "balance" : 9800.10
}, {
  "id" : 4,
  "nombre" : "Juan David",
  "balance" : 2500.00
}, {
  "id" : 1,
  "nombre" : "Andres Ospina",
  "balance" : 1500.75
} ]


Solucion de las preguntas teoricas:

Pregunta #1:
. Diferencias entre HashMap y ConcurrentHashMap, y entre List, Set y Map

HashMap: no es thread-safe, varios hilos pueden causar inconsistencias.

ConcurrentHashMap: diseñado para concurrencia, divide internamente los buckets para permitir acceso seguro.

List: colección ordenada con duplicados.

Set: colección sin duplicados, orden no garantizado.

Map: pares clave-valor, claves únicas.

Pregunta #2. ¿Qué es un Optional en Java y para qué sirve?
Es un contenedor para valores que pueden ser nulos. Evita NullPointerException y obliga a manejar explícitamente la ausencia de valores.

Pregunta #3. ¿Cómo manejar excepciones en un servicio que accede a base de datos?

Usar try-catch.

Definir excepciones personalizadas.

Registrar con logs (SLF4J, Logback).

Transformar el error en una respuesta clara (404, 500).

Pregunta #4. Diferencia entre @Component, @Service y @Repository en Spring

@Component: bean genérico de Spring.

@Service: indica lógica de negocio.

@Repository: capa de persistencia; traduce excepciones a DataAccessException.

Pregunta #5. En Fineract, el backend expone una API REST: ¿cómo mapeamos un endpoint?

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable Long id) {
        // Logica para buscar cliente por id
    }

    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        // Logica para crear cliente
    }
}

