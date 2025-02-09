package korweb.model.repository;

import korweb.model.entity.BoardEntity;
import korweb.model.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    @Query(value = "SELECT * FROM board WHERE cno = :cno ORDER BY bno DESC", nativeQuery = true)
    Page<BoardEntity> findByCno(@Param("cno") int cno, Pageable pageable);
}
