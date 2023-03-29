package com.proyecto.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.proyecto.dao.VendedorDao;
import com.proyecto.entities.Vendedor;



@Service

public class VendedorServiceImpl implements VendedorService{

    @Autowired
    private VendedorDao vendedorDao;

    @Override
    public List<Vendedor> findAll() {
     return vendedorDao.findAll();
    }

    @Override
    public Vendedor findById(int idVendedor) {
        return vendedorDao.findById(idVendedor).get();
    }

    //Los metodos Save y delete llevan ademas el @Transactional
    @Override
    @Transactional
    public void save(Vendedor vendedor) {
        vendedorDao.save(vendedor);
    }

    @Override
    @Transactional
    public void deleteById(int idVendedor) {
        vendedorDao.deleteById(idVendedor);
    }

    
    
}