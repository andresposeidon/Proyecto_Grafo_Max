Proyecto_Grafo_Max
==================

Proyecto de Paradigmas de Programación 2012.

1- Alcances
Proyect Grafo Max es un software desarrollado para que los usuarios puedan crear, editar, manipular y guardar grafos en forma sencilla y segura.
        Para iniciar la manipulación de este software se debe crear un nodo la cual al instante el usuario podrá disponer de la matriz de adyacencia, información y algoritmos sobre los caminos que posee cada nodo.

2 Objetivo del software
El objetivo principal del software es lacreación de un editor simple de grafos confuncionalidades básicas para crear, modificar y el guardar los trabajos realizados en este editor. El software posee opciones gráficas para el dibujo de grafos como tambiénpara la edición de los nodos  y de sus partes, esto se refiere al cambio de forma de los nodos, etiquetas, posiciones, peso de las aristas, colores y  tamaños. El software genera de manera automática la matriz de adyacencia asociada al grafo creado. Finalmente entrega información sobre el grafo construido la cual da a conoceral usuario el grado de sus vértices, si el grafo es conexo, dirigido, bipartito y los caminos: mínimo, eulerianos y hamiltonianos.

3- Descripción Global del Producto
3.1- Interfaz de usuario
Proyect Grafo Max posee una interfaz fácil de utilizar pensado para cualquier tipo de usuario la cual contiene una gran variedad de herramientas para crear y modificar grafos,además de iconos para mostrar resultados de los grafos creados y todo esto ubicados en el sector izquierdo de la pantalla(barra menú icono), la cual además consta de información de la  utilidad de cada icono para guiar a los usuarios sobre todo a los más inexpertos o desconocedores de este software.
        En el sector  derecho de la pantalla se  muestran los distintos resultados de los grafos creados como matriz de adyacencia, caminos (mínimos, eulerianos y hamiltonianos).
El software cuenta con un menú desplegable la cual presenta todas las funciones que posee el software, nombrando algunas de ellas por ejemplos sería crear, guardar mostrar matriz, editar, herramientas(obtener diámetro, colorear, entre otras), algoritmos y finalmente ayuda.


4- Requerimientos Específicos.
4.1- Requerimientos Funcionales Del Sistema

Id	Nombre	Descripción
R01	Editar Grafos	
R. 01.1	Abrir Grafo	El software abre archivo existente
R. 01.2	Nuevo grafo	El software crea un nuevo archivo
R. 01.3	Guardar Grafo	El software guarda un archivo
R. 01.4	Eliminar Grafo	El software elimina un archivo 
R. 02	Editar  Vértices	Edita los vértices del grafo
R. 02.1	Agregar Vértice	Agrega un nuevo vértice al grafo
R. 02.2	Eliminar Vértice	Elimina un vértice del grafo
R. 02.3	Desplazar vértice	Desplaza un vértice en distintas posiciones
R. 02.4	Modificar Vértice	Modifica color,tamaño y forma del vértice
R. 03	Editar  Arista	Edita las aristas del grafo
R. 03.1	Agregar Arista	Agrega una nueva artistaal grafo
R. 03.2	Eliminar Arista	Elimina unaarista del grafo
R. 03.3	Desplazar Arista	Desplaza una arista en distintas posiciones
R. 03.4	Modificar Arista	Modifica color,tamaño y forma delaarista
R. 04	Imprimir	Imprime el grafo creado
R. 05	Visualizar/
Ocultar	Habilita o deshabilita:
1-matriz de adyacencia
2-cuadriculado de fondo para lienzo del dibujo
3-tabla de grados asociado a cada vértice
4-las propiedades que el grafo cumple
R.06	Gestionar Acciones	Deshace o rehace acciones
R.07	Guardar Como	Exporta un grafo a diversos formatos
R.08	Cortar, Copiar y Pegar	Corta, copia y/o pega secciones seleccionados del grafo 
R.09	Mostrar Bipartito	Muestra gráficamente y además en una tabla los vértices que componen cada conjunto y señala si es grafo bipartito o bipartito completo
R10	Mostrar Ciclos Eulerianos 	Muestra todos los ciclos Eulerianos que existen en el grafo, indicando distancia de recorrido
R.11	Mostrar caminos Hamiltonianos	Muestra todos los ciclos Hamiltonianos que existen en el grafo, indicando distancia de recorrido
R.12	Mostrar Caminos/ciclos	Presenta gráficamente (paso a paso, pintando las aristas) los caminos o ciclos que existen entre dos vértices 
R13	Edición de 
grafos 	Permite ver propiedades del grafo: tabla de grados, completitud, bipartito, conexo, ciclos eulerianos, caminos Hamiltonianos, alinear grafo.
R.14	Mostrar si es conexo	Muestra si el grafo es conexo y si lo es de que tipo de conexo se trata(fuertemente, unilateralmente, débilmente).
R.15	Colorear grafos	Presenta gráficamente el coloreo de un grafo
R.16	Informar Diametro de Grafo	Muestra la mayor distancia entro todos los pares de nodos
R17	Mostrar Árbol Binario	Informa si el grafo se trata de un árbol binario o no, si lo es lo alinea y muestra altura y recorridos tales como: PreOrden, InOrden, PostOrden. 
R.18	Aplicar algoritmo Dijkstra	Determina el camino mas corto en un grafo. 
R.19	Aplicar Algoritmo Kruskal	Encuentra un árbol recubridor mínimo en un grafo conexo ponderado.
R.20	Aplicar algoritmo Prim	Encuentra un árbol recubridor mínimo en un grafo conexo ponderado. 

