// See https://aka.ms/new-console-template for more information
Console.WriteLine("Hello, World!");

//DATOS PRIMITIVOS
//----------------

// Variable enteras
int varEntero01 = 33;
int varEntero02 = 2;
int varEntero03;
varEntero03 = varEntero01 + varEntero02;
Console.WriteLine(varEntero03);

byte varEntero04 = 222;
varEntero03 = varEntero04;
varEntero04 = (byte)varEntero01;

// Variables decimales
float varDecimalSimple01 = 4.8f;
float varDecimalSimple02 = 15.16f;
Console.WriteLine(varDecimalSimple01 * varDecimalSimple02);

double varDecimaDoble01 = 23.42;
Console.WriteLine(varDecimaDoble01 * varDecimalSimple01);

varDecimalSimple01 = (float) varDecimaDoble01;
varDecimaDoble01 = varDecimalSimple01;

// Varaibles Booleanas
bool varBoolean01 = false;
bool varBoolean02 = true;
Console.WriteLine(varBoolean02);
Console.WriteLine(varBoolean01);
Console.WriteLine(varBoolean02 || varBoolean01);

//Variables Cadenas de Caracteres
string varString01 = "Hola";
string varString02 = "Mundo";
Console.WriteLine(varString01 + varString02);

char varChar01 = ' ';
Console.WriteLine(varString01 + varChar01 + varString02);

//Variables Enumeradas
enum ColoresRGB
{
    Rojo,
    Verde,
    Azul
}

enum Pad
{
    Almeria,
    Cadiz,
    Cordoba,
    Granada,
    Huelva,
    Jaen,
    Malaga,
    Sevilla
}

for(Pad provincia = Pad.Almeria; provincia <= Pad.Sevilla; provincia++)
{

}