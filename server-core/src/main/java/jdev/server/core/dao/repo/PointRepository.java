package jdev.server.core.dao.repo;

import jdev.server.core.dao.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PointRepository extends JpaRepository<Point, Integer> {
    @Query("SELECT p FROM Point p WHERE p.time >= (:currentTime - :time) AND p.auto.idAuto LIKE :autoId")
    public Iterable<Point> filterByTime(@Param("autoId") String autoId,
                                        @Param("time") long time,
                                        @Param("currentTime") long currentTime);
}