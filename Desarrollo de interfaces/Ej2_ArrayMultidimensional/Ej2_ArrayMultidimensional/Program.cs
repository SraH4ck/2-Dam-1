namespace Ej2_ArrayMultidimensional
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //1. Cree un array bidimensional (matriz) de 3x4 que almacene temperaturas en grados Celsius
            //2. Inicializa la matriz con los siguientes valores:
            /*[10, 12, 14, 16]
              [15, 18, 20, 24]
              [22, 24, 26, 28]*/
            int[,] temperaturas = {
            { 10, 12, 14, 16 ,15},
            { 15, 18, 20, 24 ,21},
            { 22, 24, 26, 28 ,23}
            };

            double temperaturaTotal = 0;
            double numTotalTemperaturas = temperaturas.Length;

            // 3. Imprime la matriz por consola en formato de tabla
            for(int fila = 0; fila < temperaturas.GetLength(0); fila++)
            {
                for(int colum = 0; colum<temperaturas.GetLength(1); colum++)
                {
                    Console.Write(temperaturas[fila,colum] + "\t");
                    temperaturaTotal += temperaturas[fila, colum];
                }
                Console.WriteLine("\n");
            }
            // 4. Calcula la temperatura media de la matriz e imprímela por consola.
            double media = temperaturaTotal / numTotalTemperaturas;
            Console.WriteLine("La media es: " + media);
        }
    }
}
