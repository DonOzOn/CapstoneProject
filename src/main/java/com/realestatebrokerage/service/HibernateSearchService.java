package com.realestatebrokerage.service;
import com.realestatebrokerage.domain.ProductPost;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.BooleanJunction;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Service
public class HibernateSearchService {


    @Autowired
    private final EntityManager entityManager;


    @Autowired
    public HibernateSearchService(EntityManager entityManager) {
        super();
        this.entityManager = entityManager;
    }


    public void initializeHibernateSearch() {
        try {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public List<ProductPost> fuzzySearch(String searchTerm) {
        initializeHibernateSearch();
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(ProductPost.class).get();

        Query luceneQuery =
          qb.bool().must(qb.keyword().fuzzy()
            .withEditDistanceUpTo(2)
            .withPrefixLength(0)
            .onFields("productPostTitle","projectName",
                "province.name","ward.name","district.name","product.price",
                "product.area","product.direction_directionName","product.type_productTypeName",
                "product.typeChild_productTypeChildName")
            .matching(searchTerm).createQuery())
              .must(qb.keyword().onField("status").matching(true).createQuery())
              .createQuery()
            ;

        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, ProductPost.class);
        List<ProductPost> BaseballCardList = null;
        try {
            BaseballCardList = jpaQuery.getResultList();
        } catch (NoResultException nre) {
            ;// do nothing

        }

        return BaseballCardList;


    }
}
