![GitHub package.json dependency version (prod)](https://img.shields.io/github/package-json/dependency-version/8ortiz4/teleport-2022/2.1.0?color=orange)
![GitHub last commit](https://img.shields.io/github/last-commit/8ortiz4/teleport-2022)
![GitHub Release Date](https://img.shields.io/github/release-date/8ortiz4/teleport-2022)
![GitHub release (by tag)](https://img.shields.io/github/downloads/8ortiz4/teleport-2022/2.1.0/total?color=brightgreen)

# Teleport 2022

Disclaimer: Teleport 2022 empezó en 2021 como un proyecto pequeño por el cual, utilizaría con fines personales. Sin embargo, me di cuenta de que los plugins de Minecraft basados en Spigot con la funcionalidad del teletransporte, estaban desfasados u obsoletos. Decidí entonces crear Teleport 2022, un punto y aparte en relación a plugins de teletransporte.

## Comandos

Los comandos son los siguientes:

```
tpa
tpreject
tpaccept
```

### tpa

Envía una solicitud de teletransporte a un jugador. Por ejemplo: `/tpa notch`.

### tpreject

Rechaza una solicitud de teletransporte.

### tpaccept

Acepta una solicitud de teletransporte.

## Personalizado e idioma

Personaliza los mensajes y sus respectivos colores a través del fichero pluyin.yml.

### Personalizado

Cosas a tener en cuenta:

- Si tu mensaje contiene acentos o caracteres especiales, reemplaza cada letra por su punto de código. Por ejemplo: á → \u00e1.
- Cambia el color o estilo de las palabras indicando al principio y sin espacios su código (abajo). Por ejemplo: hola (en rojo) → &chola.
- Utiliza &r para volver al color y estilo por defecto.

#### Código de colores

- Negro: &0
- Azul oscuro: &1
- Verde oscuro: &2
- Cian oscuro: &3
- Rojo oscuro: &4
- Púrpura oscuro: &5
- Oro: &6
- Gris: &7
- Gris oscuro: &8
- Azul: &9
- Verde: &a
- Cian: &b
- Rojo: &c
- Magenta: &d
- Amarillo: &e
- Blanco: &f

#### Código de estilos

- Ofuscado: &k
- Negrita: &l
- Tachado: &m
- Subrayado: &n
- Cursiva: &o
- Reset: &r

### Idioma

El idioma por defecto de los mensajes es el inglés estadounidense. Los idiomas siguientes están ya traducidos:

- [English (US)](https://github.com/8ortiz4/teleport-2022/blob/main/lang/en_us.yml)
- [Español (España)](https://github.com/8ortiz4/teleport-2022/blob/main/lang/es_es.yml)
- [Andalûh (España)](https://github.com/8ortiz4/teleport-2022/blob/main/lang/esan.yml)
- [Português (Brasil)](https://github.com/8ortiz4/teleport-2022/blob/main/lang/pt_br.yml)

Para cambiar el idioma se debe renombrar el fichero con la traducción deseada a config.yml y reemplazarlo por el config.yml original.

## Comentarios destacables

> Aunque una versión dada de Teleport 2022 puede funcionar en una versión de Minecraft superior a la pensada para ser utilizado Teleport 2022, es recomendable actualizar Teleport 2022 cuando coincida con la versión de Minecraft del servidor.
