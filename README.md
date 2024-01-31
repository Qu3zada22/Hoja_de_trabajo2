# Hoja_de_trabajo2
# Calculadora Postfix con Pila (Stack) - Proyecto UVG

## Descripción

Este proyecto implementa una calculadora que evalúa expresiones en formato postfix utilizando una pila (stack). También incluye una interfaz para la manipulación de pilas genéricas.

## Componentes del Proyecto

### LectorArchivo

La clase `LectorArchivo` se encarga de leer expresiones postfix desde un archivo de texto. Utiliza un `BufferedReader` para leer las líneas del archivo y devuelve una lista de expresiones.

### PostfixCalculator

La clase `PostfixCalculator` realiza el cálculo de expresiones en formato postfix. Utiliza una pila interna para realizar las operaciones y manejar los operandos y operadores.

### Stack

La clase `Stack` implementa una pila genérica utilizando una lista enlazada. También implementa la interfaz `UVGStack` que define las operaciones básicas de una pila.

### UVGStack

La interfaz `UVGStack` define las operaciones básicas de una pila genérica, incluyendo `push` (agregar), `pop` (quitar de la cima), `top` (ver la cima) y `isEmpty` (verificar si está vacía).

## Uso del Programa

El programa principal se encuentra en la clase `Main`. Lee expresiones desde un archivo utilizando la clase `LectorArchivo`, luego utiliza la `PostfixCalculator` para evaluar y calcular los resultados de estas expresiones.