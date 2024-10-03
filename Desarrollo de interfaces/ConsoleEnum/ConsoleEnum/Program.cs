namespace ConsoleEnum
{
    internal class Program
    {
        enum ColoresRGB
        {
            Rojo,
            Verde,
            Azul
        }
        enum ProvinciaAnd
        {
            Almeria = 4,
            Cadiz = 11,
            Cordoba = 14,
            Granada = 18,
            Huelva = 21,
            Jaen = 23,
            Malaga = 29,
            Sevilla = 41
        }


        struct Ficha
        {
            string nombre;
            public string apellidos { set; get; }
            public int edad { get; set; }


            
            public Ficha(string nombre, string apellido, int edad)
            {
                this.nombre = nombre;  
                this.apellidos = apellido;
                this.edad = edad;
            }

            public override string ToString()
            {
                return nombre + " " + apellidos + " (" + edad + ")";
            }

            public string getNombre()
            {
                return nombre;
            }
            public void setNombre (string nombre)
            {
                this.nombre = nombre;
            }


        }


        static void Main(string[] args)
        {
            for (ProvinciaAnd provincia = ProvinciaAnd.Almeria; provincia <= ProvinciaAnd.Sevilla; provincia++)
            {
                Console.WriteLine((int)provincia +" " + provincia);
            }

            foreach(ProvinciaAnd provincias in Enum.GetValues(typeof(ProvinciaAnd)))
            {
                Console.WriteLine((int) provincias + " " + provincias.ToString());
            }

            //Estructura
            Ficha fichaAlum;
            fichaAlum = new Ficha();
            fichaAlum.setNombre("Antonio");
            fichaAlum.apellidos = "Mesa Sánchez";
            fichaAlum.edad = 27;
            Console.WriteLine(fichaAlum);
            Console.WriteLine(fichaAlum.getNombre() + fichaAlum.apellidos + fichaAlum.edad);
            Console.WriteLine(fichaAlum.edad);

            Ficha fichaAlum2 = new Ficha("Antonio", "Mesa Sánchez" , 27);
            Console.WriteLine(fichaAlum2);
            Console.WriteLine(fichaAlum2.getNombre();
        }
    }
}
