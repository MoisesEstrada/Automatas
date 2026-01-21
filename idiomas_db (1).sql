-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-01-2026 a las 20:50:00
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `idiomas_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejercicios`
--

CREATE TABLE `ejercicios` (
  `id` bigint(20) NOT NULL,
  `audio_url` varchar(255) DEFAULT NULL,
  `enunciado` varchar(500) NOT NULL,
  `imagen_url` varchar(255) DEFAULT NULL,
  `respuesta_correcta` varchar(255) NOT NULL,
  `tipo` enum('IMAGEN','LISTENING','PRONUNCIACION','SELECCION_MULTIPLE','TRADUCCION','VERDADERO_FALSO') DEFAULT NULL,
  `ronda_id` bigint(20) DEFAULT NULL,
  `contenido` varchar(255) DEFAULT NULL,
  `opciones` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ejercicios`
--

INSERT INTO `ejercicios` (`id`, `audio_url`, `enunciado`, `imagen_url`, `respuesta_correcta`, `tipo`, `ronda_id`, `contenido`, `opciones`) VALUES
(40, NULL, 'traducir la siguiente oracion \"what the fuck is dad in animal\"', NULL, 'que put0 animal es ese', 'TRADUCCION', 11, '', ''),
(41, NULL, 'traducir este audio', NULL, 'whats is causa gaaaa is donw chupetin ', 'LISTENING', 11, '02e35a59-7172-445a-8963-424bff8457c4-Y2meta.app - Que pasa causa !! Gaaa ! Vas a caer chupetin (128 kbps) (1).mp3', ''),
(42, NULL, 'que animal es?', NULL, 'Tiger', 'IMAGEN', 11, '0203900d-e6be-40de-be4f-4febaed0cb6e-Fauna_2832020163305.jpg', 'Tiger,Lion,Bear,Panter'),
(43, NULL, 'Traducir el siguiente parrafo \"Roses are red\n\nViolets are blue\n\nIt don’t always be like that\n\nBut sometimes it do.\"', NULL, 'Las rosas son rojas  Las violetas azules  No siempre es así  Pero a veces sí.', 'TRADUCCION', 12, '', ''),
(47, NULL, 'traducir el audio ', NULL, 'whats is causa gaaaaaaaaaaaa is a donw chupetin gaaaaaaa', 'LISTENING', 15, '1f87e35a-d4ba-4eaa-8bc4-adf553cec660-Y2meta.app - Que pasa causa !! Gaaa ! Vas a caer chupetin (128 kbps) (1).mp3', ''),
(48, NULL, 'traducir', NULL, 'My god, i posivol succes', 'LISTENING', 16, '5ce747c6-5a44-4203-a4fc-eb69198f83c2-DIOS MIO 😇 COMO ES POSIBLE ESTE SUCESO _ ARIANN #SHORTS #SHORTSYOUTUBE (128 kbps).mp3', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejercicio_opciones`
--

CREATE TABLE `ejercicio_opciones` (
  `ejercicio_id` bigint(20) NOT NULL,
  `opcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `progresos`
--

CREATE TABLE `progresos` (
  `id` bigint(20) NOT NULL,
  `fecha_realizacion` datetime(6) DEFAULT NULL,
  `puntaje` int(11) DEFAULT NULL,
  `estudiante_id` bigint(20) DEFAULT NULL,
  `ronda_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `progresos`
--

INSERT INTO `progresos` (`id`, `fecha_realizacion`, `puntaje`, `estudiante_id`, `ronda_id`) VALUES
(1, '2026-01-19 23:10:27.000000', 33, 3, 11),
(2, '2026-01-19 23:12:45.000000', 0, 3, 15),
(3, '2026-01-19 23:13:14.000000', 0, 3, 15),
(4, '2026-01-19 23:13:27.000000', 33, 3, 11),
(5, '2026-01-19 23:24:49.000000', 0, 3, 16),
(6, '2026-01-19 23:25:06.000000', 0, 3, 15),
(7, '2026-01-19 23:25:31.000000', 0, 3, 12),
(8, '2026-01-21 03:17:02.000000', 0, 3, 12),
(9, '2026-01-21 03:17:17.000000', 0, 3, 15),
(10, '2026-01-21 03:17:23.000000', 0, 3, 16),
(11, '2026-01-21 03:18:39.000000', 33, 3, 11),
(12, '2026-01-21 03:21:27.000000', 0, 3, 16),
(13, '2026-01-21 17:37:44.000000', 0, 3, 12),
(14, '2026-01-21 17:37:55.000000', 0, 3, 15),
(15, '2026-01-21 17:44:03.000000', 33, 3, 11),
(16, '2026-01-21 17:49:39.000000', 0, 3, 12),
(17, '2026-01-21 17:49:45.000000', 0, 3, 15),
(18, '2026-01-21 17:49:49.000000', 0, 3, 16),
(19, '2026-01-21 18:22:05.000000', 0, 3, 12),
(20, '2026-01-21 18:22:10.000000', 0, 3, 15),
(21, '2026-01-21 18:22:14.000000', 0, 3, 16),
(22, '2026-01-21 18:42:00.000000', 33, 3, 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rondas`
--

CREATE TABLE `rondas` (
  `id` bigint(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nivel` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) NOT NULL,
  `creador_id` bigint(20) DEFAULT NULL,
  `activo` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rondas`
--

INSERT INTO `rondas` (`id`, `descripcion`, `nivel`, `titulo`, `creador_id`, `activo`) VALUES
(11, '', 'A1', 'Indentify is animals', 2, b'1'),
(12, '', 'A2', 'Traduccion de textos simples', 2, b'1'),
(15, '', 'A1', 'Audio', 2, b'1'),
(16, '', 'A2', 'voacabulari', 2, b'1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('ADMIN','DOCENTE','ESTUDIANTE') NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `email`, `enabled`, `password`, `role`, `username`) VALUES
(1, 'admin@duolingo.com', b'1', '$2a$10$VkPqSK21KPJSm/0N5nIa1em4FNuE7qOcrFbodX68LY2NxKAV14jBK', 'ADMIN', 'admin'),
(2, 'juandocente@duolingo.com', b'1', '$2a$10$4liVuNDb7eRA4d0VzAwKvOAsquk7nSm3x.Wdtutr5kS6drazPgk/O', 'DOCENTE', 'Juan'),
(3, 'joseestudiante@duolingo.com', b'1', '$2a$10$5o5tQONB3TBa1j0bNsIDpeesA4wHdvoeX/zPxEZpKJ6lac3BRP5X6', 'ESTUDIANTE', 'Jose');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ejercicios`
--
ALTER TABLE `ejercicios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmhgf7r1pmqoamoutvmmf1udx8` (`ronda_id`);

--
-- Indices de la tabla `ejercicio_opciones`
--
ALTER TABLE `ejercicio_opciones`
  ADD KEY `FK97qa8i3l8wkf4voham8w4dtxn` (`ejercicio_id`);

--
-- Indices de la tabla `progresos`
--
ALTER TABLE `progresos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK53pii8e5cu6h2vtdw4qj5a0je` (`estudiante_id`),
  ADD KEY `FKevcylrmitifvrw2n4f8a8rofu` (`ronda_id`);

--
-- Indices de la tabla `rondas`
--
ALTER TABLE `rondas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKg6clkbtvteaw5crb5bajsk9mt` (`creador_id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKm2dvbwfge291euvmk6vkkocao` (`username`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ejercicios`
--
ALTER TABLE `ejercicios`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT de la tabla `progresos`
--
ALTER TABLE `progresos`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `rondas`
--
ALTER TABLE `rondas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ejercicios`
--
ALTER TABLE `ejercicios`
  ADD CONSTRAINT `FKmhgf7r1pmqoamoutvmmf1udx8` FOREIGN KEY (`ronda_id`) REFERENCES `rondas` (`id`);

--
-- Filtros para la tabla `ejercicio_opciones`
--
ALTER TABLE `ejercicio_opciones`
  ADD CONSTRAINT `FK97qa8i3l8wkf4voham8w4dtxn` FOREIGN KEY (`ejercicio_id`) REFERENCES `ejercicios` (`id`);

--
-- Filtros para la tabla `progresos`
--
ALTER TABLE `progresos`
  ADD CONSTRAINT `FK53pii8e5cu6h2vtdw4qj5a0je` FOREIGN KEY (`estudiante_id`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `FKevcylrmitifvrw2n4f8a8rofu` FOREIGN KEY (`ronda_id`) REFERENCES `rondas` (`id`);

--
-- Filtros para la tabla `rondas`
--
ALTER TABLE `rondas`
  ADD CONSTRAINT `FKg6clkbtvteaw5crb5bajsk9mt` FOREIGN KEY (`creador_id`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
