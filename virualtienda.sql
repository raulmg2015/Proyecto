-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-03-2015 a las 18:32:44
-- Versión del servidor: 5.6.16
-- Versión de PHP: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `virualtienda`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE IF NOT EXISTS `categoria` (
  `idCategoria` int(11) NOT NULL,
  `Nombre_categoria` varchar(45) NOT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`idCategoria`, `Nombre_categoria`, `Descripcion`) VALUES
(1, 'ropa', NULL),
(2, 'deportes', NULL),
(3, 'vehiculo', NULL),
(4, 'electonica', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE IF NOT EXISTS `compras` (
  `idCompras` int(11) NOT NULL AUTO_INCREMENT,
  `idOfertas` int(11) NOT NULL,
  `Usuario_compra` int(11) NOT NULL,
  `Forma_pago` varchar(45) DEFAULT NULL,
  `Fecha` date DEFAULT NULL,
  `IdEnvio` int(11) NOT NULL,
  `Cantidad` int(11) DEFAULT NULL,
  `Precio_Total_compra` float DEFAULT NULL,
  `Precio_comp_envio` float DEFAULT NULL,
  PRIMARY KEY (`idCompras`,`idOfertas`,`Usuario_compra`,`IdEnvio`),
  KEY `Ofertas_idOfertas_fk_idx` (`idOfertas`),
  KEY `Usuario_idUsuario_compra_vende_fk_idx` (`Usuario_compra`),
  KEY `envio_idEnvio_fk_idx` (`IdEnvio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datos_bancarios_usuario`
--

CREATE TABLE IF NOT EXISTS `datos_bancarios_usuario` (
  `Numero_cuenta` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `banco` varchar(45) NOT NULL,
  `observaciones` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`Numero_cuenta`),
  KEY `DatoBanc_Usuarios_idUsuarios_fk_idx` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entidad`
--

CREATE TABLE IF NOT EXISTS `entidad` (
  `idEntidad` int(11) NOT NULL,
  `Nombre_entidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEntidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `entidad`
--

INSERT INTO `entidad` (`idEntidad`, `Nombre_entidad`) VALUES
(1, 'Aguascalientes'),
(2, 'Baja California'),
(3, 'Baja California Sur'),
(4, 'Campeche'),
(5, 'Chiapas'),
(6, 'Chihuahua'),
(7, 'Coahuila'),
(8, 'Colima'),
(9, 'Distrito Federal'),
(10, 'Durango'),
(11, 'Estado de M'),
(12, 'Guanajuato'),
(13, 'Guerrero'),
(14, 'Hidalgo'),
(15, 'Jalisco'),
(16, 'Michoac'),
(17, 'Morelos'),
(18, 'Nayarit'),
(19, 'Nuevo Le'),
(20, 'Oaxaca'),
(21, 'Puebla'),
(22, 'Quer'),
(23, 'Quintana Roo'),
(24, 'San Luis Potos'),
(25, 'Sinaloa'),
(26, 'Sonora'),
(27, 'Tabasco'),
(28, 'Tamaulipas'),
(29, 'Tlaxcala'),
(30, 'Veracruz'),
(31, 'Yucat'),
(32, 'Zacatecas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `envio`
--

CREATE TABLE IF NOT EXISTS `envio` (
  `idEnvio` int(11) NOT NULL,
  `FormadeEnvio` varchar(45) DEFAULT NULL,
  `CostoEnvio` float DEFAULT NULL,
  PRIMARY KEY (`idEnvio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ofertas`
--

CREATE TABLE IF NOT EXISTS `ofertas` (
  `idOfertas` int(11) NOT NULL AUTO_INCREMENT,
  `idProducto` int(11) NOT NULL,
  `Usuario_vende` int(11) NOT NULL,
  `Estado` varchar(45) DEFAULT NULL,
  `Precio` float DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `Descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idOfertas`,`idProducto`,`Usuario_vende`),
  KEY `Producto_idProducto_fk_idx` (`idProducto`),
  KEY `Usuario_idUsuario_fk_idx` (`Usuario_vende`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='	' AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `ofertas`
--

INSERT INTO `ofertas` (`idOfertas`, `idProducto`, `Usuario_vende`, `Estado`, `Precio`, `cantidad`, `Descripcion`) VALUES
(1, 1, 3, 'Disponible', 300, 1, 'ofertar solo por email'),
(2, 3, 1, 'Disponible', 5000, 1, 'solo por hoy unica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE IF NOT EXISTS `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `Nombre_producto` varchar(45) NOT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  `nomimagen` int(100) NOT NULL,
  `imagen` blob NOT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `producto_Categoria_idcategoria_fk_idx` (`idCategoria`),
  KEY `producto_usuario_idUsuario_fk_idx` (`idUsuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `idUsuario`, `idCategoria`, `Nombre_producto`, `Descripcion`, `nomimagen`, `imagen`) VALUES
(1, 3, 1, 'playera', 'verde con dibujos de panditas', 0, ''),
(2, 3, 2, 'gorra', 'yankis', 0, ''),
(3, 1, 4, 'computadora', 'completa', 0, ''),
(4, 3, 1, 'vestido', 'muy exotica', 0, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Apellido` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `e_mail` varchar(45) NOT NULL,
  `idEntidad` int(11) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`idUsuario`,`e_mail`),
  UNIQUE KEY `e_mail_UNIQUE` (`e_mail`),
  KEY `Usuario_Entidad_idEntidad_fk_idx` (`idEntidad`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `Nombre`, `Apellido`, `telefono`, `e_mail`, `idEntidad`, `password`) VALUES
(1, 'Alfonso', 'armas', '58323577', 'armasalfonsot@hotmail.com', 9, 'al'),
(2, 'juan', 'villa', '54323512', 'juan@gmail.com', 9, 'j'),
(3, 'Lorena', 'Ayuso', '56078960', 'lorena_0153@hotmail.com', 1, 'esponja'),
(4, 'monse', 'perez', '44690809', 'lorena_0155@hotmail.com', 1, 'silver');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `envio_idEnvio_fk` FOREIGN KEY (`IdEnvio`) REFERENCES `envio` (`idEnvio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Ofertas_idOfertas_fk` FOREIGN KEY (`idOfertas`) REFERENCES `ofertas` (`idOfertas`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Usuario_idUsuario_compra_vende_fk` FOREIGN KEY (`Usuario_compra`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `datos_bancarios_usuario`
--
ALTER TABLE `datos_bancarios_usuario`
  ADD CONSTRAINT `DatoBanc_Usuarios_idUsuarios_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ofertas`
--
ALTER TABLE `ofertas`
  ADD CONSTRAINT `Producto_idProducto_fk` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Usuario_idUsuario_fk` FOREIGN KEY (`Usuario_vende`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_Categoria_idcategoria_fk` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `producto_usuario_idUsuario_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `Usuario_Entidad_idEntidad_fk` FOREIGN KEY (`idEntidad`) REFERENCES `entidad` (`idEntidad`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
