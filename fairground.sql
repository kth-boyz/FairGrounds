-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 27, 2019 at 04:42 PM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fairgroundsdump`
--
CREATE DATABASE IF NOT EXISTS `fairgrounds` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `fairgrounds`;

-- --------------------------------------------------------

--
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `status` varchar(25) NOT NULL,
  `applicationdate` date NOT NULL,
  `id` int(10) NOT NULL,
  `person` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `application`
--

INSERT INTO `application` (`status`, `applicationdate`, `id`, `person`) VALUES
('not checked', '2000-02-05', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `availability`
--

DROP TABLE IF EXISTS `availability`;
CREATE TABLE `availability` (
  `id` bigint(20) NOT NULL,
  `fd` date NOT NULL,
  `td` date NOT NULL,
  `application` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `availability`
--

INSERT INTO `availability` (`id`, `fd`, `td`, `application`) VALUES
(1, '2014-02-23', '2014-05-25', 1),
(2, '2014-07-10', '2014-08-10', 1);

-- --------------------------------------------------------

--
-- Table structure for table `expertise`
--

DROP TABLE IF EXISTS `expertise`;
CREATE TABLE `expertise` (
  `name` varchar(255) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `expertise`
--

INSERT INTO `expertise` (`name`, `id`) VALUES
('Korvgrillning', 1),
('Karuselldrift', 2);

-- --------------------------------------------------------

--
-- Table structure for table `expertiseprofile`
--

DROP TABLE IF EXISTS `expertiseprofile`;
CREATE TABLE `expertiseprofile` (
  `id` int(11) NOT NULL,
  `expertise` int(20) NOT NULL,
  `application` int(11) NOT NULL,
  `years` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `expertiseprofile`
--

INSERT INTO `expertiseprofile` (`id`, `expertise`, `application`, `years`) VALUES
(1, 1, 1, 4),
(2, 2, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `email` varchar(255),
  `ssnr` varchar(255),
  `username` varchar(255) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `role` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `person`
-- BCrypt password borg: wl9nk23a
-- BCrypt password perstrand: dS27i8pk

INSERT INTO `person` (`id`, `fname`, `lname`, `email`, `ssnr`, `username`, `pwd`, `role`) VALUES
(1, 'Greta', 'Borg', 'NULL', 'NULL', 'borg', '$2a$10$3cX0hH6lxrQsjUMIpyVJh.7r0lhutYbOMGZ8w6FJ1SCkkPMnydohu', 'recruit'),
(2, 'Per', 'Strand', 'per@strand.kth.se', '196712121211', 'perstrand', '$2a$10$rIkDmcub5C4DfK/2fBHhL.DRkGwPkEb1cZi7dCLFue5Y/akKTlGPi', 'applicant');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `application`
--
ALTER TABLE `application`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `person` (`person`);

--
-- Indexes for table `availability`
--
ALTER TABLE `availability`
  ADD PRIMARY KEY (`id`),
  ADD KEY `application` (`application`);

--
-- Indexes for table `expertise`
--
ALTER TABLE `expertise`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `expertiseprofile`
--
ALTER TABLE `expertiseprofile`
  ADD PRIMARY KEY (`id`),
  ADD KEY `application` (`application`),
  ADD KEY `expertise` (`expertise`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `application`
--
ALTER TABLE `application`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `availability`
--
ALTER TABLE `availability`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `expertiseprofile`
--
ALTER TABLE `expertiseprofile`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `application`
--
ALTER TABLE `application`
  ADD CONSTRAINT `FKc8gtc9d6uh2m95we0kk5u73k3` FOREIGN KEY (`person`) REFERENCES `person` (`id`);

--
-- Constraints for table `availability`
--
ALTER TABLE `availability`
  ADD CONSTRAINT `availability_ibfk_1` FOREIGN KEY (`application`) REFERENCES `application` (`id`);

--
-- Constraints for table `expertiseprofile`
--
ALTER TABLE `expertiseprofile`
  ADD CONSTRAINT `expertiseprofile_ibfk_1` FOREIGN KEY (`application`) REFERENCES `application` (`id`),
  ADD CONSTRAINT `expertiseprofile_ibfk_2` FOREIGN KEY (`expertise`) REFERENCES `expertise` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
