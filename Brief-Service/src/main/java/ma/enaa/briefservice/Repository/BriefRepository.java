package ma.enaa.briefservice.Repository;

import ma.enaa.briefservice.Model.Brief;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BriefRepository extends JpaRepository<Brief,Long> {
}
