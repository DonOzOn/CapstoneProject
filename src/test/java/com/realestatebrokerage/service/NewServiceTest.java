package com.realestatebrokerage.service;

import com.google.gson.Gson;
import com.realestatebrokerage.domain.News;
import com.realestatebrokerage.repository.NewRepository;
import com.realestatebrokerage.service.dto.NewsDTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

class NewServiceTest {

    @Mock
    private NewRepository newRepository;

    @InjectMocks
    private NewService newService = new NewService();

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAllByDate() {
    }

    @Test
    void createNews() {
        Gson gson = new Gson();
        NewsDTO newDTO = new NewsDTO();
        newDTO.setContent("1");
        newDTO.setId(2L);
        newDTO.setStatus(true);

        News news = new News();
        news.setContent("1");
        news.setId(2L);
        news.setStatus(true);

        when(newRepository.save(news)).thenReturn(news);

        News expect = new News();
        expect = news;

        News actual = new News();
        actual = newService.createNews(newDTO);

        String gsExect = gson.toJson(expect);
        String gsActual = gson.toJson(actual);

//        Assert.assertTrue(EqualsBuilder.reflectionEquals(gsExect, gsActual));

    }

    @Test
    void updateNews() {
    }

    @Test
    void deleteNews() {
    }
}
