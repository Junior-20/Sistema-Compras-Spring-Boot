package com.Compras.Web.Servicios;

import com.Compras.Web.Entidadades.Proveedor;

import java.util.List;

public interface ProveedorService {
    public List<Proveedor> listarproveedor (String KeyWord);
    public Proveedor guardarproveedor (Proveedor proveedor);
    public Proveedor obtenerproveedorId (Long id);
    public Proveedor actualizarproveedor (Proveedor proveedor);
    public void  eliminarproveedor (Long id);
}
