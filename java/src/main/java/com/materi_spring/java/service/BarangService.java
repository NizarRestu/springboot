package com.materi_spring.java.service;

import com.materi_spring.java.exception.NotFoundException;
import com.materi_spring.java.model.Barang;
import com.materi_spring.java.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BarangService {
    @Autowired
    private BarangRepository barangRepository;

    public Barang tambah(Barang barang){
     return barangRepository.save(barang);
    }
    public Barang getById(Long id){
        return barangRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Not Found"));
    }
    public List<Barang> getAll(){
        return barangRepository.findAll();
    }
    public Barang edit(Barang barang , Long id){
        Barang update = barangRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Not Found"));
        update.setNama(barang.getNama());
        update.setTanggal(barang.getTanggal());
        update.setStok(barang.getStok());
        update.setJenis(barang.getJenis());
        update.setHarga(barang.getHarga());
        update.setDeskripsi(barang.getDeskripsi());
        return barangRepository.save(update);
    }
    public Map<String , Boolean> delete(Long id){
        try {
            barangRepository.deleteById(id);
            Map<String , Boolean> map = new HashMap<>();
            map.put("Deleted" , Boolean.TRUE);
            return map;
        } catch (Exception e) {
            return null;
        }
    }
}