-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-10-2020 a las 05:25:56
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_siscon`
--
CREATE DATABASE IF NOT EXISTS `bd_siscon` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `bd_siscon`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `conmae`
--

CREATE TABLE `conmae` (
  `ID` int(11) NOT NULL,
  `GRUP` int(11) DEFAULT NULL,
  `SUBGRU` int(11) DEFAULT NULL,
  `MAYOR` int(11) DEFAULT NULL,
  `CUENTA` int(11) DEFAULT NULL,
  `SUBCTA` int(11) DEFAULT NULL,
  `CUETOT` mediumtext DEFAULT NULL,
  `NUMCUE` int(11) DEFAULT NULL,
  `DESCRI` varchar(50) DEFAULT NULL,
  `ACTIVI` int(11) DEFAULT NULL,
  `NIVEL` int(11) DEFAULT NULL,
  `LUGAR` int(11) DEFAULT NULL,
  `PRESUP` int(11) DEFAULT NULL,
  `SALINI` double DEFAULT NULL,
  `ANTDIA` double DEFAULT NULL,
  `ANTMES` double DEFAULT NULL,
  `SALACT` double DEFAULT NULL,
  `DEBANO` double DEFAULT NULL,
  `CREANO` double DEFAULT NULL,
  `DEBMES` double DEFAULT NULL,
  `CREMES` double DEFAULT NULL,
  `DEBDIA` double DEFAULT NULL,
  `CREDIA` double DEFAULT NULL,
  `INDICA` int(11) DEFAULT NULL,
  `SALIN2` double DEFAULT NULL,
  `DEBME2` double DEFAULT NULL,
  `ANTME2` double DEFAULT NULL,
  `CREME2` double DEFAULT NULL,
  `SALAC2` double DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `NOMPRE` double DEFAULT NULL,
  `DEBAN2` double DEFAULT NULL,
  `CREAN2` double DEFAULT NULL,
  `ANTDI2` double DEFAULT NULL,
  `DEBDI2` double DEFAULT NULL,
  `CREDI2` double DEFAULT NULL,
  `FECHA2` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tabvar`
--

CREATE TABLE `tabvar` (
  `RECORD` int(11) NOT NULL,
  `TIPO` int(6) NOT NULL,
  `NUMERO` int(4) NOT NULL,
  `DESCRI` varchar(30) DEFAULT NULL,
  `CODCON` int(8) DEFAULT NULL,
  `CORREL` int(6) DEFAULT NULL,
  `MONTO` decimal(12,2) DEFAULT NULL,
  `OBSERV` varchar(50) DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `FECHA2` date DEFAULT NULL,
  `MONTO2` decimal(10,2) DEFAULT NULL,
  `TIPCAM` decimal(4,2) DEFAULT NULL,
  `NUMNIT` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID` int(11) NOT NULL,
  `RAZSOC` varchar(50) DEFAULT NULL,
  `NUMUSU` int(1) DEFAULT NULL,
  `FECUSU` date DEFAULT NULL,
  `TIPCAM` double DEFAULT NULL,
  `CODJJC` int(4) DEFAULT NULL,
  `DIRRAZ` varchar(50) DEFAULT NULL,
  `NUMNIT` mediumtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `conmae`
--
ALTER TABLE `conmae`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `tabvar`
--
ALTER TABLE `tabvar`
  ADD PRIMARY KEY (`RECORD`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `conmae`
--
ALTER TABLE `conmae`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tabvar`
--
ALTER TABLE `tabvar`
  MODIFY `RECORD` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
