package in.co.mmbf.services.data.jpa.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import in.co.mmbf.services.data.jpa.domain.Collateral;
import in.co.mmbf.services.data.jpa.domain.CollateralType;

@RepositoryRestResource(collectionResourceRel = "collaterals", path = "collateral")
interface CollateralRepository extends CrudRepository<Collateral, Integer> {

	List<Collateral> findByCollateralType(CollateralType collateralType);

	List<Collateral> findAll();
}
