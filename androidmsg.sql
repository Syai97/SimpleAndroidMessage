-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 18, 2017 at 09:11 AM
-- Server version: 10.1.22-MariaDB
-- PHP Version: 7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `androidmsg`
--

CREATE TABLE `androidmsg` (
  `id` int(11) NOT NULL,
  `nama` varchar(200) NOT NULL,
  `kp` varchar(200) NOT NULL,
  `deviceid` varchar(400) NOT NULL,
  `Token` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `androidmsg`
--

INSERT INTO `androidmsg` (`id`, `nama`, `kp`, `deviceid`, `Token`) VALUES
(2, '', '', 'cddd3676e84df622', 'cR9xUnCV91c:APA91bGTL3hbBskPNq2wVStZc5djMlESotBXAw0DBOFmEkH_lxry68yVw8OQKNP5FshGx6dyD2oYK9S6zzr-sHdAZm9q5e8SWTj20in64nckRR2i49Z92LwiFvDlQfIujWdOAljAfORA'),
(3, 'ãƒãƒ³ã‚¿ãƒ¼', '123456789123', '6d9fd7246e221fbc', 'eEgiF0GE3jw:APA91bGfrX4tK113d1EbKm52wcqQ9gEbIZucE9oC_5EBIaPNs9LT-28-yA_y4ucrE_Y33JhIROg2xbm5hqIVrUJEhAwNEcrjZjAYaeApFzSOq5PjtazBTcJI2gkRA_bIEMzOY9EorIQW'),
(4, 'Shatiree', '970507875023', '7608639aefbe032c', 'dDTtHDqOk8E:APA91bEewPARjcS7U3Ym8Rag2n_RaHx-nqT2ZzxfHEWL71QxjLytHuddjtnUemuEKY519cxMNxAYrO-L9XA8astZ4HEXBJ9QoakEwZh7EGh1k0sWO4LLK22WXL4jwyUDw6iS6f188EBW'),
(5, 'Syaiful', '18726629', 'b383e71d9a545b7f', 'cWyAFqM9jCo:APA91bGtKtlscnDcP2AP-_nUHLz714bLDrcHcyi7Zxtoh5M5C5DY4AkumPNJlMHIStibpznMZQRLAUL-lOyrbUniF4sTBmtSofMa-1g3rt6rHvf5UqIn6Qj_D54hCAgPq3jnUG9FhqiX'),
(7, 'Emulator', '213342443', 'cabb33ad93f4ec50', 'e9Hf4FyyL8E:APA91bHiFXmuuk2le9dthVanHy_C6aP6ivuJUz4uEGSRxtU2lLCHYRmTEKj9-x1p73d2qhGpBpZgljFSUt1PRFtYHVY3WKuPpfMxrsD-XjHGoShB_265cjp_k0fvMvBSiP1iHinvTdPN');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `androidmsg`
--
ALTER TABLE `androidmsg`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Token` (`Token`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `androidmsg`
--
ALTER TABLE `androidmsg`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
