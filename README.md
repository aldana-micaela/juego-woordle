# 🎮 Juego tipo Wordle - Adivina la palabra

Este proyecto es una versión personalizada del popular juego **Wordle**, desarrollado en **Java** con **Swing**. El objetivo es adivinar una palabra secreta de 5 letras en una cantidad limitada de intentos. Después de cada intento, se muestra una retroalimentación visual indicando qué letras están bien ubicadas, mal colocadas o ausentes.

## 🛠️ Tecnologías utilizadas

- **Java** – Lenguaje principal del desarrollo.
- **Java Swing** – Usado para construir la interfaz gráfica del usuario (GUI).
- **Programación Orientada a Objetos (POO)** – Organización del código en clases con responsabilidades bien definidas.
- **Eventos y escuchas (ActionListener)** – Para manejar la interacción del usuario con los botones e inputs.
- **Validación de lógica** -  control de palabras, retroalimentación por colores, control de intentos.
- **JUnit** - Pruebas unitarias
- **Colecciones**

Se desarrollaron pruebas unitarias con **JUnit** para validar:

- Lógica de comparación de palabras.
- Comprobación de letras correctas en posición.
- Comportamiento en distintos idiomas.

## ✨ Características del juego

- Adivinar palabras de 5 letras.
- Interfaz gráfica amigable con botones, inputs y mensajes.
- Feedback visual por cada intento.
- Mensajes de victoria o derrota.
- Posibilidad de reiniciar la partida.

  ## 🎯 Funcionalidades principales

- Juego con múltiples intentos y retroalimentación visual.
- Interfaz intuitiva desarrollada con Swing.
- Soporte para distintos idiomas (mediante Enum e internacionalización).
- Validación dinámica del input del usuario.

  ## 📂 Estructura del proyecto

```text
juego-woordle/
│
├── src/
│   ├── logica/                # Lógica del juego
│   │   ├── Juego.java
│   │   ├── Palabra.java
│   │   └── Evaluador.java
│   ├── interfaz/              # Interfaz gráfica
│   │   ├── VentanaJuego.java
│   │   └── PanelTeclado.java
│   ├── recursos/              # Diccionarios por idioma
│   │   ├── palabras_es.txt
│   │   └── palabras_en.txt
│   └── test/                  # Tests JUnit
│       ├── JuegoTest.java
│       └── PalabraTest.java
│
└── README.md

## 🚀 Cómo ejecutar el proyecto

1. Cloná este repositorio:
2. Abrilo en un IDE compatible con Java (como IntelliJ IDEA o Eclipse).
3. Ejecutá la clase principal desde el paquete src.

📦 Asegurate de tener Java 8 o superior instalado.

## 📌 Posibles mejoras
- Selección aleatoria de palabras desde archivo.
- Mayor validación de inputs.
- Agregar niveles de dificultad.
- Guardado de estadísticas.

## 👩‍💻 Autoría
- Aldana Micaela Filiberto y Juliana Camila Nuñez
- Estudiantes de Licenciatura en Sistemas
- Este proyecto fue desarrollado como parte de una práctica académica para afianzar conocimientos de Java, interfaces gráficas, lógica de programación y testing en Java.
