namespace Ej1_OperacionesConArray
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //1.Crea un array de enteros con 5 posiciones.
            //2.Rellena el array con los valores 10, 20, 30, 40, 50.
            int[] numeros = {10,20,30,40,50}; // int numeros = new int[5]
            
            
            //3.Imprime por consola el contenido del array.
            foreach(int numero in numeros)
            {
                Console.WriteLine("Contenido del array " + numero);
            }

            //4.Modifica el valor de la tercera posición para que sea 35.
            numeros[2] = 35;

            //5.Vuelve a imprimir el array.
            foreach (int numero in numeros)
            {
                Console.WriteLine("Contenido del array modificado " + numero);
            }

            //6.Calcula e imprime la suma de todos los valores del array.
            int suma = 0;
            foreach (int numero in numeros)
            {
                suma += numero;
            }
            Console.WriteLine("La suma de todos los elementos son: " + suma);
        }
    }
}
