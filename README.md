Diagrama UML
![prog2 drawio (1)](https://github.com/santiurru/Obligatorio_PROG2_Camacho_Urrutia/assets/169061259/9c408847-2b4f-4d48-87de-b34553a694d3)

Decisiones tomadas

Para guardar los datos creamos una entidad "Song" donde cada atributo sera cada una de las columnas del csv, estando guardadas sin tener que cada vez que recurrimos a un atributo tener que buscar su lugar en la lista y poder tener guardados algunos tales que no son necesariamente String mas facil. Utilizamos un hash ordenado por la fecha que contiene listas de Song para tener cada instancia ordenada, si existe la lista de esa fecha en el hash se agrega la Song a la lista sino creamos la lista en esa posicion. A su vez creamosuna lista de paises que tiene a todos los paises (sin repetir) para al pedir uno saber si existe y los mismo con la lista de fechas unicas. Se abre el archivo especificado por filePath usando BufferedReader, se omite la primera línea, se procesan las líneas siguientes hasta un límite de 748805 líneas. Usamos parseArtists para que el String de en la columna de artistas los podemos separar por distintos artistas y guardarlos en una lista donde cada entrada es un artista  distintos, mientras que usamos parseInt y parseDouble para convertir Strings en enteros y dobles, respectivamente, sacando los caracteres no deseados.

Tiempo de carga de datos:
![image](https://github.com/santiurru/Obligatorio_PROG2_Camacho_Urrutia/assets/103275179/6c5c10a6-3425-4e72-a19e-c4ac5c43ca37)
Tiempo Total:
![image](https://github.com/santiurru/Obligatorio_PROG2_Camacho_Urrutia/assets/103275179/5c1c7a9c-5e83-4ac0-ad08-d4542150099a)
Tiempo de CPU:
![image](https://github.com/santiurru/Obligatorio_PROG2_Camacho_Urrutia/assets/103275179/c0455659-de37-4aaf-988c-8995063ab7fd)
Memory Allocations:
![image](https://github.com/santiurru/Obligatorio_PROG2_Camacho_Urrutia/assets/103275179/c81b8d32-b715-4412-aa4e-a89c9848dc06)

