package api.repository;

import api.model.FaasMetric;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FaasMetricRepository extends JpaRepository<FaasMetric, Long> {

}
