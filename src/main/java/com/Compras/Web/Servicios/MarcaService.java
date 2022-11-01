package com.Compras.Web.Servicios;

import com.Compras.Web.Entidadades.Departamento;
import com.Compras.Web.Entidadades.Marca;

import java.util.List;

public interface MarcaService {
    public List<Marca> listarmarcas(String keyWord);

    public Marca guardarmarca(Marca marca);

    public Marca obtenermarcaId(Long id);

    public Marca actualizarMarca(Marca marca);

    public void eliminarmarca(Long id);
}
