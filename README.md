# WEATHERAPI_MVVM_Kotlin (Clean_Architecture)
Una aplicación de búsqueda de ciudad para ver la ubicación, fecha con hora local y la clima.
- Se hace el uso de la api de Google Maps para mostrar la mapa
- Se hace el uso de weatherapi para la búsqueda de la información.

Implementado con:
- MvvM
- Clean Architecture
- Coroutines
- Retrofit
- RoomDatabase
- LiveData
- Hilt

![alt text](https://miro.medium.com/max/1400/1*02Ink_nKAVnzLS8NA3rm_A.png)

## Coroutines VS RXJava
Son diferentes herramientas con diferentes puntos fuertes. Al igual que un tanque y un cañón, se superponen mucho, pero son más o menos deseables en diferentes circunstancias.
- Coroutines Son subprocesos ligeros para programación asíncrona.
- RX-Kotlin/RX-Java es una programación reactiva funcional, su patrón central se basa en el patrón de diseño del observador, por lo que puede usarlo para manejar la interacción del usuario con la interfaz de usuario mientras aún usa rutinas como núcleo principal para el trabajo en segundo plano.

### ¿Cuándo escoger Coroutines o RX-Kotlin?
- Corrutinas: cuando tenemos tareas concurrentes, como si buscara datos de conexiones remotas, bases de datos, cualquier proceso en segundo plano, seguro que también puede usar RX en esos casos, pero parece que usa un tanque para matar hormigas.
- RX-Kotlin: cuando manejaría el flujo de acciones de la interfaz de usuario como: desplazamiento del usuario, clics, actualización de la interfaz de usuario en algunos eventos, etc.

### Algunas ventajas de coroutines
- Escribir un código asíncrono es de manera secuencial.
- El costo de crear corrutinas es mucho más barato que crear hilos.
- No se sobrediseñe para usar un patrón observable, cuando no es necesario usarlo.
- La rutina principal puede administrar automáticamente el ciclo de vida de sus rutinas secundarias por usted

## Demo App
![alt text](https://i.ibb.co/QfpbDWK/Screenshot-1673885842.png)
![alt text](https://i.ibb.co/28p1466/Screenshot-1673885845.png)

## Ejecutar la aplicación
Para ejecutar la aplicación asegurese primero tener las siguientes llaves:
- Api Key de [Google Cloud Console](https://console.cloud.google.com/welcome). (Tener habilitado: Google Maps Android)
- Api Key de [WeatherApi](https://www.weatherapi.com/).

## Clonar la aplicación.
```sh
git clone https://github.com/frankdevelopero/city-finder-mvvm.git
Open Android Studio
Open Project
```
Una vez que tenga abierta la aplicación en Android Studio. En necesario reemplazar las API KEYS.
```sh
-res/values/strings.xml [[GOOGLE_MAP_API_KEY]] reemplace su api key de Google. 
-cityfinder/utils/constants.kt [[WEATHER_API_KEY]] reemplace su api key de WeatherApi. 
```


