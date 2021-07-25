-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 25 Jul 2021 pada 06.06
-- Versi server: 10.1.36-MariaDB
-- Versi PHP: 5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `scashier`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `KodeBarang` varchar(15) NOT NULL,
  `NamaBarang` varchar(50) NOT NULL,
  `HargaBeli` int(10) NOT NULL,
  `HargaJual` int(10) NOT NULL,
  `Stock` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`KodeBarang`, `NamaBarang`, `HargaBeli`, `HargaJual`, `Stock`) VALUES
('B001', 'Pigura 4 RS minimalis', 8000, 10000, 39),
('B002', 'Pigura 14 RS', 30000, 32000, 46),
('B003', 'Pigura 10 RS', 24000, 26000, 42),
('B004', 'Pigura 6 RS', 10000, 12000, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `beli`
--

CREATE TABLE `beli` (
  `NoBeli` varchar(15) NOT NULL,
  `KodeBarang` varchar(15) NOT NULL,
  `NamaBarang` varchar(50) NOT NULL,
  `TanggalBeli` date NOT NULL,
  `HargaBeli` int(10) NOT NULL,
  `Jumlah` int(10) NOT NULL,
  `TotalHarga` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `beli`
--

INSERT INTO `beli` (`NoBeli`, `KodeBarang`, `NamaBarang`, `TanggalBeli`, `HargaBeli`, `Jumlah`, `TotalHarga`) VALUES
('P001', 'B001', 'Pigura 4 RS minimalis', '2021-07-08', 8000, 10, 80000),
('P002', 'B002', 'Pigura 14 RS', '2021-07-08', 30000, 5, 150000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `djual`
--

CREATE TABLE `djual` (
  `id_jual` int(10) NOT NULL,
  `no_jual` varchar(10) NOT NULL,
  `KodeBarang` varchar(15) NOT NULL,
  `HargaJual` int(10) NOT NULL,
  `Jumlah` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `djual`
--

INSERT INTO `djual` (`id_jual`, `no_jual`, `KodeBarang`, `HargaJual`, `Jumlah`) VALUES
(1, 'NOTA-1', 'B001', 10000, 1),
(2, 'NOTA-2', 'B001', 10000, 3),
(3, 'NOTA-2', 'B002', 32000, 2),
(4, 'NOTA-2', 'B003', 26000, 2),
(5, 'NOTA-3', 'B002', 32000, 4),
(6, 'NOTA-3', 'B001', 10000, 5),
(7, 'NOTA-4', 'B003', 26000, 2);

--
-- Trigger `djual`
--
DELIMITER $$
CREATE TRIGGER `t_keluar` AFTER INSERT ON `djual` FOR EACH ROW BEGIN
UPDATE barang SET Stock = Stock - NEW.Jumlah
WHERE KodeBarang = NEW.KodeBarang;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `NoId` varchar(10) NOT NULL,
  `UserName` varchar(50) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `HakAkses` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`NoId`, `UserName`, `Nama`, `Password`, `HakAkses`) VALUES
('U001', 'kasir', 'widya', '123456', 'Kasir'),
('U002', 'pemilik', 'widya', '123456', 'Pemilik');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penjualan`
--

CREATE TABLE `penjualan` (
  `no_jual` varchar(10) NOT NULL,
  `tgl_jual` date NOT NULL,
  `nama_konsumen` varchar(50) NOT NULL,
  `total` int(10) NOT NULL,
  `bayar` int(10) NOT NULL,
  `kembalian` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `penjualan`
--

INSERT INTO `penjualan` (`no_jual`, `tgl_jual`, `nama_konsumen`, `total`, `bayar`, `kembalian`) VALUES
('NOTA-1', '2021-07-10', 'widya', 10000, 10000, 0),
('NOTA-2', '2021-07-10', 'Ahmad', 146000, 150000, 4000),
('NOTA-3', '2021-07-16', 'Ahmad', 178000, 200000, 22000),
('NOTA-4', '2021-07-20', 'Agung', 52000, 55000, 3000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `supplier`
--

CREATE TABLE `supplier` (
  `KodeSupplier` varchar(15) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `NoTelepon` varchar(13) NOT NULL,
  `Alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `supplier`
--

INSERT INTO `supplier` (`KodeSupplier`, `Nama`, `NoTelepon`, `Alamat`) VALUES
('S001', 'CV ANDALA JAYA', '021765454254', 'Jl.sereseng sawah No .23 jakarta selatan'),
('S002', 'rs .sederhana', '02198763567', 'jl dekat raya no 32 jakarta selatan'),
('S003', 'cv makmur adil', '0834562176656', 'jl makmur adil no 31 jakarta selatan'),
('S004', 'klink restu ibu', '067647362767', 'jl swada raya no 32 jakarta selatan'),
('S005', 'cv galang rambu', '07383276372', 'jl lebak sari raya n055'),
('S006', 'cv makmur', '087627166726', 'jl.lebak sari  raya'),
('S007', 'cv makmur  jaya', '08627637676', 'jl lebak sari raya'),
('S008', ' Cv Bangun Jaya', '0219873637636', 'jl poltangan raya no 23 ');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`KodeBarang`);

--
-- Indeks untuk tabel `beli`
--
ALTER TABLE `beli`
  ADD PRIMARY KEY (`NoBeli`),
  ADD KEY `KodeBarang` (`KodeBarang`);

--
-- Indeks untuk tabel `djual`
--
ALTER TABLE `djual`
  ADD PRIMARY KEY (`id_jual`),
  ADD KEY `no_jual` (`no_jual`),
  ADD KEY `KodeBarang` (`KodeBarang`);

--
-- Indeks untuk tabel `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`NoId`);

--
-- Indeks untuk tabel `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`no_jual`);

--
-- Indeks untuk tabel `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`KodeSupplier`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `djual`
--
ALTER TABLE `djual`
  MODIFY `id_jual` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `beli`
--
ALTER TABLE `beli`
  ADD CONSTRAINT `beli_ibfk_1` FOREIGN KEY (`KodeBarang`) REFERENCES `barang` (`KodeBarang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
