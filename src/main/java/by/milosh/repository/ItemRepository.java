package by.milosh.repository;

import by.milosh.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    String RU = "ru";
    String EN = "en";

    @Query(value = "select i.name as name from item as item "
            + "join item_" + RU + " as i "
            + "on item.id = i.id "
            + "where item.code=?1", nativeQuery = true)
    String getItemNameRu(Integer code);

    @Query(value = "select i.name as name from item as item "
            + "join item_" + EN + " as i "
            + "on item.id = i.id "
            + "where item.code=?1", nativeQuery = true)
    String getItemNameEn(Integer code);

    @Query(value = "select a.name from item as item "
            + "join item_attribute as ia "
            + "on item.id = ia.item_id "
            + "join attribute_" + RU + " as a "
            + "on ia.attribute_id = a.id "
            + "where item.code = ?1", nativeQuery = true)
    List<String> getAttributesRu(Integer code);

    @Query(value = "select a.name from item as item " +
            "join item_attribute as ia on item.id = ia.item_id join attribute_" + EN
            + " as a on ia.attribute_id = a.id where item.code = ?1", nativeQuery = true)
    List<String> getAttributesEn(Integer code);
}
