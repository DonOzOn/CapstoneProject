package com.realestatebrokerage.service;

import com.google.gson.Gson;
import com.realestatebrokerage.domain.News;
import com.realestatebrokerage.repository.NewRepository;
import com.realestatebrokerage.service.dto.NewsDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
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

        when(newRepository.save(Mockito.any(News.class))).thenReturn(news);

        News expect = new News();
        expect = news;

        News actual = new News();
        actual = newService.createNews(newDTO);

        String gsExect = gson.toJson(expect);
        String gsActual = gson.toJson(actual);

        assertEquals(gsExect, gsActual);

    }

    @Test
    void updateNews() {
    }

    @Test
    void deleteNews() {
    }
}
