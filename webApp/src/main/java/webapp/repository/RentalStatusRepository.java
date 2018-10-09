package webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webapp.controller.entity.RentalStatus;


@Repository
public interface RentalStatusRepository extends JpaRepository<RentalStatus,String>{
}

