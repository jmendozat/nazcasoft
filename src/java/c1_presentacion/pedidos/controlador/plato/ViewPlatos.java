/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1_presentacion.pedidos.controlador.plato;

import c2_aplicacion.pedidos.servicio.GestionarPlatoServicio;
import c3_dominio.pedidos.entidad.Pedido;
import c3_dominio.pedidos.entidad.Plato;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import c3_dominio.pedidos.contrato.ICalculoDescuento;
import c3_dominio.pedidos.servicio.factoryestrategia.FabricaEstrategia;
import c5_transversal.excepciones.ExcepcionRegla;
import c5_transversal.excepciones.ExcepcionSQL;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres Valentin - advancesoft.trujillo@gmail.com>
 */
public class ViewPlatos extends GestionarPlatoComando {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String ruta = "/WEB-INF/c1_presentacion/pedidos/view/plato/PageViewPlatos.jsp";
        try {
            List<Plato> listaPlatos = GestionarPlatoServicio.getInstancia().func_NAZCA_PEDIDO_BuscarPlatoPorNombre("");
            request.setAttribute("listViewPlatos", listaPlatos);
            Pedido pedido = new Pedido();
            FabricaEstrategia fabricaEstrategia = FabricaEstrategia.getInstancia();
                    ICalculoDescuento estrategiaDescuento = fabricaEstrategia.crearCalculoDescuento(pedido);
                    pedido.setEstrategiadescuento(estrategiaDescuento);
            HttpSession sesionPedido = request.getSession(true);
            sesionPedido.setAttribute("pedido", pedido);
        } catch (ExcepcionSQL | ExcepcionRegla e) {

        }
        return ruta;
    }
  

}
