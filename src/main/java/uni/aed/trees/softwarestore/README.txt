Caso 1 (Ejercicio3 Drozdek.Cap6-sofware-store)
1)Implementar un programa basado en menús para administrar una tienda de software. 
2)Toda la información sobre el software disponible se almacena en un archivo de software. 
Esta información incluye el nombre, la versión, la cantidad y el precio de cada paquete. 
3)Cuando se invoca, el programa crea automáticamente un árbol de búsqueda binario con un nodo correspondiente 
a un paquete de software e incluye como clave el nombre del paquete y su versión.
Otro campo en este nodo debe incluir la posición del registro en el software del archivo. 
4)El único acceso a la información almacenada en el software debe ser a través de este árbol.
5)El programa debería permitir que el archivo y el árbol se actualicen 
cuando 5.1)lleguen nuevos paquetes de software a la tienda 
y cuando 5.2)se vendan algunos paquetes. 
El árbol se actualiza de la forma habitual. 
Todos los paquetes están ordenados por entrada en el software de archivos; 
6)si llega un nuevo paquete, se coloca al final del archivo. 
7)Si el paquete ya tiene una entrada en el árbol (y el archivo), solo se actualiza el campo de cantidad. 
8)Si un paquete está agotado, el nodo correspondiente se elimina del árbol y el campo de cantidad en el archivo cambia a 0. 

Por ejemplo, si el archivo tiene estas entradas:
Adobe Photoshop         7.0	21	580
Norton Utilities	1.0	10	30
Norton SystemWorks 2003	1.0	6	50
Visual J++ Professional 6.0 	19	100
Visual J++ Standard	6.0	27	40

Luego, después de vender las seis copias de Norton SystemWorks 2003, el archivo es:
Adobe Photoshop         7.0	21	580
Norton Utilities	1.0	10	30
Norton SystemWorks 2003	1.0	0	50
Visual J++ Professional	6.0	19	100
Visual J++ Standard	6.0	27	40

9)Si se elige una opción de salida del menú, 
el programa limpia el archivo moviendo las entradas desde el final del archivo 
a las posiciones marcadas con cantidades 0. 
Por ejemplo, el archivo anterior se convierte en:

Adobe Photoshop         7.0	21	580
Norton Utilities	1.0	10	45
Visual J++ Standard	6.0	19	40
Visual J++ Professional	6.0	27	100


*Antes de realizar sus pruebas de funcionamiento del programa, mantenga una copia del archivo software.txt