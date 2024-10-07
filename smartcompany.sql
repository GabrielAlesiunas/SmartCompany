-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 07/10/2024 às 01:34
-- Versão do servidor: 8.3.0
-- Versão do PHP: 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `smartcompany`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `alertas_estoque`
--

DROP TABLE IF EXISTS `alertas_estoque`;
CREATE TABLE IF NOT EXISTS `alertas_estoque` (
  `id` int NOT NULL,
  `id_produto` bigint DEFAULT NULL,
  `data_alerta` date DEFAULT NULL,
  `mensagem` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_produto` (`id_produto`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `alertas_estoque`
--

INSERT INTO `alertas_estoque` (`id`, `id_produto`, `data_alerta`, `mensagem`) VALUES
(1, 1, '2024-09-28', 'Produto com Estoque baixo');

-- --------------------------------------------------------

--
-- Estrutura para tabela `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `id` int NOT NULL,
  `nome` varchar(80) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  `telefone` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `clientes`
--

INSERT INTO `clientes` (`id`, `nome`, `email`, `telefone`) VALUES
(1, 'Gabriel', '247579@facens.br', '15997671792');

-- --------------------------------------------------------

--
-- Estrutura para tabela `estoque`
--

DROP TABLE IF EXISTS `estoque`;
CREATE TABLE IF NOT EXISTS `estoque` (
  `id` int NOT NULL,
  `id_venda` bigint DEFAULT NULL,
  `id_produto` bigint DEFAULT NULL,
  `quantidade` int DEFAULT NULL,
  `preco_unitario` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_venda` (`id_venda`),
  KEY `id_produto` (`id_produto`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `estoque`
--

INSERT INTO `estoque` (`id`, `id_venda`, `id_produto`, `quantidade`, `preco_unitario`) VALUES
(1, 1, 1, 20, 10.00);

-- --------------------------------------------------------

--
-- Estrutura para tabela `fornecedores`
--

DROP TABLE IF EXISTS `fornecedores`;
CREATE TABLE IF NOT EXISTS `fornecedores` (
  `id` int NOT NULL,
  `nome` varchar(80) DEFAULT NULL,
  `contato` varchar(15) DEFAULT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `fornecedores`
--

INSERT INTO `fornecedores` (`id`, `nome`, `contato`, `telefone`, `email`) VALUES
(1, 'HortiExpress', '159999999', 'hortiExpress@gm', '159999999');

-- --------------------------------------------------------

--
-- Estrutura para tabela `pagamentos`
--

DROP TABLE IF EXISTS `pagamentos`;
CREATE TABLE IF NOT EXISTS `pagamentos` (
  `id` int NOT NULL,
  `id_venda` bigint DEFAULT NULL,
  `metodo_pagamento` varchar(20) DEFAULT NULL,
  `data_pagamento` date DEFAULT NULL,
  `valor_pago` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_venda` (`id_venda`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `pagamentos`
--

INSERT INTO `pagamentos` (`id`, `id_venda`, `metodo_pagamento`, `data_pagamento`, `valor_pago`) VALUES
(1, 1, 'a vista', '2024-09-28', 10.00);

-- --------------------------------------------------------

--
-- Estrutura para tabela `produtos`
--

DROP TABLE IF EXISTS `produtos`;
CREATE TABLE IF NOT EXISTS `produtos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) DEFAULT NULL,
  `categoria` varchar(30) DEFAULT NULL,
  `preco` decimal(10,2) DEFAULT NULL,
  `quantidade_estoque` int DEFAULT NULL,
  `limite_estoque` int DEFAULT NULL,
  `data_adicao` date DEFAULT NULL,
  `id_fornecedor` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_fornecedor` (`id_fornecedor`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `produtos`
--

INSERT INTO `produtos` (`id`, `nome`, `categoria`, `preco`, `quantidade_estoque`, `limite_estoque`, `data_adicao`, `id_fornecedor`) VALUES
(1, 'Hortelã', 'vegetal', 10.00, 100, 120, '2024-09-28', 1),
(2, 'Alface Orgânica', 'Vegetais', 3.00, 50, 100, '2024-10-06', 1),
(3, 'Tomate Orgânico', 'Vegetais', 4.50, 75, 150, '2024-10-06', 1),
(4, 'Cenoura Orgânica', 'Vegetais', 2.80, 60, 120, '2024-10-06', 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `vendas`
--

DROP TABLE IF EXISTS `vendas`;
CREATE TABLE IF NOT EXISTS `vendas` (
  `id` bigint NOT NULL,
  `data_venda` date DEFAULT NULL,
  `valor_total` decimal(10,2) DEFAULT NULL,
  `id_cliente` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`id_cliente`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `vendas`
--

INSERT INTO `vendas` (`id`, `data_venda`, `valor_total`, `id_cliente`) VALUES
(1, '2024-09-28', 150.00, 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
