package com.utn.persistenciajpa;

import com.utn.persistenciajpa.entidades.*;
import com.utn.persistenciajpa.enums.EstadoPedido;
import com.utn.persistenciajpa.enums.FormaPago;
import com.utn.persistenciajpa.enums.TipoEnvio;
import com.utn.persistenciajpa.enums.TipoProducto;
import com.utn.persistenciajpa.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class PersistenciajpaApplication {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	RubroRepository rubroRepository;

	public static void main(String[] args) {
		SpringApplication.run(PersistenciajpaApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ClienteRepository clienteRepository){
		return args -> {
			System.out.println("Eh tu, al fin has despertado");

			Domicilio domicilio1 = Domicilio.builder()
					.calle("Balgruff")
					.numero("2541")
					.localidad("Cuenca del Dragon")
					.build();

			Domicilio domicilio2 = Domicilio.builder()
					.calle("Alduin")
					.numero("524")
					.localidad("Carrera Blanca")
					.build();

			Cliente cliente = Cliente.builder()
					.nombre("Farengar")
					.apellido("Fuego Secreto")
					.telefono("2614253442")
					.email("catarataslugubres@gmail.com")
					.build();

			cliente.agregarDomicilio(domicilio1);
			cliente.agregarDomicilio(domicilio2);

			clienteRepository.save(cliente);
			Cliente clienteRecuperadoo = clienteRepository.findById(cliente.getId()).orElse(null);

			if (clienteRecuperadoo != null) {
				System.out.println("Nombre: " + clienteRecuperadoo.getNombre());
				System.out.println("Apellido: " + clienteRecuperadoo.getApellido());
				System.out.println("Telefono: " + clienteRecuperadoo.getTelefono());
				System.out.println("Email: " + clienteRecuperadoo.getEmail());
				clienteRecuperadoo.mostrarDomicilios();
			}

			Producto producto1 = Producto.builder()
					.denominacion("Pocion de salud")
					.unidadMedida("1 botella")
					.precioCompra(67)
					.precioVenta(53)
					.receta("Garras de oso, Dedo del gigante, Seta brillante, Musgo colgante, Trigo, Flor azul de montaña, Flor amarilla de montaña")
					.stockActual(15)
					.stockMinimo(5)
					.tipoProducto(TipoProducto.MANUFACTURADO)
					.tiempoEstimadoCocina(5)
					.build();

			Producto producto2 = Producto.builder()
					.denominacion("Pocion de fuerza")
					.unidadMedida("1 botella")
					.precioCompra(170)
					.precioVenta(123)
					.receta("Dedo del gigante, Pico de halcon, Betty de rio, Foliota escamosa, Enseres de fuego fatuo, Raiz trepadora")
					.stockActual(23)
					.stockMinimo(5)
					.tipoProducto(TipoProducto.MANUFACTURADO)
					.tiempoEstimadoCocina(2)
					.build();

			Rubro rubro1 = Rubro.builder()
					.denominacion("Pociones")
					.build();

			rubro1.agregarProducto(producto1);
			rubro1.agregarProducto(producto2);

			rubroRepository.save(rubro1);

			Rubro rubroRecuperadoo = rubroRepository.findById(rubro1.getId()).orElse(null);

			if (rubroRecuperadoo != null) {
				System.out.println("Denominacion: " + rubroRecuperadoo.getDenominacion());
				rubroRecuperadoo.mostrarProducto();
			}

			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(10)
					.subtotal(670)
					.build();

			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(10)
					.subtotal(1700)
					.build();

			detallePedido1.setProducto(producto1);
			detallePedido2.setProducto(producto2);

			SimpleDateFormat fechaFormato = new SimpleDateFormat("yyyy-MM-dd");
			String fechaString1 = "2023-09-13";
			String fechaString2 = "2023-09-14";
			Date fechaPedido1 = fechaFormato.parse(fechaString1);
			Date fechaPedido2 = fechaFormato.parse(fechaString2);

			Pedido pedido1 = Pedido.builder()
					.estadoPedido(EstadoPedido.INICIADO)
					.fecha(fechaPedido1)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.total(770)
					.build();

			Pedido pedido2 = Pedido.builder()
					.estadoPedido(EstadoPedido.EN_PREPARACION)
					.fecha(fechaPedido2)
					.tipoEnvio(TipoEnvio.RETIRO)
					.total(1700)
					.build();

			pedido1.agregarDetalle(detallePedido1);
			pedido2.agregarDetalle(detallePedido2);

			Factura factura1 = Factura.builder()
					.numero(54)
					.fecha(fechaPedido1)
					.descuento(77)
					.total(770)
					.formaPago(FormaPago.EFECTIVO)
					.build();

			Factura factura2 = Factura.builder()
					.numero(55)
					.fecha(fechaPedido2)
					.descuento(0)
					.total(1700)
					.formaPago(FormaPago.TRANSFERENCIA)
					.build();

			pedido1.setFactura(factura1);
			pedido2.setFactura(factura2);
		};
	}

}



