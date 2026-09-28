package e2;
public class Distance {

    /**
     * Función principal del ejercicio.
     * Aplica las reglas de sentarse y levantarse hasta que el aula se estabiliza.
     */
    public static char[][] seatingPeople(char[][] layout) {

        // Validación layaout (el parámetro)
        validateLayout(layout);

        // Copiamos el layout inicial para trabajar sobre él
        char[][] current = copy(layout);

        while (true) {
            // Calculamos la siguiente iteración sin modificar la actual
            char[][] next = computeNext(current);

            // Si no hay cambios (si next es igual que current) , hemos llegado al estado final
            if (areEqual(current, next)) {
                return next;
            }

            // Si hay cambios, seguimos iterando
            current = next;
        }
    }

    /**
     * Comprueba que el layout es válido:
     * - No es null
     * - No es ragged (todas las filas tienen la misma longitud / es una matriz regular)
     * - Solo contiene '.' o 'A'
     */

    // La función es private en vez de public ya que es una función interna que ayuda a la principal (public función)
    private static void validateLayout(char[][] layout) {
        if (layout == null) {
            throw new IllegalArgumentException("Layout null");
            // Si el aula no existe devuelve error
        }

        int cols = layout[0].length; // guarda cuantás columnas tiene la primera fila

        for (char[] row : layout) { // fila por fila revisando el aula

            // Si el número de columnas no coincide con la primera -> ERROR: matriz irregular
            if (row.length != cols) {
                throw new IllegalArgumentException("Layout ragged"); // ragged = irregular
            }

            // Revisamos los carácteres
            for (char c : row) {
                // Si un carácter es diferente a  "." o "A" entonces devuelve error
                if (c != '.' && c != 'A') {  // "#" no puede aparecer en la matriz entrada tampoco
                    throw new IllegalArgumentException("Invalid character: " + c);
                }
            }
        }
    }

    /**
     * Crea una copia del layout.
     */
    private static char[][] copy(char[][] layout) {
        // Crea matriz vacía del mismo tamaño que layaout
        char[][] result = new char[layout.length][layout[0].length];
        for (int i = 0; i < layout.length; i++) {  // copia fila por fila
            // Copia fila completa de layaout a result ( System.arraycopy copia arrays enteros )
            System.arraycopy(layout[i], 0, result[i], 0, layout[0].length);
        }
        return result; // devuelve copia del aula
    }

    /**
     * Calcula la siguiente iteración aplicando las reglas:
     * - Sentarse: 'A' → '#' si no tiene vecinos '#'
     * - Levantarse: '#' → 'A' si tiene ≥ 4 vecinos '#'
     * - '.' permanece igual
     */

    private static char[][] computeNext(char[][] current) {
        // Recibe tamaño matriz
        int rows = current.length; // nº filas
        int cols = current[0].length; // nº columnas

        char[][] next = new char[rows][cols]; // crear matriz nueva vacía

        // Recorrer la matriz
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                char seat = current[r][c]; // leer asiento actual (posibles valores: ".", "A" o "#")

                // CASO 1: asiento inválido "."
                if (seat == '.') {
                    // Los asientos inválidos nunca cambian
                    next[r][c] = '.';
                    continue; // vamos al siguiente asiento
                }

                // Mira casillas adyacentes (las 8 casillas alrededor) -> busca las "#"
                int occupiedNeighbors = countAdjacent(current, r, c); // el resultado de "#" se guarda en occupiedNeighbors

                // CASO 2: asiento libre "A"
                if (seat == 'A') {
                    // Si no hay vecinos ocupados (hay # = 0) -> se sienta alguien
                    if (occupiedNeighbors == 0) {
                        next[r][c] = '#';
                    } else {
                        // Hay al menos un vecino ocupado → permanece libre
                        next[r][c] = 'A';
                    }

                } else { // seat == '#'
                    // Si tiene 4 o más vecinos ocupados -> se levanta
                    if (occupiedNeighbors >= 4) {
                        next[r][c] = 'A'; // se levanta (asiento queda disponible)
                    } else {
                        next[r][c] = '#'; // permanece sentado
                    }
                }
            }
        }

        return next;
    }


    /**
     * Cuenta los vecinos ocupados ('#') alrededor de una posición.
     * Se revisan las 8 posiciones adyacentes.
     */
    private static int countAdjacent ( char[][] layout, int r, int c){
        int count = 0; // Inicializamos en 0 en la variable que se guardaran los vecinos de alrededor

        // Movimientos relativos a la posición actual
        int[] moves = {-1, 0, 1}; // -1 → una posición arriba / izquierda; 0 → misma fila / misma columna; 1 → una posición abajo / derecha

        for (int dr : moves) {
            for (int dc : moves) {

                // Saltamos la posición central (dr=0, dc=0)
                if (dr == 0 && dc == 0) continue;

                int nr = r + dr;
                int nc = c + dc;

                // Comprobamos límites
                if (nr >= 0 && nr < layout.length &&
                        nc >= 0 && nc < layout[0].length) {

                    if (layout[nr][nc] == '#') {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    /**
     * Compara dos matrices para ver si son iguales.
     */
    private static boolean areEqual ( char[][] a, char[][] b){
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[0].length; c++) {
                if (a[r][c] != b[r][c]) return false;
            }
        }
        return true;
    }
}


