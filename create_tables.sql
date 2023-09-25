-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 08-Fev-2021 às 13:57
-- Versão do servidor: 10.1.36-MariaDB
-- versão do PHP: 7.2.11

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
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `id_pessoa` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `endereco` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`id_pessoa`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `id_pessoa` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

CREATE TABLE `cpf` (
  `idCpf` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) NOT NULL,
  `digito` int(11) NOT NULL,
  PRIMARY KEY (idCpf)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cpf`
--

INSERT INTO `cpf` (`idCpf`, `numero`, `digito`) VALUES
(1, 654323445, 12);

-- --------------------------------------------------------

CREATE TABLE `empregado` (
  `idEmpregado` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `idCpf` int(11) NOT NULL,
   PRIMARY KEY (idEmpregado)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--
--
-- Indexes for table `empregado`
--
ALTER TABLE `empregado`
  ADD KEY `fk_cpf` (`idCpf`);

--
-- AUTO_INCREMENT for dumped tables
--
--
-- Limitadores para a tabela `empregado`
--
ALTER TABLE `empregado`
  ADD CONSTRAINT `fk_cpf` FOREIGN KEY (`idCpf`) REFERENCES `cpf` (`idCpf`);
COMMIT;