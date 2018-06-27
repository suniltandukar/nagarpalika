-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 22, 2018 at 10:07 AM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `mmis_01`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrator_settings`
--

CREATE TABLE IF NOT EXISTS `administrator_settings` (
  `administrator_settings_id` int(10) NOT NULL DEFAULT '0',
  `type` varchar(50) NOT NULL,
  `description` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `administrator_settings`
--

INSERT INTO `administrator_settings` (`administrator_settings_id`, `type`, `description`) VALUES
(1, 'image_upload_path', 'D:/xampp/tomcat/webapps/images'),
(2, 'image_download_path', 'file:///D:/xampp/tomcat/webapps/images');

-- --------------------------------------------------------

--
-- Table structure for table `branchtbl`
--

CREATE TABLE IF NOT EXISTS `branchtbl` (
  `companyId` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `branchId` varchar(20) CHARACTER SET utf8 NOT NULL,
  `branchName` varchar(35) CHARACTER SET utf8 DEFAULT NULL,
  `branchAddress` varchar(35) CHARACTER SET utf8 DEFAULT NULL,
  `branchPhone` varchar(16) CHARACTER SET utf8 DEFAULT NULL,
  `branchFax` varchar(16) CHARACTER SET utf8 DEFAULT NULL,
  `branchemail` varchar(70) CHARACTER SET utf8 DEFAULT NULL,
  `reserve1` varchar(70) CHARACTER SET utf8 DEFAULT NULL,
  `reserve2` varchar(70) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branchtbl`
--

INSERT INTO `branchtbl` (`companyId`, `branchId`, `branchName`, `branchAddress`, `branchPhone`, `branchFax`, `branchemail`, `reserve1`, `reserve2`) VALUES
('101', '001', 'main', 'main', '1234567894', '1234567894', 'main@main', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `companytbl`
--

CREATE TABLE IF NOT EXISTS `companytbl` (
  `companyId` varchar(20) NOT NULL DEFAULT '0',
  `name` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `address` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `branchcode` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `reserved` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `reserved1` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `branchdbname` varchar(50) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `education_detail`
--

CREATE TABLE IF NOT EXISTS `education_detail` (
  `edu_id` varchar(10) DEFAULT NULL,
  `education_type` varchar(35) DEFAULT NULL,
  `record_status` varchar(10) DEFAULT NULL,
  `inputter` varchar(35) DEFAULT NULL,
  `authorizer` varchar(35) DEFAULT NULL,
  `date_time` varchar(20) DEFAULT NULL,
  `curr_number` varchar(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `generalsettings`
--

CREATE TABLE IF NOT EXISTS `generalsettings` (
  `settings_id` int(11) NOT NULL DEFAULT '0',
  `type` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `generalsettings`
--

INSERT INTO `generalsettings` (`settings_id`, `type`, `description`) VALUES
(1, 'system_name', 'Araniko Schoo'),
(2, 'system_title', 'Araniko School'),
(3, 'address', 'Thapathali, Kathmandu'),
(4, 'phone', '9845811251'),
(5, 'email', 'araniko@araniko.com'),
(6, 'session', '2074'),
(7, 'session_english', '2018/19'),
(8, 'vat_pan', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `usertbl`
--

CREATE TABLE IF NOT EXISTS `usertbl` (
  `userid` int(11) NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 NOT NULL,
  `status` varchar(1) CHARACTER SET utf8 NOT NULL DEFAULT '1',
  `givenrole` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `fullName` varchar(30) DEFAULT NULL,
  `post` varchar(30) DEFAULT NULL,
  `staffCode` varchar(10) DEFAULT NULL,
  `startDate` varchar(10) DEFAULT NULL,
  `endDate` varchar(10) DEFAULT NULL,
  `branchId` varchar(10) DEFAULT NULL,
  `roleName` varchar(30) DEFAULT NULL,
  `functionAllowed` varchar(500) DEFAULT NULL,
  `functionRestriction` varchar(500) DEFAULT NULL,
  `branchAllowed` varchar(500) DEFAULT NULL,
  `additionalFunctions` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `branchAllowedFunctions` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `curStatus` varchar(1) CHARACTER SET utf8 DEFAULT '0',
  `reserved5` varchar(50) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usertbl`
--

INSERT INTO `usertbl` (`userid`, `username`, `password`, `status`, `givenrole`, `fullName`, `post`, `staffCode`, `startDate`, `endDate`, `branchId`, `roleName`, `functionAllowed`, `functionRestriction`, `branchAllowed`, `additionalFunctions`, `branchAllowedFunctions`, `curStatus`, `reserved5`) VALUES
(1, 'admin', 'admin', '1', NULL, 'admin', 'admin', '101', '2018-06-19', '2019-06-19', '001', 'admin', NULL, NULL, NULL, NULL, NULL, '0', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `usertbl`
--
ALTER TABLE `usertbl`
  ADD PRIMARY KEY (`userid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `usertbl`
--
ALTER TABLE `usertbl`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
