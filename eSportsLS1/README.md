## eSportsLS I [Ordenación mediante recursividad]
Este proyecto, denominado "eSports La Salle," es un ejercicio práctico que se centra en la implementación de algoritmos de ordenación en el lenguaje de programación Java utilizando IntelliJ IDEA como el entorno de desarrollo. El objetivo del proyecto es ordenar equipos y jugadores de League of Legends con base en diferentes criterios. Además, se proporciona una comparativa de los tiempos de ejecución de los algoritmos de ordenación utilizados en función del tamaño de los conjuntos de datos.
### Algoritmos de Ordenación Implementados:
- QuickSort: Este algoritmo de ordenación se basa en el principio de "divide y vencerás." Divide el array en subarrays más pequeños y ordena estos subarrays recursivamente. Los elementos se comparan con un "pivot" y se ubican en el lado izquierdo o derecho según su relación con el pivot.
- MergeSort: Este método también se basa en la estrategia "divide y vencerás." Divide el array en dos subarrays del mismo tamaño y los ordena por separado de forma recursiva. Luego, combina los subarrays ordenados en un solo array ordenado.
- BucketSort: Este algoritmo distribuye los elementos del array en "casillas" según criterios específicos, luego ordena cada casilla de forma individual utilizando otro algoritmo de ordenación, en este caso, el InsertionSort.
- RadixSort: RadixSort es un método de ordenación por residuos. Los elementos se almacenan en una estructura temporal y se recopilan en el orden correcto en el array original. La eficiencia de RadixSort depende del número de elementos a ordenar y del número de dígitos del elemento más grande en el array.
### Comparativas:
Se realiza una comparativa de rendimiento de los algoritmos de ordenación implementados en función del tamaño de los conjuntos de datos. Los resultados se presentan en forma de tabla y gráficos. Se ha realizado un análisis detallado de los tiempos de ejecución para diferentes tamaños de datos, destacando que algunos algoritmos funcionan de manera más eficiente que otros en ciertos escenarios.
### Herramientas usadas:
El proyecto se desarrolló en Java utilizando el entorno de desarrollo IntelliJ IDEA. IntelliJ IDEA facilitó el desarrollo al ofrecer características como autocompletado de código, integración con control de versiones y soporte para una amplia variedad de tecnologías.

El proyecto fue probado utilizando la depuración y se realizaron pruebas con diferentes conjuntos de datos para garantizar el correcto funcionamiento de los algoritmos.
