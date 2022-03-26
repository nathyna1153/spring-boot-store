-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-03-2022 a las 20:30:29
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_store`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` bigint(20) NOT NULL,
  `nombre_categoria` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nombre_categoria`) VALUES
(1, 'Baile'),
(3, 'Peleas'),
(4, 'Peleas'),
(5, 'Peleas'),
(6, 'Peleas'),
(7, 'Peleas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `video_juego`
--

CREATE TABLE `video_juego` (
  `id` bigint(20) NOT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  `id_categoria` bigint(20) DEFAULT NULL,
  `precio` int(11) NOT NULL,
  `url` varchar(255) NOT NULL,
  `anio` varchar(255) DEFAULT NULL,
  `plataforma` varchar(255) NOT NULL,
  `calificacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `video_juego`
--

INSERT INTO `video_juego` (`id`, `fecha`, `nombre`, `id_categoria`, `precio`, `url`, `anio`, `plataforma`, `calificacion`) VALUES
(2, NULL, 'Juego aaaaa', 1, 15990, 'http://localhost:8080/store/videojuego/', '2020', '', 0),
(3, NULL, 'Juego BBB', 1, 15990, 'http://localhost:8080/store/videojuego/', '2017', '', 0),
(4, NULL, 'star wars', 1, 15990, 'http://localhost:8080/store/videojuego/', '2020', 'oculus vr', 5),
(5, NULL, 'Cuphead', 1, 18990, 'http://localhost:8080/store/videojuego/', '2017', 'XBOXONE', 4);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `video_juego`
--
ALTER TABLE `video_juego`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKithj1vytetjht67jhsbj8uvxd` (`id_categoria`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `video_juego`
--
ALTER TABLE `video_juego`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `video_juego`
--
ALTER TABLE `video_juego`
  ADD CONSTRAINT `FKithj1vytetjht67jhsbj8uvxd` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
