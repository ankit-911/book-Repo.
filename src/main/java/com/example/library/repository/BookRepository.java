package com.example.library.repository;

import com.example.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {

    List<Book> findByIsDeleted(Boolean isDeleted);

    Book findByIdAndIsDeleted(Integer id, Boolean isDeleted);

//    List<Book> findAllById(Iterable<Integer> integers);

    //    @Query("select b from Book b where (:title IS NULL OR b.title like %:title%) " +
//            "AND  (:author IS NULL OR b.author like %:author%)" +
//            "AND (:minYear IS NULL OR b.yearPublished >= :minYear)" +
//            "AND (:maxYear IS NULL OR b.yearPublished <= :maxYear)" +
//            "AND (:minPrice IS NULL OR b.price >= :minPrice)" +
//            "AND (:minPrice IS NULL OR b.price <= :minPrice)" +
//            "ORDER BY " +
//            "CASE when :sortBy = 'price' then b.price END * :sortOrder NULLS LAST, " +
//            "CASE when :sortBy = 'yearPublished' then b.yearPublished END * :sortOrder ASC NULLS FIRST"
//    )
//    Page<Book> searchBooks(String title, String author, Double minPrice,
//                           Double maxPrice, Integer minYear, Integer maxYear,
//                           Pageable pageable);


//    @Query("select b from Book b where b.author =: author ORDER BY b.price")
//    List<Book> findBookByName(@Param("author") String author);
//    @Query("select b from Book b where b.price =: price")
//    List<Book> findBooksByPrice(@Param("price") double price);
//
//    List<Book> findBooksByTitleContainingIgnoreCase(String title);
//    @Query("select b from Book b where b.yearPublished =: yearPublished")
//    List<Book> findBooksByYearPublished(@Param("yearPublished") int yearPublished);
}
