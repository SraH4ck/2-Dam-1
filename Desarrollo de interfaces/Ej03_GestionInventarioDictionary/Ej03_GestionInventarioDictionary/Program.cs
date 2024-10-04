using System.Drawing;

namespace Ej03_GestionInventarioDictionary
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // 1. Cree un Dictionary donde la clave sea el nombre de un producto (cadena) y el valor sea la cantidad disponible(entero)
            Dictionary<string, int> inventario = new Dictionary<string, int>
            {   {"Manzanas",50},
                {"Naranjas", 30 },
                {"Peras", 20 }
            };

            /*
             Añade al diccionario los siguientes productos y cantidades:
            "Manzanas" - 50
            "Naranjas" - 30
            "Peras" - 20
            
            3. Imprime todos los productos y sus cantidades por consola*/
            Console.WriteLine("Inventario inicial\n");
            foreach (var producto in inventario)
            {
                Console.WriteLine("Del producto " + producto.Key + " Hay " + producto.Value + " UDs");
            }

            //4. Actualiza la cantidad de "Naranjas" a 40.
            inventario["Naranjas"] = 40;

            // 5. Añade un nuevo producto "Plátanos" con una cantidad de 25.
            inventario["Platanos"] = 25;

            // 6. Elimina el producto "Peras".
            inventario.Remove("Peras");


            //7. Imprime el inventario final.
            Console.WriteLine("\nInventario final\n");
            foreach (var producto in inventario)
            {
                Console.WriteLine("Del producto " + producto.Key + " Hay " + producto.Value + " UDs");
            }
        }
    }
}
