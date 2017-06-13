-- phpMyAdmin SQL Dump
-- version 4.4.15.5
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 13, 2017 at 12:51 AM
-- Server version: 5.6.34-log
-- PHP Version: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pruebatecnica`
--

-- --------------------------------------------------------

--
-- Table structure for table `tont_aves`
--

CREATE TABLE IF NOT EXISTS `tont_aves` (
  `CDAVE` varchar(5) NOT NULL,
  `DSNOMBRE_COMUN` varchar(100) NOT NULL,
  `DSNOMBRE_CIENTIFICO` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tont_aves_pais`
--

CREATE TABLE IF NOT EXISTS `tont_aves_pais` (
  `CDPAIS` varchar(3) NOT NULL,
  `CDAVE` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- --------------------------------------------------------
--
-- Table structure for table `tont_zonas`
--

CREATE TABLE IF NOT EXISTS `tont_zonas` (
  `CDZONA` varchar(3) NOT NULL,
  `DSNOMBRE` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tont_zonas`
--

INSERT INTO `tont_zonas` (`CDZONA`, `DSNOMBRE`) VALUES
('ADN', 'América del Norte, Norteamérica'),
('ADS', 'América del Sur, Sudamérica, Suramérica'),
('AFR', 'África'),
('ANT', 'Antártida'),
('ASI', 'Asia'),
('EUR', 'Europa'),
('MES', 'Mesoamérica'),
('NUM', 'Nuevo Mundo'),
('ORI', 'Oriente');

--
-- Table structure for table `tont_paises`
--

CREATE TABLE IF NOT EXISTS `tont_paises` (
  `CDPAIS` varchar(3) NOT NULL,
  `DSNOMBRE` varchar(100) NOT NULL,
  `CDZONA` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tont_paises`
--

INSERT INTO `tont_paises` (`CDPAIS`, `DSNOMBRE`, `CDZONA`) VALUES
('AFG', 'Afganistán', 'ASI'),
('ALE', 'Alemania', 'EUR'),
('ANG', 'Angola', 'AFR'),
('ARA', 'Arabia Saudita', 'ASI'),
('ARE', 'Argelia', 'AFR'),
('ARG', 'Argentina', 'ADS'),
('AUS', 'Australia', 'ANT'),
('AZE', 'Azerbaiyán', 'ASI'),
('BAN', 'Bangladesh', 'ASI'),
('BEN', 'Benín', 'AFR'),
('BOL', 'Bolivia', 'ADS'),
('BRA', 'Brasil', 'ADS'),
('BRU', 'Brunei', 'ASI'),
('CAB', 'Cabo Verde', 'AFR'),
('CAN', 'Canadá', 'ADN'),
('CHI', 'Chile', 'ADS'),
('COL', 'Colombia', 'ADS'),
('COS', 'Costa de Marfil', 'AFR'),
('EGI', 'Egipto', 'AFR'),
('ERI', 'Eritrea', 'AFR'),
('FIY', 'Fiyi', 'ANT'),
('KIR', 'Kiribati', 'ANT'),
('MEX', 'México', 'ADN'),
('NUZ', 'Nueva Zelanda', 'ANT'),
('USA', 'Estados Unidos', 'ADN');

-- --------------------------------------------------------



--
-- Indexes for dumped tables
--

--
-- Indexes for table `tont_aves`
--
ALTER TABLE `tont_aves`
  ADD PRIMARY KEY (`CDAVE`);

--
-- Indexes for table `tont_aves_pais`
--
ALTER TABLE `tont_aves_pais`
  ADD PRIMARY KEY (`CDPAIS`,`CDAVE`),
  ADD KEY `fk_TONT_PAISES_has_TONT_AVES_TONT_AVES1_idx` (`CDAVE`),
  ADD KEY `fk_TONT_PAISES_has_TONT_AVES_TONT_PAISES_idx` (`CDPAIS`);

--
-- Indexes for table `tont_paises`
--
ALTER TABLE `tont_paises`
  ADD PRIMARY KEY (`CDPAIS`),
  ADD KEY `fk_TONT_PAISES_TONT_ZONAS1_idx` (`CDZONA`);

--
-- Indexes for table `tont_zonas`
--
ALTER TABLE `tont_zonas`
  ADD PRIMARY KEY (`CDZONA`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tont_aves_pais`
--
ALTER TABLE `tont_aves_pais`
  ADD CONSTRAINT `fk_TONT_PAISES_has_TONT_AVES_TONT_AVES1` FOREIGN KEY (`CDAVE`) REFERENCES `tont_aves` (`CDAVE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_TONT_PAISES_has_TONT_AVES_TONT_PAISES` FOREIGN KEY (`CDPAIS`) REFERENCES `tont_paises` (`CDPAIS`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tont_paises`
--
ALTER TABLE `tont_paises`
  ADD CONSTRAINT `fk_TONT_PAISES_TONT_ZONAS1` FOREIGN KEY (`CDZONA`) REFERENCES `tont_zonas` (`CDZONA`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
