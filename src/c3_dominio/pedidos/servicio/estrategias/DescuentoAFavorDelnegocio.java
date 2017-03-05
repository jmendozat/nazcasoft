/*
 * Copyright (c) 2015, 2016, Nazca. Todos los derechos reservados.
 * NAZCA PROPIEDAD/CONFIDENCIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package c3_dominio.pedidos.servicio.estrategias;

import java.util.ArrayList;
import c3_dominio.pedidos.contrato.ICalculoDescuento;
import c3_dominio.pedidos.entidad.Pedido;
import c5_transversal.excepciones.ExcepcionRegla;

/**
 * 
 * @author <AdvanceSoft - Mendoza Torres Valentin - valentin2512jeses@gmail.com>
 */
public class DescuentoAFavorDelnegocio extends CalculaDescuentoCompuesto {

    public DescuentoAFavorDelnegocio() {
        estrategiasdescuentos = new ArrayList();
        ICalculoDescuento estrategiauno = new CalcularDescuentoPorcentaje();
        estrategiasdescuentos.add(estrategiauno);
        ICalculoDescuento estrategiados = new CalcularPorNumeroDePlatos();
        estrategiasdescuentos.add(estrategiados);

    }

    @Override
    public double calcularDescuento(Pedido pedido) {
        double descuentomenor = 0.0, descuento;
        if (estrategiasdescuentos.size() > 0) {
            descuentomenor = estrategiasdescuentos.get(0).calcularDescuento(pedido);
        }
        for (ICalculoDescuento estrategiadescuento : estrategiasdescuentos) {
            descuento = estrategiadescuento.calcularDescuento(pedido);
            if (descuento < descuentomenor) {
                descuentomenor = descuento;
            }
        }
        return descuentomenor;
    }

    @Override
    public ICalculoDescuento crearCalculoDescuento(Pedido pedido) throws ExcepcionRegla {
        return new DescuentoAFavorDelnegocio();
    }

}
