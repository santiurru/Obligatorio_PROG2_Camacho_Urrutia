Diagrama UML

![prog2 drawio (1)](https://github.com/santiurru/Obligatorio_PROG2_Camacho_Urrutia/assets/169061259/9c408847-2b4f-4d48-87de-b34553a694d3)

Decisiones tomadas

Para guardar los datos creamos una entidad "Song" donde cada atributo sera cada una de las columnas del csv, estando guardadas sin tener que cada vez que recurrimos a un atributo tener que buscar su lugar en la lista y poder tener guardados algunos tales que no son necesariamente String mas facil. Utilizamos un hash ordenado por la fecha que contiene listas de Song para tener cada instancia ordenada, si existe la lista de esa fecha en el hash se agrega la Song a la lista sino creamos la lista en esa posicion. A su vez creamos una lista de paises que tiene a todos los paises (sin repetir) para al pedir uno saber si existe y lo mismo con la lista de fechas unicas. Se abre el archivo especificado por filePath usando BufferedReader, se omite la primera línea, se procesan las líneas siguientes hasta un límite de 748805 líneas. Usamos parseArtists para que el String en la columna de artistas los podemos separar por distintos artistas y guardarlos en una lista donde cada entrada es un artista  distinto, mientras que usamos parseInt y parseDouble para convertir Strings en enteros y dobles, respectivamente, sacando los caracteres no deseados.

Tiempo de carga de datos:

![image](https://github.com/santiurru/Obligatorio_PROG2_Camacho_Urrutia/assets/103275179/6c5c10a6-3425-4e72-a19e-c4ac5c43ca37)
Tiempo Total:

![image](https://github.com/santiurru/Obligatorio_PROG2_Camacho_Urrutia/assets/103275179/5c1c7a9c-5e83-4ac0-ad08-d4542150099a)
Tiempo de CPU:

![image](https://github.com/santiurru/Obligatorio_PROG2_Camacho_Urrutia/assets/103275179/c0455659-de37-4aaf-988c-8995063ab7fd)
Memory Allocations:

![image](https://github.com/santiurru/Obligatorio_PROG2_Camacho_Urrutia/assets/103275179/c81b8d32-b715-4412-aa4e-a89c9848dc06)

Consulta 1

![Screenshot 2024-06-22 155941](https://github.com/santiurru/Obligatorio_PROG2_Camacho_Urrutia/assets/169061259/36dc158a-876f-4ab4-9838-a788ec6a792f)
![image](https://github.com/santiurru/Obligatorio_PROG2_Camacho_Urrutia/assets/169061259/bf4d1a34-fb98-4ced-84f5-cf6f05e0f14b)

Consulta 2

![Screenshot 2024-06-22 160011](https://github.com/santiurru/Obligatorio_PROG2_Camacho_Urrutia/assets/169061259/8efafcac-3eb7-4f40-8915-70477441c2bd)
![image](https://github.com/santiurru/Obligatorio_PROG2_Camacho_Urrutia/assets/169061259/42f09f0f-e34c-4399-a8cb-664187478612)

Consulta 3

![Screenshot 2024-06-22 160053](https://github.com/santiurru/Obligatorio_PROG2_Camacho_Urrutia/assets/169061259/51a7938e-be98-427e-a25f-b95119b9f646)
![image](https://github.com/santiurru/Obligatorio_PROG2_Camacho_Urrutia/assets/169061259/0a4d64c2-b9a9-4cbd-bcf5-1d39cae9fe06)

Consulta 4

![Screenshot 2024-06-22 160146](https://github.com/santiurru/Obligatorio_PROG2_Camacho_Urrutia/assets/169061259/f4a5a3f7-5b98-43fa-9dab-cfb55efe5def)
![image](https://github.com/santiurru/Obligatorio_PROG2_Camacho_Urrutia/assets/169061259/d19c9436-340c-4680-a8f0-973d077b6fbe)

Consulta 5

![Screenshot 2024-06-22 160248](https://github.com/santiurru/Obligatorio_PROG2_Camacho_Urrutia/assets/169061259/1b2b5bcc-e4c5-488b-bdbf-1dd41852a2c2)
![image](https://github.com/santiurru/Obligatorio_PROG2_Camacho_Urrutia/assets/169061259/b38a54e6-d255-4ed6-b00c-b5f919815f9d)



