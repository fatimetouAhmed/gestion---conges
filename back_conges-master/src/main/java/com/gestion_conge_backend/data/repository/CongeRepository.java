package com.gestion_conge_backend.data.repository;

import com.gestion_conge_backend.data.entities.CongeEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CongeRepository extends JpaRepository<CongeEntity,Integer> {
  //  String stat="Non Confirmer";
    @Query("SELECT c FROM CongeEntity   c WHERE c.status ='' or c.status IS NULL")
    List<CongeEntity> conge_NO_Confirmer();
    @Query(value = "SELECT * FROM conge c WHERE c.status ='' or c.status IS NULL",nativeQuery = true)
    List<CongeEntity> conge_NO_ConfirmerSQL();
    @Query("SELECT c FROM CongeEntity   c WHERE c.status ='Confirmer'")
    List<CongeEntity> congeConfirmer();
    @Query(value = "SELECT * FROM conge c WHERE c.status ='Confirmer'",nativeQuery = true)
    List<CongeEntity> congeConfirmerSQL();
    @Query("SELECT c FROM CongeEntity   c WHERE c.status ='Refuser'")
    List<CongeEntity> congeRefuser();
    @Query(value = "SELECT * FROM conge c WHERE c.status ='Refuser'",nativeQuery = true)
    List<CongeEntity> congeRefuserSQL();
  @Query("SELECT c FROM CongeEntity   c WHERE c.status ='Confirmer' and c.emploiyee=1")
  List<CongeEntity> congeConfirmerUser();
  @Query(value = "SELECT * FROM conge c WHERE c.status ='Confirmer' and c.emploiyee=1",nativeQuery = true)
  List<CongeEntity> congeConfirmerUserSQL();
}
