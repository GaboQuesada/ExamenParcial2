-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-02-2017 a las 03:52:15
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `progra3_exa2`
--
CREATE DATABASE IF NOT EXISTS `progra3_exa2` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `progra3_exa2`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `author`
--

DROP TABLE IF EXISTS `author`;
CREATE TABLE IF NOT EXISTS `author` (
  `idAuthor` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  PRIMARY KEY (`idAuthor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `authorcontact`
--

DROP TABLE IF EXISTS `authorcontact`;
CREATE TABLE IF NOT EXISTS `authorcontact` (
  `idAuthorContact` int(11) NOT NULL AUTO_INCREMENT,
  `idAuthor` int(11) NOT NULL,
  `contact` text NOT NULL,
  `type` text NOT NULL,
  PRIMARY KEY (`idAuthorContact`),
  KEY `idAuthor` (`idAuthor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `book`
--

DROP TABLE IF EXISTS `book`;
CREATE TABLE IF NOT EXISTS `book` (
  `idBook` int(11) NOT NULL AUTO_INCREMENT,
  `idAuthor` int(11) NOT NULL,
  `idType` int(11) NOT NULL,
  `name` text NOT NULL,
  `dateRelease` date NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`idBook`),
  KEY `idAuthor` (`idAuthor`,`idType`),
  KEY `idType` (`idType`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `booktype`
--

DROP TABLE IF EXISTS `booktype`;
CREATE TABLE IF NOT EXISTS `booktype` (
  `idType` int(11) NOT NULL AUTO_INCREMENT,
  `type` text NOT NULL,
  PRIMARY KEY (`idType`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Volcado de datos para la tabla `booktype`
--

INSERT INTO `booktype` (`idType`, `type`) VALUES
(30, 'Drama');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `authorcontact`
--
ALTER TABLE `authorcontact`
  ADD CONSTRAINT `authorcontact_ibfk_1` FOREIGN KEY (`idAuthor`) REFERENCES `author` (`idAuthor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `book_ibfk_1` FOREIGN KEY (`idAuthor`) REFERENCES `author` (`idAuthor`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `book_ibfk_2` FOREIGN KEY (`idType`) REFERENCES `booktype` (`idType`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
