-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 30, 2022 at 03:34 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.0.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbbuku`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `ID_Buku` varchar(10) NOT NULL,
  `Judul` varchar(25) DEFAULT NULL,
  `Pengarang` varchar(30) DEFAULT NULL,
  `Jenis` varchar(20) DEFAULT NULL,
  `Hargabeli` decimal(10,0) DEFAULT NULL,
  `Hargajual` decimal(10,0) DEFAULT NULL,
  `Stok` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`ID_Buku`, `Judul`, `Pengarang`, `Jenis`, `Hargabeli`, `Hargajual`, `Stok`) VALUES
('BK001', 'Kisah si Ler', 'Lerz', 'Fantasy', '100000', '200000', 10),
('BK002', 'Hantu Tinggi seram', 'Lerz', 'Horor', '150000', '250000', 30),
('BK003', 'Antung dan Alif', 'Lerz', 'Fantasy', '30000', '50000', 10),
('BK004', 'Easter EGG 5N', 'Lerz', 'Horor', '30000', '90000', 20),
('BK005', 'Dua Master Piece', 'Lerz', 'Fantasy', '70000', '100000', 20),
('BK006', 'Kisah Banjarmasin', 'Lerz', 'Fantasy', '100000', '200000', 5);

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `NoFaktur` varchar(20) NOT NULL,
  `Tanggal` varchar(20) DEFAULT NULL,
  `ID_Pembeli` varchar(10) DEFAULT NULL,
  `TotalBeli` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pembayaran`
--

INSERT INTO `pembayaran` (`NoFaktur`, `Tanggal`, `ID_Pembeli`, `TotalBeli`) VALUES
('TR0001', '27-12-2022', 'P001', '700000'),
('TR0002', '28-12-2022', 'P002', '480000'),
('TR0003', '28-12-2022', 'P003', '750000'),
('TR0004', '30-12-2022', 'P002', '280000'),
('TR0005', '30-12-2022', 'P006', '160000'),
('TR0006', '30-12-2022', 'P006', '300000');

-- --------------------------------------------------------

--
-- Table structure for table `pembayaranrinci`
--

CREATE TABLE `pembayaranrinci` (
  `NoFaktur` varchar(20) DEFAULT NULL,
  `ID_Buku` varchar(10) DEFAULT NULL,
  `Judul` varchar(30) DEFAULT NULL,
  `Jumlah` int(11) DEFAULT NULL,
  `Harga` decimal(10,0) DEFAULT NULL,
  `Total` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pembayaranrinci`
--

INSERT INTO `pembayaranrinci` (`NoFaktur`, `ID_Buku`, `Judul`, `Jumlah`, `Harga`, `Total`) VALUES
('TR0001', 'BK002', 'Hantu Tinggi seram', 2, '250000', '500000'),
('TR0001', 'BK003', 'Aku dan Kamu', 1, '200000', '200000'),
('TR0002', 'BK005', 'Dua Master Piece', 3, '100000', '300000'),
('TR0002', 'BK004', 'Easter EGG 5N', 2, '90000', '180000'),
('TR0003', 'BK002', 'Hantu Tinggi seram', 3, '250000', '750000'),
('TR0004', 'BK004', 'Easter EGG 5N', 2, '90000', '180000'),
('TR0004', 'BK005', 'Dua Master Piece', 1, '100000', '100000'),
('TR0005', 'BK006', 'Kisah Rakyat', 3, '20000', '60000'),
('TR0005', 'BK005', 'Dua Master Piece', 1, '100000', '100000'),
('TR0006', 'BK006', 'Kisah Banjarmasin', 3, '100000', '300000');

-- --------------------------------------------------------

--
-- Table structure for table `pembeli`
--

CREATE TABLE `pembeli` (
  `ID_Pembeli` varchar(10) NOT NULL,
  `Nama` varchar(25) NOT NULL,
  `Alamat` varchar(30) NOT NULL,
  `Telepon` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pembeli`
--

INSERT INTO `pembeli` (`ID_Pembeli`, `Nama`, `Alamat`, `Telepon`) VALUES
('P001', 'Ricky Mahen', 'kayu tangi', 918281913),
('P002', 'Helmi', 'Kuin', 91291021),
('P003', 'Iwan', 'Cemara', 19282191),
('P004', 'Koko', 'Sultan Adam', 829192144),
('P005', 'Dicky', 'Basirih', 928192011),
('P006', 'Ricky', 'Adhyaksa 6', 18291010);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`ID_Buku`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`NoFaktur`),
  ADD KEY `ID_Pembeli` (`ID_Pembeli`);

--
-- Indexes for table `pembayaranrinci`
--
ALTER TABLE `pembayaranrinci`
  ADD KEY `NoFaktur` (`NoFaktur`),
  ADD KEY `ID_Buku` (`ID_Buku`);

--
-- Indexes for table `pembeli`
--
ALTER TABLE `pembeli`
  ADD PRIMARY KEY (`ID_Pembeli`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pembayaranrinci`
--
ALTER TABLE `pembayaranrinci`
  ADD CONSTRAINT `pembayaranrinci_ibfk_1` FOREIGN KEY (`NoFaktur`) REFERENCES `pembayaran` (`NoFaktur`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
