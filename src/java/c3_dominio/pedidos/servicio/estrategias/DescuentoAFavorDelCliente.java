/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominio.pedidos.servicio.estrategias;

import java.util.ArrayList;
import c3_dominio.pedidos.contrato.ICalculoDescuento;
import c3_dominio.pedidos.entidad.Pedido;
import c5_transversal.excepciones.ExcepcionRegla;

/**
 *
 * @author CLIENTE
 */
public class DescuentoAFavorDelCliente extends CalculaDescuentoCompuesto {

    public DescuentoAFavorDelCliente() {
        estrategiasdescuentos = new ArrayList();
        ICalculoDescuento estrategiauno = new CalcularDescuentoPorcentaje();
        estrategiasdescuentos.add(estrategiauno);
        ICalculoDescuento estrategiados = new CalcularPorNumeroDePlatos();
        estrategiasdescuentos.add(estrategiados);
    }

    @Override
    public double calcularDescuento(Pedido pedido) {
        double descuentomayor = 0.0, descuento;
        if (estrategiasdescuentos.size() > 0) {
            descuentomayor = estrategiasdescuentos.get(0).calcularDescuento(pedido);
        }
        for (ICalculoDescuento estrategiadescuento : estrategiasdescuentos) {
            descuento = estrategiadescuento.calcularDescuento(pedido);
            if (descuento > descuentomayor) {
                descuentomayor = descuento;
            }
        }
        return descuentomayor;
    }

    @Override
    public ICalculoDescuento crearCalculoDescuento(Pedido pedido) throws ExcepcionRegla {
        return new DescuentoAFavorDelCliente();
    }

}
