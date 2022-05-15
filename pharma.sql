-- phpMyAdmin SQL Dump
-- version 3.1.3.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 12, 2017 at 01:18 AM
-- Server version: 5.1.33
-- PHP Version: 5.2.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `pharma`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `Name` varchar(20) NOT NULL,
  `Password` varchar(8) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `Mobile Number` varchar(12) NOT NULL,
  `Gender` varchar(8) NOT NULL,
  `Type` varchar(15) NOT NULL,
  PRIMARY KEY (`Email`),
  UNIQUE KEY `Name` (`Name`,`Password`,`Mobile Number`,`Gender`,`Type`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`Name`, `Password`, `Email`, `Mobile Number`, `Gender`, `Type`) VALUES
('Imran', '1234', 'imran33', '01739862386', 'Male', 'Admin'),
('Noshin', '5678', 'noshin33', '01711111111', 'Female', 'Customer'),
('Roman', '0000', 'roman33', '01757000000', 'Male', 'Product Manager'),
('Munna', '1111', 'munna33', '01746000000', 'Male', 'Sales Manager'),
('Kuddus', '2222', 'kuddus33', '01711000000', 'Male', 'Customer');

-- --------------------------------------------------------

--
-- Table structure for table `product1`
--

CREATE TABLE IF NOT EXISTS `product1` (
  `ProductName` varchar(10) NOT NULL,
  `ProductID` varchar(6) NOT NULL,
  `ProductPrice` double(6,2) NOT NULL,
  `ProductQuantity` int(5) NOT NULL,
  PRIMARY KEY (`ProductName`,`ProductID`,`ProductPrice`,`ProductQuantity`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product1`
--

INSERT INTO `product1` (`ProductName`, `ProductID`, `ProductPrice`, `ProductQuantity`) VALUES
('Drinks', '345', 40.00, 200),
('Medicine', '123', 500.00, 400);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE IF NOT EXISTS `sales` (
  `Price` double(10,2) NOT NULL,
  `Quantity` double(10,2) NOT NULL,
  `ID` varchar(8) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`Price`, `Quantity`, `ID`) VALUES
(0.00, 0.00, '1');
