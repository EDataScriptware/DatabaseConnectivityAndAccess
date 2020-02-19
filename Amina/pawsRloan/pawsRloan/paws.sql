-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 09, 2018 at 02:52 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paws`
--

-- --------------------------------------------------------

--
-- Table structure for table `blockList`
--

CREATE TABLE `blockList` (
  `username` varchar(30) NOT NULL,
  `dateAdded` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `categoryId` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Book`
--

CREATE TABLE `Book` (
  `ISBN` int(10) DEFAULT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `borrowPeriod`
--

CREATE TABLE `borrowPeriod` (
  `item` varchar(20) NOT NULL,
  `duration` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Category`
--

CREATE TABLE `Category` (
  `name` varchar(30) NOT NULL,
  `categoryId` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Category`
--

INSERT INTO `Category` (`name`, `categoryId`) VALUES
('Human', 'b8ab3ff957e3e02179b4');

-- --------------------------------------------------------

--
-- Table structure for table `extension`
--

CREATE TABLE `extension` (
  `username` varchar(30) NOT NULL,
  `extensionDate` datetime NOT NULL,
  `itemId` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `fees`
--

CREATE TABLE `fees` (
  `categoryId` varchar(30) NOT NULL,
  `fee` decimal(10,2) NOT NULL,
  `rate` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fees`
--

INSERT INTO `fees` (`categoryId`, `fee`, `rate`) VALUES
('ccfba4a2bcb0f33595a4', '11.00', 'day'),
('e8c89f5796937f47fe3b', '11.00', 'day');

-- --------------------------------------------------------

--
-- Table structure for table `Human`
--

CREATE TABLE `Human` (
  `Height` int(10) NOT NULL,
  `Color` text NOT NULL,
  `itemId` varchar(60) DEFAULT NULL,
  `name` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Human`
--

INSERT INTO `Human` (`Height`, `Color`, `itemId`, `name`) VALUES
(7, 'blue', 'randomid', 'someitem'),
(11, '11', 'dfdfdf', 'jd');

-- --------------------------------------------------------

--
-- Table structure for table `Ipad`
--

CREATE TABLE `Ipad` (
  `Model` int(11) NOT NULL,
  `Generation` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `itemId` varchar(20) NOT NULL,
  `categoryId` varchar(20) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`itemId`, `categoryId`, `id`) VALUES
('dfdfdf', 'b8ab3ff957e3e02179b4', 1);

-- --------------------------------------------------------

--
-- Table structure for table `item_policy`
--

CREATE TABLE `item_policy` (
  `name` varchar(50) NOT NULL,
  `policy` text NOT NULL,
  `categoryId` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Laptop`
--

CREATE TABLE `Laptop` (
  `Model` varchar(23) NOT NULL,
  `Generation` int(1) NOT NULL,
  `Color` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `loan`
--

CREATE TABLE `loan` (
  `itemId` varchar(20) NOT NULL,
  `date_loan` datetime NOT NULL,
  `dueDate` datetime NOT NULL,
  `borrower` varchar(30) NOT NULL,
  `authorizedOut` varchar(30) NOT NULL,
  `dateReturned` datetime NOT NULL,
  `authorizedIn` varchar(30) NOT NULL,
  `id` int(11) NOT NULL,
  `categoryId` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `next`
--

CREATE TABLE `next` (
  `random` int(1) NOT NULL,
  `itemId` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `operationHours`
--

CREATE TABLE `operationHours` (
  `day` varchar(3) NOT NULL,
  `openHour` time NOT NULL,
  `closeHour` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Pen`
--

CREATE TABLE `Pen` (
  `ink` int(1) NOT NULL,
  `fineness` int(3) DEFAULT NULL,
  `itemId` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `random`
--

CREATE TABLE `random` (
  `Model` int(11) NOT NULL,
  `Generation` int(11) NOT NULL,
  `Whatever` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `name` varchar(20) NOT NULL,
  `roleId` varchar(20) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`name`, `roleId`, `id`) VALUES
('ROLE_MANAGER', 'fdfdsfdfdsf', 2);

-- --------------------------------------------------------

--
-- Table structure for table `testy`
--

CREATE TABLE `testy` (
  `whatever` int(11) NOT NULL,
  `itemId` varchar(60) DEFAULT NULL,
  `name` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `userRoles`
--

CREATE TABLE `userRoles` (
  `username` varchar(30) NOT NULL,
  `roleId` varchar(20) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userRoles`
--

INSERT INTO `userRoles` (`username`, `roleId`, `id`) VALUES
('mjfics', 'fdfdsfdfdsf', 1),
('ksc2650', 'fdfdsfdfdsf', 4);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(30) NOT NULL,
  `fName` varchar(30) NOT NULL,
  `lName` varchar(50) NOT NULL,
  `universityId` varchar(65) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `fName`, `lName`, `universityId`) VALUES
('ksc2650', 'Kemoy', 'Campbell', '123456789'),
('mjfics', 'Micahel', 'Floeser', '15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225');

-- --------------------------------------------------------

--
-- Table structure for table `WaterBottle`
--

CREATE TABLE `WaterBottle` (
  `height` varchar(10) DEFAULT NULL,
  `Color` varchar(30) DEFAULT NULL,
  `itemId` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Book`
--
ALTER TABLE `Book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Category`
--
ALTER TABLE `Category`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `fees`
--
ALTER TABLE `fees`
  ADD PRIMARY KEY (`categoryId`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `item_policy`
--
ALTER TABLE `item_policy`
  ADD PRIMARY KEY (`categoryId`);

--
-- Indexes for table `loan`
--
ALTER TABLE `loan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `userRoles`
--
ALTER TABLE `userRoles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Book`
--
ALTER TABLE `Book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `loan`
--
ALTER TABLE `loan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `userRoles`
--
ALTER TABLE `userRoles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
