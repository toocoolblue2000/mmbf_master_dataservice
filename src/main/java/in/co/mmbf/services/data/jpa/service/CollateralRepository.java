package in.co.mmbf.services.data.jpa.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import in.co.mmbf.services.data.jpa.domain.MemberType;
import in.co.mmbf.services.data.jpa.domain.Collateral;

@RepositoryRestResource(collectionResourceRel = "hotels", path = "hotels")
interface CollateralRepository extends PagingAndSortingRepository<Collateral, Long> {

	Collateral findByCityAndName(MemberType city, String name);

}
