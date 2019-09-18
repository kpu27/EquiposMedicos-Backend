package com.gts.equipos.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gts.equipos.modelo.OrdenesDetalle;

public interface OrdenesDetalleRepository extends JpaRepository<OrdenesDetalle, Integer> {
	
	@Query("SELECT p.fkEmpresa, p.fkCliente, count(p.fkEquipos) From OrdenesDetalle p where (p.fechaProgramada != null) AND (p.fechaRealizada = null) AND (p.fkEmpresa.idEmpresa = :idEmpresa) group by p.fkEmpresa.idEmpresa, p.fkCliente.idCliente")
	public List<Object> listarByIdEmpresa(@Param("idEmpresa") Integer idEmpresa);
	 
	@Query("SELECT p.fkEmpresa, p.fkCliente, p.fkEquipos, count(p.fkEquipos) FROM OrdenesDetalle p where (p.fechaProgramada != null) and (p.fkEmpresa.idEmpresa = :idEmpresa)  and  (p.fechaProgramada >= :fechai) and ( p.fechaProgramada <= :fechaf) group by p.fkEmpresa.idEmpresa, p.fkCliente.idCliente,p.fkEquipos.idEquipos")
	public List<Object> listarByEmpresaFecha(@Param("idEmpresa") Integer idEmpresa, @Param("fechai") Date fechai, @Param("fechaf") Date fechaf);
	
	@Query("SELECT p.fkEmpresa, p.fkCliente, count(p.fkEquipos) FROM OrdenesDetalle p where (p.fechaProgramada != null) and (p.fkEmpresa.idEmpresa = :idEmpresa)  and  (p.fechaProgramada >= :fechai) and ( p.fechaProgramada <= :fechaf) group by p.fkEmpresa.idEmpresa, p.fkCliente.idCliente")
	public List<Object> listarByEmpresaCliente(@Param("idEmpresa") Integer idEmpresa, @Param("fechai") Date fechai, @Param("fechaf") Date fechaf);
	
	@Query("SELECT p.fkEmpresa, p.fkResponsable, count(p.fkEquipos) FROM OrdenesDetalle p where (p.fechaProgramada != null) and (p.fkEmpresa.idEmpresa = :idEmpresa)  and  (p.fechaProgramada >= :fechai) and ( p.fechaProgramada <= :fechaf) group by p.fkEmpresa.idEmpresa,p.fkResponsable")
	public List<Object> listarByEmpresaResponsable2(@Param("idEmpresa") Integer idEmpresa, @Param("fechai") Date fechai, @Param("fechaf") Date fechaf);
	
	@Query("SELECT p.fkEmpresa, p.fkCliente, p.fkResponsable, count(p.fkEquipos) FROM OrdenesDetalle p where (p.fechaProgramada != null) and (p.fkEmpresa.idEmpresa = :idEmpresa)  and  (p.fechaProgramada >= :fechai) and ( p.fechaProgramada <= :fechaf) group by p.fkEmpresa.idEmpresa, p.fkCliente.idCliente,p.fkResponsable")
	public List<Object> listarByEmpresaResponsable(@Param("idEmpresa") Integer idEmpresa, @Param("fechai") Date fechai, @Param("fechaf") Date fechaf);
	

}
