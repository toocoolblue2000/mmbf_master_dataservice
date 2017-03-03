package in.co.mmbf.services.data.jpa.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import in.co.mmbf.services.data.jpa.domain.MemberType;

@RepositoryRestResource(collectionResourceRel = "member-types", path = "member-type")
interface MemberTypeRepository extends CrudRepository<MemberType, Long> {

	MemberType findByNameAndActive(String name, boolean active);

	List<MemberType> findAll();

}
