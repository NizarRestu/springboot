package com.materi_spring.java.repository;

import com.materi_spring.java.model.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarangRepository extends JpaRepository<Barang , Long> {
}
