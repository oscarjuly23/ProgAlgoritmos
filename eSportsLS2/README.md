# eSportsLS II [Optimización combinatoria]
eSports La Salle es un proyecto académico que aborda la organización de competiciones de League of Legends. El objetivo principal es distribuir equipos en grupos para la fase inicial del torneo y organizar servicios para los jugadores. Se utilizan varios algoritmos, incluyendo Backtracking, Branch & Bound y Greedy, para abordar diferentes desafíos.
## Algoritmos implementados:
### Backtracking
- Abordaje recursivo de problemas.
- Se construye una solución de manera incremental.
- Se eliminan soluciones inválidas.
- Conceptos clave incluyen configuración, solución factible/no factible, marcatge/desmarcatge y búsqueda de la mejor solución.
### Branch & Bound
- Variante mejorada del Backtracking.
- Utilizado para problemas de optimización.
- Se crea un árbol de soluciones y se realiza la poda de ramas no óptimas.
### Greedy
- Utilizado en situaciones donde la solución óptima no es necesaria.
- Prioriza un menor costo computacional y busca una solución sin mirar hacia atrás.
## Problemas Abordados:
- Menú Equilibrado: Creación de un menú nutricionalmente equilibrado para alimentar a los jugadores, optimizando la ingesta de calorías y grasas.
- Fase de Grupos: Distribución de equipos en grupos teniendo en cuenta las fortalezas y debilidades de los personajes de los jugadores. Se prioriza que los equipos españoles tengan más probabilidades de ganar.
## Conclusiones:
- Backtracking logra soluciones óptimas, pero es menos eficiente debido a su complejidad.
- Branch & Bound mejora la eficiencia al ordenar las configuraciones según el valor a minimizar.
- Greedy proporciona soluciones válidas, aunque no necesariamente óptimas, pero con un menor costo computacional.
