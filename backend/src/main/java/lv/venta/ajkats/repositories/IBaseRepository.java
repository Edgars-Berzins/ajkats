package lv.venta.ajkats.repositories;

import lv.venta.ajkats.models.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBaseRepository<T extends BaseEntity, I> extends JpaRepository<T, I> {

}
