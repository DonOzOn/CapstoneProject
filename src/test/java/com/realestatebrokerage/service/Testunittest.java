package com.realestatebrokerage.service;

import com.google.gson.Gson;
import com.realestatebrokerage.domain.*;
import com.realestatebrokerage.repository.*;
import com.realestatebrokerage.service.ProvinceService;
import com.realestatebrokerage.service.dto.GuestCareProductRequestDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class Testunittest {
    @Mock
    private ProvinceRepository provinceRepository;
    @Mock
    private DistrictRepository districtRepository;
    @Mock
    private WardRepository wardRepository;
    @Mock
    private DirectionHouseRepository directionHouseRepository;
    @Mock
    private DirectionRepository directionRepository;
    @Mock
    private GuestCareProductRepository guestCareProductRepository;


    @InjectMocks
    private ProvinceService provinceService = new ProvinceService();

    @InjectMocks
    private DistrictService districtService = new DistrictService();

    @InjectMocks
    private WardService wardService = new WardService();

    @InjectMocks
    private DirectionHouseService directionHouseService = new DirectionHouseService();

    @InjectMocks
    private DirectionService directionService = new DirectionService();

    @InjectMocks
    private GuestCareProductService guestCareProductService = new GuestCareProductService();


    /**
     * Address service test
     * */
    @Test
    public void findAllProvince(){
        Gson gs = new Gson();
        List<Province> lst = new ArrayList<>();
        lst.add(new Province("1", "hà nội","1"));
        lst.add(new Province("2", "Đà nẵng","2"));
        lst.add(new Province("3", "HCM","1"));
        when(provinceRepository.findAll()).thenReturn(lst);
        List<Province> lstExpect = lst;
        List<Province> lstActual = provinceService.findAll();
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    @Test
    public void findAllDistrict(){
        Gson gs = new Gson();
        List<District> districtList = new ArrayList<>();
        districtRepository.save(new District("1", "Thanh Xuân",new Province("2", "hà nội","1"),"2"));
        districtRepository.save(new District("2", "Liên Chiểu",new Province("2", "Đà nẵng","2"),"1"));
        districtRepository.save(new District("3", "Tân Bình",new Province("2", "Đà nẵng","2"),"2"));
        when(districtRepository.findAllByProvinceCode("2")).thenReturn(districtList);
        List<District> lstExpect = districtList;
        List<District> lstActual = districtService.findAllByProvinceCode("2");
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    @Test
    public void findAllWard(){
        Gson gs = new Gson();
        List<Ward> wardList = new ArrayList<>();
        wardRepository.save(new Ward("1", "Thanh Xuân","1",new District("1", "Thanh Xuân",new Province("1", "hà nội","1"),"2")));
        wardRepository.save(new Ward("2", "Liên Chiểu","2",new District("1", "Liên Chiểu",new Province("2", "Đà nẵng","2"),"1")));
        wardRepository.save(new Ward("3", "Tân Bình","2",new District("1", "Tân Bình",new Province("2", "Đà nẵng","2"),"2")));
        when(wardRepository.findAllByDistrictCode("1")).thenReturn(wardList);
        List<Ward> lstExpect = wardList;
        List<Ward> lstActual = wardService.findAllByDistrictCode("1");
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    /**
     * Direction house service test
     * */
    @Test
    public void findByNamePar(){
        Gson gs = new Gson();

        DirectionHouse directionHouse1 = new DirectionHouse();
        directionHouse1.setDiennien("Hoa");
        directionHouse1.setHoahai("La");
        directionHouse1.setId(1L);
        directionHouse1.setLucsat("Canh");
        directionHouse1.setName_par("Re");
        directionHouse1.setNguquy("Ngon");
        directionHouse1.setPhucvi("Nhanh");
        directionHouse1.setThieny("Choi");
        directionHouse1.setTuyetmenh("Bong");
        directionHouseRepository.save(directionHouse1);

        DirectionHouse directionHouse2 = new DirectionHouse();
        directionHouse1.setDiennien("Hoa2");
        directionHouse1.setHoahai("La2");
        directionHouse1.setId(2L);
        directionHouse1.setLucsat("Canh2");
        directionHouse1.setName_par("Re2");
        directionHouse1.setNguquy("Ngon2");
        directionHouse1.setPhucvi("Nhanh2");
        directionHouse1.setThieny("Choi2");
        directionHouse1.setTuyetmenh("Bong2");
        directionHouseRepository.save(directionHouse2);

        Optional<DirectionHouse> directionHouseOptional = null ;

        when(directionHouseRepository.findByParName("Re2")).thenReturn(directionHouseOptional);
        Optional<DirectionHouse> lstExpect = directionHouseOptional;
        Optional<DirectionHouse> lstActual = directionHouseService.findByNamePar("Re2");
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    /**
     * Direction Service test
     * */
    @Test
    public void findAllDirection(){
        Gson gs = new Gson();
        List<Direction> directionList = new ArrayList<>();
        directionRepository.save(new Direction("Đông"));
        directionRepository.save(new Direction("Nam"));
        directionRepository.save(new Direction("Bắc"));
        when(directionRepository.findAll()).thenReturn(directionList);
        List<Direction> lstExpect = directionList;
        List<Direction> lstActual = directionService.findAll();
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    /**
     * Guest care service test
     * */
    @Test
    public void findAllGuestCare(){
        Gson gs = new Gson();
        List<GuestCareProduct> guestCareProductList = new ArrayList<>();
        guestCareProductRepository.save(new GuestCareProduct("111","abc123.com","don","Co lien he 2",null,null, true));
        guestCareProductRepository.save(new GuestCareProduct("222","abc12.com","ha","Co lien he 3",null,null, true));
        guestCareProductRepository.save(new GuestCareProduct("333","abc1.com","manh","Co lien he 4",null,null, true));
        when(guestCareProductRepository.findAllByStatusIsTrue()).thenReturn(guestCareProductList);
        List<GuestCareProduct> lstExpect = guestCareProductList;
        List<GuestCareProduct> lstActual = guestCareProductService.findAll();
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    @Test
    public void findAllGuestCareById(){
        Gson gs = new Gson();
        Optional<GuestCareProduct> guestCareProduct = Optional.of(new GuestCareProduct("222", "abc123.com", "don", "Co lien he 2", null, null, true));
        guestCareProductRepository.save(new GuestCareProduct("111","abc123.com","don","Co lien he 2",null,null, true));
        guestCareProductRepository.save(new GuestCareProduct("222","abc12.com","ha","Co lien he 3",null,null, true));
        guestCareProductRepository.save(new GuestCareProduct("333","abc1.com","manh","Co lien he 4",null,null, true));
        when(guestCareProductRepository.findById(2L)).thenReturn(guestCareProduct);
        Optional<GuestCareProduct> lstExpect = guestCareProduct;
        Optional<GuestCareProduct> lstActual = guestCareProductService.findById(2L);
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    @Test
    public void createGuestCareProduct(){
        Gson gson = new Gson();
        GuestCareProductRequestDTO guestCareProductRequestDTO = new GuestCareProductRequestDTO();
        guestCareProductRequestDTO.setId(1L);
        guestCareProductRequestDTO.setEmail("abc123");
        guestCareProductRequestDTO.setName("don");
        guestCareProductRequestDTO.setPhone("1234");
        guestCareProductRequestDTO.setMess("see");
        guestCareProductRequestDTO.setStatus(true);

        GuestCareProduct guestCareProduct = new GuestCareProduct();
        guestCareProduct.setId(1L);
        guestCareProduct.setEmail("abc123");
        guestCareProduct.setName("don");
        guestCareProduct.setPhone("1234");
        guestCareProduct.setMess("see");
        guestCareProduct.setStatus(true);

        when(guestCareProductRepository.save(guestCareProduct)).thenReturn(guestCareProduct);

        GuestCareProduct expect = guestCareProduct;
        System.out.println("request : " + guestCareProductRequestDTO);
        GuestCareProduct actual = guestCareProductService.createGuestCareProduct(guestCareProductRequestDTO);

        System.out.println("actual : " + actual);
        String gsExect = gson.toJson(expect);
        String gsActual = gson.toJson(actual);
        assertEquals(gsExect, gsActual);
    }

}
